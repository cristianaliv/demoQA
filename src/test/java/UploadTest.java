import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.automation.framework.BrowserManager;
import org.automation.pageobjects.UploadPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.nio.file.Paths;

public class UploadTest {


    UploadPage uploadPage = new UploadPage();
    Logger log = LogManager.getRootLogger();


    @BeforeEach
    public void setUp() {
        uploadPage.openUploadPage();
    }


    @Test
@DisplayName("Upload a file that is saved inside the project structure.")

    public void uploadSavedFile(){

        String filePath = Paths.get("src/test/resources/testfile.txt").toAbsolutePath().toString();
        uploadPage.uploadFile(filePath);
        String successMessage = uploadPage.getUploadSuccessMessage();
        System.out.println("Upload success message: " + successMessage);
    }



    @AfterEach
    public void tearDown() {
        BrowserManager.closeDriver();
    }
}



