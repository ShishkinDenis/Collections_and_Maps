package ru.denisshishin.task3foxminded.maps;

import android.os.Handler;
import android.os.Looper;

import java.util.HashMap;
import java.util.TreeMap;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import moxy.MvpPresenter;
import ru.denisshishin.task3foxminded.ReadyCallback;

public class MapsFragmentPresenter extends MvpPresenter<MapsFragmentView> {

    public MapsFragmentPresenter(){
    }

    public void launchMaps(String inputValue){

        ReadyCallback readyCallback = () -> new Handler(Looper.getMainLooper()).post(() ->
                executeMapsThreads(inputValue));

        new Thread(() -> {
            fillMaps(inputValue);
            readyCallback.onReady();
        }).start();
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

    public void executeMapsThreads(String value) {
        int numberOfCores = Runtime.getRuntime().availableProcessors();
        LinkedBlockingQueue<Runnable> fifoQueue = new LinkedBlockingQueue<Runnable>();
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(numberOfCores, numberOfCores,
                1, TimeUnit.SECONDS, fifoQueue);

        getViewState().hideTextViewMapsFragment();
        getViewState().showProgressBarMapsFragment();

        Handler handler = new Handler(Looper.getMainLooper());

        //HashMap
        threadPool.execute(() -> {
            long time = System.currentTimeMillis();
            addingNewElementHashMap(value);
            long threadTime = System.currentTimeMillis() - time;

            handler.post(() -> getViewState().showTvAddingNewHashMap(threadTime + " ms"));
        });
        threadPool.execute(() -> {
            long time = System.currentTimeMillis();
            removingElementHashMap(value);
            long threadTime = System.currentTimeMillis() - time;

            handler.post(() -> getViewState().showTvRemovingHashMap(threadTime + " ms"));
        });
        threadPool.execute(() -> {
            long time = System.currentTimeMillis();
            searchByKeyHashMap(value);
            long threadTime = System.currentTimeMillis() - time;

            handler.post(() -> getViewState().showTvSearchByKeyHashMap(threadTime + " ms"));
        });

        //TreeMap
        threadPool.execute(() -> {
            long time = System.currentTimeMillis();
            addingNewElementTreeMap(value);
            long threadTime = System.currentTimeMillis() - time;

            handler.post(() -> getViewState().showTvAddingNewTreeMap(threadTime + " ms"));
        });
        threadPool.execute(() -> {
            long time = System.currentTimeMillis();
            removingElementTreeMap(value);
            long threadTime = System.currentTimeMillis() - time;

            handler.post(() -> getViewState().showTvRemovingTreeMap(threadTime + " ms"));
        });
        threadPool.execute(() -> {
            long time = System.currentTimeMillis();
            searchByKeyTreeMap(value);
            long threadTime = System.currentTimeMillis() - time;

            handler.post(() -> getViewState().showTvSearchByKeyTreeMap(threadTime + " ms"));
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


}


