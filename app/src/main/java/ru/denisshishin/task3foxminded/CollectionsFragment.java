package ru.denisshishin.task3foxminded;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import moxy.MvpAppCompatFragment;
import moxy.presenter.InjectPresenter;

public class CollectionsFragment extends MvpAppCompatFragment implements CollectionFragmentView {


    @InjectPresenter
    CollectionFragmentPresenter collectionFragmentPresenter;

    TextView tvCollections;
    TextView tvCollections2;
    Button btnCollectionsFragment;
    ProgressBar pbCollectionsFragment;
    ProgressBar pbCollections2;


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
        tvCollections2 = view.findViewById(R.id.tvCollections2);
        pbCollectionsFragment = view.findViewById(R.id.pbCollectionsFragment);
        pbCollections2 = view.findViewById(R.id.pbCollections2);


        btnCollectionsFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              //  pbCollectionsFragment.setVisibility(View.VISIBLE );
               // collectionFragmentPresenter.presentPbCollectionsFragment();
                collectionFragmentPresenter.presentTvFragment();
               // collectionFragmentPresenter.hidePbPresenter();
            }
        });
    }


    @Override
    public void showTvFragment(String string) {
        tvCollections.setText(string);
    }
    @Override
    public void showTv2Fragment(String string) {
        tvCollections2.setText(string);
    }

    @Override
    public void showPbCollectonsFragment() {
        tvCollections.setVisibility(View.INVISIBLE);
        pbCollectionsFragment.setVisibility(View.VISIBLE);

        tvCollections2.setVisibility(View.INVISIBLE);
        pbCollections2.setVisibility(View.VISIBLE);


    }

    @Override
    public void hidePbCollectonsFragment() {
        pbCollectionsFragment.setVisibility(View.INVISIBLE);
        tvCollections.setVisibility(View.VISIBLE);
    }

    @Override
    public void hidePbCollectons2() {
        pbCollections2.setVisibility(View.INVISIBLE);
        tvCollections2.setVisibility(View.VISIBLE);
    }
}
