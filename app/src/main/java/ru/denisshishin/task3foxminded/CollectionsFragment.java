package ru.denisshishin.task3foxminded;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import moxy.MvpAppCompatFragment;
import moxy.presenter.InjectPresenter;

public class CollectionsFragment extends MvpAppCompatFragment implements CollectionFragmentView {


    @InjectPresenter
    CollectionFragmentPresenter collectionFragmentPresenter;

    TextView tvCollections;
    Button btnCollectionsFragment;

    //public CollectionsFragment(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View viewCollectionsFragment = inflater.inflate(R.layout.fragment_collections, container, false);
        return viewCollectionsFragment;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        btnCollectionsFragment = view.findViewById(R.id.btnCollectionsFragment);
        tvCollections = view.findViewById(R.id.tvCollections);

        btnCollectionsFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                collectionFragmentPresenter.presentTvFragment();
            }
        });
    }


    @Override
    public void showTvFragment() {
        tvCollections.setText("Что-то");
///перенести значение в Presenter
    }
}
