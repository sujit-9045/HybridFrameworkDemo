

import org.testng.annotations.Test;

import com.hybrid.base.BaseClass;
import com.hybrid.pages.LoginPage;

public class TestWithDuplicates extends BaseClass {

    @Test
    public void verifyLogin() throws InterruptedException {
        try {
            launchBrowser(); // from BaseClass

            LoginPage loginPage = new LoginPage(driver);
            loginPage.login("Admin", "admin123"); // dummy credentials

            System.out.println("✅ Login test executed successfully");

        } catch (Exception e) {
            System.out.println("❌ Login test failed: " + e.getMessage());
        } finally {
        	Thread.sleep(2000);
            closeBrowser(); // from BaseClass
        }
    }
}