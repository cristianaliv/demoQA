package org.automation.pageobjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.automation.framework.BrowserManager;
import org.automation.framework.SeleniumActions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;


public class ButtonsPage {

    Logger log = LogManager.getRootLogger();
    BrowserManager manager = new BrowserManager();
    SeleniumActions actions = new SeleniumActions(manager);

    private final static By CLICK_ME_BUTTON = By.xpath("//button[text() = 'Click Me']");
    private final static By CLICK_ME_MESSAGE = By.xpath("//p[@id = 'dynamicClickMessage']");

    public void openButtonsPage() {
        log.info("Open buttons page");
        manager.openBrowser();
        manager.getDriver().get("https://demoqa.com/buttons");
        manager.getDriver().manage().window().maximize();
    }

    public void scrollToButton() {
        log.info("Scrolling to the 'Click Me' button.");
        WebElement button = manager.getDriver().findElement(CLICK_ME_BUTTON);
        manager.scrollToElement(button);
    }

    public void findButton(){
        log.info("Find 'Click me' button");
        actions.waitElementToBeVisible(CLICK_ME_MESSAGE, 10);

    }

    public void clickMeButton(){

        log.info("Clicking on the 'Click Me' button.");
        actions.clickElement(CLICK_ME_BUTTON);

    }

    public String getClickMeMessage() {

        log.info("Verifying the outcome for 'Click Me' button.");
        actions.waitElementToBeVisible(CLICK_ME_MESSAGE, 5);
        return actions.getElementText(CLICK_ME_MESSAGE);
    }

}
