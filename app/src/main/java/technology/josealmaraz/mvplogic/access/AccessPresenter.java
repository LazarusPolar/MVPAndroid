package technology.josealmaraz.mvplogic.access;

import android.support.annotation.Nullable;

/**
 * Created by Usuario on 14/11/2017.
 */

public class AccessPresenter implements AccessActivityContract.Presenter {

    @Nullable
    private AccessActivityContract.View view;
    private AccessActivityContract.Model model;

    public AccessPresenter(AccessActivityContract.Model model) {
        this.model = model;
    }

    @Override
    public void setView(AccessActivityContract.View view) {
        this.view = view;
    }

    @Override
    public void botonAccesoPresionado() {
        if (view != null){
            if (view.getApellidos().trim().equals("") || view.getNombres().trim().equals("")){
                view.muestraErrorEntrada();
            } else {
                model.createUser(view.getNombres(), view.getApellidos());
                view.muestraGuardado();
            }
        }
    }

    @Override
    public void obtieneUsuario() {
        Usuario user = model.getUser();
        if(user == null){
            if(view != null){
                view.muestraNoDisponible();
            }
        } else {
            if (view != null){
                view.setNombres(user.getNombres());
                view.setApellidos(user.getApellidos());
            }
        }
    }
}
