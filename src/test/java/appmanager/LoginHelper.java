package appmanager;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import model.UsernameData;
import model.PasswordData;
public class LoginHelper extends HelperBase{

    public LoginHelper(WebDriver driver) {
        super(driver);
    }

    private final By _usernameField = By.xpath("//input[@name='login']");
    private final By _passwordField = By.xpath("//*[@name='passwd']");
    private final By _submitButton = By.xpath("//button[@type='submit']");
    private final By _loginButton = By.xpath("//*[contains(@class, 'login')][2]");
    private final By _yandexIdSelectButton = By.xpath("//*[contains(@class, 'base-login')][text()='Войти через Яндекс ID']");
    private final By _openDropDownMenu = By.xpath("//*[@aria-label='Аккаунт']");
    private final By _exitButton = By.xpath("//*[@aria-label='Выйти из аккаунта']");




    public void fillUsername(UsernameData accountData)
    {
        type(_usernameField, accountData.getUsername());
    }
    public void fillPassword(PasswordData passwordData){
        type(_passwordField, passwordData.getPassword());
    }

    public void typeUsername()
    {
        fillUsername(new UsernameData("TestAuth00"));   //TestAuth00
        driver.findElement(_submitButton).click();
    }

    public void typePassword()
    {
        fillPassword(new PasswordData("kj2h6tluh092"));   //kj2h6tluh092
        driver.findElement(_submitButton).click();
    }

    public void goToAuthPage(){
        driver.findElement(_loginButton).click();
        driver.findElement(_yandexIdSelectButton).click();
    }
    public void logout(){
        waitForElementClickable(_openDropDownMenu);
        driver.findElement(_openDropDownMenu).click();
        driver.findElement(_exitButton).click();
    }
}
