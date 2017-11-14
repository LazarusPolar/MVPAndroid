package technology.josealmaraz.mvplogic.access;

/**
 * Created by Usuario on 14/11/2017.
 */

public interface LoginRepository {
    User getUser();
    void saveUser();
}
