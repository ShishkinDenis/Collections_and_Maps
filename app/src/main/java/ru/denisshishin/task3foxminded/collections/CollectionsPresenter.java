package ru.denisshishin.task3foxminded.collections;

import android.os.Handler;
import android.os.Looper;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.concurrent.CopyOnWriteArrayList;

import javax.inject.Inject;
import javax.inject.Named;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Scheduler;
import moxy.InjectViewState;
import moxy.MvpPresenter;
import ru.denisshishin.task3foxminded.ReadyCallback;

@InjectViewState
public class CollectionsPresenter extends MvpPresenter<CollectionsView> {

    Scheduler observerScheduler;
    Scheduler processScheduler;
    Handler handler;

    @Inject
    public CollectionsPresenter(@Named("Observer") Scheduler observerScheduler,
                                @Named("Process") Scheduler processScheduler, Handler handler) {
        this.observerScheduler = observerScheduler;
        this.processScheduler = processScheduler;
        this.handler = handler;
    }

    public void launchCollections(String inputValue) {

        ReadyCallback readyCallback = () -> handler.post(() ->
                executeCollectionsThreads(inputValue));

       /* new Thread(() -> {
            fillCollections(inputValue);
                readyCallback.onReady();
        }).start();*/
//упростить
        Observable
                .create(o -> {
                    fillCollections(inputValue);
                    readyCallback.onReady();
                })
                .subscribeOn(processScheduler)
                .observeOn(observerScheduler)
                .subscribe();

    }
    /*public void test(String value) {
        getViewState().showAddingInTheBeginningArrayList(value);
    }
    public void test2(){

    getViewState().showProgressBarCollectionsFragment();

}*/
    public void fillCollections(String value) {
        int intValue = Integer.parseInt(value);

        handler.post(() -> getViewState().showProgressBarFillingCollections());

            if (arrayList.size() < intValue) {
                for (int i = 0; i < (intValue-arrayList.size()); i++) {
                    arrayList.add(i);
                    linkedList.add(i);
                    copyOnWriteArrayList.add(i);
                }
            }
            else {
                for (int i = 0; i < (arrayList.size()-intValue); i++) {
                    arrayList.remove(i);
                    linkedList.remove(i);
                    copyOnWriteArrayList.remove(i);
                }
            }

        handler.post(() -> getViewState().hideProgressBarFillingCollections());
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
                .observeOn(observerScheduler);
}

