package appmanager;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationHelper extends HelperBase{

    public NavigationHelper(WebDriver driver) {
        super(driver);
    }
    public String baseUrl;

    private final By _dropDownMenuDzen = By.xpath("//*[@aria-label='Меню профиля']");
    private final By _nameInfoProfile = By.xpath("//*[@aria-label='Информация о профиле']");
    private final By _dropDownMenuYandexId = By.xpath("//*[@class='UserID-Account']");
    private final By  iframeLocator = By.xpath("//iframe[contains(@class, 'UserWidget-Iframe')]");
    private final By _yandexDiscLink = By.xpath("//*[@class='MenuItem-Content']//*[text()='Диск']");
    private final By _closeHeaderButton = By.xpath("//*[@aria-label='Отменить выделение']");


    @Step("Переходим в яндекс ID из яндекс Дзен")
    public void goToYandexIdPage(){
        driver.findElement(_dropDownMenuDzen).click();
        driver.findElement(_nameInfoProfile).click();
    }
    @Step("Открываем дропдаун меню в Яндекс ИД")
    public void goToYandexDiscPage(){
        waitForElementVisible(_dropDownMenuYandexId).click();
    }
    @Step("Нажимаем на иконку яндекс диск")
    public void clickDisc(){
        clickInsideIFrame(iframeLocator, _yandexDiscLink);
    }
    @Step("Закрываем панель действий")
    public void clickCloseHeaderButton(){
        driver.findElement(_closeHeaderButton).click();
    }
    @Step("Открываем главную страницу")
    public void openHomePage() {
        driver.get(baseUrl);
    }
}
