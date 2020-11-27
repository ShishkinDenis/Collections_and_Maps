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

import butterknife.BindView;
import butterknife.ButterKnife;
import moxy.MvpAppCompatFragment;
import moxy.presenter.InjectPresenter;


public class MapsFragment extends MvpAppCompatFragment implements MapsFragmentView {
    @InjectPresenter
    MapsFragmentPresenter mapsFragmentPresenter;

    @BindView (R.id.tvAddingNewHashMap) TextView tvAddingNewHashMap;
    @BindView (R.id.tvRemovingHashMap) TextView tvRemovingHashMap;
    @BindView (R.id.tvSearchByKeyHashMap) TextView tvSearchByKeyHashMap;

    @BindView (R.id.tvAddingNewTreeMap) TextView tvAddingNewTreeMap;
    @BindView (R.id.tvRemovingTreeMap) TextView tvRemovingTreeMap;
    @BindView (R.id.tvSearchByKeyTreeMap) TextView tvSearchByKeyTreeMap;


    @BindView (R.id.btnMapsFragment) Button btnMapsFragment;

    @BindView (R.id.pbAddingNewHashMap) ProgressBar pbAddingNewHashMap;

    @BindView (R.id.tietInputNumberMapsFragment)EditText etInputNumberMapsFragment;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View viewMapsFragment = inflater.inflate(R.layout.fragment_maps, container, false);
        ButterKnife.bind(this,viewMapsFragment);

        return viewMapsFragment;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        btnMapsFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               mapsFragmentPresenter.presentTvMapsFragment(etInputNumberMapsFragment.getText().toString());
            }
        });
    }


    @Override
    public void showTvAddingNewHashMap(String string) {
        tvAddingNewHashMap.setText(string);
    }
    @Override
    public void showTvRemovingHashMap(String string) {
        tvRemovingHashMap.setText(string);
    }
    @Override
    public void showTvSearchByKeyHashMap(String string) {
        tvSearchByKeyHashMap.setText(string);
    }


    @Override
    public void showTvAddingNewTreeMap(String string) {
        tvAddingNewTreeMap.setText(string);
    }
    @Override
    public void showTvRemovingTreeMap(String string) {
        tvRemovingTreeMap.setText(string);
    }
    @Override
    public void showTvSearchByKeyTreeMap(String string) {
        tvSearchByKeyTreeMap.setText(string);
    }


    @Override
    public void showPbMapsFragment() {
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
