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

import butterknife.BindView;
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


   //TextView tvCollections;
   // TextView tvCollections2;
    Button btnCollectionsFragment;
   // ProgressBar pbCollectionsFragment;
  //  ProgressBar pbCollections2;


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
        //tvCollections = view.findViewById(R.id.tvCollections);
      //  tvCollections2 = view.findViewById(R.id.tvCollections2);
       // pbCollectionsFragment = view.findViewById(R.id.pbCollectionsFragment);
      //  pbCollections2 = view.findViewById(R.id.pbCollections2);


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
      //  tvCollections.setText(string);
    }
    @Override
    public void showTv2Fragment(String string) {
   //    tvCollections2.setText(string);
    }

    @Override
    public void showPbCollectonsFragment() {

        /*tvCollections.setVisibility(View.INVISIBLE);
        pbCollectionsFragment.setVisibility(View.VISIBLE);

        tvCollections2.setVisibility(View.INVISIBLE);
        pbCollections2.setVisibility(View.VISIBLE);

*/
    }

    @Override
    public void hidePbCollectonsFragment() {
        /*pbCollectionsFragment.setVisibility(View.INVISIBLE);
        tvCollections.setVisibility(View.VISIBLE);*/
    }

    @Override
    public void hidePbCollectons2() {
    /*    pbCollections2.setVisibility(View.INVISIBLE);
        tvCollections2.setVisibility(View.VISIBLE);*/
    }
}
