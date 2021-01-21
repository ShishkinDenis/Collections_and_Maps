package ru.denisshishin.task3foxminded;

import android.os.Handler;
import android.os.Looper;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.schedulers.Schedulers;
import ru.denisshishin.task3foxminded.collections.CollectionsPresenter;
import ru.denisshishin.task3foxminded.maps.MapsPresenter;

@Module

public class SchedulerModule {
    Scheduler processScheduler = Schedulers.computation();
    Scheduler observerScheduler = AndroidSchedulers.mainThread();
    Handler handler = new Handler(Looper.getMainLooper());


//    @Provides
//    CollectionsPresenter provideCollectionsPresenter(@Named("Observer") Scheduler observerScheduler,
//                                                     @Named("Process") Scheduler processScheduler,
//                                                     Handler handler){
//        return new CollectionsPresenter(observerScheduler, processScheduler, handler);
//    }
//
//    @Provides
//    MapsPresenter provideMapsPresenter(@Named("Observer") Scheduler observerScheduler,
//                                       @Named("Process") Scheduler processScheduler,
//                                       Handler handler){
//        return new MapsPresenter(observerScheduler, processScheduler, handler);
//    }

    @Provides
    @Named("Observer")
    Scheduler provideObserverScheduler(){
        return  observerScheduler;
    }

    @Provides
    @Named("Process")
    Scheduler provideProcessScheduler(){
        return processScheduler;
    }

    @Provides
    Handler provideHandler(){
        return handler;
    }


}
