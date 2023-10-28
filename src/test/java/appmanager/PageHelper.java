package appmanager;

import org.openqa.selenium.WebDriver;

import java.util.Set;

public class PageHelper extends HelperBase{
    public PageHelper(WebDriver driver) {
        super(driver);
    }
    public void switchToNewTabAndCloseOldTab() {
        String oldTab = driver.getWindowHandle();
        for (String tab : driver.getWindowHandles()) {
            if (!tab.equals(oldTab)) {
                driver.close();
                driver.switchTo().window(tab);
                break;
            }
        }
    }
    public void switchToNewTab() {
        String oldTab = driver.getWindowHandle();
        for (String tab : driver.getWindowHandles()) {
            if (!tab.equals(oldTab)) {
                driver.switchTo().window(tab);
                break;
            }
        }
    }
    public void closeNewTabAndSwitchToOldTab() {
        String oldTab = driver.getWindowHandle();
        String newTab = null;
        for (String tab : driver.getWindowHandles()) {
            if (!tab.equals(oldTab)) {
                newTab = tab;
                driver.switchTo().window(newTab);
                break;
            }
        }
        if (newTab != null) {
            driver.close();
            driver.switchTo().window(oldTab);
        } else {
            throw new IllegalStateException("Вкладка не найдена.");
        }
    }
    public void switchToPreviousTab() {
        String currentHandle = driver.getWindowHandle();
        Set<String> windowHandles = driver.getWindowHandles();
        String previousHandle = null;
        for (String handle : windowHandles) {
            if (!handle.equals(currentHandle)) {
                previousHandle = handle;
            }
        }
        if (previousHandle != null) {
            driver.switchTo().window(previousHandle);
        } else {
            throw new IllegalStateException("Предыдущая вкладка не найдена.");
        }
    }
}