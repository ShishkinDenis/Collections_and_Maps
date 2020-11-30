package ru.denisshishin.task3foxminded;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class ViewPagerAdapter extends FragmentStateAdapter {

    public ViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    public String[] titles = new String[]{"Collections","Maps"};

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new CollectionsFragment();
            case 1:
                return new MapsFragment();
        }
        return new CollectionsFragment();
        }


    @Override
    public int getItemCount() {
        return titles.length;
    }
}
