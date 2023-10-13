package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class YandexTest extends TestBase{

    @Test
    public void firstTest() {
        app.navigator().openHomePage();
        //app.login().goToAuthPage();
        //app.login().typeUsername();
        //app.login().typePassword();
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
    @Test
    public void secondTest() {
        app.navigator().openHomePage();
        //app.login().goToAuthPage();
        //app.login().typeUsername();
        //app.login().typePassword();
        app.navigator().goToYandexIdPage();
        app.page().switchToNewTabAndCloseOldTab();
        app.navigator().goToYandexDiscPage();
        app.navigator().clickDisc();
        app.upload().uploadFile();
        app.upload().openUploadFile();
        app.page().switchToNewTab();
        app.upload().testUploadAssert();
        app.page().switchToNewTabAndCloseOldTab();
        app.login().logout();
    }
}
