package technology.josealmaraz.mvplogic.access;

/**
 * Created by Usuario on 14/11/2017.
 */

public interface AccessActivityContract {
    interface View {
        String getNombres();
        String getApellidos();

        void muestraNoDisponible();
        void muestraErrorEntrada();
        void muestraGuardado();

        void setNombres(String nombres);
        void setApellidos(String apellidos);
    }

    interface Presenter {

        void setView(AccessActivityContract.View view);
        void botonAccesoPresionado();
        void obtieneUsuario();
        void saveUser();
    }

    interface Model {

        void createUser(String nombres, String apellidos);
        Usuario getUser();
    }
}
