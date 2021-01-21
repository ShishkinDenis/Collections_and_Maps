package ru.denisshishin.task3foxminded;

import android.os.Handler;
import android.os.Looper;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;


import java.util.concurrent.Callable;

import io.reactivex.rxjava3.android.plugins.RxAndroidPlugins;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.observers.TestObserver;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import io.reactivex.rxjava3.schedulers.Schedulers;
import io.reactivex.rxjava3.schedulers.TestScheduler;
import io.reactivex.rxjava3.subscribers.TestSubscriber;
import ru.denisshishin.task3foxminded.collections.CollectionsPresenter;
import ru.denisshishin.task3foxminded.collections.CollectionsView;
import ru.denisshishin.task3foxminded.collections.CollectionsView$$State;
import ru.denisshishin.task3foxminded.maps.MapsView$$State;

import static org.mockito.Mockito.verify;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(MockitoJUnitRunner.class)
public class ExampleUnitTest {

    TestObserver testObserver;
    CollectionsPresenter collectionsPresenter;
    @Mock
    CollectionsView$$State collectionsView$$State;
    @Mock
    TestScheduler testScheduler;
    @Mock
    Handler handler;

    @Before
    public void setUp(){
        testObserver = new TestObserver();
        testScheduler = new TestScheduler();
        RxAndroidPlugins.setInitMainThreadSchedulerHandler(scheduler -> Schedulers.trampoline());
        RxJavaPlugins.setComputationSchedulerHandler(h -> Schedulers.trampoline());
        collectionsPresenter = new CollectionsPresenter(testScheduler,testScheduler,handler);
        collectionsPresenter.setViewState(collectionsView$$State);
    }
    @Test
    public void testAddingInTheBeginningArrayList(){
        collectionsPresenter.executeCollectionsThreads("50000");
        verify(collectionsView$$State).showAddingInTheBeginningArrayList("50000");
    }

    @Test
    public void method_showAddingInTheBeginningArrayList_WasCalled(){
        collectionsView$$State.showAddingInTheBeginningArrayList("50000");
        verify(collectionsView$$State).showAddingInTheBeginningArrayList("50000");
    }
///А если сделать паблик fillingCollections?
    @Test
    public void method_showAddingInTheBeginningArrayList_WasCalled2(){
        collectionsPresenter.launchCollections("50000");
//        verify(collectionsView$$State).showAddingInTheBeginningArrayList("50000");
        verify(collectionsView$$State).showAddingInTheBeginningArrayList("50000");

    }
    @Test
    public void method_test_WasCalled(){
//       collectionsPresenter.test("50000");
        verify(collectionsView$$State).showAddingInTheBeginningArrayList("50000");

    }

    @Test
    public void method_showTvAddingNewHashMap_WasCalled(){
//        mapsView$$State.showTvAddingNewHashMap("70000");
//        verify(mapsView$$State).showTvAddingNewHashMap("70000");
    }

    @Test
    public void testProgressBar(){
//        collectionsPresenter.test2();
        verify(collectionsView$$State).showProgressBarCollectionsFragment();
    }

    @Test
    public void testProgressBar2(){
        collectionsPresenter.executeCollectionsThreads("50000");
        verify(collectionsView$$State).hideTextViewCollectionsFragment();
    }

    @Test
    public void testAddingInTheBeginningArrayList2(){
        collectionsPresenter.executeCollectionsThreads("50000");
        verify(collectionsView$$State).showAddingInTheBeginningArrayList("50000");
    }

    @Test
    public void testAddingInTheBeginningArrayList3(){
        collectionsPresenter.launchCollections("50000");
        verify(collectionsView$$State).showAddingInTheBeginningArrayList("50000");
    }

    @Test
    public void testAddingInTheMiddleArrayList() {
        collectionsPresenter.executeCollectionsThreads("50000");
        verify(collectionsView$$State).showAddingInTheMiddleArrayList("50000");
    }

    @Test
    public void testObserve() {
        collectionsPresenter.createObservable(() -> collectionsPresenter.addingInTheMiddleArrayList())
                .subscribe(testObserver);
        testObserver.assertValue(3000L);
    }

//    Поставить аннотацию @Mock?
    //поменял core на inline в gradle


    /*    @Mock
//    Scheduler processScheduler;
    @Mock
//    Scheduler observerScheduler;
    @Mock
//    Handler handler;
//
//    @Rule
//    public MockitoRule mockitoRule = MockitoJUnit.rule();
//
//    @Test
//    public void fillingMapsIsCorrect(){
//
//       // Scheduler processScheduler = Schedulers.computation();
//      //  Scheduler observerScheduler = AndroidSchedulers.mainThread();
//     //   Handler handler = new Handler(Looper.getMainLooper());
//        //замокай шедулеры и хендлеры
//
//        MapsPresenter mapsPresenter = new MapsPresenter(observerScheduler,processScheduler,handler);
//
//        HashMap hashMap = new HashMap();
//        TreeMap treeMap = new TreeMap();
//
//        mapsPresenter.fillMaps2("200",hashMap,treeMap);
//
//        assertEquals(200,hashMap.size());
//
//    }
//
    @Test
    public void rxIsCorrect() {
        Scheduler processScheduler = Schedulers.computation();
        Scheduler observerScheduler = AndroidSchedulers.mainThread();
        Handler handler = new Handler(Looper.getMainLooper());
        CollectionsPresenter collectionsPresenter = new CollectionsPresenter(observerScheduler,processScheduler,handler);

        Observable
                .create(o -> {
                    long time = System.currentTimeMillis();
                   collectionsPresenter.addingInTheBeginningArrayList();
                    long threadTime = System.currentTimeMillis() - time;
                    o.onNext(threadTime);
                })
                .subscribeOn(processScheduler)
                .observeOn(observerScheduler)
                .subscribe(s-> getViewState().showAddingInTheBeginningArrayList(s + " ms"));
    }



    наполняются ли каждая коллекция введенным значением
    проверка времени выполнения не равно 0


    тестирование RxJava
//
//    @Test
//    public void addingIsCorrect() {
//
//        assertEquals(arrayList,);
//        TestExample testExample = new TestExample();
//        testExample.addingInTheBeginningArrayList2();
//    }
//    добавляет ли метод один элемент
//    удаляет и метод элемнт
//    ДЕЙСТвительно ли удаляется элемент?
//
//    private TestScheduler testScheduler;
//    @Mock
//    private MapsPresenter mapsPresenter;
//
//    @Mock
//    Handler handler2;
//
//
//    @Test
//    public void launchCollectionsShouldUpdateViews(){
//
//        testScheduler = new TestScheduler();
//        mapsPresenter = new MapsPresenter(testScheduler,testScheduler,handler2);
//
//        mapsPresenter.launchMaps("500");
//
//        testScheduler.triggerActions();
//
//        verify(mapsPresenter).getViewState().showTvAddingNewHashMap("500");
//
//
//
//


//    }*/



}