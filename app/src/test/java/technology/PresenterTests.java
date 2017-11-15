package technology;

import org.junit.Before;
import org.junit.Test;

import technology.josealmaraz.mvplogic.access.AccessActivityContract;
import technology.josealmaraz.mvplogic.access.AccessPresenter;
import technology.josealmaraz.mvplogic.access.Usuario;

import static org.mockito.Mockito.mock;
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
        user = new Usuario("Fox", "Mulder");
        //when(mockLoginModel.getUser()).thenReturn(user);
        mockView = mock(AccessActivityContract.View.class);
        presenter = new AccessPresenter(mockLoginModel);
        presenter.setView(mockView);
    }

    @Test
    public void sinInteraccionDeVista(){
        presenter.obtieneUsuario();
        verifyZeroInteractions(mockView);
    }
}
