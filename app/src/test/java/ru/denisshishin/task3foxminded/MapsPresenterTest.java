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
    public void setUp() {
        testObserver = new TestObserver();

        mapsPresenter = new MapsPresenter(Schedulers.trampoline(), Schedulers.trampoline(), handler);
        mapsPresenter.setViewState(mapsView$$State);
    }

    @Test
    public void mapsHashMapOperationsAreCalled() {
        mapsPresenter.executeMapsThreads("100000");

        verify(mapsView$$State).showTvAddingNewHashMap(endsWith("ms"));
        verify(mapsView$$State).showTvRemovingHashMap(endsWith("ms"));
        verify(mapsView$$State).showTvSearchByKeyHashMap(endsWith("ms"));
    }

    @Test
    public void mapsTreeMapOperationsAreCalled() {
        mapsPresenter.executeMapsThreads("200000");

        verify(mapsView$$State).showTvAddingNewTreeMap(endsWith("ms"));
        verify(mapsView$$State).showTvRemovingTreeMap(endsWith("ms"));
        verify(mapsView$$State).showTvSearchByKeyTreeMap(endsWith("ms"));
    }

    @Test
    public void mapsProgressBarsAreCalled() {
        mapsPresenter.executeMapsThreads("50000");

        verify(mapsView$$State).hideTextViewMapsFragment();
        verify(mapsView$$State).showProgressBarMapsFragment();
    }

    @Test
    public void throwsExceptionsInAddingNewElementHashMapWhenInputLetters() {
        mapsPresenter.createObservable(() -> mapsPresenter.addingNewElementHashMap("abc"))
                .subscribe(testObserver);
        testObserver.assertNoValues();
        testObserver.assertError(NumberFormatException.class);
    }

    @Test
    public void throwsExceptionsInSearchByKeyHashMapWhenInputLetters() {
        mapsPresenter.createObservable(() -> mapsPresenter.searchByKeyHashMap("abc"))
                .subscribe(testObserver);
        testObserver.assertNoValues();
        testObserver.assertError(NumberFormatException.class);
    }

    @Test
    public void throwsExceptionsInRemovingElementHashMapWhenInputLetters() {
        mapsPresenter.createObservable(() -> mapsPresenter.removingElementHashMap("abc"))
                .subscribe(testObserver);
        testObserver.assertNoValues();
        testObserver.assertError(NumberFormatException.class);
    }

    @Test
    public void throwsExceptionsInAddingNewElementTreeMapWhenInputLetters() {
        mapsPresenter.createObservable(() -> mapsPresenter.addingNewElementTreeMap("abc"))
                .subscribe(testObserver);
        testObserver.assertNoValues();
        testObserver.assertError(NumberFormatException.class);
    }

    @Test
    public void throwsExceptionsInSearchByKeyTreeMapWhenInputLetters() {
        mapsPresenter.createObservable(() -> mapsPresenter.searchByKeyTreeMap("abc"))
                .subscribe(testObserver);
        testObserver.assertNoValues();
        testObserver.assertError(NumberFormatException.class);
    }

    @Test
    public void throwsExceptionsInRemovingElementTreeMapWhenInputLetters() {
        mapsPresenter.createObservable(() -> mapsPresenter.removingElementTreeMap("abc"))
                .subscribe(testObserver);
        testObserver.assertNoValues();
        testObserver.assertError(NumberFormatException.class);
    }

    @Test
    public void noErrorsInAddingNewElementHashMapWhenInputNumber() {
        mapsPresenter.createObservable(() -> mapsPresenter.addingNewElementHashMap("50000"))
                .subscribe(testObserver);
        testObserver.assertNoErrors();
    }

    @Test
    public void noErrorsInSearchByKeyHashMapWhenInputNumber() {
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
    public void noErrorsInAddingNewElementTreeMapWhenInputNumber() {
        mapsPresenter.createObservable(() -> mapsPresenter.addingNewElementTreeMap("50000"))
                .subscribe(testObserver);
        testObserver.assertNoErrors();
    }

    @Test
    public void noErrorsInSearchByKeyTreeMapWhenInputNumber() {
        mapsPresenter.createObservable(() -> mapsPresenter.searchByKeyTreeMap("50000"))
                .subscribe(testObserver);
        testObserver.assertNoErrors();
    }

    @Test
    public void noErrorsInRemovingElementTreeMapWhenInputNumber() {
        mapsPresenter.createObservable(() -> mapsPresenter.removingElementTreeMap("50000"))
                .subscribe(testObserver);
        testObserver.assertNoErrors();
    }
}
