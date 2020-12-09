package ru.denisshishin.task3foxminded.collections;

import moxy.MvpView;
import moxy.viewstate.strategy.AddToEndSingleStrategy;
import moxy.viewstate.strategy.StateStrategyType;


@StateStrategyType(AddToEndSingleStrategy.class)

public interface CollectionFragmentView extends MvpView {

    void showProgressBarCollectionsFragment();

    void hideTextViewCollectionsFragment();

    void showProgressBarFillingCollections();

    void hideProgressBarFillingCollections();

    void showAddingInTheBeginningArrayList(String string);
    void showAddingInTheMiddleArrayList(String string);
    void showAddingInTheEndArrayList(String string);
    void showSearchByValueArrayList(String string);
    void showRemovingInTheBeginningArrayList(String string);
    void showRemovingInTheMiddleArrayList(String string);
    void showRemovingInTheEndArrayList(String string);

    void showAddingInTheBeginningLinkedList(String string);
    void showAddingInTheMiddleLinkedList(String string);
    void showAddingInTheEndLinkedList(String string);
    void showSearchByValueLinkedList(String string);
    void showRemovingInTheBeginningLinkedList(String string);
    void showRemovingInTheMiddleLinkedList(String string);
    void showRemovingInTheEndLinkedList(String string);

    void showAddingInTheBeginningCopyOnWriteArrayList(String string);
    void showAddingInTheMiddleCopyOnWriteArrayList(String string);
    void showAddingInTheEndCopyOnWriteArrayList(String string);
    void showSearchByValueCopyOnWriteArrayList(String string);
    void showRemovingInTheBeginningCopyOnWriteArrayList(String string);
    void showRemovingInTheMiddleCopyOnWriteArrayList(String string);
    void showRemovingInTheEndCopyOnWriteArrayList(String string);


}
