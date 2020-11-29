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

    public void presentTvFragment(String value) {

        int numberOfCores = Runtime.getRuntime().availableProcessors();
        LinkedBlockingQueue<Runnable> fifoQueue = new LinkedBlockingQueue<Runnable>();
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(numberOfCores, numberOfCores,
                1, TimeUnit.SECONDS, fifoQueue);

        getViewState().hideTextViewCollectionsFragment();
         getViewState().showProgressBarCollectionsFragment();

       /* threadPool.execute(new Runnable() {
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

        });*/

        //ArrayList
        threadPool.execute(new Runnable() {
            @Override
            public void run() {
                long time = System.currentTimeMillis();
                addingInTheBeginningArrayList(value);
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
                long time = System.currentTimeMillis();
                addingInTheMiddleArrayList(value);
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
                addingInTheEndArrayList(value);
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
                removingInTheBeginningArrayList(value);
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
                removingInTheMiddleArrayList(value);
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
                removingInTheEndArrayList(value);
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
                addingInTheBeginningLinkedList(value);
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
                addingInTheMiddleLinkedList(value);
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
                addingInTheEndLinkedList(value);
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
                removingInTheBeginningLinkedList(value);
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
                removingInTheMiddleLinkedList(value);
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
                removingInTheEndLinkedList(value);
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
                addingInTheBeginningCopyOnWriteArrayList(value);
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
                addingInTheMiddleCopyOnWriteArrayList(value);
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
                addingInTheEndCopyOnWriteArrayList(value);
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
                removingInTheBeginningCopyOnWriteArrayList(value);
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
                removingInTheMiddleCopyOnWriteArrayList(value);
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
                removingInTheEndCopyOnWriteArrayList(value);
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


   // ArrayList arrayList = new ArrayList();
  //  LinkedList linkedList = new LinkedList();
   // CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();


    public void addingInTheBeginningArrayList(String value){
        int intValue = Integer.parseInt(value);
        ArrayList arrayList = new ArrayList();

        for (int i = 0; i < intValue; i++) {
            arrayList.add(0, i);
        }
        arrayList.clear();
    }
    public void addingInTheMiddleArrayList(String value){
        int intValue = Integer.parseInt(value);
        ArrayList arrayList = new ArrayList();

        for (int i = 0; i < intValue; i++) {
            arrayList.add(arrayList.size()/2, i);
        }
        arrayList.clear();
    }
    public void addingInTheEndArrayList(String value){
        int intValue = Integer.parseInt(value);
        ArrayList arrayList = new ArrayList();

        for (int i = 0; i < intValue; i++) {
            arrayList.add(i, i);
        }
        arrayList.clear();
    }
    public void searchByValueArrayList(String value){
        int intValue = Integer.parseInt(value);
        ArrayList arrayList = new ArrayList();

        for (int i = 0; i < intValue; i++) {
            arrayList.add(i, i);
        }

        arrayList.indexOf(intValue);
        arrayList.clear();

    }
    public void removingInTheBeginningArrayList(String value){
        int intValue = Integer.parseInt(value);
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < intValue; i++) {
            arrayList.add(i, i);
        }

        for (int i = 0; i < intValue; i++) {
            arrayList.remove(0);
        }
        arrayList.clear();
    }
    public void removingInTheMiddleArrayList(String value){
        int intValue = Integer.parseInt(value);

        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < intValue; i++) {
            arrayList.add(i, i);
        }

        for (int i = 0; i < intValue; i++) {
            arrayList.remove(arrayList.size()/2);
        }
        arrayList.clear();
    }
    //!
    public void removingInTheEndArrayList(String value){
        int intValue = Integer.parseInt(value);
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < intValue; i++) {
            arrayList.add(i, i);
        }
       // for (int i = 0; i < intValue; i++) {
       //     arrayList.remove(i);
     //   }
        arrayList.clear();
    }


    public void addingInTheBeginningLinkedList(String value){
        int intValue = Integer.parseInt(value);

        LinkedList linkedList = new LinkedList();

        for (int i = 0; i < intValue; i++) {
            linkedList.addFirst(i);
        }
        linkedList.clear();
    }
    public void addingInTheMiddleLinkedList(String value){
        int intValue = Integer.parseInt(value);
        LinkedList linkedList = new LinkedList();
        for (int i = 0; i < intValue; i++) {
            linkedList.add(linkedList.size()/2);
        }
        linkedList.clear();
    }
    public void addingInTheEndLinkedList(String value){
        int intValue = Integer.parseInt(value);
        LinkedList linkedList = new LinkedList();
        for (int i = 0; i < intValue; i++) {
            linkedList.addLast(i);
        }
        linkedList.clear();
    }
    public void searchByValueLinkedList(String value){
        int intValue = Integer.parseInt(value);
        LinkedList linkedList = new LinkedList();
        for (int i = 0; i < intValue; i++) {
            linkedList.add(i);
        }
        linkedList.indexOf(intValue);
        linkedList.clear();
    }
    public void removingInTheBeginningLinkedList(String value){
        int intValue = Integer.parseInt(value);


   //     for (int i = 0; i < intValue; i++) {
   //         linkedList.removeFirst();
    //    }
    }
    public void removingInTheMiddleLinkedList(String value){
        int intValue = Integer.parseInt(value);

     //   for (int i = 0; i < intValue; i++) {
   //         linkedList.remove();
   //     }
    }
    public void removingInTheEndLinkedList(String value){
        int intValue = Integer.parseInt(value);

        //for (int i = 0; i < intValue; i++) {
      //      linkedList.remove(i);
     //   }
    }


    public void addingInTheBeginningCopyOnWriteArrayList(String value){
        int intValue = Integer.parseInt(value);
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();

        for (int i = 0; i < intValue; i++) {
            copyOnWriteArrayList.add(0, i);
        }
        copyOnWriteArrayList.clear();
    }
    public void addingInTheMiddleCopyOnWriteArrayList(String value){
        int intValue = Integer.parseInt(value);
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        for (int i = 0; i < intValue; i++) {
            copyOnWriteArrayList.add(copyOnWriteArrayList.size()/2, i);
        }
        copyOnWriteArrayList.clear();
    }
    public void addingInTheEndCopyOnWriteArrayList(String value){
        int intValue = Integer.parseInt(value);
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        for (int i = 0; i < intValue; i++) {
            copyOnWriteArrayList.add(i);
        }
        copyOnWriteArrayList.clear();
    }
    public void searchByValueCopyOnWriteArrayList(String value){
        int intValue = Integer.parseInt(value);
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        for (int i = 0; i < intValue; i++) {
            copyOnWriteArrayList.add(i);
        }
        copyOnWriteArrayList.indexOf(intValue);
        copyOnWriteArrayList.clear();
    }
    public void removingInTheBeginningCopyOnWriteArrayList(String value){
        int intValue = Integer.parseInt(value);
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        for (int i = 0; i < intValue; i++) {
            copyOnWriteArrayList.add(i);
        }
        for (int i = 0; i < intValue; i++) {
            copyOnWriteArrayList.remove(0);
        }
        copyOnWriteArrayList.clear();
    }
    public void removingInTheMiddleCopyOnWriteArrayList(String value){
        int intValue = Integer.parseInt(value);
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        for (int i = 0; i < intValue; i++) {
            copyOnWriteArrayList.add(i);
        }

       for (int i = 0; i < intValue; i++) {
            copyOnWriteArrayList.remove(copyOnWriteArrayList.size()/2);
        }
       copyOnWriteArrayList.clear();
    }
    //!
    public void removingInTheEndCopyOnWriteArrayList(String value){
        int intValue = Integer.parseInt(value);
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        for (int i = 0; i < intValue; i++) {
            copyOnWriteArrayList.add(i);
        }

      //  for (int i = 0; i < intValue; i++) {
     //       copyOnWriteArrayList.remove(i);
     //   }

        copyOnWriteArrayList.clear();
    }

}

