package ru.denisshishin.task3foxminded;

import android.os.Handler;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import io.reactivex.rxjava3.observers.TestObserver;
import io.reactivex.rxjava3.schedulers.Schedulers;
import ru.denisshishin.task3foxminded.maps.MapsPresenter;
import ru.denisshishin.task3foxminded.maps.MapsView$$State;

import static org.mockito.ArgumentMatchers.endsWith;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class MapsPresenterTest {

    TestObserver testObserver;

    Handler handler;

    MapsPresenter mapsPresenter;

    @Mock
    MapsView$$State mapsView$$State;

    @Before
    public void setUp(){
        testObserver = new TestObserver();

        mapsPresenter = new MapsPresenter(Schedulers.trampoline(),Schedulers.trampoline(),handler);
        mapsPresenter.setViewState(mapsView$$State);
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
    public void mapsProgressBarsAreCalled(){
        mapsPresenter.executeMapsThreads("50000");
        verify(mapsView$$State).hideTextViewMapsFragment();
        verify(mapsView$$State).showProgressBarMapsFragment();
    }

    @Test
    public void noErrorsInAddingNewElementHashMap() {
        mapsPresenter.createObservable(() -> mapsPresenter.addingNewElementHashMap("50000"))
                .subscribe(testObserver);
        testObserver.assertNoErrors();
    }
    @Test
    public void noErrorsInSearchByKeyHashMap() {
        mapsPresenter.createObservable(() -> mapsPresenter.searchByKeyHashMap("50000"))
                .subscribe(testObserver);
        testObserver.assertNoErrors();
    }
    @Test
    public void noErrorsInRemovingElementHashMap() {
        mapsPresenter.createObservable(() -> mapsPresenter.removingElementHashMap("50000"))
                .subscribe(testObserver);
        testObserver.assertNoErrors();
    }

    @Test
    public void noErrorsInAddingNewElementTreeMap() {
        mapsPresenter.createObservable(() -> mapsPresenter.addingNewElementTreeMap("50000"))
                .subscribe(testObserver);
        testObserver.assertNoErrors();
    }
    @Test
    public void noErrorsInSearchByKeyTreeMap() {
        mapsPresenter.createObservable(() -> mapsPresenter.searchByKeyTreeMap("50000"))
                .subscribe(testObserver);
        testObserver.assertNoErrors();
    }
    @Test
    public void noErrorsInRemovingElementTreeMap() {
        mapsPresenter.createObservable(() -> mapsPresenter.removingElementTreeMap("50000"))
                .subscribe(testObserver);
        testObserver.assertNoErrors();
    }
}
