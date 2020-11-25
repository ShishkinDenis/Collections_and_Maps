package ru.denisshishin.task3foxminded;

import moxy.MvpPresenter;

public class MapsFragmentPresenter extends MvpPresenter<MapsFragmentView> {

    public MapsFragmentPresenter(){}

    public void presentTvMapsFragment() {
        getViewState().showTvMapsFragment();
    }
}
