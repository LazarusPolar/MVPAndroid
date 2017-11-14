package technology.josealmaraz.mvplogic.root;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import technology.josealmaraz.mvplogic.access.AccessActivity;

/**
 * Created by Usuario on 14/11/2017.
 */

@Module
public class ApplicationModule {
    private Application application;

    public ApplicationModule(Application application) {
        this.application = application;
    }

    @Provides
    @Singleton
    public Context provideContext(){
        return application;
    }
}
