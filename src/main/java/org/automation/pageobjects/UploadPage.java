package org.automation.pageobjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.automation.framework.BrowserManager;
import org.automation.framework.SeleniumActions;
import org.openqa.selenium.By;

public class UploadPage {

    Logger log = LogManager.getRootLogger();
    BrowserManager manager = new BrowserManager();
    SeleniumActions actions = new SeleniumActions(manager);

    private static final By UPLOAD_INPUT = By.xpath("//input[@class='form-control-file']");
    private static final By UPLOAD_MESSAGE = By.xpath("//p[@id='uploadedFilePath']");

    public void openUploadPage() {
        log.info("Open upload page");
        manager.openBrowser();
        manager.getDriver().get("https://demoqa.com/upload-download");
        manager.getDriver().manage().window().maximize();
    }


    public void uploadFile(String filePath) {
        log.info("Uploading file: " + filePath);
        actions.waitElementToBeVisible(UPLOAD_INPUT, 10);
        actions.sendKeys(UPLOAD_INPUT, filePath);
    }


    public String getUploadSuccessMessage() {
        log.info("Verifying upload success message...");
        actions.waitElementToBeVisible(UPLOAD_MESSAGE, 10);
        return actions.getElementText(UPLOAD_MESSAGE);
    }





}
