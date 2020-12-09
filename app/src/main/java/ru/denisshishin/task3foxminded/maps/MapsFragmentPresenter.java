package ru.denisshishin.task3foxminded.maps;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;

import java.util.HashMap;
import java.util.TreeMap;
import java.util.concurrent.Callable;
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

        threadPool.execute(() -> {
            new Handler(Looper.getMainLooper()).post(() ->
                    getViewState().showTvAddingNewHashMap(measureThreadTime(() -> {
                        addingNewElementHashMap(value);
                        return null;
                    })));
        });
        threadPool.execute(() -> {
            new Handler(Looper.getMainLooper()).post(() ->
                    getViewState().showTvRemovingHashMap(measureThreadTime(() -> {
                        removingElementHashMap(value);
                        return null;
                    })));
        });
        threadPool.execute(() -> {
            new Handler(Looper.getMainLooper()).post(() ->
                    getViewState().showTvSearchByKeyHashMap(measureThreadTime(() -> {
                        searchByKeyHashMap(value);
                        return null;
                    })));
        });

        //TreeMap

        threadPool.execute(() -> {
            new Handler(Looper.getMainLooper()).post(() ->
                    getViewState().showTvAddingNewTreeMap(measureThreadTime(() -> {
                        addingNewElementTreeMap(value);
                        return null;
                    })));
        });
        threadPool.execute(() -> {
            new Handler(Looper.getMainLooper()).post(() ->
                    getViewState().showTvRemovingTreeMap(measureThreadTime(() -> {
                        removingElementTreeMap(value);
                        return null;
                    })));
        });
        threadPool.execute(() -> {
            new Handler(Looper.getMainLooper()).post(() ->
                    getViewState().showTvSearchByKeyTreeMap(measureThreadTime(() -> {
                        searchByKeyTreeMap(value);
                        return null;
                    })));
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


    public String measureThreadTime(Callable<Void> collectionsOperation){
        long time = System.currentTimeMillis();
        try {
            collectionsOperation.call();
        } catch (Exception e) {
            e.printStackTrace();
        }
        long threadTime = System.currentTimeMillis() - time;
        return threadTime + " ms";
    }

}


