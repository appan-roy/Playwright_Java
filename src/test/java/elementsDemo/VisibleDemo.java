package elementsDemo;

import com.microsoft.playwright.*;

import java.util.List;

public class VisibleDemo {

    public static void main(String[] args) {

        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
            BrowserContext browserContext = browser.newContext();
            Page page = browserContext.newPage();

            page.navigate("https://www.google.com");
            List<String> links = page.locator("a:visible").allInnerTexts();
            for (String s :
                    links) {
                System.out.println(s);
            }

            int imagesCount = page.locator("xpath = //img >> visible=true").count();
            System.out.println(imagesCount);

        }

    }

}
