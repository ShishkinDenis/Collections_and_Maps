package ru.denisshishin.task3foxminded.maps;

import moxy.MvpView;
import moxy.viewstate.strategy.AddToEndSingleStrategy;
import moxy.viewstate.strategy.StateStrategyType;

@StateStrategyType(AddToEndSingleStrategy.class)

public interface MapsView extends MvpView {

    void showProgressBarMapsFragment();

    void hideTextViewMapsFragment();

    void showProgressBarFillingMaps();

    void hideProgressBarFillingMaps();

    void showTvAddingNewHashMap(String string);

    void showTvRemovingHashMap(String string);

    void showTvSearchByKeyHashMap(String string);

    void showTvAddingNewTreeMap(String string);

    void showTvRemovingTreeMap(String string);

    void showTvSearchByKeyTreeMap(String string);

}
