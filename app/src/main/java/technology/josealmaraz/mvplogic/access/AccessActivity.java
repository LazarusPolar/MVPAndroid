package technology.josealmaraz.mvplogic.access;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import technology.josealmaraz.mvplogic.R;

public class AccessActivity extends AppCompatActivity implements LoginActivityContract.View{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_access);
    }

    @Override
    public String getNombres() {
        return null;
    }

    @Override
    public String getApellidos() {
        return null;
    }

    @Override
    public void muestraNoDisponible() {

    }

    @Override
    public void muestraErrorEntrada() {

    }

    @Override
    public void muestraGuardado() {

    }

    @Override
    public void setNombres(String nombres) {

    }

    @Override
    public void setApellidos(String apellidos) {

    }
}
