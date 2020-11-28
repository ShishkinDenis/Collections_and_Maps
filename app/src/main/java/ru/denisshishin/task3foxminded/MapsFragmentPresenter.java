package ru.denisshishin.task3foxminded;

import android.os.Handler;
import android.os.Looper;

import java.util.HashMap;
import java.util.TreeMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import moxy.MvpPresenter;

public class MapsFragmentPresenter extends MvpPresenter<MapsFragmentView> {

    public MapsFragmentPresenter(){}

    public void presentTvMapsFragment(String value) {
        long time = System.currentTimeMillis();
        addingNewElementHashMap(value);
        long time2 = System.currentTimeMillis() - time;
        getViewState().showTvAddingNewHashMap(String.valueOf(time2) + " ms");

        long time3 = System.currentTimeMillis();
        addingNewElementTreeMap(value);
        long time4 = System.currentTimeMillis() - time;
        getViewState().showTvAddingNewTreeMap(String.valueOf(time4) + " ms");


        int numberOfCores = Runtime.getRuntime().availableProcessors();
        LinkedBlockingQueue<Runnable> fifoQueue = new LinkedBlockingQueue<Runnable>();
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(numberOfCores, numberOfCores,
                1, TimeUnit.SECONDS, fifoQueue);

        //getViewState().showPbMapsFragment();

       /* Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                long time = System.currentTimeMillis();
                addingNewElementHashMap(value);
                long time2 = System.currentTimeMillis() - time;

                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    @Override
                    public void run() {
                        getViewState().showTvAddingNewHashMap(String.valueOf(time2) + " ms");
                        getViewState().hidePbMapsFragment();
                    }
                });
            }
        });
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
       /*Future future = threadPool.submit(new Runnable() {
            @Override
            public void run() {
                long time = System.currentTimeMillis();
                addingNewElementHashMap(value);
                long time2 = System.currentTimeMillis() - time;

                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    @Override
                    public void run() {
                        getViewState().showTvAddingNewHashMap(String.valueOf(time2) + " ms");
                        getViewState().hidePbMapsFragment();

                    }
                });
            }

        });
        try {
            future.get();
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }
       /* threadPool.execute(new Runnable() {
            @Override
            public void run() {
                long time = System.currentTimeMillis();
                addingNewElementHashMap(value);
                long time2 = System.currentTimeMillis() - time;

                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    @Override
                    public void run() {
                        getViewState().showTvAddingNewHashMap(String.valueOf(time2) + " ms");
                        getViewState().hidePbMapsFragment();

                    }
                });
            }

        });*/
        threadPool.execute(new Runnable() {
            @Override
            public void run() {
                long time = System.currentTimeMillis();
                removingElementHashMap(value);
                long time2 = System.currentTimeMillis() - time;

                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    @Override
                    public void run() {
                        getViewState().showTvRemovingHashMap(String.valueOf(time2) + " ms");
                    }
                });
            }
        });
        threadPool.execute(new Runnable() {
            @Override
            public void run() {
                long time = System.currentTimeMillis();
                searchByKeyHashMap(value);
                long time2 = System.currentTimeMillis() - time;

                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    @Override
                    public void run() {
                        getViewState().showTvSearchByKeyHashMap(String.valueOf(time2) + " ms");
                    }
                });
            }
        });

       /* Future future2 = threadPool.submit(new Runnable() {
            @Override
            public void run() {
                long time = System.currentTimeMillis();
                addingNewElementTreeMap(value);
                long time2 = System.currentTimeMillis() - time;

                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    @Override
                    public void run() {
                        getViewState().showTvAddingNewTreeMap(String.valueOf(time2) + " ms");
                        //     getViewState().hidePbMapsFragment();

                    }
                });
            }

        });
        try {
            future2.get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        */

       /* Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                long time = System.currentTimeMillis();
                addingNewElementTreeMap(value);
                long time2 = System.currentTimeMillis() - time;

                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    @Override
                    public void run() {
                        getViewState().showTvAddingNewTreeMap(String.valueOf(time2) + " ms");
                        //     getViewState().hidePbMapsFragment();

                    }
                });
            }

        });
        thread2.start();
        try {
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/

        /*threadPool.execute(new Runnable() {
            @Override
            public void run() {
                long time = System.currentTimeMillis();
                addingNewElementTreeMap(value);
                long time2 = System.currentTimeMillis() - time;

                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    @Override
                    public void run() {
                        getViewState().showTvAddingNewTreeMap(String.valueOf(time2) + " ms");
                   //     getViewState().hidePbMapsFragment();

                    }
                });
            }

        });*/
        threadPool.execute(new Runnable() {
            @Override
            public void run() {
                long time = System.currentTimeMillis();
                removingElementTreeMap(value);
                long time2 = System.currentTimeMillis() - time;

                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    @Override
                    public void run() {
                        getViewState().showTvRemovingTreeMap(String.valueOf(time2) + " ms");
                    }
                });
            }
        });
        threadPool.execute(new Runnable() {
            @Override
            public void run() {
                long time = System.currentTimeMillis();
                searchByKeyTreeMap(value);
                long time2 = System.currentTimeMillis() - time;

                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    @Override
                    public void run() {
                        getViewState().showTvSearchByKeyTreeMap(String.valueOf(time2) + " ms");
                    }
                });
            }
        });

    }

    HashMap hashMap = new HashMap();

    public void addingNewElementHashMap(String value){
        int intValue = Integer.parseInt(value);

        for (int i = 0; i < intValue; i++) {
            hashMap.put(i, i);
        }
    }

    public void removingElementHashMap(String value){
        int intValue = Integer.parseInt(value);
        for (int i = 0; i < intValue; i++) {
            hashMap.remove(i, i);
        }
    }

    public void searchByKeyHashMap(String value){
        int intValue = Integer.parseInt(value);
        hashMap.get(intValue);
    }



    TreeMap treeMap = new TreeMap();

    public void addingNewElementTreeMap(String value){
        int intValue = Integer.parseInt(value);

        for (int i = 0; i < intValue; i++) {
            treeMap.put(i, i);
        }
    }

    public void removingElementTreeMap(String value){
        int intValue = Integer.parseInt(value);
        for (int i = 0; i < intValue; i++) {
            treeMap.remove(i, i);
        }
    }

    public void searchByKeyTreeMap(String value){
        int intValue = Integer.parseInt(value);
        treeMap.get(intValue);
    }




}


