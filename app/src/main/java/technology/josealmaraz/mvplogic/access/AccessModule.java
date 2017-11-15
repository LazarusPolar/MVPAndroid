package technology.josealmaraz.mvplogic.access;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Usuario on 14/11/2017.
 */

@Module
public class AccessModule {

    @Provides
    public AccessActivityContract.Presenter provideAccessActivityPresenter(AccessActivityContract.Model model){
        return new AccessPresenter(model);
    }

    @Provides
    public AccessActivityContract.Model providesAccessActivityModel(AccessRepository repository){
        return new AccessModel(repository);
    }

    @Provides
    public AccessRepository provideAccessRepository(){
        return new MemoryRepository();
    }
}
