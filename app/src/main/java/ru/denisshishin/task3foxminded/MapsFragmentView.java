package ru.denisshishin.task3foxminded;

import android.widget.ProgressBar;
import android.widget.TextView;

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
     void showProgressBarMapsFragment();

    @AddToEndSingle
    void hideTextViewMapsFragment();

    @AddToEndSingle
    void getNumberMapsFragment();



    /*@AddToEndSingle
    void hideProgressBarAddingNewHashMap();
    @AddToEndSingle
    void hideProgressBarRemovingHashMap();
    @AddToEndSingle
    void hideProgressBarSearchByKeyHashMap();
    @AddToEndSingle
    void hideProgressBarAddingNewTreeMap();
    @AddToEndSingle
    void  hideProgressBarRemovingTreeMap();
    @AddToEndSingle
    void hideProgressBarSearchByKeyTreeMap();*/

}
