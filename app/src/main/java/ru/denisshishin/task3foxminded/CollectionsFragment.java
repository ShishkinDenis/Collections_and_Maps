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
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import moxy.MvpAppCompatFragment;
import moxy.presenter.InjectPresenter;

public class CollectionsFragment extends MvpAppCompatFragment implements CollectionFragmentView {


    @InjectPresenter
    CollectionFragmentPresenter collectionFragmentPresenter;

    @BindView(R.id.tvAddingInTheBeginningArrayList) TextView tvAddingInTheBeginningArrayList;
    @BindView(R.id.tvAddingInTheMiddleArrayList) TextView tvAddingInTheMiddleArrayList;
    @BindView(R.id.tvAddingInTheEndArrayList) TextView tvAddingInTheEndArrayList;
    @BindView(R.id.tvSearchByValueArrayList) TextView tvSearchByValueArrayList;
    @BindView(R.id.tvRemovingInTheBeginningArrayList) TextView tvRemovingInTheBeginningArrayList;
    @BindView(R.id.tvRemovingInTheMiddleArrayList) TextView tvRemovingInTheMiddleArrayList;
    @BindView(R.id.tvRemovingInTheEndArrayList) TextView tvRemovingInTheEndArrayList;

    @BindView(R.id.tvAddingInTheBeginningLinkedList) TextView tvAddingInTheBeginningLinkedList;
    @BindView(R.id.tvAddingInTheMiddleLinkedList) TextView tvAddingInTheMiddleLinkedList;
    @BindView(R.id.tvAddingInTheEndLinkedList) TextView tvAddingInTheEndLinkedList;
    @BindView(R.id.tvSearchByValueLinkedList) TextView tvSearchByValueLinkedList;
    @BindView(R.id.tvRemovingInTheBeginningLinkedList) TextView tvRemovingInTheBeginningLinkedList;
    @BindView(R.id.tvRemovingInTheMiddleLinkedList) TextView tvRemovingInTheMiddleLinkedList;
    @BindView(R.id.tvRemovingInTheEndLinkedList) TextView tvRemovingInTheEndLinkedList;

    @BindView(R.id.tvAddingInTheBeginningCopyOnWriteList) TextView tvAddingInTheBeginningCopyOnWriteList;
    @BindView(R.id.tvAddingInTheMiddleCopyOnWriteList) TextView tvAddingInTheMiddleCopyOnWriteList;
    @BindView(R.id.tvAddingInTheEndCopyOnWriteList) TextView tvAddingInTheEndCopyOnWriteList;
    @BindView(R.id.tvSearchByValueCopyOnWriteList) TextView tvSearchByValueCopyOnWriteList;
    @BindView(R.id.tvRemovingInTheBeginningCopyOnWriteList) TextView tvRemovingInTheBeginningCopyOnWriteList;
    @BindView(R.id.tvRemovingInTheMiddleCopyOnWriteList) TextView tvRemovingInTheMiddleCopyOnWriteList;
    @BindView(R.id.tvRemovingInTheEndCopyOnWriteList) TextView tvRemovingInTheEndCopyOnWriteList;



    @BindView(R.id.pbAddingInTheBeginningArrayList) ProgressBar pbAddingInTheBeginningArrayList;
    @BindView(R.id.pbAddingInTheMiddleArrayList) ProgressBar pbAddingInTheMiddleArrayList;
    @BindView(R.id.pbAddingInTheEndArrayList) ProgressBar pbAddingInTheEndArrayList;
    @BindView(R.id.pbSearchByValueArrayList) ProgressBar pbSearchByValueArrayList;
    @BindView(R.id.pbRemovingInTheBeginningArrayList) ProgressBar pbRemovingInTheBeginningArrayList;
    @BindView(R.id.pbRemovingInTheMiddleArrayList) ProgressBar pbRemovingInTheMiddleArrayList;
    @BindView(R.id.pbRemovingInTheEndArrayList) ProgressBar pbRemovingInTheEndArrayList;

    @BindView(R.id.pbAddingInTheBeginningLinkedList) ProgressBar pbAddingInTheBeginningLinkedList;
    @BindView(R.id.pbAddingInTheMiddleLinkedList) ProgressBar pbAddingInTheMiddleLinkedList;
    @BindView(R.id.pbAddingInTheEndLinkedList) ProgressBar pbAddingInTheEndLinkedList;
    @BindView(R.id.pbSearchByValueLinkedList) ProgressBar pbSearchByValueLinkedList;
    @BindView(R.id.pbRemovingInTheBeginningLinkedList) ProgressBar pbRemovingInTheBeginningLinkedList;
    @BindView(R.id.pbRemovingInTheMiddleLinkedList) ProgressBar pbRemovingInTheMiddleLinkedList;
    @BindView(R.id.pbRemovingInTheEndLinkedList) ProgressBar pbRemovingInTheEndLinkedList;

