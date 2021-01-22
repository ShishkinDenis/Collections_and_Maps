package ru.denisshishin.task3foxminded;

import android.app.Application;

public class MyApplication extends Application {

    public static ApplicationComponent appComponent = DaggerApplicationComponent.create();

}
