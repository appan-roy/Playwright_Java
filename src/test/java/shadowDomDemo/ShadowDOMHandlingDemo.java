package shadowDomDemo;

import com.microsoft.playwright.*;

public class ShadowDOMHandlingDemo {

    public static void main(String[] args) {

        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
            BrowserContext browserContext = browser.newContext();
            Page page = browserContext.newPage();

            page.navigate("https://books-pwakit.appspot.com/");

            page.locator("book-app[apptitle='BOOKS'] #input").fill("Testing books");

            String text = page.locator("book-app[apptitle='BOOKS'] .books-desc").textContent();
            System.out.println(text);
        }
    }
}