    public void executeCollectionsThreads(String value) {

        getViewState().hideTextViewCollectionsFragment();
        getViewState().showProgressBarCollectionsFragment();

//       getViewState().showAddingInTheBeginningArrayList("50000");

        //ArrayList

    /*    Observable
                .create(o -> {
                    long time = System.currentTimeMillis();
                    addingInTheBeginningArrayList();
                    long threadTime = System.currentTimeMillis() - time;
                    o.onNext(threadTime);
                })
                .subscribeOn(processScheduler)
                .observeOn(observerScheduler)
                .subscribe(s-> getViewState().showAddingInTheBeginningArrayList(s + " ms"));*/

        createObservable(() -> addingInTheBeginningArrayList())
                .subscribe(s-> getViewState().showAddingInTheBeginningArrayList(s + " ms"));

        createObservable(() -> addingInTheMiddleArrayList())
                .subscribe(s-> getViewState().showAddingInTheMiddleArrayList(s + " ms"));
        
        createObservable(() -> addingInTheEndArrayList())
                .subscribe(s-> getViewState().showAddingInTheEndArrayList(s + " ms"));

        createObservable(() ->  searchByValueArrayList(value))
                .subscribe(s-> getViewState().showSearchByValueArrayList(s + " ms"));

        createObservable(() ->  removingInTheBeginningArrayList())
                .subscribe(s-> getViewState().showRemovingInTheBeginningArrayList(s + " ms"));

        createObservable(() ->  removingInTheMiddleArrayList())
                .subscribe(s-> getViewState().showRemovingInTheMiddleArrayList(s + " ms"));

        createObservable(() ->  removingInTheEndArrayList())
                .subscribe(s-> getViewState().showRemovingInTheEndArrayList(s + " ms"));

/*
Observable
                .create(o -> {
                    long time = System.currentTimeMillis();
                    addingInTheBeginningArrayList();
                    long threadTime = System.currentTimeMillis() - time;
                    o.onNext(threadTime);
                })
                .subscribeOn(processScheduler)
                .observeOn(observerScheduler)
                .subscribe(s-> getViewState().showAddingInTheBeginningArrayList(s + " ms"));

Observable
                .create(o -> {
                    long time = System.currentTimeMillis();
                    addingInTheMiddleArrayList();
                    long threadTime = System.currentTimeMillis() - time;
                    o.onNext(threadTime);
                })
                .subscribeOn(processScheduler)
                .observeOn(observerScheduler)
                .subscribe(s-> getViewState().showAddingInTheMiddleArrayList(s + " ms"));
        Observable
                .create(o -> {
                    long time = System.currentTimeMillis();
                    addingInTheEndArrayList();
                    long threadTime = System.currentTimeMillis() - time;
                    o.onNext(threadTime);
                })
                .subscribeOn(processScheduler)
                .observeOn(observerScheduler)
                .subscribe(s-> getViewState().showAddingInTheEndArrayList(s + " ms"));

        Observable
                .create(o -> {
                    long time = System.currentTimeMillis();
                    searchByValueArrayList(value);
                    long threadTime = System.currentTimeMillis() - time;
                    o.onNext(threadTime);
                })
                .subscribeOn(processScheduler)
                .observeOn(observerScheduler)
                .subscribe(s-> getViewState().showSearchByValueArrayList(s + " ms"));

        Observable
                .create(o -> {
                    long time = System.currentTimeMillis();
                    removingInTheBeginningArrayList();
                    long threadTime = System.currentTimeMillis() - time;
                    o.onNext(threadTime);
                })
                .subscribeOn(processScheduler)
                .observeOn(observerScheduler)
                .subscribe(s-> getViewState().showRemovingInTheBeginningArrayList(s + " ms"));

        Observable
                .create(o -> {
                    long time = System.currentTimeMillis();
                    removingInTheMiddleArrayList();
                    long threadTime = System.currentTimeMillis() - time;
                    o.onNext(threadTime);
                })
                .subscribeOn(processScheduler)
                .observeOn(observerScheduler)
                .subscribe(s-> getViewState().showRemovingInTheMiddleArrayList(s + " ms"));

        Observable
                .create(o -> {
                    long time = System.currentTimeMillis();
                    removingInTheEndArrayList();
                    long threadTime = System.currentTimeMillis() - time;
                    o.onNext(threadTime);
                })
                .subscribeOn(processScheduler)
                .observeOn(observerScheduler)
                .subscribe(s-> getViewState().showRemovingInTheEndArrayList(s + " ms"));*/

        //LinkedList

        createObservable(() -> addingInTheBeginningLinkedList())
                .subscribe(s-> getViewState().showAddingInTheBeginningLinkedList(s + " ms"));

        createObservable(() -> addingInTheMiddleLinkedList())
                .subscribe(s-> getViewState().showAddingInTheMiddleLinkedList(s + " ms"));

        createObservable(() -> addingInTheEndLinkedList())
                .subscribe(s-> getViewState().showAddingInTheEndLinkedList(s + " ms"));

        createObservable(() ->  searchByValueLinkedList(value))
                .subscribe(s-> getViewState().showSearchByValueLinkedList(s + " ms"));

        createObservable(() ->  removingInTheBeginningLinkedList())
                .subscribe(s-> getViewState().showRemovingInTheBeginningLinkedList(s + " ms"));

        createObservable(() ->  removingInTheMiddleLinkedList())
                .subscribe(s-> getViewState().showRemovingInTheMiddleLinkedList(s + " ms"));

        createObservable(() ->  removingInTheEndLinkedList())
                .subscribe(s-> getViewState().showRemovingInTheEndLinkedList(s + " ms"));

       /* Observable
                .create(o -> {
                    long time = System.currentTimeMillis();
                    addingInTheBeginningLinkedList();
                    long threadTime = System.currentTimeMillis() - time;
                    o.onNext(threadTime);
                })
                .subscribeOn(processScheduler)
                .observeOn(observerScheduler)
                .subscribe(s-> getViewState().showAddingInTheBeginningLinkedList(s + " ms"));

        Observable
                .create(o -> {
                    long time = System.currentTimeMillis();
                    addingInTheMiddleLinkedList();
                    long threadTime = System.currentTimeMillis() - time;
                    o.onNext(threadTime);
                })
                .subscribeOn(processScheduler)
                .observeOn(observerScheduler)
                .subscribe(s-> getViewState().showAddingInTheMiddleLinkedList(s + " ms"));

        Observable
                .create(o -> {
                    long time = System.currentTimeMillis();
                    addingInTheEndLinkedList();
                    long threadTime = System.currentTimeMillis() - time;
                    o.onNext(threadTime);
                })
                .subscribeOn(processScheduler)
                .observeOn(observerScheduler)
                .subscribe(s-> getViewState().showAddingInTheEndLinkedList(s + " ms"));

        Observable
                .create(o -> {
                    long time = System.currentTimeMillis();
                    searchByValueLinkedList(value);
                    long threadTime = System.currentTimeMillis() - time;
                    o.onNext(threadTime);
                })
                .subscribeOn(processScheduler)
                .observeOn(observerScheduler)
                .subscribe(s-> getViewState().showSearchByValueLinkedList(s + " ms"));

        Observable
                .create(o -> {
                    long time = System.currentTimeMillis();
                    removingInTheBeginningLinkedList();
                    long threadTime = System.currentTimeMillis() - time;
                    o.onNext(threadTime);
                })
                .subscribeOn(processScheduler)
                .observeOn(observerScheduler)
                .subscribe(s-> getViewState().showRemovingInTheBeginningLinkedList(s + " ms"));

        Observable
                .create(o -> {
                    long time = System.currentTimeMillis();
                    removingInTheMiddleLinkedList();
                    long threadTime = System.currentTimeMillis() - time;
                    o.onNext(threadTime);
                })
                .subscribeOn(processScheduler)
                .observeOn(observerScheduler)
                .subscribe(s-> getViewState().showRemovingInTheMiddleLinkedList(s + " ms"));

        Observable
                .create(o -> {
                    long time = System.currentTimeMillis();
                    removingInTheEndLinkedList();
                    long threadTime = System.currentTimeMillis() - time;
                    o.onNext(threadTime);
                })
                .subscribeOn(processScheduler)
                .observeOn(observerScheduler)
                .subscribe(s-> getViewState().showRemovingInTheEndLinkedList(s + " ms"));*/

        //CopyOnWriteArrayList

        createObservable(() -> addingInTheBeginningCopyOnWriteArrayList())
                .subscribe(s-> getViewState().showAddingInTheBeginningCopyOnWriteArrayList(s + " ms"));

        createObservable(() -> addingInTheMiddleCopyOnWriteArrayList())
                .subscribe(s-> getViewState().showAddingInTheMiddleCopyOnWriteArrayList(s + " ms"));

        createObservable(() -> addingInTheEndCopyOnWriteArrayList())
                .subscribe(s-> getViewState().showAddingInTheEndCopyOnWriteArrayList(s + " ms"));

        createObservable(() ->  searchByValueCopyOnWriteArrayList(value))
                .subscribe(s-> getViewState().showSearchByValueCopyOnWriteArrayList(s + " ms"));

        createObservable(() ->  removingInTheBeginningCopyOnWriteArrayList())
                .subscribe(s-> getViewState().showRemovingInTheBeginningCopyOnWriteArrayList(s + " ms"));

        createObservable(() ->  removingInTheMiddleCopyOnWriteArrayList())
                .subscribe(s-> getViewState().showRemovingInTheMiddleCopyOnWriteArrayList(s + " ms"));

        createObservable(() ->  removingInTheEndCopyOnWriteArrayList())
                .subscribe(s-> getViewState().showRemovingInTheEndCopyOnWriteArrayList(s + " ms"));

       /* Observable
                .create(o -> {
                    long time = System.currentTimeMillis();
                    addingInTheBeginningCopyOnWriteArrayList();
                    long threadTime = System.currentTimeMillis() - time;
                    o.onNext(threadTime);
                })
                .subscribeOn(processScheduler)
                .observeOn(observerScheduler)
                .subscribe(s-> getViewState().showAddingInTheBeginningCopyOnWriteArrayList(s + " ms"));

        Observable
                .create(o -> {
                    long time = System.currentTimeMillis();
                    addingInTheMiddleCopyOnWriteArrayList();
                    long threadTime = System.currentTimeMillis() - time;
                    o.onNext(threadTime);
                })
                .subscribeOn(processScheduler)
                .observeOn(observerScheduler)
                .subscribe(s-> getViewState().showAddingInTheMiddleCopyOnWriteArrayList(s + " ms"));

        Observable
                .create(o -> {
                    long time = System.currentTimeMillis();
                    addingInTheEndCopyOnWriteArrayList();
                    long threadTime = System.currentTimeMillis() - time;
                    o.onNext(threadTime);
                })
                .subscribeOn(processScheduler)
                .observeOn(observerScheduler)
                .subscribe(s-> getViewState().showAddingInTheEndCopyOnWriteArrayList(s + " ms"));

        Observable
                .create(o -> {
                    long time = System.currentTimeMillis();
                    searchByValueCopyOnWriteArrayList(value);
                    long threadTime = System.currentTimeMillis() - time;
                    o.onNext(threadTime);
                })
                .subscribeOn(processScheduler)
                .observeOn(observerScheduler)
                .subscribe(s-> getViewState().showSearchByValueCopyOnWriteArrayList(s + " ms"));

        Observable
                .create(o -> {
                    long time = System.currentTimeMillis();
                    removingInTheBeginningCopyOnWriteArrayList();
                    long threadTime = System.currentTimeMillis() - time;
                    o.onNext(threadTime);
                })
                .subscribeOn(processScheduler)
                .observeOn(observerScheduler)
                .subscribe(s-> getViewState().showRemovingInTheBeginningCopyOnWriteArrayList(s + " ms"));

        Observable
                .create(o -> {
                    long time = System.currentTimeMillis();
                    removingInTheMiddleCopyOnWriteArrayList();
                    long threadTime = System.currentTimeMillis() - time;
                    o.onNext(threadTime);
                })
                .subscribeOn(processScheduler)
                .observeOn(observerScheduler)
                .subscribe(s-> getViewState().showRemovingInTheMiddleCopyOnWriteArrayList(s + " ms"));

        Observable
                .create(o -> {
                    long time = System.currentTimeMillis();
                    removingInTheEndCopyOnWriteArrayList();
                    long threadTime = System.currentTimeMillis() - time;
                    o.onNext(threadTime);
                })
                .subscribeOn(processScheduler)
                .observeOn(observerScheduler)
                .subscribe(s-> getViewState().showRemovingInTheEndCopyOnWriteArrayList(s + " ms"));*/

    }


