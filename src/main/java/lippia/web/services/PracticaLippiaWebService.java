package lippia.web.services;

import com.crowdar.core.PropertyManager;
import com.crowdar.core.actions.ActionManager;
import lippia.web.constants.PracticaLippiaWebConstants;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;

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

    public static void verificarSearchInPage(){
        String span_text = getText(PracticaLippiaWebConstants.SPAN_SEARCH_XPATH);
        span_text = span_text.substring(1, span_text.length()-1);
        waitVisibility(PracticaLippiaWebConstants.SPAN_SEARCH_XPATH);
        Assert.assertTrue(isVisible(PracticaLippiaWebConstants.SPAN_SEARCH_XPATH));
//        System.out.println("************************METODO verificarSearchInPage()*****************************");
//        List<WebElement> elementos = getElements(PracticaLippiaWebConstants.DIV_PRODUCTS_XPATH);
//
//        System.out.println("Valor de UL Productos: "+getAttribute(PracticaLippiaWebConstants.UL_PRODUCTS_XPATH,"innerText"));
//        for(WebElement e:elementos){
//            System.out.println(e.getText());
//            System.out.println("***************");
//        }
//        //System.out.println(elementos.get(0).getText());
//        System.out.println("*************************************************************************************");
        Assert.assertEquals(getAttribute(PracticaLippiaWebConstants.INPUT_SEARCH_XPATH,"value"),span_text,"No se encuentra la busqueda para el producto");





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

    public static void clickButtonSort(String sortBy){
       /* waitVisibility(PracticaLippiaWebConstants.SELECT_SORT_XPATH);
        Assert.assertTrue(isVisible(PracticaLippiaWebConstants.SELECT_SORT_XPATH));*/

        System.out.println("*******************METODO clickButtonSort() INICIO******************************************");
        List<WebElement> elementos_inicial = getElements(PracticaLippiaWebConstants.DIV_PRODUCTS_XPATH);
        for(WebElement e:elementos_inicial){
            System.out.println(e.getText());
            //System.out.println("****************");
        }
        System.out.println("*************************************************************************************");

        /**
         * Intrucciones para leer los valores del select
         *
        List<WebElement> miSelect = getElements(PracticaLippiaWebConstants.SELECT_SORT_XPATH);
        System.out.println("************Valores del select*******************");
        for(WebElement e:miSelect){
            System.out.println(e.getText());

        }
        System.out.println("*************************************************");*/


        waitVisibility(PracticaLippiaWebConstants.DIV_SORT_XPATH);
        Assert.assertTrue(isVisible(PracticaLippiaWebConstants.DIV_SORT_XPATH));
        System.out.println("****************Presionando el DropDown*****************************");




        setDropdownByText(PracticaLippiaWebConstants.SELECT_SORT_XPATH, sortBy);
        //waitInvisibility(PracticaLippiaWebConstants.UL_PRODUCTS_XPATH);


        System.out.println("****************Esperando el DIV_PRODUCTS_XPATH*****************************");
        waitVisibility((PracticaLippiaWebConstants.DIV_PRODUCTS_XPATH));
        Assert.assertTrue((isVisible(PracticaLippiaWebConstants.DIV_PRODUCTS_XPATH)));
        System.out.println("*************************************************");

        System.out.println("*******************METODO clickButtonSort() al Final******************************************");
        List<WebElement> elementos_final = getElements(PracticaLippiaWebConstants.DIV_PRODUCTS_XPATH);
        for(WebElement e:elementos_final){
            System.out.println(e.getText());
            //System.out.println("****************");
        }
        System.out.println("*************************************************************************************");



    }
}
