import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.automation.framework.BrowserManager;
import org.automation.pageobjects.ButtonsPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ButtonsTest {

    ButtonsPage buttonsPage = new ButtonsPage();
    Logger log = LogManager.getRootLogger();

    @BeforeEach
    public void setUp() {
        buttonsPage.openButtonsPage();
    }

    @Test
    @DisplayName("Click a button and verify the outcome")

    public void clickButtonAndVerify(){

        buttonsPage.scrollToButton();
        buttonsPage.clickMeButton();
        String result = buttonsPage.getClickMeMessage();
        assertEquals("You have done a dynamic click",result, "I found: " + result);
        System.out.println("Message of the button: " + result);
    }


    @AfterEach
    public void tearDown() {
        BrowserManager.closeDriver();
    }
}
