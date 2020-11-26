package ru.denisshishin.task3foxminded;

import android.os.Handler;
import android.os.Looper;

import java.util.HashMap;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import moxy.MvpPresenter;

public class MapsFragmentPresenter extends MvpPresenter<MapsFragmentView> {

    public MapsFragmentPresenter(){}

    public void presentTvMapsFragment(String value) {
        //getViewState().showTvMapsFragment();
        int numberOfCores = Runtime.getRuntime().availableProcessors();
        LinkedBlockingQueue<Runnable> fifoQueue = new LinkedBlockingQueue<Runnable>();
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(numberOfCores, numberOfCores,
                1, TimeUnit.SECONDS, fifoQueue);

        getViewState().showPbMapsFragment();

       // String value = getViewState().getNumberMapsFragment();

        threadPool.execute(new Runnable() {
            @Override
            public void run() {
                long time = System.currentTimeMillis();
               /* try {
                    Thread.sleep(5000);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }*/
                addingNewElementHashMap(value);
                long time2 = System.currentTimeMillis() - time;

              //  int value2 = Integer.parseInt(value) + 999;


                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    @Override
                    public void run() {
                        //getViewState().showTvMapsFragment(String.valueOf(time2));
                        getViewState().showTvMapsFragment(String.valueOf(time2) + " ms");
                       // getViewState().getNumberMapsFragment();
                        getViewState().hidePbMapsFragment();

                    }
                });
            }

        });

        threadPool.execute(new Runnable() {
            @Override
            public void run() {
                long time = System.currentTimeMillis();
               /* try {
                    Thread.sleep(5000);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }*/
                removingElementHashMap(value);
                long time2 = System.currentTimeMillis() - time;

              //  int value2 = Integer.parseInt(value) + 999;


                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    @Override
                    public void run() {
                        //getViewState().showTvMapsFragment(String.valueOf(time2));
                        getViewState().showTvMapsFragment(String.valueOf(time2) + " ms");
                       // getViewState().getNumberMapsFragment();
                       // getViewState().hidePbMapsFragment();

                    }
                });
            }

        });

    }

    public void addingNewElementHashMap(String value){
        int value2 = Integer.parseInt(value);

        HashMap hashMap = new HashMap();
        for (int i = 0; i < value2; i++) {
            hashMap.put(i, i);
        }
    }
    public void removingElementHashMap(String value){
        int value2 = Integer.parseInt(value);

        HashMap hashMap = new HashMap();
        for (int i = 0; i < value2; i++) {
            hashMap.remove(i, i);
        }
    }
}
