package technology;

import org.junit.Before;
import org.junit.Test;

import technology.josealmaraz.mvplogic.access.AccessActivityContract;
import technology.josealmaraz.mvplogic.access.AccessPresenter;
import technology.josealmaraz.mvplogic.access.Usuario;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.mockingDetails;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyZeroInteractions;
import static org.mockito.Mockito.when;

/**
 * Created by Usuario on 15/11/2017.
 */

public class PresenterTests {
    AccessActivityContract.Model mockLoginModel;
    AccessActivityContract.View mockView;
    AccessPresenter presenter;
    Usuario user;

    @Before
    public void setup(){
        mockLoginModel = mock(AccessActivityContract.Model.class);
        user = new Usuario("Almaraz", "Jose");
        //when(mockLoginModel.getUser()).thenReturn(user);
        mockView = mock(AccessActivityContract.View.class);
        presenter = new AccessPresenter(mockLoginModel);
        presenter.setView(mockView);
    }


    //Pasa cuando no se encuentra la condicion "else" en obtenerUsuario()
    /*
    @Test
    public void sinInteraccionDeVista(){
        presenter.obtieneUsuario();
        verifyZeroInteractions(mockView);
    }*/

    @Test
    public void cargaUsuarioDelRepositorioCuandoUsuarioValido() {
        when(mockLoginModel.getUser()).thenReturn(user);

        presenter.obtieneUsuario();

        //Verifica interacciones del modelo
        verify(mockLoginModel, times(1)).getUser();

        //Verifica interacciones de la vista
        verify(mockView, times(1)).setNombres("Jose");
        verify(mockView, times(1)).setApellidos("Almaraz");
        verify(mockView, never()).muestraNoDisponible();
    }

    @Test
    public void muestraErrorCuandoUsuarioEsNull(){
        when(mockLoginModel.getUser()).thenReturn(null);

        presenter.obtieneUsuario();

        //Verifica interacciones del mdelo
        verify(mockLoginModel, times(1)).getUser();

        //Verifica interacciones de vista
        verify(mockView, never()).setApellidos("Almaraz");
        verify(mockView, never()).setNombres("Jose");
        verify(mockView, times(1)).muestraNoDisponible();
    }

    // TODO: ARREGLAR METODO DE PRUEBA
    @Test
    public void creaMensajesDeErrorSiLosCamposSonVacios() {
        when(mockView.getNombres()).thenReturn(""); // Vacio
        presenter.saveUser();

        verify(mockView, times(1)).getNombres();
        verify(mockView, never()).getApellidos();
        verify(mockView, times(1)).muestraErrorEntrada();

        //Regresa el valor de uno vacio y otro normal
        when(mockView.getNombres()).thenReturn("Daniel");
        when(mockView.getApellidos()).thenReturn("");

        presenter.saveUser();

        verify(mockView, times(1)).getApellidos(); //Llamado dos veces. Una antes y una ahora.
        verify(mockView, times(2)).getNombres(); // Solo llamado esta unica vez
        verify(mockView, times(2)).muestraErrorEntrada(); // Llamado dos veces. Una anterior y esta.

    }

    @Test
    public void debeGuardarUsuarioValido(){
        when(mockView.getApellidos()).thenReturn("Daniel");
        when(mockView.getNombres()).thenReturn("Alducin");

        presenter.saveUser();

        //Se llama dos veces y cuenta las de la invocacion del when
        verify(mockView, times(2)).getNombres();
        verify(mockView, times(2)).getApellidos();

        //Se asegura que el repositorio lo ha almancenado correctamente
        verify(mockLoginModel, times(1)).createUser("Alducin", "Daniel");

        //Se asegura de que la vista muestre mensaje
        verify(mockView, times(1)).muestraGuardado();
    }
}
