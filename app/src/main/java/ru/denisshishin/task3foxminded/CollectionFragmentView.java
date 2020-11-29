package ru.denisshishin.task3foxminded;

import moxy.MvpView;
import moxy.viewstate.strategy.alias.AddToEndSingle;

public interface CollectionFragmentView extends MvpView {
    @AddToEndSingle
    void showAddingInTheBeginningArrayList(String string);

    @AddToEndSingle
    void showAddingInTheMiddleArrayList(String string);

    @AddToEndSingle
    void showAddingInTheEndArrayList(String string);

    @AddToEndSingle
    void showSearchByValueArrayList(String string);

    @AddToEndSingle
    void showRemovingInTheBeginningArrayList(String string);

    @AddToEndSingle
    void showRemovingInTheMiddleArrayList(String string);

    @AddToEndSingle
    void showRemovingInTheEndArrayList(String string);


    @AddToEndSingle
    void showAddingInTheBeginningLinkedList(String string);

    @AddToEndSingle
    void showAddingInTheMiddleLinkedList(String string);

    @AddToEndSingle
    void showAddingInTheEndLinkedList(String string);

    @AddToEndSingle
    void showSearchByValueLinkedList(String string);

    @AddToEndSingle
    void showRemovingInTheBeginningLinkedList(String string);

    @AddToEndSingle
    void showRemovingInTheMiddleLinkedList(String string);

    @AddToEndSingle
    void showRemovingInTheEndLinkedList(String string);

    @AddToEndSingle
    void showAddingInTheBeginningCopyOnWriteArrayList(String string);

    @AddToEndSingle
    void showAddingInTheMiddleCopyOnWriteArrayList(String string);

    @AddToEndSingle
    void showAddingInTheEndCopyOnWriteArrayList(String string);

    @AddToEndSingle
    void showSearchByValueCopyOnWriteArrayList(String string);

    @AddToEndSingle
    void showRemovingInTheBeginningCopyOnWriteArrayList(String string);

    @AddToEndSingle
    void showRemovingInTheMiddleCopyOnWriteArrayList(String string);

    @AddToEndSingle
    void showRemovingInTheEndCopyOnWriteArrayList(String string);


    @AddToEndSingle
    void showProgressBarCollectionsFragment();

    @AddToEndSingle
    void hideTextViewCollectionsFragment();

}
