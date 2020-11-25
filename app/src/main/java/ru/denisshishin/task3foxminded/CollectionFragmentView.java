package ru.denisshishin.task3foxminded;

import moxy.MvpView;
import moxy.viewstate.strategy.alias.AddToEndSingle;

public interface CollectionFragmentView extends MvpView {
    @AddToEndSingle
    void showTvFragment(String string);

    @AddToEndSingle
    void showTv2Fragment(String string);

    @AddToEndSingle
    void showPbCollectonsFragment();

    @AddToEndSingle
    void hidePbCollectonsFragment();

    @AddToEndSingle
    void hidePbCollectons2();
}
