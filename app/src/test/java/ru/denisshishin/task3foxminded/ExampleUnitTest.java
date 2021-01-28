package ru.denisshishin.task3foxminded;

import android.os.Handler;
import android.os.Looper;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatcher;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.internal.matchers.GreaterOrEqual;
import org.mockito.junit.MockitoJUnitRunner;

import io.reactivex.rxjava3.android.plugins.RxAndroidPlugins;
import io.reactivex.rxjava3.observers.TestObserver;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import io.reactivex.rxjava3.schedulers.Schedulers;
import io.reactivex.rxjava3.schedulers.TestScheduler;
import ru.denisshishin.task3foxminded.collections.CollectionsPresenter;
import ru.denisshishin.task3foxminded.collections.CollectionsView$$State;
import ru.denisshishin.task3foxminded.maps.MapsPresenter;
import ru.denisshishin.task3foxminded.maps.MapsView$$State;

import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.ArgumentMatchers.endsWith;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;


@RunWith(MockitoJUnitRunner.class)
//@RunWith(PowerMockRunner.class)
public class ExampleUnitTest {

    TestObserver testObserver;
    @Mock
    TestScheduler testScheduler;

//    @Spy
    @Mock
    Handler handler;

//    @Mock
    Looper looper;

//    @Mock
//    Runnable runnable;

    CollectionsPresenter collectionsPresenter;
    @Mock
    CollectionsView$$State collectionsView$$State;

    MapsPresenter mapsPresenter;
    @Mock
    MapsView$$State mapsView$$State;
    private Object GreaterThan;
    private Long GreaterOrEqual = 0L;


    @Before
    public void setUp(){
//        handler = spy(new Handler());

        testObserver = new TestObserver();
        testScheduler = new TestScheduler();

        RxAndroidPlugins.setInitMainThreadSchedulerHandler(scheduler -> Schedulers.trampoline());
        RxJavaPlugins.setComputationSchedulerHandler(h -> Schedulers.trampoline());

//      collectionsPresenter = new CollectionsPresenter(testScheduler,testScheduler,handler);
        collectionsPresenter = new CollectionsPresenter(Schedulers.trampoline(),Schedulers.trampoline(), handler);
        collectionsPresenter.setViewState(collectionsView$$State);

        mapsPresenter = new MapsPresenter(testScheduler,testScheduler,handler);
        mapsPresenter = new MapsPresenter(Schedulers.trampoline(),Schedulers.trampoline(),handler);
        mapsPresenter.setViewState(mapsView$$State);
    }

    @Test
    public void collectionsArrayListOperationsAreCalled(){
        collectionsPresenter.executeCollectionsThreads("50000");

        verify(collectionsView$$State).showAddingInTheBeginningArrayList(endsWith("ms"));


        verify(collectionsView$$State).showAddingInTheBeginningArrayList(endsWith("ms"));
        verify(collectionsView$$State).showAddingInTheMiddleArrayList(endsWith("ms"));
        verify(collectionsView$$State).showAddingInTheEndArrayList(endsWith("ms"));

        verify(collectionsView$$State).showSearchByValueArrayList(endsWith("ms"));

        verify(collectionsView$$State).showRemovingInTheBeginningArrayList(endsWith("ms"));
        verify(collectionsView$$State).showRemovingInTheMiddleArrayList(endsWith("ms"));
        verify(collectionsView$$State).showRemovingInTheEndArrayList(endsWith("ms"));
    }

    @Test
    public void collectionsLinkedListOperationsAreCalled(){
        collectionsPresenter.executeCollectionsThreads("60000");

        verify(collectionsView$$State).showAddingInTheBeginningLinkedList(endsWith("ms"));


        verify(collectionsView$$State).showAddingInTheBeginningLinkedList(endsWith("ms"));
        verify(collectionsView$$State).showAddingInTheMiddleLinkedList(endsWith("ms"));
        verify(collectionsView$$State).showAddingInTheEndLinkedList(endsWith("ms"));

        verify(collectionsView$$State).showSearchByValueLinkedList(endsWith("ms"));

        verify(collectionsView$$State).showRemovingInTheBeginningLinkedList(endsWith("ms"));
        verify(collectionsView$$State).showRemovingInTheMiddleLinkedList(endsWith("ms"));
        verify(collectionsView$$State).showRemovingInTheEndLinkedList(endsWith("ms"));
    }

