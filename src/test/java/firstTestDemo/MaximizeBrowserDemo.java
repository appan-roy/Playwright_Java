package firstTestDemo;

import com.microsoft.playwright.*;

import java.awt.*;

public class MaximizeBrowserDemo {

    public static void main(String[] args) throws InterruptedException {

        // get the screen dimension
        Dimension scrDimension = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int) scrDimension.getWidth();
        int height = (int) scrDimension.getHeight();
        System.out.println(width + " * " + height);

        try(Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
            BrowserContext browserContext = browser.newContext(new Browser.NewContextOptions().setViewportSize(width, height));
            Page page = browser.newPage();
            page.navigate("https://chromedriver.storage.googleapis.com/index.html?path=114.0.5735.90/");
            Thread.sleep(5000);
        }

    }

}
