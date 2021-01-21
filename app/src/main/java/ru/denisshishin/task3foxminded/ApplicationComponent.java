package ru.denisshishin.task3foxminded;

import dagger.Component;
import ru.denisshishin.task3foxminded.collections.CollectionsFragment;
import ru.denisshishin.task3foxminded.collections.CollectionsPresenter;
import ru.denisshishin.task3foxminded.maps.MapsFragment;
import ru.denisshishin.task3foxminded.maps.MapsPresenter;


@Component(modules = {SchedulerModule.class})
public interface ApplicationComponent {
   void inject(MapsFragment mapsFragment);
   void inject(CollectionsFragment collectionsFragment);
   void inject(CollectionsPresenter collectionsPresenter);
   void inject(MapsPresenter mapsPresenter);
}
