package ru.denisshishin.task3foxminded;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import moxy.MvpAppCompatFragment;
import moxy.presenter.InjectPresenter;


public class MapsFragment extends MvpAppCompatFragment implements MapsFragmentView {
    @InjectPresenter
    MapsFragmentPresenter mapsFragmentPresenter;

    TextView tvAddingNewHashMap;
    TextView tvRemovingHashMap;
    Button btnMapsFragment;
    ProgressBar pbAddingNewHashMap;
    EditText etInputNumberMapsFragment;

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
        pbAddingNewHashMap = view.findViewById(R.id.pbAddingNewHashMap);
        etInputNumberMapsFragment = view.findViewById(R.id.tietInputNumberMapsFragment);
        tvRemovingHashMap = view.findViewById(R.id.tvRemovingHashMap);


        btnMapsFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               mapsFragmentPresenter.presentTvMapsFragment(etInputNumberMapsFragment.getText().toString());
            }
        });
    }


    @Override
    public void showTvMapsFragment(String string) {
        tvAddingNewHashMap.setText(string);
    }
    @Override
    public void showTvRemovingHashMap(String string) {
        tvRemovingHashMap.setText(string);
    }

    @Override
    public void showPbMapsFragment() {
        tvAddingNewHashMap.setVisibility(View.INVISIBLE);
        pbAddingNewHashMap.setVisibility(View.VISIBLE);

        tvAddingNewHashMap.setVisibility(View.INVISIBLE);
        pbAddingNewHashMap.setVisibility(View.VISIBLE);
    }

    @Override
    public void hidePbMapsFragment() {
        pbAddingNewHashMap.setVisibility(View.INVISIBLE);
        tvAddingNewHashMap.setVisibility(View.VISIBLE);
    }

    @Override
    public void getNumberMapsFragment() {
       // tvAddingNewHashMap.setText(etInputNumberMapsFragment.getText().toString());
         etInputNumberMapsFragment.getText().toString();
         ///сделать String без интерфейса
    }


}
