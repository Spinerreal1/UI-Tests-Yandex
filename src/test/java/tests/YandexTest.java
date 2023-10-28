package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class YandexTest extends TestBase{


/*  Предусловие:
            ● Открыть браузер
    Шаги:
            ● Открыть страницу http://yandex.ru
            ● Авторизоваться
            ● Открыть Яндекс.Диск
            ● Создать новую папку и назвать её
            ● Открыть папку
            ● Создать новый файл и назвать его
            ● Закрыть открывшийся новый файл
            ● Проверить наличие нового файла и его название
    Ожидаемый результат:
            ● Файл создан
            ● Название соответствует введенному при создании
    Постусловие:
            ● Разлогиниться
            ● Закрыть браузер*/



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



/*  Предусловие:
            ● Открыть браузер
    Шаги:
            ● Открыть страницу http://yandex.ru
            ● Авторизоваться
            ● Открыть Яндекс.Диск
            ● Создать новую папку и назвать её
            ● Открыть папку
            ● Загрузить файл расширения .txt с текстом
            ● Открыть файл
            ● Проверить текст в файле
    Ожидаемый результат:
            ● Текст соответствует ожиданиям
    Постусловие:
            ● Разлогиниться
            ● Закрыть браузер*/


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
