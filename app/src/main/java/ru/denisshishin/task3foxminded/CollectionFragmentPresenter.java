package ru.denisshishin.task3foxminded;

import android.os.Handler;
import android.os.Looper;
import android.view.View;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import moxy.InjectViewState;
import moxy.MvpPresenter;

@InjectViewState
public class CollectionFragmentPresenter extends MvpPresenter<CollectionFragmentView> {
    public CollectionFragmentPresenter(){}

    public void presentTvFragment() {

        int numberOfCores = Runtime.getRuntime().availableProcessors();
        LinkedBlockingQueue<Runnable> fifoQueue = new LinkedBlockingQueue<Runnable>();
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(numberOfCores, numberOfCores,
                1, TimeUnit.SECONDS, fifoQueue);

         getViewState().showPbCollectonsFragment();

        threadPool.execute(new Runnable() {
            @Override
            public void run() {
                long time = System.currentTimeMillis();
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                long time2 = System.currentTimeMillis() - time;

                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    @Override
                    public void run() {
                        getViewState().showTvFragment(String.valueOf(time2));
                        getViewState().hidePbCollectonsFragment();

                    }
                });
            }

        });

        threadPool.execute(new Runnable() {
            @Override
            public void run() {
                long time = System.currentTimeMillis();
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                long time2 = System.currentTimeMillis() - time;

                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    @Override
                    public void run() {
                        getViewState().showTv2Fragment(String.valueOf(time2));
                        getViewState().hidePbCollectons2();

                    }
                });
            }

        });

    }

    public void presentPbCollectionsFragment(){
        getViewState().showPbCollectonsFragment();
    }

    public void hidePbPresenter(){
        getViewState().hidePbCollectonsFragment();
    }

    ArrayList arrayList = new ArrayList();
    LinkedList linkedList = new LinkedList();
    CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();

    public void addingInTheBeginningArrayList(String value){
        int intValue = Integer.parseInt(value);

        for (int i = 0; i < intValue; i++) {
            arrayList.add(0, i);
        }
    }
    ///!
    public void addingInTheMiddleArrayList(String value){
        int intValue = Integer.parseInt(value);

        for (int i = 0; i < intValue; i++) {
            arrayList.add(1, i);
        }
    }
    public void addingInTheEndArrayList(String value){
        int intValue = Integer.parseInt(value);

        for (int i = 0; i < intValue; i++) {
            arrayList.add(i);
        }
    }
    public void searchByValueArrayList(String value){
        int intValue = Integer.parseInt(value);
        arrayList.indexOf(intValue);

    }

    public void removingInTheBeginningArrayList(String value){
        int intValue = Integer.parseInt(value);

        for (int i = 0; i < intValue; i++) {
            arrayList.remove(0);
        }
    }
    //!
    public void removingInTheMiddleArrayList(String value){
        int intValue = Integer.parseInt(value);

        for (int i = 0; i < intValue; i++) {
            arrayList.remove(1);
        }
    }
    public void removingInTheEndArrayList(String value){
        int intValue = Integer.parseInt(value);

        for (int i = 0; i < intValue; i++) {
            arrayList.remove(i);
        }
    }

    public void addingInTheBeginningLinkedList(String value){
        int intValue = Integer.parseInt(value);

        for (int i = 0; i < intValue; i++) {
            linkedList.addFirst(i);
        }
    }

}

