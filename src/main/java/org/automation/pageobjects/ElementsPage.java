package org.automation.pageobjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.automation.framework.BrowserManager;
import org.automation.framework.SeleniumActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Locale;

public class ElementsPage {

    Logger log = LogManager.getRootLogger();
    BrowserManager manager = new BrowserManager();
    SeleniumActions actions = new SeleniumActions(manager);

    private final static By ELEMENTS_PAGE_ELEMENTS = By.xpath("//div[@class='element-list collapse show']//li[@class='btn btn-light ']");
    private final static By TEXT_BOX_BANNER = By.xpath("//h1[@class='text-center']");


    public void openElementsPage() {
        log.info("Open elements page");
        manager.openBrowser();
        manager.getDriver().get("https://demoqa.com/elements");
        manager.getDriver().manage().window().maximize();
    }


    public List<WebElement> elementsDisplayed() {
        log.info("Check if elements are displayed");
        return actions.getElements(ELEMENTS_PAGE_ELEMENTS);
    }


    public void selectElementFromDropdown() {
        log.info("Search for 'Text Box' element:");
        List<WebElement> searchElements= actions.getElements(ELEMENTS_PAGE_ELEMENTS);
        for (var item : searchElements) {
            if (item.getText().equals("Text Box")) {
                item.click();
                break;
            }
        }

    }



    public String getTextBoxMessage() {

        log.info("Verify if the 'Text Box' is selected'");
        actions.waitElementToBeVisible(TEXT_BOX_BANNER, 5);
        return actions.getElementText(TEXT_BOX_BANNER);
    }
}

