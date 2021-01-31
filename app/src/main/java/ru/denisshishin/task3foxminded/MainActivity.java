package ru.denisshishin.task3foxminded;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.fragment.app.FragmentActivity;

import com.google.android.material.tabs.TabLayoutMediator;

import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import ru.denisshishin.task3foxminded.databinding.ActivityMainBinding;

public class MainActivity extends FragmentActivity {


    private ActivityMainBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.viewPager.setAdapter(createCardAdapter());
        new TabLayoutMediator(binding.tabLayout,binding.viewPager, (tab, position) -> {
            if (position == 0){
                tab.setText("Collections");
            }
            else{
                tab.setText("Maps");
            }
        })
                .attach();
        RxJavaPlugins.setErrorHandler(e ->   Log.d("onError",e.getMessage()));
    }

    private ViewPagerAdapter createCardAdapter() {
        return new ViewPagerAdapter(this);
    }

}
