package ru.denisshishin.task3foxminded;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.concurrent.Callable;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import moxy.InjectViewState;
import moxy.MvpPresenter;

@InjectViewState
public class CollectionFragmentPresenter extends MvpPresenter<CollectionFragmentView> {

    public CollectionFragmentPresenter(){}

    public void launch(String string){

        CollectionFragmentPresenter.ReadyCallback readyCallback = new CollectionFragmentPresenter.ReadyCallback() {
            @Override
            public void onReady() {
                new Handler(Looper.getMainLooper()).post(() -> {
                    presentTvCollectionsFragment(string);
            });
            }
        };

        new Thread(() -> {
            fillCollections(string);
                readyCallback.onReady();
        }).start();
    }

    private interface ReadyCallback{
        void onReady();
    }

    public void fillCollections(String value) {
        int intValue = Integer.parseInt(value);

        new Handler(Looper.getMainLooper()).post(() -> getViewState().showProgressBarFillingCollections());

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

        new Handler(Looper.getMainLooper()).post(() -> getViewState().hideProgressBarFillingCollections());
}

    public void presentTvCollectionsFragment(String value) {

        int numberOfCores = Runtime.getRuntime().availableProcessors();
        LinkedBlockingQueue<Runnable> fifoQueue = new LinkedBlockingQueue<Runnable>();
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(numberOfCores, numberOfCores,
                1, TimeUnit.SECONDS, fifoQueue);

        getViewState().hideTextViewCollectionsFragment();
        getViewState().showProgressBarCollectionsFragment();

        //ArrayList
        threadPool.execute(() -> {
            long time = System.currentTimeMillis();
            addingInTheBeginningArrayList();
            long threadTime = System.currentTimeMillis() - time;

            new Handler(Looper.getMainLooper()).post(() ->
                    getViewState().showAddingInTheBeginningArrayList(threadTime + " ms"));
        });
        threadPool.execute(() -> {
            long time = System.currentTimeMillis();
            addingInTheMiddleArrayList();
            long threadTime = System.currentTimeMillis() - time;

            new Handler(Looper.getMainLooper()).post(() ->
                    getViewState().showAddingInTheMiddleArrayList(threadTime + " ms"));
        });
        threadPool.execute(() -> {
            long time = System.currentTimeMillis();
            addingInTheEndArrayList();
            long threadTime = System.currentTimeMillis() - time;

            new Handler(Looper.getMainLooper()).post(() ->
                    getViewState().showAddingInTheEndArrayList(threadTime + " ms"));
        });

        threadPool.execute(() -> {
            long time = System.currentTimeMillis();
            searchByValueArrayList(value);
            long threadTime = System.currentTimeMillis() - time;

            new Handler(Looper.getMainLooper()).post(() ->
                    getViewState().showSearchByValueArrayList(threadTime + " ms"));
        });

        threadPool.execute(() -> {
            long time = System.currentTimeMillis();
            removingInTheBeginningArrayList();
            long threadTime = System.currentTimeMillis() - time;

            new Handler(Looper.getMainLooper()).post(() ->
                    getViewState().showRemovingInTheBeginningArrayList(threadTime + " ms"));
        });
        threadPool.execute(() -> {
            long time = System.currentTimeMillis();
            removingInTheMiddleArrayList();
            long threadTime = System.currentTimeMillis() - time;

            new Handler(Looper.getMainLooper()).post(() ->
                    getViewState().showRemovingInTheMiddleArrayList(threadTime + " ms"));
        });
        threadPool.execute(() -> {
            long time = System.currentTimeMillis();
            removingInTheEndArrayList();
            long threadTime = System.currentTimeMillis() - time;

            new Handler(Looper.getMainLooper()).post(() ->
                    getViewState().showRemovingInTheEndArrayList(threadTime + " ms"));
        });

        //LinkedList
        threadPool.execute(() -> {
            long time = System.currentTimeMillis();
            addingInTheBeginningLinkedList();
            long threadTime = System.currentTimeMillis() - time;

            new Handler(Looper.getMainLooper()).post(() ->
                    getViewState().showAddingInTheBeginningLinkedList(threadTime + " ms"));
        });
        threadPool.execute(() -> {
            long time = System.currentTimeMillis();
            addingInTheMiddleLinkedList();
            long threadTime = System.currentTimeMillis() - time;

            new Handler(Looper.getMainLooper()).post(() ->
                    getViewState().showAddingInTheMiddleLinkedList(threadTime + " ms"));
        });
        threadPool.execute(() -> {
            long time = System.currentTimeMillis();
            addingInTheEndLinkedList();
            long threadTime = System.currentTimeMillis() - time;

            new Handler(Looper.getMainLooper()).post(() ->
                    getViewState().showAddingInTheEndLinkedList(threadTime + " ms"));
        });

        threadPool.execute(() -> {
            long time = System.currentTimeMillis();
            searchByValueLinkedList(value);
            long threadTime = System.currentTimeMillis() - time;

            new Handler(Looper.getMainLooper()).post(() ->
                    getViewState().showSearchByValueLinkedList(threadTime + " ms"));
        });

        threadPool.execute(() -> {
            long time = System.currentTimeMillis();
            removingInTheBeginningLinkedList();
            long threadTime = System.currentTimeMillis() - time;

            new Handler(Looper.getMainLooper()).post(() ->
                    getViewState().showRemovingInTheBeginningLinkedList(threadTime + " ms"));
        });
        threadPool.execute(() -> {
            long time = System.currentTimeMillis();
            removingInTheMiddleLinkedList();
            long threadTime = System.currentTimeMillis() - time;

            new Handler(Looper.getMainLooper()).post(() ->
                    getViewState().showRemovingInTheMiddleLinkedList(threadTime + " ms"));
        });
        threadPool.execute(() -> {
            long time = System.currentTimeMillis();
            removingInTheEndLinkedList();
            long threadTime = System.currentTimeMillis() - time;

            new Handler(Looper.getMainLooper()).post(() ->
                    getViewState().showRemovingInTheEndLinkedList(threadTime + " ms"));
        });

        //CopyOnWriteLinkedList
       /* threadPool.execute(() -> {
            long time = System.currentTimeMillis();
            addingInTheBeginningCopyOnWriteArrayList();
            long threadTime = System.currentTimeMillis() - time;

            new Handler(Looper.getMainLooper()).post(() ->
                    getViewState().showAddingInTheBeginningCopyOnWriteArrayList(threadTime + " ms"));
        });*/

         threadPool.execute(() -> {
            new Handler(Looper.getMainLooper()).post(() ->
                   getViewState().showAddingInTheBeginningCopyOnWriteArrayList(measureThreadTime(() -> {
                       addingInTheBeginningCopyOnWriteArrayList();
                       return null;
                   }) + " ms"));
        });


        threadPool.execute(() -> {
            long time = System.currentTimeMillis();
            addingInTheMiddleCopyOnWriteArrayList();
            long threadTime = System.currentTimeMillis() - time;

            new Handler(Looper.getMainLooper()).post(() ->
                    getViewState().showAddingInTheMiddleCopyOnWriteArrayList(threadTime + " ms"));
        });
        threadPool.execute(() -> {
            long time = System.currentTimeMillis();
            addingInTheEndCopyOnWriteArrayList();
            long threadTime = System.currentTimeMillis() - time;

            new Handler(Looper.getMainLooper()).post(() ->
                    getViewState().showAddingInTheEndCopyOnWriteArrayList(threadTime + " ms"));
        });

        threadPool.execute(() -> {
            long time = System.currentTimeMillis();
            searchByValueCopyOnWriteArrayList(value);
            long threadTime = System.currentTimeMillis() - time;

            new Handler(Looper.getMainLooper()).post(() ->
                    getViewState().showSearchByValueCopyOnWriteArrayList(threadTime + " ms"));
        });

        threadPool.execute(() -> {
            long time = System.currentTimeMillis();
            removingInTheBeginningCopyOnWriteArrayList();
            long threadTime = System.currentTimeMillis() - time;

            new Handler(Looper.getMainLooper()).post(() ->
                    getViewState().showRemovingInTheBeginningCopyOnWriteArrayList(threadTime + " ms"));
        });
        threadPool.execute(() -> {
            long time = System.currentTimeMillis();
            removingInTheMiddleCopyOnWriteArrayList();
            long threadTime = System.currentTimeMillis() - time;

            new Handler(Looper.getMainLooper()).post(() ->
                    getViewState().showRemovingInTheMiddleCopyOnWriteArrayList(threadTime + " ms"));
        });
        threadPool.execute(() -> {
            long time = System.currentTimeMillis();
            removingInTheEndCopyOnWriteArrayList();
            long threadTime = System.currentTimeMillis() - time;

            new Handler(Looper.getMainLooper()).post(() ->
                   getViewState().showRemovingInTheEndCopyOnWriteArrayList(threadTime + " ms"));
        });

        /*threadPool.execute(() -> {
            new Handler(Looper.getMainLooper()).post(() ->
                   getViewState().showRemovingInTheEndCopyOnWriteArrayList(measureThreadTime(() -> {
                       removingInTheEndCopyOnWriteArrayList();
                       return null;
                   }) + " ms"));
        });*/

    }


