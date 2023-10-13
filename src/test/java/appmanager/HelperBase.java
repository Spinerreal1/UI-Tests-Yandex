package appmanager;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HelperBase {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public HelperBase(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public static void doubleClickElement(WebDriver driver, By locator) {
        WebElement element = driver.findElement(locator);
        Actions actions = new Actions(driver);
        actions.doubleClick(element).perform();
    }

    protected void click(By locator) {
        driver.findElement(locator).click();
    }

    protected void type(By locator, String text) {
        click(locator);
        if (text != null) {
            String existingText = driver.findElement(locator).getAttribute("value");

            if (!text.equals(existingText)) {
                driver.findElement(locator).clear();
                driver.findElement(locator).sendKeys(text);
            }
        }
    }

    protected void typeWithHotKeys(By locator, String text) {
        WebElement element = driver.findElement(locator);
        if (!element.getAttribute("value").isEmpty()) {
            element.sendKeys(Keys.CONTROL + "a");
            element.sendKeys(Keys.DELETE);
        }
        element.sendKeys(text);
    }

    public WebElement waitForElementVisible(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public WebElement waitForElementClickable(By locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public void setImplicitWait(Duration duration) {
        driver.manage().timeouts().implicitlyWait(duration);
    }

    public boolean isElementPresent(By locator) {
        try {
            driver.findElement(locator);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    protected void clickInsideIFrame(By iframeLocator, By elementLocator) {
        WebElement iframe = driver.findElement(iframeLocator);
        driver.switchTo().frame(iframe);
        driver.findElement(elementLocator).click();
        driver.switchTo().defaultContent();
    }
}
