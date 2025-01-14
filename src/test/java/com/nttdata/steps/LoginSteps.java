package com.nttdata.steps;

import com.nttdata.page.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class LoginSteps {

    private WebDriver driver;
    private  WebElement userInputElement;
    private WebElement userPassword;
    private WebElement loginButton;
    private WebElement imagen;

    //constructor
    public LoginSteps(WebDriver driver){
        this.driver = driver;
    }

    /**
     * Escribir el usuario
     * @param user el usuario
     */
    public void typeUser(String user){
        userInputElement = driver.findElement(LoginPage.userInput);
        userInputElement.sendKeys(user);

        //Espera implicita
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(444));

        //Espera explícita
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        wait.until(ExpectedConditions.visibilityOfElementLocated(LoginPage.loginButton));


    }

    /**
     * Escribir el password
     * @param password el password del usuario
     */
    public void typePassword(String password){
        userPassword=driver.findElement(LoginPage.passInput);
        userPassword.sendKeys(password);
    }

    /**
     * Hacer click en el botón login
     */
    public void login(){
        loginButton = driver.findElement(LoginPage.loginButton);
        loginButton.click();
    }

    public void validarImagen() {
        imagen =  driver.findElement(LoginPage.buscador);
        imagen.click();
    }
}
