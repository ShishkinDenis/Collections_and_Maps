package ru.denisshishin.task3foxminded;

import moxy.InjectViewState;
import moxy.MvpPresenter;

@InjectViewState
public class CollectionFragmentPresenter extends MvpPresenter<CollectionFragmentView> {
    public CollectionFragmentPresenter(){}

    public void presentTvFragment() {
        getViewState().showTvFragment();
    }
}
