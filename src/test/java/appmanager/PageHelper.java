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
    public void switchToPreviousTabAndClosePrevious() {
        // Сохраните идентификатор текущей вкладки
        String currentHandle = driver.getWindowHandle();

        // Получите список всех открытых вкладок
        Set<String> windowHandles = driver.getWindowHandles();

        // Найдите идентификатор предыдущей вкладки (кроме текущей)
        String previousHandle = null;
        for (String handle : windowHandles) {
            if (!handle.equals(currentHandle)) {
                previousHandle = handle;
            }
        }

        if (previousHandle != null) {
            // Переключитесь на предыдущую вкладку
            driver.switchTo().window(previousHandle);

            // Закройте предыдущую вкладку
            driver.close();
        } else {
            throw new IllegalStateException("Предыдущая вкладка не найдена.");
        }
    }
    public void switchToOldTabAndCloseCurrent() {
        // Сохраните идентификатор текущей вкладки (новой вкладки)
        String currentTab = driver.getWindowHandle();

        // Найдите идентификатор старой вкладки (другой, кроме текущей)
        String oldTab = null;
        for (String tab : driver.getWindowHandles()) {
            if (!tab.equals(currentTab)) {
                oldTab = tab;
                break;
            }
        }

        if (oldTab != null) {
            // Переключитесь на старую вкладку
            driver.switchTo().window(oldTab);

            // Закройте текущую вкладку (новую вкладку)
            driver.close();
        } else {
            throw new IllegalStateException("Старая вкладка не найдена.");
        }
    }
    public void switchToPreviousTab() {
        // Сохраните идентификатор текущей вкладки
        String currentHandle = driver.getWindowHandle();

        // Получите список всех открытых вкладок
        Set<String> windowHandles = driver.getWindowHandles();

        // Найдите идентификатор предыдущей вкладки (кроме текущей)
        String previousHandle = null;
        for (String handle : windowHandles) {
            if (!handle.equals(currentHandle)) {
                previousHandle = handle;
            }
        }

        if (previousHandle != null) {
            // Переключитесь на предыдущую вкладку
            driver.switchTo().window(previousHandle);
        } else {
            throw new IllegalStateException("Предыдущая вкладка не найдена.");
        }
    }
}