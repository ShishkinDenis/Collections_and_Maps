package ru.denisshishin.task3foxminded.collections;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import moxy.MvpAppCompatFragment;
import moxy.presenter.InjectPresenter;
import ru.denisshishin.task3foxminded.databinding.FragmentCollectionsBinding;

public class CollectionsFragment extends MvpAppCompatFragment implements CollectionsView {


    @InjectPresenter
    CollectionsPresenter collectionsPresenter;

    private FragmentCollectionsBinding binding;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentCollectionsBinding.inflate(inflater, container, false);
        View viewCollectionsFragment = binding.getRoot();
        return viewCollectionsFragment;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.btnCollectionsFragment.setOnClickListener(v -> {
            if(!binding.tietInputNumberCollectionsFragment.getText().toString().isEmpty() ) {
                collectionsPresenter.launchCollections(binding.tietInputNumberCollectionsFragment.getText().toString());
            }
            else {
                Toast toast = Toast.makeText(getActivity(),"Please input number",
                        Toast.LENGTH_SHORT);
                toast.show();
            }
        });
    }



    @Override
    public void showProgressBarCollectionsFragment() {
        binding.pbAddingInTheBeginningArrayList.setVisibility(View.VISIBLE);
        binding.pbAddingInTheMiddleArrayList.setVisibility(View.VISIBLE);
        binding.pbAddingInTheEndArrayList.setVisibility(View.VISIBLE);
        binding.pbSearchByValueArrayList.setVisibility(View.VISIBLE);
        binding.pbRemovingInTheBeginningArrayList.setVisibility(View.VISIBLE);
        binding.pbRemovingInTheMiddleArrayList.setVisibility(View.VISIBLE);
        binding.pbRemovingInTheEndArrayList.setVisibility(View.VISIBLE);

        binding.pbAddingInTheBeginningLinkedList.setVisibility(View.VISIBLE);
        binding.pbAddingInTheMiddleLinkedList.setVisibility(View.VISIBLE);
        binding.pbAddingInTheEndLinkedList.setVisibility(View.VISIBLE);
        binding.pbSearchByValueLinkedList.setVisibility(View.VISIBLE);
        binding.pbRemovingInTheBeginningLinkedList.setVisibility(View.VISIBLE);
        binding.pbRemovingInTheMiddleLinkedList.setVisibility(View.VISIBLE);
        binding.pbRemovingInTheEndLinkedList.setVisibility(View.VISIBLE);

        binding.pbAddingInTheBeginningCopyOnWriteList.setVisibility(View.VISIBLE);
        binding.pbAddingInTheMiddleCopyOnWriteList.setVisibility(View.VISIBLE);
        binding.pbAddingInTheEndCopyOnWriteList.setVisibility(View.VISIBLE);
        binding.pbSearchByValueCopyOnWriteList.setVisibility(View.VISIBLE);
        binding.pbRemovingInTheBeginningCopyOnWriteList.setVisibility(View.VISIBLE);
        binding.pbRemovingInTheMiddleCopyOnWriteList.setVisibility(View.VISIBLE);
        binding.pbRemovingInTheEndCopyOnWriteList.setVisibility(View.VISIBLE);
    }
    @Override
    public void hideTextViewCollectionsFragment() {
        binding.tvAddingInTheBeginningArrayList.setVisibility(View.INVISIBLE);
        binding.tvAddingInTheMiddleArrayList.setVisibility(View.INVISIBLE);
        binding.tvAddingInTheEndArrayList.setVisibility(View.INVISIBLE);
        binding.tvSearchByValueArrayList.setVisibility(View.INVISIBLE);
        binding.tvRemovingInTheBeginningArrayList.setVisibility(View.INVISIBLE);
        binding.tvRemovingInTheMiddleArrayList.setVisibility(View.INVISIBLE);
        binding.tvRemovingInTheEndArrayList.setVisibility(View.INVISIBLE);

        binding.tvAddingInTheBeginningLinkedList.setVisibility(View.INVISIBLE);
        binding.tvAddingInTheMiddleLinkedList.setVisibility(View.INVISIBLE);
        binding.tvAddingInTheEndLinkedList.setVisibility(View.INVISIBLE);
        binding.tvSearchByValueLinkedList.setVisibility(View.INVISIBLE);
        binding.tvRemovingInTheBeginningLinkedList.setVisibility(View.INVISIBLE);
        binding.tvRemovingInTheMiddleLinkedList.setVisibility(View.INVISIBLE);
        binding.tvRemovingInTheEndLinkedList.setVisibility(View.INVISIBLE);

        binding.tvAddingInTheBeginningCopyOnWriteList.setVisibility(View.INVISIBLE);
        binding.tvAddingInTheMiddleCopyOnWriteList.setVisibility(View.INVISIBLE);
        binding.tvAddingInTheEndCopyOnWriteList.setVisibility(View.INVISIBLE);
        binding.tvSearchByValueCopyOnWriteList.setVisibility(View.INVISIBLE);
        binding.tvRemovingInTheBeginningCopyOnWriteList.setVisibility(View.INVISIBLE);
        binding.tvRemovingInTheMiddleCopyOnWriteList.setVisibility(View.INVISIBLE);
        binding.tvRemovingInTheEndCopyOnWriteList.setVisibility(View.INVISIBLE);
    }

    @Override
    public void showProgressBarFillingCollections() {
        binding.pbFillingCollections.setVisibility(View.VISIBLE);
        binding.tvFillingCollections.setVisibility(View.VISIBLE);
    }
    @Override
    public void hideProgressBarFillingCollections() {
        binding.pbFillingCollections.setVisibility(View.INVISIBLE);
        binding.tvFillingCollections.setVisibility(View.INVISIBLE);
    }


    @Override
    public void showAddingInTheBeginningArrayList(String string) {
        binding.tvAddingInTheBeginningArrayList.setText(string);

        binding.pbAddingInTheBeginningArrayList.setVisibility(View.INVISIBLE);
        binding.tvAddingInTheBeginningArrayList.setVisibility(View.VISIBLE);

    }
    @Override
    public void showAddingInTheMiddleArrayList(String string) {
        binding.tvAddingInTheMiddleArrayList.setText(string);

        binding.pbAddingInTheMiddleArrayList.setVisibility(View.INVISIBLE);
        binding.tvAddingInTheMiddleArrayList.setVisibility(View.VISIBLE);
    }
    @Override
    public void showAddingInTheEndArrayList(String string) {
        binding.tvAddingInTheEndArrayList.setText(string);

        binding.pbAddingInTheEndArrayList.setVisibility(View.INVISIBLE);
        binding.tvAddingInTheEndArrayList.setVisibility(View.VISIBLE);
    }
    @Override
    public void showSearchByValueArrayList(String string) {
        binding.tvSearchByValueArrayList.setText(string);

        binding.pbSearchByValueArrayList.setVisibility(View.INVISIBLE);
        binding.tvSearchByValueArrayList.setVisibility(View.VISIBLE);
    }
    @Override
    public void showRemovingInTheBeginningArrayList(String string) {
        binding.tvRemovingInTheBeginningArrayList.setText(string);

        binding.pbRemovingInTheBeginningArrayList.setVisibility(View.INVISIBLE);
        binding.tvRemovingInTheBeginningArrayList.setVisibility(View.VISIBLE);
    }
    @Override
    public void showRemovingInTheMiddleArrayList(String string) {
        binding.tvRemovingInTheMiddleArrayList.setText(string);

        binding.pbRemovingInTheMiddleArrayList.setVisibility(View.INVISIBLE);
        binding.tvRemovingInTheMiddleArrayList.setVisibility(View.VISIBLE);
    }
    @Override
    public void showRemovingInTheEndArrayList(String string){
        binding.tvRemovingInTheEndArrayList.setText(string);

        binding.pbRemovingInTheEndArrayList.setVisibility(View.INVISIBLE);
        binding.tvRemovingInTheEndArrayList.setVisibility(View.VISIBLE);
    }



    @Override
    public void showAddingInTheBeginningLinkedList(String string) {
        binding.tvAddingInTheBeginningLinkedList.setText(string);

        binding.pbAddingInTheBeginningLinkedList.setVisibility(View.INVISIBLE);
        binding.tvAddingInTheBeginningLinkedList.setVisibility(View.VISIBLE);
    }
    @Override
    public void showAddingInTheMiddleLinkedList(String string) {
        binding.tvAddingInTheMiddleLinkedList.setText(string);

        binding.pbAddingInTheMiddleLinkedList.setVisibility(View.INVISIBLE);
        binding.tvAddingInTheMiddleLinkedList.setVisibility(View.VISIBLE);
    }
    @Override
    public void showAddingInTheEndLinkedList(String string) {
        binding.tvAddingInTheEndLinkedList.setText(string);

        binding.pbAddingInTheEndLinkedList.setVisibility(View.INVISIBLE);
        binding.tvAddingInTheEndLinkedList.setVisibility(View.VISIBLE);
    }
    @Override
    public void showSearchByValueLinkedList(String string) {
        binding.tvSearchByValueLinkedList.setText(string);

        binding.pbSearchByValueLinkedList.setVisibility(View.INVISIBLE);
        binding.tvSearchByValueLinkedList.setVisibility(View.VISIBLE);
    }
    @Override
    public void showRemovingInTheBeginningLinkedList(String string) {
        binding.tvRemovingInTheBeginningLinkedList.setText(string);

        binding.pbRemovingInTheBeginningLinkedList.setVisibility(View.INVISIBLE);
        binding.tvRemovingInTheBeginningLinkedList.setVisibility(View.VISIBLE);
    }
    @Override
    public void showRemovingInTheMiddleLinkedList(String string) {
        binding.tvRemovingInTheMiddleLinkedList.setText(string);

        binding.pbRemovingInTheMiddleLinkedList.setVisibility(View.INVISIBLE);
        binding.tvRemovingInTheMiddleLinkedList.setVisibility(View.VISIBLE);
    }
    @Override
    public void showRemovingInTheEndLinkedList(String string) {
        binding.tvRemovingInTheEndLinkedList.setText(string);

        binding.pbRemovingInTheEndLinkedList.setVisibility(View.INVISIBLE);
        binding.tvRemovingInTheEndLinkedList.setVisibility(View.VISIBLE);
    }


    @Override
    public void showAddingInTheBeginningCopyOnWriteArrayList(String string) {
        binding.tvAddingInTheBeginningCopyOnWriteList.setText(string);

        binding.pbAddingInTheBeginningCopyOnWriteList.setVisibility(View.INVISIBLE);
        binding.tvAddingInTheBeginningCopyOnWriteList.setVisibility(View.VISIBLE);
    }
    @Override
    public void showAddingInTheMiddleCopyOnWriteArrayList(String string) {
        binding.tvAddingInTheMiddleCopyOnWriteList.setText(string);

        binding.pbAddingInTheMiddleCopyOnWriteList.setVisibility(View.INVISIBLE);
        binding.tvAddingInTheMiddleCopyOnWriteList.setVisibility(View.VISIBLE);
    }
    @Override
    public void showAddingInTheEndCopyOnWriteArrayList(String string) {
        binding.tvAddingInTheEndCopyOnWriteList.setText(string);

        binding.pbAddingInTheEndCopyOnWriteList.setVisibility(View.INVISIBLE);
        binding.tvAddingInTheEndCopyOnWriteList.setVisibility(View.VISIBLE);
    }
    @Override
    public void showSearchByValueCopyOnWriteArrayList(String string) {
        binding.tvSearchByValueCopyOnWriteList.setText(string);

        binding.pbSearchByValueCopyOnWriteList.setVisibility(View.INVISIBLE);
        binding.tvSearchByValueCopyOnWriteList.setVisibility(View.VISIBLE);
    }
    @Override
    public void showRemovingInTheBeginningCopyOnWriteArrayList(String string) {
        binding.tvRemovingInTheBeginningCopyOnWriteList.setText(string);

        binding.pbRemovingInTheBeginningCopyOnWriteList.setVisibility(View.INVISIBLE);
        binding.tvRemovingInTheBeginningCopyOnWriteList.setVisibility(View.VISIBLE);
    }
    @Override
    public void showRemovingInTheMiddleCopyOnWriteArrayList(String string) {
        binding.tvRemovingInTheMiddleCopyOnWriteList.setText(string);

        binding.pbRemovingInTheMiddleCopyOnWriteList.setVisibility(View.INVISIBLE);
        binding.tvRemovingInTheMiddleCopyOnWriteList.setVisibility(View.VISIBLE);

    }
    @Override
    public void showRemovingInTheEndCopyOnWriteArrayList(String string) {
        binding.tvRemovingInTheEndCopyOnWriteList.setText(string);

        binding.pbRemovingInTheEndCopyOnWriteList.setVisibility(View.INVISIBLE);
        binding.tvRemovingInTheEndCopyOnWriteList.setVisibility(View.VISIBLE);

    }


}
