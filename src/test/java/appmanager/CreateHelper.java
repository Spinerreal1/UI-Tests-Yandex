package appmanager;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import randomgenerator.RandomGenerator;


public class CreateHelper extends HelperBase {
    private String folderNameValue;
    private String fileNameValue;
    private final By _createButton = By.xpath("//*[@class='create-resource-popup-with-anchor']");
    private final By _folderIcon = By.xpath("//*[contains(@class, 'create-item')]//*[@aria-label='Папку']");
    private final By _inputName = By.xpath("//*[@class='Modal-Content']//*[@class='Textinput-Control']");
    private final By _saveModalButton = By.xpath("//*[contains(@class, 'button_submit')]");
    private final By _submitFolderCreation = By.xpath("//*[contains(@class, 'button_submit')]");
    private final By _wordIcon = By.xpath("//*[contains(@class, 'create-item')]//*[@aria-label='Текстовый документ']");
    private final By _filesButton = By.xpath("//*[@id='/disk']");

    private By _folderByName(String folderName) {
        return By.xpath("//*[@class='listing-item__info']//*[@aria-label='" + folderName + "']");
    }
    private By _fileByName(String fileName) {
        return By.xpath("//*[contains(@class, 'listing-item')]//*[@title='" + fileName + ".docx']");
    }
    public CreateHelper(WebDriver driver) {
        super(driver);
    }

    public void createNewFolder() {
        driver.findElement(_filesButton).click();
        driver.findElement(_createButton).click();
        driver.findElement(_folderIcon).click();
        folderNameValue = RandomGenerator.newFolderName();
        typeWithHotKeys(_inputName, folderNameValue);
        driver.findElement(_submitFolderCreation).click();
    }


    public void openFolderDoubleClick() {
        if (folderNameValue != null) {
            doubleClickElement(driver, _folderByName(folderNameValue));
        } else {
            throw new IllegalStateException("folderNameValue is null. Cannot open folder.");
        }
    }

    public void createNewTextDocument() {
        driver.findElement(_createButton).click();
        driver.findElement(_wordIcon).click();
        fileNameValue = RandomGenerator.newFileName();
        typeWithHotKeys(_inputName, fileNameValue);
        driver.findElement(_saveModalButton).click();
    }
    public boolean isNameWordFilePresent() {
        try {
            waitForElementVisible(_fileByName(fileNameValue));
            System.out.println("Файл с названием " + fileNameValue + " успешно найден.");
            return true;
        } catch (org.openqa.selenium.TimeoutException e) {
            System.out.println("Файл с названием " + fileNameValue + " не найден.");
            return false;
        }
    }
}
