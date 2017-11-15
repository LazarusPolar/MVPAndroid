package technology.josealmaraz.mvplogic.access;

/**
 * Created by Usuario on 14/11/2017.
 */

public class AccessModel implements AccessActivityContract.Model {

    private AccessRepository repository;

    public AccessModel(AccessRepository repository) {
        this.repository = repository;
    }

    @Override
    public void createUser(String nombres, String apellidos) {
       repository.saveUser(new Usuario(nombres, apellidos));
    }

    @Override
    public Usuario getUser() {
        return repository.getUser();
    }
}
