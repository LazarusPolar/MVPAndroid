package technology.josealmaraz.mvplogic.access;

/**
 * Created by Usuario on 14/11/2017.
 */

public interface AccessRepository {
    Usuario getUser();
    void saveUser(Usuario user);
}
