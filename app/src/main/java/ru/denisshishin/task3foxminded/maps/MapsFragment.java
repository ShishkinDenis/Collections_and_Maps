package ru.denisshishin.task3foxminded.maps;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import javax.inject.Inject;

import moxy.MvpAppCompatFragment;
import moxy.presenter.InjectPresenter;
import moxy.presenter.ProvidePresenter;
import ru.denisshishin.task3foxminded.MyApplication;
import ru.denisshishin.task3foxminded.databinding.FragmentMapsBinding;


public class MapsFragment extends MvpAppCompatFragment implements MapsView {

    @Inject
    @InjectPresenter
    MapsPresenter mapsPresenter;

    @ProvidePresenter
    MapsPresenter providePresenter() {
        return mapsPresenter;
    }

    private FragmentMapsBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentMapsBinding.inflate(inflater, container, false);
        View viewMapsFragment = binding.getRoot();
        return viewMapsFragment;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.btnMapsFragment.setOnClickListener(v -> {
            if (!binding.tietInputNumberMapsFragment.getText().toString().isEmpty()) {
                mapsPresenter.launchMaps(binding.tietInputNumberMapsFragment.getText().toString());
            } else {
                Toast toast = Toast.makeText(getActivity(), "Please input number",
                        Toast.LENGTH_SHORT);
                toast.show();
            }
        });
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        MyApplication.appComponent.inject(this);
    }

    @Override
    public void showProgressBarFillingMaps() {
        binding.pbFillingMaps.setVisibility(View.VISIBLE);
        binding.tvFillingMaps.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressBarFillingMaps() {
        binding.pbFillingMaps.setVisibility(View.INVISIBLE);
        binding.tvFillingMaps.setVisibility(View.INVISIBLE);
    }

    @Override
    public void showProgressBarMapsFragment() {
        binding.pbAddingNewHashMap.setVisibility(View.VISIBLE);
        binding.pbRemovingHashMap.setVisibility(View.VISIBLE);
        binding.pbSearchByKeyHashMap.setVisibility(View.VISIBLE);
        binding.pbAddingNewTreeMap.setVisibility(View.VISIBLE);
        binding.pbRemovingTreeMap.setVisibility(View.VISIBLE);
        binding.pbSearchByKeyTreeMap.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideTextViewMapsFragment() {
        binding.tvAddingNewHashMap.setVisibility(View.INVISIBLE);
        binding.tvRemovingHashMap.setVisibility(View.INVISIBLE);
        binding.tvSearchByKeyHashMap.setVisibility(View.INVISIBLE);
        binding.tvAddingNewTreeMap.setVisibility(View.INVISIBLE);
        binding.tvRemovingTreeMap.setVisibility(View.INVISIBLE);
        binding.tvSearchByKeyTreeMap.setVisibility(View.INVISIBLE);
    }

    @Override
    public void showTvAddingNewHashMap(String string) {
        binding.tvAddingNewHashMap.setText(string);
        binding.pbAddingNewHashMap.setVisibility(View.INVISIBLE);
        binding.tvAddingNewHashMap.setVisibility(View.VISIBLE);
    }

    @Override
    public void showTvRemovingHashMap(String string) {
        binding.tvRemovingHashMap.setText(string);
        binding.pbRemovingHashMap.setVisibility(View.INVISIBLE);
        binding.tvRemovingHashMap.setVisibility(View.VISIBLE);
    }

    @Override
    public void showTvSearchByKeyHashMap(String string) {
        binding.tvSearchByKeyHashMap.setText(string);
        binding.pbSearchByKeyHashMap.setVisibility(View.INVISIBLE);
        binding.tvSearchByKeyHashMap.setVisibility(View.VISIBLE);
    }

    @Override
    public void showTvAddingNewTreeMap(String string) {
        binding.tvAddingNewTreeMap.setText(string);
        binding.pbAddingNewTreeMap.setVisibility(View.INVISIBLE);
        binding.tvAddingNewTreeMap.setVisibility(View.VISIBLE);
    }

    @Override
    public void showTvRemovingTreeMap(String string) {
        binding.tvRemovingTreeMap.setText(string);
        binding.pbRemovingTreeMap.setVisibility(View.INVISIBLE);
        binding.tvRemovingTreeMap.setVisibility(View.VISIBLE);
    }

    @Override
    public void showTvSearchByKeyTreeMap(String string) {
        binding.tvSearchByKeyTreeMap.setText(string);
        binding.pbSearchByKeyTreeMap.setVisibility(View.INVISIBLE);
        binding.tvSearchByKeyTreeMap.setVisibility(View.VISIBLE);
    }

}
