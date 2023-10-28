package appmanager;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class UploadHelper extends HelperBase {
    public UploadHelper(WebDriver driver) {
        super(driver);
    }
    private String fileTxt = System.getProperty("user.dir") + "/src/main/resources/file.txt";
    private final By _uploadButton = By.xpath("//*[@class='upload-button__attach']");
    private final By _submitUpload = By.xpath("//*[contains(@class, 'button_submit')]");
    private final By _filePosition = By.xpath("//*[contains(@class, 'listing_completed')]//*[@aria-label='file.txt']");
    private final By _test = By.xpath("//*[@aria-label='file.txt']");
    private final By _uploadStatus = By.xpath("//*[@class='uploader-progress__progress-primary'][text()='Все файлы загружены']");
    private final By _textWeb = By.xpath("//*[@class='__page-1']");
    private final By _deleteButton = By.xpath("//button[@aria-label='Удалить']");



    protected void deleteTxtIfExist(){
        driver.findElement(_filePosition).click();
        driver.findElement(_deleteButton).click();
    }
    public void uploadFile(){
        if(isElementPresent(_filePosition)){
            deleteTxtIfExist();
        }

         WebElement upload = driver.findElement(_uploadButton);
         upload.sendKeys(fileTxt);

        if(isElementPresent(_submitUpload)){
            driver.findElement(_submitUpload).click();
        }
    }
    public void openUploadFile(){
        waitForElementVisible(_uploadStatus);
        doubleClickElement(driver, _filePosition);
    }

    public void testUploadAssert() {
        try {
            String fileContent = FileUtils.readFileToString(new File(fileTxt), "UTF-8");
            String webContent = driver.findElement(_textWeb).getText();
            fileContent = fileContent.replace("\n", "").replace("\r", "");
            webContent = webContent.replace("\n", "").replace("\r", "");
            System.out.println("Содержимое файла: " + fileContent);
            System.out.println("Содержимое веб-страницы: " + webContent);
            if (fileContent.equals(webContent)) {
                System.out.println("Содержимое файла совпадает с содержимым веб-страницы.");
            } else {
                throw new RuntimeException("Содержимое файла не совпадает с содержимым веб-страницы.");
            }
        } catch (IOException e) {
            throw new RuntimeException("Ошибка при чтении файла", e);
        }
    }
}