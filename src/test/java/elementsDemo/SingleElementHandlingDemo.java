package elementsDemo;

import com.microsoft.playwright.*;

public class SingleElementHandlingDemo {

    public static void main(String[] args) {

        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        BrowserContext browserContext = browser.newContext();
        Page page = browserContext.newPage();
        page.navigate("https://demo.seleniumeasy.com/");

        // single element handling
        Locator contactSalesLink = page.locator("text = Start Practising");
        contactSalesLink.click();

        page.close();
        browserContext.close();
        playwright.close();

    }

}
