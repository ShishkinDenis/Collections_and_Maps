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


public class MapsFragment extends MvpAppCompatFragment implements MapsFragmentView {
    @InjectPresenter
    MapsFragmentPresenter mapsFragmentPresenter;

    TextView tvAddingNewHashMap;
    Button btnMapsFragment;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View viewMapsFragment = inflater.inflate(R.layout.fragment_maps, container, false);
        return viewMapsFragment;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        btnMapsFragment = view.findViewById(R.id.btnMapsFragment);
        tvAddingNewHashMap = view.findViewById(R.id.tvAddingNewHashMap);


        btnMapsFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               mapsFragmentPresenter.presentTvMapsFragment();
            }
        });
    }


    @Override
    public void showTvMapsFragment(String string) {
        tvAddingNewHashMap.setText(string);

    }
}
