package ru.denisshishin.task3foxminded;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;

import java.util.HashMap;
import java.util.TreeMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import moxy.MvpPresenter;

public class MapsFragmentPresenter extends MvpPresenter<MapsFragmentView> {

    public MapsFragmentPresenter(){
    }

    public void launch(String string){

        ReadyCallback readyCallback = new ReadyCallback() {
            @Override
            public void onReady() {
                new Handler(Looper.getMainLooper()).post(() ->
                        presentTvMapsFragment(string));
            }
        };

        new Thread(() -> {
            fillMaps(string);
            readyCallback.onReady();
        }).start();
    }

    private interface ReadyCallback{
        void onReady();
    }


    public void fillMaps(String value) {
        int intValue = Integer.parseInt(value);

        new Handler(Looper.getMainLooper()).post(() -> getViewState().showProgressBarFillingMaps());
        if (hashMap.size() < intValue) {
            for (int i = 0; i < (intValue-hashMap.size()); i++) {
                hashMap.put(i,i);
                treeMap.put(i,i);
            }
        }
        else {
            for (int i = 0; i < (hashMap.size()-intValue); i++) {
                hashMap.remove(i);
                treeMap.remove(i);
            }
        }
        new Handler(Looper.getMainLooper()).post(() -> getViewState().hideProgressBarFillingMaps());
    }

    public void presentTvMapsFragment(String value) {
        int numberOfCores = Runtime.getRuntime().availableProcessors();
        LinkedBlockingQueue<Runnable> fifoQueue = new LinkedBlockingQueue<Runnable>();
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(numberOfCores, numberOfCores,
                1, TimeUnit.SECONDS, fifoQueue);

        getViewState().hideTextViewMapsFragment();
        getViewState().showProgressBarMapsFragment();

        //HashMap
        threadPool.execute(new Runnable() {
            @Override
            public void run() {
                long time = System.currentTimeMillis();
                addingNewElementHashMap(value);
                long time2 = System.currentTimeMillis() - time;

                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    @Override
                    public void run() {
                        getViewState().showTvAddingNewHashMap(String.valueOf(time2) + " ms");


                    }
                });
            }
        });
        threadPool.execute(new Runnable() {
            @Override
            public void run() {
                long time = System.currentTimeMillis();
                removingElementHashMap(value);
                long time2 = System.currentTimeMillis() - time;

                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    @Override
                    public void run() {
                        getViewState().showTvRemovingHashMap(String.valueOf(time2) + " ms");

                    }
                });
            }
        });
        threadPool.execute(new Runnable() {
            @Override
            public void run() {
                long time = System.currentTimeMillis();
                searchByKeyHashMap(value);
                long time2 = System.currentTimeMillis() - time;

                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    @Override
                    public void run() {
                        getViewState().showTvSearchByKeyHashMap(String.valueOf(time2) + " ms");
                    }
                });
            }
        });

        //TreeMap
        threadPool.execute(new Runnable() {
            @Override
            public void run() {
                long time = System.currentTimeMillis();
                addingNewElementTreeMap(value);
                long time2 = System.currentTimeMillis() - time;

                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    @Override
                    public void run() {
                        getViewState().showTvAddingNewTreeMap(String.valueOf(time2) + " ms");


                    }
                });
            }

        });
        threadPool.execute(new Runnable() {
            @Override
            public void run() {
                long time = System.currentTimeMillis();
                removingElementTreeMap(value);
                long time2 = System.currentTimeMillis() - time;

                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    @Override
                    public void run() {
                        getViewState().showTvRemovingTreeMap(String.valueOf(time2) + " ms");
                    }
                });
            }
        });
        threadPool.execute(new Runnable() {
            @Override
            public void run() {
                long time = System.currentTimeMillis();
                searchByKeyTreeMap(value);
                long time2 = System.currentTimeMillis() - time;

                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    @Override
                    public void run() {
                        getViewState().showTvSearchByKeyTreeMap(String.valueOf(time2) + " ms");
                    }
                });
            }
        });

    }

    HashMap hashMap = new HashMap();

    TreeMap treeMap = new TreeMap();

    public void addingNewElementHashMap(String value){
        int intValue = Integer.parseInt(value);
        synchronized(this) {
                hashMap.put(intValue, intValue);
        }
    }
    public void removingElementHashMap(String value){
        int intValue = Integer.parseInt(value);
        synchronized(this) {
                hashMap.remove(intValue);
            }
    }
    public void searchByKeyHashMap(String value){
        int intValue = Integer.parseInt(value);
        synchronized(this) {
            hashMap.get(intValue);
        }
    }


    public void addingNewElementTreeMap(String value){
        int intValue = Integer.parseInt(value);
        synchronized(this) {
                treeMap.put(intValue, intValue);
        }
    }
    public void removingElementTreeMap(String value){
        int intValue = Integer.parseInt(value);
        synchronized(this) {
                treeMap.remove(intValue);
        }
    }
    public void searchByKeyTreeMap(String value){
        int intValue = Integer.parseInt(value);
        synchronized(this) {
            treeMap.get(intValue);
        }
    }


    private void log(String message){
        Log.i("Callback",message);
    }


}


