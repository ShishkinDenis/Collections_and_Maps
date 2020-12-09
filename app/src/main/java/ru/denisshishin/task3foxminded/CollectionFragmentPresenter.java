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

        log("Creating callback");

        CollectionFragmentPresenter.ReadyCallback readyCallback = new CollectionFragmentPresenter.ReadyCallback() {
            @Override
            public void onReady() {
                log("Ready to do anything");
                // getViewState().showTvFragment("Callback works!");
                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    @Override
                    public void run() {
                        //getViewState().showAddingInTheBeginningArrayList("Callback works!");

                        presentTvFragment(string);

                }
                });
               // presentTvFragment(string);
            }
        };

        log("callback created,launching thread");

        new Thread(new Runnable() {
            @Override
            public void run() {
                    //Thread.sleep(5000);
                    log("Start filling collections");
               // try {
              //      Thread.sleep(5000);
              //  } catch (InterruptedException e) {
              //      e.printStackTrace();
             //   }
                fillCollections(string);
                    log("End filling collections");

                    log("Start Callback");
                    readyCallback.onReady();
                    log("End Callback");
            }
        }).start();

       // readyCallback.onReady();
        log("thread launched");

    }

    private void log(String message){
        Log.i("Callback",message);
    }

    private interface ReadyCallback{
        void onReady();
    }

    public void fillCollections(String value) {
    //new Thread(new Runnable() {
    //    public void run() {
            //arrayList.clear();
            //linkedList.clear();
            //copyOnWriteArrayList.clear();

            int intValue = Integer.parseInt(value);

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
    //    }
   // }).start();
}

    public void presentTvFragment(String value) {
   //     arrayList.clear();
    //    linkedList.clear();
   //     copyOnWriteArrayList.clear();

    //    int intValue = Integer.parseInt(value);

   //     for (int i = 0; i < intValue; i++) {
   //         arrayList.add(i);
    //        linkedList.add(i);
    //    }

        //Костьль!Заполняю в 10 000 раз меньшим количеством элементов
   //     for (int i = 0; i < intValue/10000; i++) {
    //        copyOnWriteArrayList.add(i);
     //   }


        int numberOfCores = Runtime.getRuntime().availableProcessors();
        LinkedBlockingQueue<Runnable> fifoQueue = new LinkedBlockingQueue<Runnable>();
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(numberOfCores, numberOfCores,
                1, TimeUnit.SECONDS, fifoQueue);

        getViewState().hideTextViewCollectionsFragment();
        getViewState().showProgressBarCollectionsFragment();

        //ArrayList

       // String s = "s";

        //superMethod(threadPool,addingInTheBeginningArrayList(),getViewState().showAddingInTheBeginningArrayList(s));
       /* superMethod(threadPool, () -> {
            addingInTheBeginningArrayList();
            return null;
        }, () -> {
            getViewState().showAddingInTheBeginningArrayList(addingInTheBeginningArrayList());
            return null;
        });

        measureThreadTime(new Callable<Void>() {
            @Override
            public Void call() throws Exception {
                addingInTheBeginningArrayList();
                return null;
            }
        });*/

        threadPool.execute(new Runnable() {
            @Override
            public void run() {
                long time = System.currentTimeMillis();
                addingInTheBeginningArrayList();
                long threadTime = System.currentTimeMillis() - time;

                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    @Override
                    public void run() {
                        getViewState().showAddingInTheBeginningArrayList(String.valueOf(threadTime) + " ms");
                    }
                });
            }

        });


        threadPool.execute(new Runnable() {
            @Override
            public void run() {
                //выделить в метод измерение в секундах
               // return long

               // Runnable вынести в отдельный класс
                //класс для run(),класс для handler
                //гугли примеры ThreadPool

                long time = System.currentTimeMillis();
                addingInTheMiddleArrayList();
                long threadTime = System.currentTimeMillis() - time;

                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    @Override
                    public void run() {
                        getViewState().showAddingInTheMiddleArrayList(String.valueOf(threadTime) + " ms");
                    }
                });
            }

        });
        threadPool.execute(new Runnable() {
            @Override
            public void run() {
                long time = System.currentTimeMillis();
                addingInTheEndArrayList();
                long threadTime = System.currentTimeMillis() - time;

                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    @Override
                    public void run() {
                        getViewState().showAddingInTheEndArrayList(String.valueOf(threadTime) + " ms");
                    }
                });
            }

        });

        threadPool.execute(new Runnable() {
            @Override
            public void run() {
                long time = System.currentTimeMillis();
                searchByValueArrayList(value);
                long threadTime = System.currentTimeMillis() - time;

                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    @Override
                    public void run() {
                        getViewState().showSearchByValueArrayList(String.valueOf(threadTime) + " ms");
                    }
                });
            }

        });

        threadPool.execute(new Runnable() {
            @Override
            public void run() {
                long time = System.currentTimeMillis();
                removingInTheBeginningArrayList();
                long threadTime = System.currentTimeMillis() - time;

                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    @Override
                    public void run() {
                        getViewState().showRemovingInTheBeginningArrayList(String.valueOf(threadTime) + " ms");
                    }
                });
            }

        });
        threadPool.execute(new Runnable() {
            @Override
            public void run() {
                long time = System.currentTimeMillis();
                removingInTheMiddleArrayList();
                long threadTime = System.currentTimeMillis() - time;

                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    @Override
                    public void run() {
                        getViewState().showRemovingInTheMiddleArrayList(String.valueOf(threadTime) + " ms");
                    }
                });
            }

        });
        threadPool.execute(new Runnable() {
            @Override
            public void run() {
                long time = System.currentTimeMillis();
                removingInTheEndArrayList();
                long threadTime = System.currentTimeMillis() - time;

                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    @Override
                    public void run() {
                        getViewState().showRemovingInTheEndArrayList(String.valueOf(threadTime) + " ms");
                    }
                });
            }

        });

        //LinkedList
        threadPool.execute(new Runnable() {
            @Override
            public void run() {
                long time = System.currentTimeMillis();
                addingInTheBeginningLinkedList();
                long threadTime = System.currentTimeMillis() - time;

                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    @Override
                    public void run() {
                        getViewState().showAddingInTheBeginningLinkedList(String.valueOf(threadTime) + " ms");
                    }
                });
            }

        });
        threadPool.execute(new Runnable() {
            @Override
            public void run() {
                long time = System.currentTimeMillis();
                addingInTheMiddleLinkedList();
                long threadTime = System.currentTimeMillis() - time;

                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    @Override
                    public void run() {
                        getViewState().showAddingInTheMiddleLinkedList(String.valueOf(threadTime) + " ms");
                    }
                });
            }

        });
        threadPool.execute(new Runnable() {
            @Override
            public void run() {
                long time = System.currentTimeMillis();
                addingInTheEndLinkedList();
                long threadTime = System.currentTimeMillis() - time;

                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    @Override
                    public void run() {
                        getViewState().showAddingInTheEndLinkedList(String.valueOf(threadTime) + " ms");
                    }
                });
            }

        });

        threadPool.execute(new Runnable() {
            @Override
            public void run() {
                long time = System.currentTimeMillis();
                searchByValueLinkedList(value);
                long threadTime = System.currentTimeMillis() - time;

                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    @Override
                    public void run() {
                        getViewState().showSearchByValueLinkedList(String.valueOf(threadTime) + " ms");
                    }
                });
            }

        });

        threadPool.execute(new Runnable() {
            @Override
            public void run() {
                long time = System.currentTimeMillis();
                removingInTheBeginningLinkedList();
                long threadTime = System.currentTimeMillis() - time;

                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    @Override
                    public void run() {
                        getViewState().showRemovingInTheBeginningLinkedList(String.valueOf(threadTime) + " ms");
                    }
                });
            }

        });
        threadPool.execute(new Runnable() {
            @Override
            public void run() {
                long time = System.currentTimeMillis();
                removingInTheMiddleLinkedList();
                long threadTime = System.currentTimeMillis() - time;

                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    @Override
                    public void run() {
                        getViewState().showRemovingInTheMiddleLinkedList(String.valueOf(threadTime) + " ms");
                    }
                });
            }

        });
        threadPool.execute(new Runnable() {
            @Override
            public void run() {
                long time = System.currentTimeMillis();
                removingInTheEndLinkedList();
                long threadTime = System.currentTimeMillis() - time;

                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    @Override
                    public void run() {
                        getViewState().showRemovingInTheEndLinkedList(String.valueOf(threadTime) + " ms");
                    }
                });
            }

        });

        //CopyOnWriteLinkedList
        threadPool.execute(new Runnable() {
            @Override
            public void run() {
                long time = System.currentTimeMillis();
                addingInTheBeginningCopyOnWriteArrayList();
                long threadTime = System.currentTimeMillis() - time;

                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    @Override
                    public void run() {
                        getViewState().showAddingInTheBeginningCopyOnWriteArrayList(String.valueOf(threadTime) + " ms");
                    }
                });
            }

        });
        threadPool.execute(new Runnable() {
            @Override
            public void run() {
                long time = System.currentTimeMillis();
                addingInTheMiddleCopyOnWriteArrayList();
                long threadTime = System.currentTimeMillis() - time;

                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    @Override
                    public void run() {
                        getViewState().showAddingInTheMiddleCopyOnWriteArrayList(String.valueOf(threadTime) + " ms");
                    }
                });
            }

        });
        threadPool.execute(new Runnable() {
            @Override
            public void run() {
                long time = System.currentTimeMillis();
                addingInTheEndCopyOnWriteArrayList();
                long threadTime = System.currentTimeMillis() - time;

                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    @Override
                    public void run() {
                        getViewState().showAddingInTheEndCopyOnWriteArrayList(String.valueOf(threadTime) + " ms");
                    }
                });
            }

        });

        threadPool.execute(new Runnable() {
            @Override
            public void run() {
                long time = System.currentTimeMillis();
                searchByValueCopyOnWriteArrayList(value);
                long threadTime = System.currentTimeMillis() - time;

                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    @Override
                    public void run() {
                        getViewState().showSearchByValueCopyOnWriteArrayList(String.valueOf(threadTime) + " ms");
                    }
                });
            }

        });

        threadPool.execute(new Runnable() {
            @Override
            public void run() {
                long time = System.currentTimeMillis();
                removingInTheBeginningCopyOnWriteArrayList();
                long threadTime = System.currentTimeMillis() - time;

                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    @Override
                    public void run() {
                        getViewState().showRemovingInTheBeginningCopyOnWriteArrayList(String.valueOf(threadTime) + " ms");
                    }
                });
            }

        });
        threadPool.execute(new Runnable() {
            @Override
            public void run() {
                long time = System.currentTimeMillis();
                removingInTheMiddleCopyOnWriteArrayList();
                long threadTime = System.currentTimeMillis() - time;

                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    @Override
                    public void run() {
                        getViewState().showRemovingInTheMiddleCopyOnWriteArrayList(String.valueOf(threadTime) + " ms");
                    }
                });
            }

        });
        threadPool.execute(new Runnable() {
            @Override
            public void run() {
                long time = System.currentTimeMillis();
                removingInTheEndCopyOnWriteArrayList();
                long threadTime = System.currentTimeMillis() - time;

                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    @Override
                    public void run() {
                        getViewState().showRemovingInTheEndCopyOnWriteArrayList(String.valueOf(threadTime) + " ms");
                    }
                });
            }

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
       // if (linkedList.size() != 0) {
            synchronized (this) {
                linkedList.remove(0);
            }
      //  }
    }
    public void removingInTheMiddleLinkedList(){
     //   if (linkedList.size() != 0) {
            synchronized (this) {
                linkedList.remove(linkedList.size() / 2);
            }
      //  }
    }
    public void removingInTheEndLinkedList(){
       // if (linkedList.size() != 0) {
            synchronized (this) {
                linkedList.remove(linkedList.size() - 1);
            }
     //   }
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


    public void superMethod(ThreadPoolExecutor threadPoolExecutor,Callable<Void> methodParam, Callable<Void> methodParam2){
       threadPoolExecutor.execute(new Runnable() {
            @Override
            public void run() {
                long time = System.currentTimeMillis();
                try {
                    methodParam.call();
                    // addingInTheBeginningArrayList();
                } catch (Exception e) {
                    e.printStackTrace();
                }

                long threadTime = System.currentTimeMillis() - time;

                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    @Override
                    public void run() {
                        try {
                           //  getViewState().showAddingInTheBeginningArrayList(String.valueOf(threadTime) + " ms");
                            methodParam2.call();

                            // getViewState().showAddingInTheBeginningArrayList(String.valueOf(threadTime) + " ms");
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                    }
                });
            }

        });

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

    public void superMethod2(ThreadPoolExecutor threadPoolExecutor,Callable<Void> methodParam, Callable<Void> methodParam2){
        threadPoolExecutor.execute(new Runnable() {
            long l;
            @Override
            public void run() {
                try {
                l = measureThreadTime(methodParam);
                } catch (Exception e) {
                    e.printStackTrace();
                }

                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    @Override
                    public void run() {
                        try {
                           // getViewState().showAddingInTheBeginningArrayList(String.valueOf(threadTime) + " ms");
                            methodParam2.call();

                            // getViewState().showAddingInTheBeginningArrayList(String.valueOf(threadTime) + " ms");
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                    }
                });
            }

        });

    }

}

