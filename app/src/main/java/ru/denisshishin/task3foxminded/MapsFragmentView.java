package ru.denisshishin.task3foxminded;

import moxy.MvpView;
import moxy.viewstate.strategy.alias.AddToEndSingle;

public interface MapsFragmentView extends MvpView {
    @AddToEndSingle
    void showTvAddingNewHashMap(String string);

    @AddToEndSingle
    void showTvRemovingHashMap(String string);

    @AddToEndSingle
    void showTvSearchByKeyHashMap(String string);

    @AddToEndSingle
    void showTvAddingNewTreeMap(String string);

    @AddToEndSingle
    void showTvRemovingTreeMap(String string);

    @AddToEndSingle
    void showTvSearchByKeyTreeMap(String string);



    @AddToEndSingle
     void showPbMapsFragment();

    @AddToEndSingle
    void hidePbMapsFragment();

    @AddToEndSingle
    void getNumberMapsFragment();


}
