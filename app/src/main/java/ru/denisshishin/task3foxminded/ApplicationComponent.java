package ru.denisshishin.task3foxminded;

import dagger.Component;
import ru.denisshishin.task3foxminded.collections.CollectionsFragment;
import ru.denisshishin.task3foxminded.maps.MapsFragment;

@Component
public interface ApplicationComponent {
    void inject(MapsFragment mapsFragment);
    void inject(CollectionsFragment collectionsFragment);
}
