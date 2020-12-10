package ru.denisshishin.task3foxminded.collections;

import android.os.Handler;
import android.os.Looper;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import moxy.InjectViewState;
import moxy.MvpPresenter;
import ru.denisshishin.task3foxminded.ReadyCallback;

@InjectViewState
public class CollectionsPresenter extends MvpPresenter<CollectionsView> {

    public CollectionsPresenter(){}

    public void launchCollections(String inputValue){

        ReadyCallback readyCallback = () -> new Handler(Looper.getMainLooper()).post(() ->
                executeCollectionsThreads(inputValue));

        new Thread(() -> {
            fillCollections(inputValue);
                readyCallback.onReady();
        }).start();
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

    public void executeCollectionsThreads(String value) {

        int numberOfCores = Runtime.getRuntime().availableProcessors();
        LinkedBlockingQueue<Runnable> fifoQueue = new LinkedBlockingQueue<Runnable>();
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(numberOfCores, numberOfCores,
                1, TimeUnit.SECONDS, fifoQueue);

        getViewState().hideTextViewCollectionsFragment();
        getViewState().showProgressBarCollectionsFragment();

        Handler handler = new Handler(Looper.getMainLooper());


        //ArrayList
        threadPool.execute(() -> {
            long time = System.currentTimeMillis();
            addingInTheBeginningArrayList();
            long threadTime = System.currentTimeMillis() - time;

            handler.post(() -> getViewState().showAddingInTheBeginningArrayList(threadTime + "ms"));
        });
        threadPool.execute(() -> {
            long time = System.currentTimeMillis();
            addingInTheMiddleArrayList();
            long threadTime = System.currentTimeMillis() - time;

            handler.post(() -> getViewState().showAddingInTheMiddleArrayList(threadTime + " ms"));
        });
        threadPool.execute(() -> {
            long time = System.currentTimeMillis();
            addingInTheEndArrayList();
            long threadTime = System.currentTimeMillis() - time;

            handler.post(() -> getViewState().showAddingInTheEndArrayList(threadTime + " ms"));
        });

        threadPool.execute(() -> {
            long time = System.currentTimeMillis();
            searchByValueArrayList(value);
            long threadTime = System.currentTimeMillis() - time;

            handler.post(() -> getViewState().showSearchByValueArrayList(threadTime + " ms"));
        });

        threadPool.execute(() -> {
            long time = System.currentTimeMillis();
            removingInTheBeginningArrayList();
            long threadTime = System.currentTimeMillis() - time;

            handler.post(() -> getViewState().showRemovingInTheBeginningArrayList(threadTime + " ms"));
        });
        threadPool.execute(() -> {
            long time = System.currentTimeMillis();
            removingInTheMiddleArrayList();
            long threadTime = System.currentTimeMillis() - time;

           handler.post(() -> getViewState().showRemovingInTheMiddleArrayList(threadTime + " ms"));
        });
        threadPool.execute(() -> {
            long time = System.currentTimeMillis();
            removingInTheEndArrayList();
            long threadTime = System.currentTimeMillis() - time;

            handler.post(() -> getViewState().showRemovingInTheEndArrayList(threadTime + " ms"));
        });

        //LinkedList
        threadPool.execute(() -> {
            long time = System.currentTimeMillis();
            addingInTheBeginningLinkedList();
            long threadTime = System.currentTimeMillis() - time;

            handler.post(() -> getViewState().showAddingInTheBeginningLinkedList(threadTime + " ms"));
        });
        threadPool.execute(() -> {
            long time = System.currentTimeMillis();
            addingInTheMiddleLinkedList();
            long threadTime = System.currentTimeMillis() - time;

            handler.post(() -> getViewState().showAddingInTheMiddleLinkedList(threadTime + " ms"));
        });
        threadPool.execute(() -> {
            long time = System.currentTimeMillis();
            addingInTheEndLinkedList();
            long threadTime = System.currentTimeMillis() - time;

            handler.post(() -> getViewState().showAddingInTheEndLinkedList(threadTime + " ms"));
        });

        threadPool.execute(() -> {
            long time = System.currentTimeMillis();
            searchByValueLinkedList(value);
            long threadTime = System.currentTimeMillis() - time;

            handler.post(() -> getViewState().showSearchByValueLinkedList(threadTime + " ms"));
        });

        threadPool.execute(() -> {
            long time = System.currentTimeMillis();
            removingInTheBeginningLinkedList();
            long threadTime = System.currentTimeMillis() - time;

            handler.post(() -> getViewState().showRemovingInTheBeginningLinkedList(threadTime + " ms"));
        });
        threadPool.execute(() -> {
            long time = System.currentTimeMillis();
            removingInTheMiddleLinkedList();
            long threadTime = System.currentTimeMillis() - time;

            handler.post(() -> getViewState().showRemovingInTheMiddleLinkedList(threadTime + " ms"));
        });
        threadPool.execute(() -> {
            long time = System.currentTimeMillis();
            removingInTheEndLinkedList();
            long threadTime = System.currentTimeMillis() - time;

            handler.post(() -> getViewState().showRemovingInTheEndLinkedList(threadTime + " ms"));
        });

        //CopyOnWriteLinkedList
        threadPool.execute(() -> {
            long time = System.currentTimeMillis();
            addingInTheBeginningCopyOnWriteArrayList();
            long threadTime = System.currentTimeMillis() - time;

            handler.post(() -> getViewState().showAddingInTheBeginningCopyOnWriteArrayList(threadTime + " ms"));
        });
        threadPool.execute(() -> {
            long time = System.currentTimeMillis();
            addingInTheMiddleCopyOnWriteArrayList();
            long threadTime = System.currentTimeMillis() - time;

            handler.post(() -> getViewState().showAddingInTheMiddleCopyOnWriteArrayList(threadTime + " ms"));
        });
        threadPool.execute(() -> {
            long time = System.currentTimeMillis();
            addingInTheEndCopyOnWriteArrayList();
            long threadTime = System.currentTimeMillis() - time;

            handler.post(() -> getViewState().showAddingInTheEndCopyOnWriteArrayList(threadTime + " ms"));
        });

        threadPool.execute(() -> {
            long time = System.currentTimeMillis();
            searchByValueCopyOnWriteArrayList(value);
            long threadTime = System.currentTimeMillis() - time;

            handler.post(() -> getViewState().showSearchByValueCopyOnWriteArrayList(threadTime + " ms"));
        });

        threadPool.execute(() -> {
            long time = System.currentTimeMillis();
            removingInTheBeginningCopyOnWriteArrayList();
            long threadTime = System.currentTimeMillis() - time;

            handler.post(() -> getViewState().showRemovingInTheBeginningCopyOnWriteArrayList(threadTime + " ms"));
        });
        threadPool.execute(() -> {
            long time = System.currentTimeMillis();
            removingInTheMiddleCopyOnWriteArrayList();
            long threadTime = System.currentTimeMillis() - time;

            handler.post(() -> getViewState().showRemovingInTheMiddleCopyOnWriteArrayList(threadTime + " ms"));
        });
        threadPool.execute(() -> {
            long time = System.currentTimeMillis();
            removingInTheEndCopyOnWriteArrayList();
            long threadTime = System.currentTimeMillis() - time;

            handler.post(() -> getViewState().showRemovingInTheEndCopyOnWriteArrayList(threadTime + " ms"));
        });

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


}

