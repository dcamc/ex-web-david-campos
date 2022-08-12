package com.nttdata.stepsdefinitions;

import com.nttdata.steps.InventorySteps;
import com.nttdata.steps.LinioLoginSteps;
import com.nttdata.steps.LoginSteps;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class LinioStepsDef {

    private WebDriver driver;
    private Scenario scenario;
    LinioLoginSteps loginSteps = new LinioLoginSteps(driver);


    @Before(order = 0)
    public void setUp(){
        //setUp
        System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
        //crear el driver
        driver = new ChromeDriver();
        //max
        driver.manage().window().maximize();
    }

    @Before(order = 1)
    public void setScenario(Scenario scenario){
        this.scenario = scenario;
    }

    @After
    public void quitDriver(){
        driver.quit();
    }

    @Dado("que me encuentro en la página de login de Linio")
    public void queMeEncuentroEnLaPáginaDeLoginDeLinio() {
        driver.get("https://www.linio.com.pe/account/login");
        screenShot();
    }

    @Cuando("inicio sesión con credenciales usuario: {string} y contraseña: {string}")
    public void inicioSesiónConCredencialesUsuarioYContraseña(String user, String password) {
        loginSteps.typeUser(user);
        loginSteps.typePassword(password);
        loginSteps.login();
        screenShot();
    }

    @Y("valido que estoy logeado correctamente con el usuario: {string}")
    public void validoQueEstoyLogeadoCorrectamenteConElUsuario(String arg0) {
        driver.get("https://www.linio.com.pe/");
        String usuarioLogeado =  ;
    }

    @Y("añado producto al carrito")
    public void añadoProductoAlCarrito() {
        
    }

    @Y("valido que el producto ha sido añadido")
    public void validoQueElProductoHaSidoAñadido() {
    }

    public void screenShot(){
        byte[] evidencia = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        this.scenario.attach(evidencia, "image/png", "evidencias");
    }


}
