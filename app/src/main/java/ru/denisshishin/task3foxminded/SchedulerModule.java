package ru.denisshishin.task3foxminded;

import android.os.Handler;
import android.os.Looper;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.schedulers.Schedulers;

@Module

public class SchedulerModule {

    Scheduler processScheduler = Schedulers.computation();
    Scheduler observerScheduler = AndroidSchedulers.mainThread();
    Handler handler = new Handler(Looper.getMainLooper());

    public static final String OBSERVER = "Observer";
    public static final String PROCESS = "Process";

    @Provides
    @Named(OBSERVER)
    Scheduler provideObserverScheduler() {
        return observerScheduler;
    }

    @Provides
    @Named(PROCESS)
    Scheduler provideProcessScheduler() {
        return processScheduler;
    }

    @Provides
    Handler provideHandler() {
        return handler;
    }

}
