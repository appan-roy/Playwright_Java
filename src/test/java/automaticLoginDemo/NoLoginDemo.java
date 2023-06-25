package automaticLoginDemo;

import com.microsoft.playwright.*;

import java.nio.file.Paths;

public class NoLoginDemo {

    public static void main(String[] args) {

        try (Playwright playwright = Playwright.create()) {

            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
            BrowserContext browserContext = browser.newContext(new Browser.NewContextOptions().setStorageStatePath(Paths.get("orangeHrmLogin.json")));
            Page page = browserContext.newPage();
            page.navigate("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

            page.waitForSelector("//span[text()='Admin']/parent::a");
            page.click("//span[text()='Admin']/parent::a");
            page.waitForSelector("//button[@type='submit']");

        }

    }

}
