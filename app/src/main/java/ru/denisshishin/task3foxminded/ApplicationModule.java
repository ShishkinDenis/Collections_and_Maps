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
public class ApplicationModule {

    @Provides
    @Named("Observer")
    Scheduler provideObserverScheduler(){
        return  AndroidSchedulers.mainThread();
    }

    @Provides
    @Named("Process")
    Scheduler provideProcessScheduler(){
        return Schedulers.computation();
    }

    @Provides
    Handler provideHandler(){
        return new Handler(Looper.getMainLooper());
    }
}
