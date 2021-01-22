package ru.denisshishin.task3foxminded;

import android.os.Handler;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import io.reactivex.rxjava3.android.plugins.RxAndroidPlugins;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.observers.TestObserver;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import io.reactivex.rxjava3.schedulers.Schedulers;
import io.reactivex.rxjava3.schedulers.TestScheduler;
import ru.denisshishin.task3foxminded.collections.CollectionsPresenter;
import ru.denisshishin.task3foxminded.collections.CollectionsView$$State;
import ru.denisshishin.task3foxminded.maps.MapsPresenter;
import ru.denisshishin.task3foxminded.maps.MapsView$$State;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
public class ExampleUnitTest {

    TestObserver testObserver;
    @Mock
    TestScheduler testScheduler;
    @Mock
    Handler handler;

    CollectionsPresenter collectionsPresenter;
    @Mock
    CollectionsView$$State collectionsView$$State;

    MapsPresenter mapsPresenter;
    @Mock
    MapsView$$State mapsView$$State;





    @Before
    public void setUp(){
        testObserver = new TestObserver();
        testScheduler = new TestScheduler();

        RxAndroidPlugins.setInitMainThreadSchedulerHandler(scheduler -> Schedulers.trampoline());
        RxJavaPlugins.setComputationSchedulerHandler(h -> Schedulers.trampoline());

//        collectionsPresenter = new CollectionsPresenter(testScheduler,testScheduler,handler);
        collectionsPresenter = new CollectionsPresenter(Schedulers.trampoline(),Schedulers.trampoline(),handler);
        collectionsPresenter.setViewState(collectionsView$$State);

        mapsPresenter = new MapsPresenter(testScheduler,testScheduler,handler);
        mapsPresenter = new MapsPresenter(Schedulers.trampoline(),Schedulers.trampoline(),handler);
        mapsPresenter.setViewState(mapsView$$State);
    }

    @Test
    public void collectionsArrayListOperationsAreCalled(){
        collectionsPresenter.executeCollectionsThreads("50000");

        verify(collectionsView$$State).showAddingInTheBeginningArrayList("0 ms");
        verify(collectionsView$$State).showAddingInTheMiddleArrayList("0 ms");
        verify(collectionsView$$State).showAddingInTheEndArrayList("0 ms");

        verify(collectionsView$$State).showSearchByValueArrayList("0 ms");

        verify(collectionsView$$State).showRemovingInTheBeginningArrayList("0 ms");
        verify(collectionsView$$State).showRemovingInTheMiddleArrayList("0 ms");
        verify(collectionsView$$State).showRemovingInTheEndArrayList("0 ms");
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
        testObserver.assertNoErrors();
    }


    @Test
    public void progressBar_FillingCollections_IsCalled(){
        collectionsPresenter.fillCollections("50000");
        verify(collectionsView$$State).showProgressBarFillingCollections();
        verify(collectionsView$$State).hideProgressBarFillingCollections();
    }


    @Test
    public void progressBar_FillingMaps_IsCalled(){
        mapsPresenter.fillMaps("50000");
        verify(mapsView$$State).showProgressBarFillingMaps();
        verify(mapsView$$State).hideProgressBarFillingMaps();
   }








}