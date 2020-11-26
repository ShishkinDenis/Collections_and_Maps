package ru.denisshishin.task3foxminded;

import moxy.MvpView;
import moxy.viewstate.strategy.alias.AddToEndSingle;

public interface MapsFragmentView extends MvpView {
    @AddToEndSingle
    void showTvMapsFragment(String string);

    @AddToEndSingle
    void showTvRemovingHashMap(String string);

    @AddToEndSingle
     void showPbMapsFragment();

    @AddToEndSingle
    void hidePbMapsFragment();

    @AddToEndSingle
    void getNumberMapsFragment();


}
