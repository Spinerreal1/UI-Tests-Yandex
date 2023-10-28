package tests;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class YandexTest extends TestBase{


    @Epic("Тест кейсы yandex")
    @Feature("Тест-кейс 1")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Создание нового файла и проверка корректности названия")
    @Test
    public void firstTest() {
        app.navigator().openHomePage();
        app.login().goToAuthPage();
        app.login().typeUsername();
        app.login().typePassword();
        app.navigator().goToYandexIdPage();
        app.page().switchToNewTabAndCloseOldTab();
        app.navigator().goToYandexDiscPage();
        app.navigator().clickDisc();
        app.create().createNewFolder();
        app.create().openFolderDoubleClick();
        app.create().createNewTextDocument();
        app.page().closeNewTabAndSwitchToOldTab();
        Assertions.assertTrue(app.create().isNameWordFilePresent());
        app.login().logout();
    }





    @Epic("Тест кейсы yandex")
    @Feature("Тест-кейс 1")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Загрузка и сравнение информации из фала txt и на яндекс диске")
    @Test
    public void secondTest() {
        app.navigator().openHomePage();
        app.login().goToAuthPage();
        app.login().typeUsername();
        app.login().typePassword();
        app.navigator().goToYandexIdPage();
        app.page().switchToNewTabAndCloseOldTab();
        app.navigator().goToYandexDiscPage();
        app.navigator().clickDisc();
        app.upload().uploadFile();
        app.upload().openUploadFile();
        app.page().switchToNewTab();
        app.upload().testUploadAssert();
        app.page().switchToPreviousTab();
        app.page().closeNewTabAndSwitchToOldTab();
        app.navigator().clickCloseHeaderButton();
        app.login().logout();
    }
}