    @Test
    public void collectionsCopyOnWriteArrayListOperationsAreCalled(){
        collectionsPresenter.executeCollectionsThreads("70000");

        verify(collectionsView$$State).showAddingInTheBeginningCopyOnWriteArrayList(endsWith("ms"));


        verify(collectionsView$$State).showAddingInTheBeginningCopyOnWriteArrayList(endsWith("ms"));
        verify(collectionsView$$State).showAddingInTheMiddleCopyOnWriteArrayList(endsWith("ms"));
        verify(collectionsView$$State).showAddingInTheEndCopyOnWriteArrayList(endsWith("ms"));

        verify(collectionsView$$State).showSearchByValueCopyOnWriteArrayList(endsWith("ms"));

        verify(collectionsView$$State).showRemovingInTheBeginningCopyOnWriteArrayList(endsWith("ms"));
        verify(collectionsView$$State).showRemovingInTheMiddleCopyOnWriteArrayList(endsWith("ms"));
        verify(collectionsView$$State).showRemovingInTheEndCopyOnWriteArrayList(endsWith("ms"));
    }


    @Test
    public void mapsHashMapOperationsAreCalled(){
        mapsPresenter.executeMapsThreads("100000");

        verify(mapsView$$State).showTvAddingNewHashMap(endsWith("ms"));
        verify(mapsView$$State).showTvRemovingHashMap(endsWith("ms"));
        verify(mapsView$$State).showTvSearchByKeyHashMap(endsWith("ms"));
    }

    @Test
    public void mapsTreeMapOperationsAreCalled(){
        mapsPresenter.executeMapsThreads("200000");

        verify(mapsView$$State).showTvAddingNewTreeMap(endsWith("ms"));
        verify(mapsView$$State).showTvRemovingTreeMap(endsWith("ms"));
        verify(mapsView$$State).showTvSearchByKeyTreeMap(endsWith("ms"));
    }



    @Test
    public void collectionsProgressBarsAreCalled(){
        collectionsPresenter.executeCollectionsThreads("50000");
        verify(collectionsView$$State).hideTextViewCollectionsFragment();
        verify(collectionsView$$State).showProgressBarCollectionsFragment();
    }

    @Test
    public void mapsProgressBarsAreCalled(){
        mapsPresenter.executeMapsThreads("50000");
        verify(mapsView$$State).hideTextViewMapsFragment();
        verify(mapsView$$State).showProgressBarMapsFragment();
    }


    @Test
    public void noErrors() {
        collectionsPresenter.createObservable(() -> collectionsPresenter.addingInTheBeginningArrayList())
                .subscribe(testObserver);
//       testObserver.assertNoErrors();
//        Assert.assertNotNull(testObserver);
//        testObserver.assertResult(Mockito.)

        Assert.assertThat(testObserver.assertResult( new GreaterOrEqual<>(5));
//        Assert.ass


//       testObserver.assertResult(0L);

//        Mockito.argThat(arg -> arg != null);
//        testObserver.assertValue(Mockito.argThat(arg -> arg != null));
//        Assert.assertThat(testObserver,Mockito.argThat(arg -> arg != null));
//
//       assertNotNull(testObserver);
//       Mockito. ...


//        Assert.assertTrue(testObserver, GreaterOrEqual);

//        Assert.assertTrue(testObserver, GreaterOrEqual);
//        testObserver.assertResult(GreaterOrEqual);
//        Assert.assertThat(testObserver, new LessThan(5));
//        Assert.assertNotNull(testObserver);


//        testObserver.assertResult(new GreaterOrEqual(0));

//                greaterThan
//        lessThan
    }

    @Test
    public void noErrors2() {
        collectionsPresenter.createObservable(() -> collectionsPresenter.addingInTheMiddleArrayList())
                .subscribe(testObserver);
        testObserver.assertNoErrors();

    }




    @Test
    public void progressBar_FillingCollections_IsCalled(){
//        when(handler.post(any(Runnable.class))).thenReturn(true);
//        whenNew(Handler.class).withExpectedArguments(looper).thenReturn(handler);
//        try {
//            whenNew(Handler.class).withAnyArguments().thenReturn(handler);
//        } catch (Exception e) {
//            e.printStackTrace();
        doReturn(true).when(handler).post(any(Runnable.class));

        collectionsPresenter.fillCollections("50000");
        verify(collectionsView$$State).showProgressBarFillingCollections();
//    /    verify(collectionsView$$State).hideProgressBarFillingCollections();
}
    @Test
    public void progressBar_FillingCollections_IsCalled2(){
//        when(handler.post()).thenReturn()
//        when(handler.post(runnable)).thenReturn(true);

        collectionsPresenter.fillCollections("50000");
//        verify(collectionsView$$State).showProgressBarFillingCollections();
       verify(collectionsView$$State).hideProgressBarFillingCollections();
    }


    @Test
    public void progressBar_FillingMaps_IsCalled(){
//      when(handler.post(runnable)).thenReturn(true);
        mapsPresenter.fillMaps("50000");
        verify(mapsView$$State).showProgressBarFillingMaps();
        verify(mapsView$$State).hideProgressBarFillingMaps();
   }








}