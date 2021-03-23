package ru.denisshishin.task3foxminded;

import android.os.Handler;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;
import io.reactivex.rxjava3.core.Scheduler;
import ru.denisshishin.task3foxminded.collections.CollectionsPresenter;
import ru.denisshishin.task3foxminded.maps.MapsPresenter;

import static ru.denisshishin.task3foxminded.SchedulerModule.OBSERVER;
import static ru.denisshishin.task3foxminded.SchedulerModule.PROCESS;

@Module
public class PresenterModule {

    @Provides
    CollectionsPresenter provideCollectionsPresenter(@Named(OBSERVER) Scheduler observerScheduler,
                                                     @Named(PROCESS) Scheduler processScheduler,
                                                     Handler handler) {
        return new CollectionsPresenter(observerScheduler, processScheduler, handler);
    }

    @Provides
    MapsPresenter provideMapsPresenter(@Named(OBSERVER) Scheduler observerScheduler,
                                       @Named(PROCESS) Scheduler processScheduler,
                                       Handler handler) {
        return new MapsPresenter(observerScheduler, processScheduler, handler);
    }
}
