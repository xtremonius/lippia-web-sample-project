package lippia.web.steps;

import com.crowdar.core.PageSteps;
import io.cucumber.java.en.*;
import lippia.web.services.PracticaLippiaWebService;

public class PracticaLippiaWebSteps extends PageSteps {

    @Given("el alumno navega a la web de Automation Practice")
    public void elAlumnoNavegaALaWebDeAutomationPractice() {
        PracticaLippiaWebService.navegarWeb();
    }

    @When("^el alumno realiza una busqueda del \"(.*)\"$")
    public void elAlumnoRealizaUnaBusquedaDelProducto(String producto) {
        PracticaLippiaWebService.setCampoSearch(producto);
        PracticaLippiaWebService.clickButtonSearch();
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


    @Then("el alumno verifica que el resultado de la busqueda en search sea el mismo ingresado en el input \"(.*)\"$")
    public void elAlumnoVerificaQueElResultadoDeLaBusquedaEnSearchSeaElMismoIngresadoEnElInputProducto(String producto) {
        PracticaLippiaWebService.verificarSearchInPage(producto);
    }

    @When("el alumno pulsa el boton Sign in")
    public void elAlumnoPulsaElBotonSignIn() {
        PracticaLippiaWebService.clickButtonSignIn();
    }

    @And("el alumno presiona el boton view list")
    public void elAlumnoPresionaElBotonViewList() {
        PracticaLippiaWebService.clickButtonViewList();
    }

    @Then("el alumno verifica que el orden de los productos")
    public void elAlumnoVerificaQueElOrdenDeLosProductos() {
        PracticaLippiaWebService.checkOrder();
    }


    @And("el alumno presiona el boton de ordenar por \"(.*)\"")
    public void elAlumnoPresionaElBotonDeOrdenarPorSortby(String sortby) {
        PracticaLippiaWebService.clickButtonShort(sortby);
    }
}
