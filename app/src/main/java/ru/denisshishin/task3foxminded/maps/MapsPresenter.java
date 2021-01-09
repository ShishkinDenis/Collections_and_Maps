package ru.denisshishin.task3foxminded.maps;

import android.os.Handler;
import android.os.Looper;

import java.util.HashMap;
import java.util.TreeMap;

import javax.inject.Inject;
import javax.inject.Named;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Scheduler;
import moxy.MvpPresenter;
import ru.denisshishin.task3foxminded.DaggerApplicationComponent;
import ru.denisshishin.task3foxminded.ReadyCallback;

public class MapsPresenter extends MvpPresenter<MapsView> {

    @Inject
    @Named("Observer")
    Scheduler observerScheduler;

    @Inject
    @Named("Process")
    Scheduler processScheduler;

    @Inject
    Handler handler;

    @Inject
    public MapsPresenter(){
        DaggerApplicationComponent.create().inject(this);
    }

    public void launchMaps(String inputValue){

        ReadyCallback readyCallback = () -> new Handler(Looper.getMainLooper()).post(() ->
                executeMapsThreads(inputValue));

        new Thread(() -> {
            fillMaps(inputValue);
            readyCallback.onReady();
        }).start();
    }

    private void fillMaps(String value) {
        int intValue = Integer.parseInt(value);

        handler.post(() -> getViewState().showProgressBarFillingMaps());
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
        handler.post(() -> getViewState().hideProgressBarFillingMaps());
    }

    private void executeMapsThreads(String value) {

        getViewState().hideTextViewMapsFragment();
        getViewState().showProgressBarMapsFragment();

        //HashMap
        Observable
                .create(o -> {
                    long time = System.currentTimeMillis();
                    addingNewElementHashMap(value);
                    long threadTime = System.currentTimeMillis() - time;
                    o.onNext(threadTime);
                })
                .subscribeOn(processScheduler)
                .observeOn(observerScheduler)
                .subscribe(s-> getViewState().showTvAddingNewHashMap(s + " ms"));

        Observable
                .create(o -> {
                    long time = System.currentTimeMillis();
                    removingElementHashMap(value);
                    long threadTime = System.currentTimeMillis() - time;
                    o.onNext(threadTime);
                })
                .subscribeOn(processScheduler)
                .observeOn(observerScheduler)
                .subscribe(s-> getViewState().showTvRemovingHashMap(s + " ms"));

        Observable
                .create(o -> {
                    long time = System.currentTimeMillis();
                    searchByKeyHashMap(value);
                    long threadTime = System.currentTimeMillis() - time;
                    o.onNext(threadTime);
                })
                .subscribeOn(processScheduler)
                .observeOn(observerScheduler)
                .subscribe(s-> getViewState().showTvSearchByKeyHashMap(s + " ms"));

        //TreeMap
        Observable
                .create(o -> {
                    long time = System.currentTimeMillis();
                    addingNewElementTreeMap(value);
                    long threadTime = System.currentTimeMillis() - time;
                    o.onNext(threadTime);
                })
                .subscribeOn(processScheduler)
                .observeOn(observerScheduler)
                .subscribe(s-> getViewState().showTvAddingNewTreeMap(s + " ms"));

        Observable
                .create(o -> {
                    long time = System.currentTimeMillis();
                    removingElementTreeMap(value);
                    long threadTime = System.currentTimeMillis() - time;
                    o.onNext(threadTime);
                })
                .subscribeOn(processScheduler)
                .observeOn(observerScheduler)
                .subscribe(s-> getViewState().showTvRemovingTreeMap(s + " ms"));

        Observable
                .create(o -> {
                    long time = System.currentTimeMillis();
                    searchByKeyTreeMap(value);
                    long threadTime = System.currentTimeMillis() - time;
                    o.onNext(threadTime);
                })
                .subscribeOn(processScheduler)
                .observeOn(observerScheduler)
                .subscribe(s-> getViewState().showTvSearchByKeyTreeMap(s + " ms"));

    }

    HashMap hashMap = new HashMap();

    TreeMap treeMap = new TreeMap();

    private void addingNewElementHashMap(String value){
        int intValue = Integer.parseInt(value);
        synchronized(this) {
                hashMap.put(intValue, intValue);
        }
    }
    private void removingElementHashMap(String value){
        int intValue = Integer.parseInt(value);
        synchronized(this) {
                hashMap.remove(intValue);
            }
    }
    private void searchByKeyHashMap(String value){
        int intValue = Integer.parseInt(value);
        synchronized(this) {
            hashMap.get(intValue);
        }
    }


    private void addingNewElementTreeMap(String value){
        int intValue = Integer.parseInt(value);
        synchronized(this) {
                treeMap.put(intValue, intValue);
        }
    }
    private void removingElementTreeMap(String value){
        int intValue = Integer.parseInt(value);
        synchronized(this) {
                treeMap.remove(intValue);
        }
    }
    private void searchByKeyTreeMap(String value){
        int intValue = Integer.parseInt(value);
        synchronized(this) {
            treeMap.get(intValue);
        }
    }


}