    ArrayList<Integer> arrayList = new ArrayList<>();
    LinkedList<Integer> linkedList = new LinkedList<>();
    CopyOnWriteArrayList<Integer> copyOnWriteArrayList = new CopyOnWriteArrayList<>();


    private void addingInTheBeginningArrayList() {
        synchronized (this) {
            arrayList.add(0);
        }
    }
    public void addingInTheMiddleArrayList(){
        synchronized(this) {
                arrayList.add(arrayList.size() / 2);
        }

    }
    private void addingInTheEndArrayList(){
        synchronized(this) {
                arrayList.add(arrayList.size()-1);
            }
    }
    private void searchByValueArrayList(String value){
        int intValue = Integer.parseInt(value);
        synchronized(this) {
            arrayList.indexOf(intValue);
        }
    }
    private void removingInTheBeginningArrayList(){
        synchronized(this) {
                arrayList.remove(0);
        }
    }
    private void removingInTheMiddleArrayList(){
        synchronized(this) {
                arrayList.remove(arrayList.size() / 2);
            }
    }
    private void removingInTheEndArrayList(){

        synchronized(this){
            arrayList.remove(arrayList.size()-1);
        }
    }


    private void addingInTheBeginningLinkedList(){
        synchronized(this) {
                linkedList.add(0);
            }
    }
    private void addingInTheMiddleLinkedList(){
        synchronized(this) {
                linkedList.add(linkedList.size() / 2);
            }
    }
    private void addingInTheEndLinkedList(){
            synchronized (this) {
                linkedList.add(linkedList.size() - 1);
            }
    }
    private void searchByValueLinkedList(String value){
        int intValue = Integer.parseInt(value);
        synchronized(this) {
            linkedList.indexOf(intValue);
        }
    }
    private void removingInTheBeginningLinkedList(){

            synchronized (this) {
                linkedList.remove(0);
            }
    }
    private void removingInTheMiddleLinkedList(){
            synchronized (this) {
                linkedList.remove(linkedList.size() / 2);
            }
    }
    private void removingInTheEndLinkedList(){
            synchronized (this) {
                linkedList.remove(linkedList.size() - 1);
            }
    }

    private void addingInTheBeginningCopyOnWriteArrayList(){
        synchronized(this) {
                copyOnWriteArrayList.add(0);
            }
    }
    private void addingInTheMiddleCopyOnWriteArrayList(){
        synchronized(this) {
                copyOnWriteArrayList.add(copyOnWriteArrayList.size() / 2);
        }
    }
    private void addingInTheEndCopyOnWriteArrayList(){
        synchronized(this) {
                copyOnWriteArrayList.add(copyOnWriteArrayList.size()-1);
            }
    }
    private void searchByValueCopyOnWriteArrayList(String value){
        int intValue = Integer.parseInt(value);
        synchronized(this) {
            copyOnWriteArrayList.indexOf(intValue);
        }
    }
    private void removingInTheBeginningCopyOnWriteArrayList(){
        synchronized(this) {
                copyOnWriteArrayList.remove(0);
        }
    }
    private void removingInTheMiddleCopyOnWriteArrayList(){
        synchronized(this) {
                copyOnWriteArrayList.remove(copyOnWriteArrayList.size() / 2);
            }
    }
    private void removingInTheEndCopyOnWriteArrayList(){
        synchronized(this) {
                copyOnWriteArrayList.remove(copyOnWriteArrayList.size()-1);
            }
    }

}

