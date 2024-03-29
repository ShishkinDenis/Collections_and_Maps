package ru.denisshishin.task3foxminded.maps;

import android.os.Handler;

import java.util.HashMap;
import java.util.TreeMap;

import javax.inject.Inject;
import javax.inject.Named;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Scheduler;
import moxy.MvpPresenter;
import ru.denisshishin.task3foxminded.ReadyCallback;

import static ru.denisshishin.task3foxminded.SchedulerModule.OBSERVER;
import static ru.denisshishin.task3foxminded.SchedulerModule.PROCESS;

public class MapsPresenter extends MvpPresenter<MapsView> {

    private Scheduler observerScheduler;
    private Scheduler processScheduler;
    private Handler handler;

    private static final String MILLISECONDS = " ms";

    @Inject
    public MapsPresenter(@Named(OBSERVER) Scheduler observerScheduler, @Named(PROCESS) Scheduler processScheduler, Handler handler) {
        this.observerScheduler = observerScheduler;
        this.processScheduler = processScheduler;
        this.handler = handler;
    }

    public void launchMaps(String inputValue) {

        ReadyCallback readyCallback = () -> handler.post(() ->
                executeMapsThreads(inputValue));

        Observable
                .create(o -> {
                    fillMaps(inputValue);
                    readyCallback.onReady();
                })
                .subscribeOn(processScheduler)
                .observeOn(observerScheduler)
                .subscribe();
    }

    public void fillMaps(String value) {
        int intValue = Integer.parseInt(value);

        handler.post(() -> getViewState().showProgressBarFillingMaps());

        if (hashMap.size() < intValue) {
            for (int i = 0; i < (intValue - hashMap.size()); i++) {
                hashMap.put(i, i);
                treeMap.put(i, i);
            }
        } else {
            for (int i = 0; i < (hashMap.size() - intValue); i++) {
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

    public void executeMapsThreads(String value) {

        getViewState().hideTextViewMapsFragment();
        getViewState().showProgressBarMapsFragment();

        //HashMap

        createObservable(() -> addingNewElementHashMap(value))
                .subscribe(s -> getViewState().showTvAddingNewHashMap(s + MILLISECONDS));

        createObservable(() -> removingElementHashMap(value))
                .subscribe(s -> getViewState().showTvRemovingHashMap(s + MILLISECONDS));

        createObservable(() -> searchByKeyHashMap(value))
                .subscribe(s -> getViewState().showTvSearchByKeyHashMap(s + MILLISECONDS));

        //TreeMap

        createObservable(() -> addingNewElementTreeMap(value))
                .subscribe(s -> getViewState().showTvAddingNewTreeMap(s + MILLISECONDS));

        createObservable(() -> removingElementTreeMap(value))
                .subscribe(s -> getViewState().showTvRemovingTreeMap(s + MILLISECONDS));

        createObservable(() -> searchByKeyTreeMap(value))
                .subscribe(s -> getViewState().showTvSearchByKeyTreeMap(s + MILLISECONDS));
    }

    HashMap hashMap = new HashMap();

    TreeMap treeMap = new TreeMap();

    public void addingNewElementHashMap(String value) {
        int intValue = Integer.parseInt(value);
        synchronized (this) {
            hashMap.put(intValue, intValue);
        }
    }

    public void removingElementHashMap(String value) {
        int intValue = Integer.parseInt(value);
        synchronized (this) {
            hashMap.remove(intValue);
        }
    }

    public void searchByKeyHashMap(String value) {
        int intValue = Integer.parseInt(value);
        synchronized (this) {
            hashMap.get(intValue);
        }
    }

    public void addingNewElementTreeMap(String value) {
        int intValue = Integer.parseInt(value);
        synchronized (this) {
            treeMap.put(intValue, intValue);
        }
    }

    public void removingElementTreeMap(String value) {
        int intValue = Integer.parseInt(value);
        synchronized (this) {
            treeMap.remove(intValue);
        }
    }

    public void searchByKeyTreeMap(String value) {
        int intValue = Integer.parseInt(value);
        synchronized (this) {
            treeMap.get(intValue);
        }
    }

}


