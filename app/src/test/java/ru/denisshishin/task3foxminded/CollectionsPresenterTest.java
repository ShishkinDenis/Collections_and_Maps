package ru.denisshishin.task3foxminded;

import android.os.Handler;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import io.reactivex.rxjava3.observers.TestObserver;
import io.reactivex.rxjava3.schedulers.Schedulers;
import ru.denisshishin.task3foxminded.collections.CollectionsPresenter;
import ru.denisshishin.task3foxminded.collections.CollectionsView$$State;

import static org.mockito.ArgumentMatchers.endsWith;
import static org.mockito.Mockito.verify;


@RunWith(MockitoJUnitRunner.class)
public class CollectionsPresenterTest {

    TestObserver testObserver;

    Handler handler;

    CollectionsPresenter collectionsPresenter;

    @Mock
    CollectionsView$$State collectionsView$$State;

    @Before
    public void setUp(){
        testObserver = new TestObserver();

        collectionsPresenter = new CollectionsPresenter(Schedulers.trampoline(),Schedulers.trampoline(), handler);
        collectionsPresenter.setViewState(collectionsView$$State);
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
    public void collectionsProgressBarsAreCalled(){
        collectionsPresenter.executeCollectionsThreads("50000");
        verify(collectionsView$$State).hideTextViewCollectionsFragment();
        verify(collectionsView$$State).showProgressBarCollectionsFragment();
    }

    @Test
    public void noErrorsInAddingInTheBeginningArrayList() {
        collectionsPresenter.createObservable(() -> collectionsPresenter.addingInTheBeginningArrayList())
                .subscribe(testObserver);
        testObserver.assertNoErrors();

    }
    @Test
    public void noErrorsInAddingInTheMiddleArrayList() {
        collectionsPresenter.createObservable(() -> collectionsPresenter.addingInTheMiddleArrayList())
                .subscribe(testObserver);
        testObserver.assertNoErrors();

    }
    @Test
    public void noErrorsInAddingInTheEndArrayList() {
        collectionsPresenter.createObservable(() -> collectionsPresenter.addingInTheEndArrayList())
                .subscribe(testObserver);
        testObserver.assertNoErrors();

    }

    @Test
    public void noErrorsInSearchByValueArrayList() {
        collectionsPresenter.createObservable(() -> collectionsPresenter.searchByValueArrayList("5"))
                .subscribe(testObserver);
        testObserver.assertNoErrors();
    }

    @Test
    public void noValuesInRemovingInTheBeginningArrayList() {
        collectionsPresenter.createObservable(() -> collectionsPresenter.removingInTheBeginningArrayList())
                .subscribe(testObserver);
        testObserver.assertNoValues();

    }
    @Test
    public void noValuesInRemovingInTheMiddleArrayList() {
        collectionsPresenter.createObservable(() -> collectionsPresenter.removingInTheMiddleArrayList())
                .subscribe(testObserver);
        testObserver.assertNoValues();

    }
    @Test
    public void noValuesInRemovingInTheEndArrayList() {
        collectionsPresenter.createObservable(() -> collectionsPresenter.removingInTheEndArrayList())
                .subscribe(testObserver);
        testObserver.assertNoValues();

    }

    @Test
    public void noErrorsInAddingInTheBeginningLinkedList() {
        collectionsPresenter.createObservable(() -> collectionsPresenter.addingInTheBeginningLinkedList())
                .subscribe(testObserver);
        testObserver.assertNoErrors();

    }
    @Test
    public void noErrorsInAddingInTheMiddleLinkedList() {
        collectionsPresenter.createObservable(() -> collectionsPresenter.addingInTheMiddleLinkedList())
                .subscribe(testObserver);
        testObserver.assertNoErrors();

    }
    @Test
    public void noErrorsInAddingInTheEndLinkedList() {
        collectionsPresenter.createObservable(() -> collectionsPresenter.addingInTheEndLinkedList())
                .subscribe(testObserver);
        testObserver.assertNoErrors();

    }

    @Test
    public void noErrorsInSearchByValueLinkedList() {
        collectionsPresenter.createObservable(() -> collectionsPresenter.searchByValueArrayList("5"))
                .subscribe(testObserver);
        testObserver.assertNoErrors();
    }

    @Test
    public void noValuesInRemovingInTheBeginningLinkedList() {
        collectionsPresenter.createObservable(() -> collectionsPresenter.removingInTheBeginningLinkedList())
                .subscribe(testObserver);
        testObserver.assertNoValues();

    }
    @Test
    public void noValuesInRemovingInTheMiddleLinkedList() {
        collectionsPresenter.createObservable(() -> collectionsPresenter.removingInTheMiddleLinkedList())
                .subscribe(testObserver);
        testObserver.assertNoValues();

    }
    @Test
    public void noValuesInRemovingInTheEndLinkedList() {
        collectionsPresenter.createObservable(() -> collectionsPresenter.removingInTheEndLinkedList())
                .subscribe(testObserver);
        testObserver.assertNoValues();

    }

    @Test
    public void noErrorsInAddingInTheBeginningCopyOnWriteArrayList() {
        collectionsPresenter.createObservable(() -> collectionsPresenter.addingInTheBeginningCopyOnWriteArrayList())
                .subscribe(testObserver);
        testObserver.assertNoErrors();

    }
    @Test
    public void noErrorsInAddingInTheMiddleCopyOnWriteArrayList() {
        collectionsPresenter.createObservable(() -> collectionsPresenter.addingInTheMiddleCopyOnWriteArrayList())
                .subscribe(testObserver);
        testObserver.assertNoErrors();

    }
    @Test
    public void noErrorsInAddingInTheEndCopyOnWriteArrayList() {
        collectionsPresenter.createObservable(() -> collectionsPresenter.addingInTheEndCopyOnWriteArrayList())
                .subscribe(testObserver);
        testObserver.assertNoErrors();

    }

    @Test
    public void noErrorsInSearchByValueCopyOnWriteArrayList() {
        collectionsPresenter.createObservable(() -> collectionsPresenter.searchByValueCopyOnWriteArrayList("5"))
                .subscribe(testObserver);
        testObserver.assertNoErrors();
    }

    @Test
    public void noValuesInRemovingInTheBeginningCopyOnWriteArrayList() {
        collectionsPresenter.createObservable(() -> collectionsPresenter.removingInTheBeginningCopyOnWriteArrayList())
                .subscribe(testObserver);
        testObserver.assertNoValues();

    }
    @Test
    public void noValuesInRemovingInTheMiddleCopyOnWriteArrayList() {
        collectionsPresenter.createObservable(() -> collectionsPresenter.removingInTheMiddleCopyOnWriteArrayList())
                .subscribe(testObserver);
        testObserver.assertNoValues();

    }
    @Test
    public void noValuesInRemovingInTheEndCopyOnWriteArrayList() {
        collectionsPresenter.createObservable(() -> collectionsPresenter.removingInTheEndCopyOnWriteArrayList())
                .subscribe(testObserver);
        testObserver.assertNoValues();

    }
}