    ArrayList<Integer> arrayList = new ArrayList();
    LinkedList<Integer> linkedList = new LinkedList();
    CopyOnWriteArrayList<Integer> copyOnWriteArrayList = new CopyOnWriteArrayList();


    public void addingInTheBeginningArrayList(){
        synchronized(this) {
                arrayList.add(0);
        }
    }
    public void addingInTheMiddleArrayList(){
        synchronized(this) {
                arrayList.add(arrayList.size() / 2);
        }

    }
    public void addingInTheEndArrayList(){
        synchronized(this) {
                arrayList.add(arrayList.size()-1);
            }
    }
    public void searchByValueArrayList(String value){
        int intValue = Integer.parseInt(value);
        synchronized(this) {
            arrayList.indexOf(intValue);
        }
    }
    public void removingInTheBeginningArrayList(){
        synchronized(this) {
                arrayList.remove(0);
        }
    }
    public void removingInTheMiddleArrayList(){
        synchronized(this) {
                arrayList.remove(arrayList.size() / 2);
            }
    }
    public void removingInTheEndArrayList(){

        synchronized(this){
            arrayList.remove(arrayList.size()-1);
        }
    }


    public void addingInTheBeginningLinkedList(){
        synchronized(this) {
                linkedList.add(0);
            }
    }
    public void addingInTheMiddleLinkedList(){
        synchronized(this) {
                linkedList.add(linkedList.size() / 2);
            }
    }
    public void addingInTheEndLinkedList(){

            synchronized (this) {
                linkedList.add(linkedList.size() - 1);
            }

    }
    public void searchByValueLinkedList(String value){
        int intValue = Integer.parseInt(value);
        synchronized(this) {
            linkedList.indexOf(intValue);
        }
    }
    public void removingInTheBeginningLinkedList(){

            synchronized (this) {
                linkedList.remove(0);
            }
    }
    public void removingInTheMiddleLinkedList(){
            synchronized (this) {
                linkedList.remove(linkedList.size() / 2);
            }
    }
    public void removingInTheEndLinkedList(){
            synchronized (this) {
                linkedList.remove(linkedList.size() - 1);
            }
    }


