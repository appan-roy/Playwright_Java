package videoRecordingDemo;

import com.microsoft.playwright.*;

import java.nio.file.Paths;

public class TestExecutionVideoRecordingDemo {

    public static void main(String[] args) throws InterruptedException {

        try(Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

            // record video of test execution with size
            BrowserContext browserContext = browser.newContext(new Browser.NewContextOptions().setRecordVideoDir(Paths.get("test_videos/")).setRecordVideoSize(1080, 720));
            Page page = browserContext.newPage();
            page.navigate("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

            page.waitForSelector("//input[@name='username']");
            page.fill("//input[@name='username']", "Admin");
            page.fill("//input[@name='password']", "admin123");
            page.click("//button[@type='submit']");
            Thread.sleep(5000);
        }

    }

}
