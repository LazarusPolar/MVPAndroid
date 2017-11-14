package technology.josealmaraz.mvplogic.root;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Component;
import technology.josealmaraz.mvplogic.access.AccessActivity;

/**
 * Created by Usuario on 14/11/2017.
 */

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    void inject(AccessActivity target);
}
