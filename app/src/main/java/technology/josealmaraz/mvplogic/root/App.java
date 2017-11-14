package technology.josealmaraz.mvplogic.root;

import android.app.Application;

import technology.josealmaraz.mvplogic.access.AccessModule;

/**
 * Created by Usuario on 14/11/2017.
 */

public class App extends Application {

    private ApplicationComponent component;

    @Override
    public void onCreate() {
        super.onCreate();

        component = DaggerApplicationComponent.builder().applicationModule(new ApplicationModule(this)).accessModule(new AccessModule()).build();
    }

    public ApplicationComponent getComponent() {
        return component;
    }
}
