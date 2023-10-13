package tests;

import appmanager.ApplicationManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.io.IOException;

public class TestBase {
    protected final ApplicationManager app = new ApplicationManager();

    @BeforeEach
    public void setUp() {
        app.init();
    }

    @AfterEach
    public void tearDown() throws IOException {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        app.takeScreenshot();
        app.stop();
    }
}