    public void addingInTheBeginningCopyOnWriteArrayList(){
        synchronized(this) {
                copyOnWriteArrayList.add(0);
            }
    }
    public void addingInTheMiddleCopyOnWriteArrayList(){
        synchronized(this) {
                copyOnWriteArrayList.add(copyOnWriteArrayList.size() / 2);
        }
    }
    public void addingInTheEndCopyOnWriteArrayList(){
        synchronized(this) {
                copyOnWriteArrayList.add(copyOnWriteArrayList.size()-1);
            }
    }
    public void searchByValueCopyOnWriteArrayList(String value){
        int intValue = Integer.parseInt(value);
        synchronized(this) {
            copyOnWriteArrayList.indexOf(intValue);
        }
    }
    public void removingInTheBeginningCopyOnWriteArrayList(){
        synchronized(this) {
                copyOnWriteArrayList.remove(0);
        }
    }
    public void removingInTheMiddleCopyOnWriteArrayList(){
        synchronized(this) {
                copyOnWriteArrayList.remove(copyOnWriteArrayList.size() / 2);
            }
    }
    public void removingInTheEndCopyOnWriteArrayList(){
        synchronized(this) {
                copyOnWriteArrayList.remove(copyOnWriteArrayList.size()-1);
            }
    }

    private void log(String message){
        Log.i("Callback",message);
    }

    public long measureTime(Callable callable){
        long time = System.currentTimeMillis();
        removingInTheEndCopyOnWriteArrayList();
        long threadTime = System.currentTimeMillis() - time;
        return threadTime;
    }

    public long measureThreadTime(Callable<Void> collectionsOperation){
        long time = System.currentTimeMillis();
        try {
            collectionsOperation.call();
        } catch (Exception e) {
            e.printStackTrace();
        }
        long threadTime = System.currentTimeMillis() - time;
        return threadTime;
    }


}

