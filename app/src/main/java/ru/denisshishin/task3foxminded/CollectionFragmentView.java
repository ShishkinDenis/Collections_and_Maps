package ru.denisshishin.task3foxminded;

import moxy.MvpView;
import moxy.viewstate.strategy.alias.AddToEndSingle;

public interface CollectionFragmentView extends MvpView {
    @AddToEndSingle
    void showTvFragment();
}
