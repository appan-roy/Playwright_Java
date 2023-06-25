package automaticLoginDemo;

import com.microsoft.playwright.*;

import java.nio.file.Path;
import java.nio.file.Paths;

public class AuthDemo {

    public static void main(String[] args) {

        try (Playwright playwright = Playwright.create()) {

            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
            BrowserContext browserContext = browser.newContext();
            Page page = browserContext.newPage();
            page.navigate("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

            page.fill("//input[@name='username']", "Admin");
            page.fill("//input[@name='password']", "admin123");
            page.click("//button[@type='submit']");

            browserContext.storageState(new BrowserContext.StorageStateOptions().setPath(Paths.get("orangeHrmLogin.json")));

        }

    }

}
