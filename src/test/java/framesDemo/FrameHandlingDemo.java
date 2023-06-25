package framesDemo;

import com.microsoft.playwright.*;

public class FrameHandlingDemo {

    public static void main(String[] args) {

        try(Playwright playwright = Playwright.create()){
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
            BrowserContext browserContext = browser.newContext();
            Page page = browserContext.newPage();

            page.navigate("http://londonfreelance.org/courses/frames/index.html");

            String h1 = page.frameLocator("frame[name=main]").locator("h2").textContent();
            System.out.println(h1);

            String h2 = page.frameLocator("//frame[@name='main']").locator("h2").textContent();
            System.out.println(h2);

            String h3 = page.frame("main").locator("h2").textContent();
            System.out.println(h3);
        }

    }

}
