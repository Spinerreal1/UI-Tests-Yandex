package appmanager;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.List;

public class UploadHelper extends HelperBase {
    public UploadHelper(WebDriver driver) {
        super(driver);
    }
    private String filePathTxt = "C:\\drivers\\testuploadfile.txt";
    private final By _uploadButton = By.xpath("//*[@class='upload-button__attach']");
    private final By _submitUpload = By.xpath("//*[contains(@class, 'button_submit')]");
    private final By _filePosition = By.xpath("//*[contains(@class, 'listing_completed')]//*[@aria-label='testuploadfile.txt']");
    private final By _uploadStatus = By.xpath("//*[@class='uploader-progress__progress-primary'][text()='Все файлы загружены']");
    private final By _textWeb = By.xpath("//*[contains(@class, 'page_with_table_layout_fixed')]//p[@class='mg1']");

    public void uploadFile(){
         WebElement upload = driver.findElement(_uploadButton);
         upload.sendKeys(filePathTxt);
         driver.findElement(_submitUpload).click();
    }
    public void openUploadFile(){
        waitForElementVisible(_uploadStatus);
        doubleClickElement(driver, _filePosition);
    }

    String filePath = "C:\\drivers\\testuploadfile.txt";
    public void testUploadAssert() {
        try {
            String fileContent = FileUtils.readFileToString(new File(filePath), "UTF-8");
            String webContent = driver.findElement(_textWeb).getText();

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