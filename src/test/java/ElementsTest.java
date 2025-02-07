import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.automation.framework.BrowserManager;
import org.automation.pageobjects.ButtonsPage;
import org.automation.pageobjects.ElementsPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ElementsTest {

    ElementsPage elementsPage = new ElementsPage();
    Logger log = LogManager.getRootLogger();

    @BeforeEach
    public void setUp() {
        elementsPage.openElementsPage();
    }


    @Test
    @DisplayName("Validate elements test")
    public void validateElements() {
        log.info("Validate elements");
        List<WebElement> listOfProducts = elementsPage.elementsDisplayed();
        assertNotNull(listOfProducts, "List of elements is null");
        assertEquals(9, listOfProducts.size(), "Number of products is: " + listOfProducts.size());
        assertTrue(listOfProducts.get(0).getText().contains("Text Box"));
        elementsPage.selectElementFromDropdown();
        String message = elementsPage.getTextBoxMessage();
        assertEquals("Text Box", message, "I found: " + message);

    }



    @AfterEach
    public void tearDown() {
        BrowserManager.closeDriver();
    }


}