    @BindView(R.id.pbAddingInTheBeginningCopyOnWriteList) ProgressBar pbAddingInTheBeginningCopyOnWriteList;
    @BindView(R.id.pbAddingInTheMiddleCopyOnWriteList) ProgressBar pbAddingInTheMiddleCopyOnWriteList;
    @BindView(R.id.pbAddingInTheEndCopyOnWriteList) ProgressBar pbAddingInTheEndCopyOnWriteList;
    @BindView(R.id.pbSearchByValueCopyOnWriteList) ProgressBar pbSearchByValueCopyOnWriteList;
    @BindView(R.id.pbRemovingInTheBeginningCopyOnWriteList) ProgressBar pbRemovingInTheBeginningCopyOnWriteList;
    @BindView(R.id.pbRemovingInTheMiddleCopyOnWriteList) ProgressBar pbRemovingInTheMiddleCopyOnWriteList;
    @BindView(R.id.pbRemovingInTheEndCopyOnWriteList) ProgressBar pbRemovingInTheEndCopyOnWriteList;

    @BindView(R.id.btnCollectionsFragment) Button btnCollectionsFragment;

    @BindView(R.id.tietInputNumberCollectionsFragment) EditText tietInputNumberCollectionsFragment;

    @BindView(R.id.pbFillingCollections) ProgressBar pbFillingCollections;
    @BindView(R.id.tvFillingCollections) TextView tvFillingCollections;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View viewCollectionsFragment = inflater.inflate(R.layout.fragment_collections, container, false);
        ButterKnife.bind(this,viewCollectionsFragment);
        return viewCollectionsFragment;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        btnCollectionsFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!tietInputNumberCollectionsFragment.getText().toString().isEmpty() ) {
                    collectionFragmentPresenter.launch(tietInputNumberCollectionsFragment.getText().toString());
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
    public void showProgressBarCollectionsFragment() {
        pbAddingInTheBeginningArrayList.setVisibility(View.VISIBLE);
        pbAddingInTheMiddleArrayList.setVisibility(View.VISIBLE);
        pbAddingInTheEndArrayList.setVisibility(View.VISIBLE);
        pbSearchByValueArrayList.setVisibility(View.VISIBLE);
        pbRemovingInTheBeginningArrayList.setVisibility(View.VISIBLE);
        pbRemovingInTheMiddleArrayList.setVisibility(View.VISIBLE);
        pbRemovingInTheEndArrayList.setVisibility(View.VISIBLE);

        pbAddingInTheBeginningLinkedList.setVisibility(View.VISIBLE);
        pbAddingInTheMiddleLinkedList.setVisibility(View.VISIBLE);
        pbAddingInTheEndLinkedList.setVisibility(View.VISIBLE);
        pbSearchByValueLinkedList.setVisibility(View.VISIBLE);
        pbRemovingInTheBeginningLinkedList.setVisibility(View.VISIBLE);
        pbRemovingInTheMiddleLinkedList.setVisibility(View.VISIBLE);
        pbRemovingInTheEndLinkedList.setVisibility(View.VISIBLE);

        pbAddingInTheBeginningCopyOnWriteList.setVisibility(View.VISIBLE);
        pbAddingInTheMiddleCopyOnWriteList.setVisibility(View.VISIBLE);
        pbAddingInTheEndCopyOnWriteList.setVisibility(View.VISIBLE);
        pbSearchByValueCopyOnWriteList.setVisibility(View.VISIBLE);
        pbRemovingInTheBeginningCopyOnWriteList.setVisibility(View.VISIBLE);
        pbRemovingInTheMiddleCopyOnWriteList.setVisibility(View.VISIBLE);
        pbRemovingInTheEndCopyOnWriteList.setVisibility(View.VISIBLE);
    }
    @Override
    public void hideTextViewCollectionsFragment() {
        tvAddingInTheBeginningArrayList.setVisibility(View.INVISIBLE);
        tvAddingInTheMiddleArrayList.setVisibility(View.INVISIBLE);
        tvAddingInTheEndArrayList.setVisibility(View.INVISIBLE);
        tvSearchByValueArrayList.setVisibility(View.INVISIBLE);
        tvRemovingInTheBeginningArrayList.setVisibility(View.INVISIBLE);
        tvRemovingInTheMiddleArrayList.setVisibility(View.INVISIBLE);
        tvRemovingInTheEndArrayList.setVisibility(View.INVISIBLE);

        tvAddingInTheBeginningLinkedList.setVisibility(View.INVISIBLE);
        tvAddingInTheMiddleLinkedList.setVisibility(View.INVISIBLE);
        tvAddingInTheEndLinkedList.setVisibility(View.INVISIBLE);
        tvSearchByValueLinkedList.setVisibility(View.INVISIBLE);
        tvRemovingInTheBeginningLinkedList.setVisibility(View.INVISIBLE);
        tvRemovingInTheMiddleLinkedList.setVisibility(View.INVISIBLE);
        tvRemovingInTheEndLinkedList.setVisibility(View.INVISIBLE);

        tvAddingInTheBeginningCopyOnWriteList.setVisibility(View.INVISIBLE);
        tvAddingInTheMiddleCopyOnWriteList.setVisibility(View.INVISIBLE);
        tvAddingInTheEndCopyOnWriteList.setVisibility(View.INVISIBLE);
        tvSearchByValueCopyOnWriteList.setVisibility(View.INVISIBLE);
        tvRemovingInTheBeginningCopyOnWriteList.setVisibility(View.INVISIBLE);
        tvRemovingInTheMiddleCopyOnWriteList.setVisibility(View.INVISIBLE);
        tvRemovingInTheEndCopyOnWriteList.setVisibility(View.INVISIBLE);
    }

    @Override
    public void showProgressBarFillingCollections() {
        pbFillingCollections.setVisibility(View.VISIBLE);
        tvFillingCollections.setVisibility(View.VISIBLE);
    }
    @Override
    public void hideProgressBarFillingCollections() {
        pbFillingCollections.setVisibility(View.INVISIBLE);
        tvFillingCollections.setVisibility(View.INVISIBLE);
    }


    @Override
    public void showAddingInTheBeginningArrayList(String string) {
        tvAddingInTheBeginningArrayList.setText(string);

        pbAddingInTheBeginningArrayList.setVisibility(View.INVISIBLE);
        tvAddingInTheBeginningArrayList.setVisibility(View.VISIBLE);

    }
    @Override
    public void showAddingInTheMiddleArrayList(String string) {
        tvAddingInTheMiddleArrayList.setText(string);

        pbAddingInTheMiddleArrayList.setVisibility(View.INVISIBLE);
        tvAddingInTheMiddleArrayList.setVisibility(View.VISIBLE);
    }
    @Override
    public void showAddingInTheEndArrayList(String string) {
        tvAddingInTheEndArrayList.setText(string);

        pbAddingInTheEndArrayList.setVisibility(View.INVISIBLE);
        tvAddingInTheEndArrayList.setVisibility(View.VISIBLE);
    }
    @Override
    public void showSearchByValueArrayList(String string) {
        tvSearchByValueArrayList.setText(string);

        pbSearchByValueArrayList.setVisibility(View.INVISIBLE);
        tvSearchByValueArrayList.setVisibility(View.VISIBLE);
    }
    @Override
    public void showRemovingInTheBeginningArrayList(String string) {
        tvRemovingInTheBeginningArrayList.setText(string);

        pbRemovingInTheBeginningArrayList.setVisibility(View.INVISIBLE);
        tvRemovingInTheBeginningArrayList.setVisibility(View.VISIBLE);
    }
    @Override
    public void showRemovingInTheMiddleArrayList(String string) {
        tvRemovingInTheMiddleArrayList.setText(string);

        pbRemovingInTheMiddleArrayList.setVisibility(View.INVISIBLE);
        tvRemovingInTheMiddleArrayList.setVisibility(View.VISIBLE);
    }
    @Override
    public void showRemovingInTheEndArrayList(String string){
        tvRemovingInTheEndArrayList.setText(string);

        pbRemovingInTheEndArrayList.setVisibility(View.INVISIBLE);
        tvRemovingInTheEndArrayList.setVisibility(View.VISIBLE);
    }



    @Override
    public void showAddingInTheBeginningLinkedList(String string) {
        tvAddingInTheBeginningLinkedList.setText(string);

        pbAddingInTheBeginningLinkedList.setVisibility(View.INVISIBLE);
        tvAddingInTheBeginningLinkedList.setVisibility(View.VISIBLE);
    }
    @Override
    public void showAddingInTheMiddleLinkedList(String string) {
        tvAddingInTheMiddleLinkedList.setText(string);

        pbAddingInTheMiddleLinkedList.setVisibility(View.INVISIBLE);
        tvAddingInTheMiddleLinkedList.setVisibility(View.VISIBLE);
    }
    @Override
    public void showAddingInTheEndLinkedList(String string) {
        tvAddingInTheEndLinkedList.setText(string);

        pbAddingInTheEndLinkedList.setVisibility(View.INVISIBLE);
        tvAddingInTheEndLinkedList.setVisibility(View.VISIBLE);
    }
    @Override
    public void showSearchByValueLinkedList(String string) {
        tvSearchByValueLinkedList.setText(string);

        pbSearchByValueLinkedList.setVisibility(View.INVISIBLE);
        tvSearchByValueLinkedList.setVisibility(View.VISIBLE);
    }
    @Override
    public void showRemovingInTheBeginningLinkedList(String string) {
        tvRemovingInTheBeginningLinkedList.setText(string);

        pbRemovingInTheBeginningLinkedList.setVisibility(View.INVISIBLE);
        tvRemovingInTheBeginningLinkedList.setVisibility(View.VISIBLE);
    }
    @Override
    public void showRemovingInTheMiddleLinkedList(String string) {
        tvRemovingInTheMiddleLinkedList.setText(string);

        pbRemovingInTheMiddleLinkedList.setVisibility(View.INVISIBLE);
        tvRemovingInTheMiddleLinkedList.setVisibility(View.VISIBLE);
    }
    @Override
    public void showRemovingInTheEndLinkedList(String string) {
        tvRemovingInTheEndLinkedList.setText(string);

        pbRemovingInTheEndLinkedList.setVisibility(View.INVISIBLE);
        tvRemovingInTheEndLinkedList.setVisibility(View.VISIBLE);
    }


    @Override
    public void showAddingInTheBeginningCopyOnWriteArrayList(String string) {
        tvAddingInTheBeginningCopyOnWriteList.setText(string);

        pbAddingInTheBeginningCopyOnWriteList.setVisibility(View.INVISIBLE);
        tvAddingInTheBeginningCopyOnWriteList.setVisibility(View.VISIBLE);
    }
    @Override
    public void showAddingInTheMiddleCopyOnWriteArrayList(String string) {
        tvAddingInTheMiddleCopyOnWriteList.setText(string);

        pbAddingInTheMiddleCopyOnWriteList.setVisibility(View.INVISIBLE);
        tvAddingInTheMiddleCopyOnWriteList.setVisibility(View.VISIBLE);
    }
    @Override
    public void showAddingInTheEndCopyOnWriteArrayList(String string) {
        tvAddingInTheEndCopyOnWriteList.setText(string);

        pbAddingInTheEndCopyOnWriteList.setVisibility(View.INVISIBLE);
        tvAddingInTheEndCopyOnWriteList.setVisibility(View.VISIBLE);
    }
    @Override
    public void showSearchByValueCopyOnWriteArrayList(String string) {
        tvSearchByValueCopyOnWriteList.setText(string);

        pbSearchByValueCopyOnWriteList.setVisibility(View.INVISIBLE);
        tvSearchByValueCopyOnWriteList.setVisibility(View.VISIBLE);
    }
    @Override
    public void showRemovingInTheBeginningCopyOnWriteArrayList(String string) {
        tvRemovingInTheBeginningCopyOnWriteList.setText(string);

        pbRemovingInTheBeginningCopyOnWriteList.setVisibility(View.INVISIBLE);
        tvRemovingInTheBeginningCopyOnWriteList.setVisibility(View.VISIBLE);
    }
    @Override
    public void showRemovingInTheMiddleCopyOnWriteArrayList(String string) {
        tvRemovingInTheMiddleCopyOnWriteList.setText(string);

        pbRemovingInTheMiddleCopyOnWriteList.setVisibility(View.INVISIBLE);
        tvRemovingInTheMiddleCopyOnWriteList.setVisibility(View.VISIBLE);


    }
    @Override
    public void showRemovingInTheEndCopyOnWriteArrayList(String string) {
        tvRemovingInTheEndCopyOnWriteList.setText(string);

        pbRemovingInTheEndCopyOnWriteList.setVisibility(View.INVISIBLE);
        tvRemovingInTheEndCopyOnWriteList.setVisibility(View.VISIBLE);

    }


}
