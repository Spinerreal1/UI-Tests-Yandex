package appmanager;

import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.ScreenshotException;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    WebDriver driver;

    private LoginHelper loginHelper;
    private NavigationHelper navigationHelper;
    private PageHelper pageHelper;
    private CreateHelper createHelper;
    private UploadHelper uploadHelper;

    public void init() {
        ChromeOptions options = new ChromeOptions();
        //options.addArguments("--headless");
        options.addArguments("--start-maximized", "--incognito");

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        navigationHelper = new NavigationHelper(driver);
        loginHelper = new LoginHelper(driver);
        createHelper = new CreateHelper(driver);
        uploadHelper = new UploadHelper(driver);
        pageHelper = new PageHelper(driver);
        navigationHelper.baseUrl = "https://yandex.ru/";
    }


    @Step("Прикрепление скриншота")
    @Attachment(value = "Screenshot", type = "image/png")
    public byte[] takeScreenshot() {
        try {
            long pageHeight = (long) ((JavascriptExecutor) driver).executeScript("return Math.max(document.body.scrollHeight, " +
                    "document.documentElement.scrollHeight, " +
                    "document.body.offsetHeight, " +
                    "document.documentElement.offsetHeight, " +
                    "document.body.clientHeight, " +
                    "document.documentElement.clientHeight);");
            driver.manage().window().setSize(new org.openqa.selenium.Dimension(1920, (int) pageHeight));
            byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            driver.manage().window().setSize(new org.openqa.selenium.Dimension(1920, 1080));
            String timestamp = LocalDateTime.now().toString().replace(':', '-');
            String filename = "screenshot_" + timestamp + ".png";
            return screenshot;
        } catch (ScreenshotException e) {
            e.printStackTrace();
            return new byte[0];
        }
    }

    public void stop() {
        driver.quit();
    }

    public LoginHelper login() {
        return loginHelper;
    }

    public NavigationHelper navigator() {
        return navigationHelper;
    }

    public PageHelper page() {
        return pageHelper;
    }

    public CreateHelper create() {
        return createHelper;
    }
    public UploadHelper upload() {
        return uploadHelper;
    }
}
