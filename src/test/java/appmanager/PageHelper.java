package appmanager;

import org.openqa.selenium.WebDriver;

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
}