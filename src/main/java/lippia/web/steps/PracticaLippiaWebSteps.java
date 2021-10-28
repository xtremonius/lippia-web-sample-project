package lippia.web.steps;

import com.crowdar.core.PageSteps;
import io.cucumber.java.en.*;
import lippia.web.constants.PracticaLippiaWebConstants;
import lippia.web.services.PracticaLippiaWebService;

public class PracticaLippiaWebSteps extends PageSteps {

    @Given("el alumno navega a la web de Automation Practice")
    public void elAlumnoNavegaALaWebDeAutomationPractice() {
        PracticaLippiaWebService.navegarWeb();
    }

    @When("^el alumno realiza una busqueda del producto \"(.*)\"$")
    public void elAlumnoRealizaUnaBusquedaDelProducto(String campo) {
        PracticaLippiaWebService.setCampoSearch(campo);
    }

    @And("^el alumno presiona el boton \"(.*)\"$")
    public void elAlumnoPresionaElBoton(String boton) {
        PracticaLippiaWebService.clickButtonSearch();
    }

    @Then("el alumno verifica que el resultado de la busqueda en search sea el mismo ingresado en el input")
    public void elAlumnoVerificaQueElResultadoDeLaBusquedaEnSearchSeaElMismoIngresadoEnElInput() {
        PracticaLippiaWebService.verificarSearchInPage();

    }


    @When("^el alumno pulsa el boton \"(.*)\"$")
    public void elAlumnoPulsaElBoton(String boton) {
        PracticaLippiaWebService.clickButtonSignIn();
    }

    @And("el alumno carga el email \"(.*)\" en el campo email address$")
    public void elAlumnoCargaElEmailEnElCampoEmailAddress(String email) {
        PracticaLippiaWebService.setCampoAddress(email);
    }

    @And("^el alumno carga el password \"(.*)\" en el campo password$")
    public void elAlumnoCargaElPasswordEnElCampoPassword(String password) {
        PracticaLippiaWebService.setCampoPassword(password);
    }

    @And("el alumno pulsa el boton de submit Sign in")
    public void elAlumnoPulsaElBotonDeSubmitSignIn() {
        PracticaLippiaWebService.clickButtonSignInSubmit();
    }

    @Then("el alumno verifica que el usuario ingreso a su cuenta")
    public void elAlumnoVerificaQueElUsuarioIngresoASuCuenta() {
        PracticaLippiaWebService.verificarLogin();
    }


    @And("^el alumno presiona el boton de ordenar \"(.*)\"$")
    public void elAlumnoPresionaElBotonDeOrdenar(String sortBy) {
        PracticaLippiaWebService.clickButtonSort(sortBy);
    }
}
