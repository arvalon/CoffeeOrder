package ru.arvalon.coffeeorder.system;

import android.app.Application;
import android.util.Log;

import com.squareup.leakcanary.LeakCanary;

import io.realm.Realm;
import ru.arvalon.coffeeorder.mainpage.impl.MainActivity;

/**
 * Created by arvalon on 26.03.2018.
 */

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        // https://github.com/robolectric/robolectric/issues/3839
        // Падает

        //if (LeakCanary.isInAnalyzerProcess(this)) {return;}
        //LeakCanary.install(this);

        Realm.init(this);
        Log.d("vga","App init Realm");

    }
}