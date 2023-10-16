package appmanager;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
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
    //private String fileTxt = "src/main/resources/file.txt";
    private String fileTxt = System.getProperty("user.dir") + "/src/main/resources/file.txt";
    //Path filePath = Paths.get(fileTxt);
    private final By _uploadButton = By.xpath("//*[@class='upload-button__attach']");
    private final By _submitUpload = By.xpath("//*[contains(@class, 'button_submit')]");
    private final By _filePosition = By.xpath("//*[contains(@class, 'listing_completed')]//*[@aria-label='file.txt']");
    private final By _uploadStatus = By.xpath("//*[@class='uploader-progress__progress-primary'][text()='Все файлы загружены']");
    private final By _textWeb = By.xpath("//*[@class='__page-1']");

    public void uploadFile(){
         WebElement upload = driver.findElement(_uploadButton);
         upload.sendKeys(fileTxt);
         //driver.findElement(_submitUpload).click();
    }
    public void openUploadFile(){
        waitForElementVisible(_uploadStatus);
        doubleClickElement(driver, _filePosition);
    }

    public void testUploadAssert() {
        try {
            // Считываем содержимое файла
            //String filePath = System.getProperty("user.dir") + "/src/main/resources/file.txt";
            String fileContent = FileUtils.readFileToString(new File(fileTxt), "UTF-8");

            // Получаем текст с веб-страницы
            String webContent = driver.findElement(_textWeb).getText();

            fileContent = fileContent.replace("\n", "").replace("\r", "");
            webContent = webContent.replace("\n", "").replace("\r", "");

            System.out.println("Содержимое файла: " + fileContent);
            System.out.println("Содержимое веб-страницы: " + webContent);

            // Сравниваем содержимое файла и веб-страницы
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