package technology.josealmaraz.mvplogic.access;

/**
 * Created by Usuario on 14/11/2017.
 */

public class MemoryRepository implements AccessRepository {

    private Usuario user;

    @Override
    public Usuario getUser() {
        if(user == null){
            Usuario user = new Usuario("Fox", "Mulder");
            user.setId(0);
            return user;
        } else {
            return user;
        }
    }

    @Override
    public void saveUser(Usuario user) {
        if (user == null){
            user = getUser();
        } else {
            this.user = user;
        }
    }
}
