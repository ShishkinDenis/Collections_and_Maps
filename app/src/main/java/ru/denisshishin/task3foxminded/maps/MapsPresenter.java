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
import ru.denisshishin.task3foxminded.ReadyCallback;

public class MapsPresenter extends MvpPresenter<MapsView> {

    Scheduler observerScheduler;
    Scheduler processScheduler;
    Handler handler;

    @Inject
    public MapsPresenter(@Named("Observer") Scheduler observerScheduler,  @Named("Process") Scheduler processScheduler,Handler handler){
        this.observerScheduler = observerScheduler;
        this.processScheduler = processScheduler;
        this.handler = handler;
    }

    public void launchMaps(String inputValue){

        ReadyCallback readyCallback = () -> handler.post(() ->
                executeMapsThreads(inputValue));

    /*    new Thread(new Runnable() {
            @Override
            public void run() {
                MapsPresenter.this.fillMaps(inputValue);
                //  fillMaps2(inputValue,hashMap,treeMap);
                readyCallback.onReady();
            }
        }).start();*/

        Observable
                .create(o -> {
                    fillMaps(inputValue);
                    readyCallback.onReady();
                })
                .subscribeOn(processScheduler)
                .observeOn(observerScheduler)
                .subscribe();

    }
///Тестовую TextView положить
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

    public Observable createObservable(Runnable runnable) {
        return Observable
                .create(o -> {
                    long time = System.currentTimeMillis();
                    runnable.run();
                    long threadTime = System.currentTimeMillis() - time;
                    o.onNext(threadTime);
                })
                .subscribeOn(processScheduler)
                .observeOn(observerScheduler);
    }


   /* public void fillMaps2(String value,HashMap hashMap,TreeMap treeMap) {
        int intValue = Integer.parseInt(value);

   //     handler.post(() -> getViewState().showProgressBarFillingMaps());
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
   //     handler.post(() -> getViewState().hideProgressBarFillingMaps());
    }

    public void fillMaps3(String value,HashMap hashMap,TreeMap treeMap) {
        int intValue = Integer.parseInt(value);

            for (int i = 0; i < intValue; i++) {
                hashMap.put(i,i);
                treeMap.put(i,i);
            }

    }

    public Observable createObservable(Runnable runnable){
        return  Observable
                .create(o -> {
                    long time = System.currentTimeMillis();
                    runnable.run();
                    long threadTime = System.currentTimeMillis() - time;
                    o.onNext(threadTime);
                })
                .subscribeOn(processScheduler)
                .observeOn(observerScheduler);*/

    private void executeMapsThreads(String value) {

        getViewState().hideTextViewMapsFragment();
        getViewState().showProgressBarMapsFragment();

        //HashMap

        createObservable(() ->  addingNewElementHashMap(value))
                .subscribe(s-> getViewState().showTvAddingNewHashMap(s + " ms"));

        createObservable(() ->   removingElementHashMap(value))
                .subscribe(s-> getViewState().showTvRemovingHashMap(s + " ms"));

        createObservable(() ->   searchByKeyHashMap(value))
                .subscribe(s-> getViewState().showTvSearchByKeyHashMap(s + " ms"));

    /*    Observable
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
                .subscribe(s-> getViewState().showTvSearchByKeyHashMap(s + " ms"));*/

        //TreeMap

        createObservable(() ->     addingNewElementTreeMap(value))
                .subscribe(s-> getViewState().showTvAddingNewTreeMap(s + " ms"));

        createObservable(() ->   removingElementTreeMap(value))
                .subscribe(s-> getViewState().showTvRemovingTreeMap(s + " ms"));

        createObservable(() ->   searchByKeyTreeMap(value))
                .subscribe(s-> getViewState().showTvSearchByKeyTreeMap(s + " ms"));

       /* Observable
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
                .subscribe(s-> getViewState().showTvSearchByKeyTreeMap(s + " ms"));*/

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


