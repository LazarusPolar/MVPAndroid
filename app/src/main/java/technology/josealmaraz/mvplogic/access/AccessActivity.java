package technology.josealmaraz.mvplogic.access;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import javax.inject.Inject;

import technology.josealmaraz.mvplogic.R;
import technology.josealmaraz.mvplogic.root.App;

public class AccessActivity extends AppCompatActivity implements AccessActivityContract.View{

    private EditText editText1, editText2;
    private Button button;

    @Inject
    AccessActivityContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_access);

        ((App) getApplication()).getComponent().inject(this);

        editText1 = (EditText)findViewById(R.id.editText);
        editText2 = (EditText)findViewById(R.id.editText2);
        button = (Button)findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.botonAccesoPresionado();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.setView(this);
        presenter.obtieneUsuario();
    }

    @Override
    public String getNombres() {
        return editText1.getText().toString();
    }

    @Override
    public String getApellidos() {
        return editText2.getText().toString();
    }

    @Override
    public void muestraNoDisponible() {
        Toast.makeText(this, "No es posible recuperar usuario", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void muestraErrorEntrada() {
        Toast.makeText(this, "No se permiten valores nulos", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void muestraGuardado() {
        Toast.makeText(this, "Usuario almacenado", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setNombres(String nombres) {
        editText1.setText(nombres);
    }

    @Override
    public void setApellidos(String apellidos) {
        editText2.setText(apellidos);
    }
}
