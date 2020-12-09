package ru.denisshishin.task3foxminded.maps;

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
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import moxy.MvpAppCompatFragment;
import moxy.presenter.InjectPresenter;
import ru.denisshishin.task3foxminded.R;


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

    @BindView (R.id.tietInputNumberMapsFragment)EditText etInputNumberMapsFragment;

    @BindView (R.id.pbAddingNewHashMap) ProgressBar pbAddingNewHashMap;
    @BindView (R.id.pbRemovingHashMap) ProgressBar pbRemovingHashMap;
    @BindView (R.id.pbSearchByKeyHashMap) ProgressBar pbSearchByKeyHashMap;
    @BindView (R.id.pbAddingNewTreeMap) ProgressBar pbAddingNewTreeMap;
    @BindView (R.id.pbRemovingTreeMap) ProgressBar pbRemovingTreeMap;
    @BindView (R.id.pbSearchByKeyTreeMap) ProgressBar pbSearchByKeyTreeMap;

    @BindView(R.id.pbFillingMaps) ProgressBar pbFillingMaps;
    @BindView(R.id.tvFillingMaps) TextView tvFillingMaps;

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
                if (!etInputNumberMapsFragment.getText().toString().isEmpty()) {
                    mapsFragmentPresenter.launch(etInputNumberMapsFragment.getText().toString());
                }
                else {
                    Toast toast = Toast.makeText(getActivity(),"Please input number",
                            Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });
    }



    @Override
    public void showProgressBarFillingMaps() {
        pbFillingMaps.setVisibility(View.VISIBLE);
        tvFillingMaps.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressBarFillingMaps() {
        pbFillingMaps.setVisibility(View.INVISIBLE);
        tvFillingMaps.setVisibility(View.INVISIBLE);
    }

    @Override
    public void showProgressBarMapsFragment() {
        pbAddingNewHashMap.setVisibility(View.VISIBLE);
        pbRemovingHashMap.setVisibility(View.VISIBLE);
        pbSearchByKeyHashMap.setVisibility(View.VISIBLE);
        pbAddingNewTreeMap.setVisibility(View.VISIBLE);
        pbRemovingTreeMap.setVisibility(View.VISIBLE);
        pbSearchByKeyTreeMap.setVisibility(View.VISIBLE);
    }
    @Override
    public void hideTextViewMapsFragment() {
        tvAddingNewHashMap.setVisibility(View.INVISIBLE);
        tvRemovingHashMap.setVisibility(View.INVISIBLE);
        tvSearchByKeyHashMap.setVisibility(View.INVISIBLE);
        tvAddingNewTreeMap.setVisibility(View.INVISIBLE);
        tvRemovingTreeMap.setVisibility(View.INVISIBLE);
        tvSearchByKeyTreeMap.setVisibility(View.INVISIBLE);
    }


    @Override
    public void showTvAddingNewHashMap(String string) {
        tvAddingNewHashMap.setText(string);
        pbAddingNewHashMap.setVisibility(View.INVISIBLE);
        tvAddingNewHashMap.setVisibility(View.VISIBLE);

    }
    @Override
    public void showTvRemovingHashMap(String string) {
        tvRemovingHashMap.setText(string);
        pbRemovingHashMap.setVisibility(View.INVISIBLE);
        tvRemovingHashMap.setVisibility(View.VISIBLE);
    }
    @Override
    public void showTvSearchByKeyHashMap(String string) {
        tvSearchByKeyHashMap.setText(string);
        pbSearchByKeyHashMap.setVisibility(View.INVISIBLE);
        tvSearchByKeyHashMap.setVisibility(View.VISIBLE);
    }


    @Override
    public void showTvAddingNewTreeMap(String string) {
        tvAddingNewTreeMap.setText(string);
        pbAddingNewTreeMap.setVisibility(View.INVISIBLE);
        tvAddingNewTreeMap.setVisibility(View.VISIBLE);
    }
    @Override
    public void showTvRemovingTreeMap(String string) {
        tvRemovingTreeMap.setText(string);
        pbRemovingTreeMap.setVisibility(View.INVISIBLE);
        tvRemovingTreeMap.setVisibility(View.VISIBLE);
    }
    @Override
    public void showTvSearchByKeyTreeMap(String string) {
        tvSearchByKeyTreeMap.setText(string);
        pbSearchByKeyTreeMap.setVisibility(View.INVISIBLE);
        tvSearchByKeyTreeMap.setVisibility(View.VISIBLE);
    }

}
