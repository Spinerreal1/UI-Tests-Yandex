package appmanager;

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



    public void goToYandexIdPage(){
        driver.findElement(_dropDownMenuDzen).click();
        driver.findElement(_nameInfoProfile).click();
    }

    public void goToYandexDiscPage(){
        waitForElementVisible(_dropDownMenuYandexId).click();
    }
    public void clickDisc(){
        clickInsideIFrame(iframeLocator, _yandexDiscLink);
    }
    public void clickCloseHeaderButton(){
        driver.findElement(_closeHeaderButton).click();
    }

    public void openHomePage() {
        driver.get(baseUrl);
    }
}
