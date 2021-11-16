package lippia.web.services;

import com.crowdar.core.PropertyManager;
import com.crowdar.core.actions.ActionManager;
import lippia.web.constants.PracticaLippiaWebConstants;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.*;

import static com.crowdar.core.actions.WebActionManager.*;


public class PracticaLippiaWebService extends ActionManager {

    public static void navegarWeb(){
        navigateTo(PropertyManager.getProperty("web.base.url"));
    }

    public static void clickButtonSignIn(){
        click(PracticaLippiaWebConstants.BUTTON_SIGNIN_XPATH);
    }

    public static void verificarSignInPage(){
        waitVisibility(PracticaLippiaWebConstants.INPUT_ADDRESS_XPATH);
        Assert.assertTrue(isVisible(PracticaLippiaWebConstants.INPUT_ADDRESS_XPATH));
        waitVisibility(PracticaLippiaWebConstants.H1_TITULO_XPATH);
        Assert.assertEquals(getText(PracticaLippiaWebConstants.H1_TITULO_XPATH),"AUTHENTICATION","No se encuentra el titulo");
    }

    public static void setCampoSearch(String text){
        setInput(PracticaLippiaWebConstants.INPUT_SEARCH_XPATH, text);
    }

    public static void clickButtonSearch(){
        click(PracticaLippiaWebConstants.BUTTON_SEARCH_XPATH);
    }

    public static void verificarSearchInPage(String produc){
        waitVisibility(PracticaLippiaWebConstants.SPAN_SEARCH_XPATH);
        Assert.assertTrue(isVisible(PracticaLippiaWebConstants.SPAN_SEARCH_XPATH));
        String span_text = getText(PracticaLippiaWebConstants.SPAN_SEARCH_XPATH);
        span_text = span_text.substring(1, span_text.length()-1);
        produc = produc.toUpperCase();
        Assert.assertEquals(produc,span_text,"No se encuentra la busqueda para el producto");

    }

    public static void setCampoAddress(String email){
        setInput(PracticaLippiaWebConstants.INPUT_ADDRESS_XPATH, email);
    }

    public static void setCampoPassword(String password){
        setInput(PracticaLippiaWebConstants.INPUT_PASSWD_XPATH, password);
    }

    public static void clickButtonSignInSubmit(){
        click(PracticaLippiaWebConstants.BUTTON_SIGNINSUBMIT_XPATH);
    }

    public static void verificarLogin(){
        waitVisibility(PracticaLippiaWebConstants.H1_MYACCOUNT_XPATH);
        Assert.assertTrue(isVisible(PracticaLippiaWebConstants.H1_MYACCOUNT_XPATH));
        Assert.assertEquals(getText(PracticaLippiaWebConstants.H1_MYACCOUNT_XPATH), "MY ACCOUNT","Error de login");
    }


    public static void clickButtonViewList() {
        click(PracticaLippiaWebConstants.VIEW_LIST_XPATH);
    }

    public static void clickButtonShort(String sortby) {
        Select s = new Select(getElement(PracticaLippiaWebConstants.SELECT_SORT_XPATH));
        s.selectByVisibleText(sortby);

    }


    public static void checkOrder() {
        waitVisibility(PracticaLippiaWebConstants.DIV_PRODUCTS_XPATH);
        List<WebElement> productosString = getElements(PracticaLippiaWebConstants.DIV_PRODUCTS_XPATH);
        List<Double> productosPrecioFormat = new ArrayList<>();
        for (WebElement e : productosString){
            String str = e.getText().substring(1);
            double d = Double.parseDouble(str);
            productosPrecioFormat.add(d);
        }
        ArrayList<Double> productosPrecioFormatCopy = new ArrayList<Double>(productosPrecioFormat);
        Collections.sort(productosPrecioFormat);
        Assert.assertTrue(productosPrecioFormat.equals(productosPrecioFormatCopy), "Los productos no se encuentra ordenados");

    }
}
