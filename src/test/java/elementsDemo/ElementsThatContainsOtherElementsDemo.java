package elementsDemo;

import com.microsoft.playwright.*;

public class ElementsThatContainsOtherElementsDemo {

    public static void main(String[] args) {

        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
            BrowserContext browserContext = browser.newContext();
            Page page = browserContext.newPage();

            page.navigate("https://www.amazon.com/");

            Locator links = page.locator("div.navFooterLinkCol:has(a[href='https://www.amazon.jobs'])");
            links.allInnerTexts().forEach(s -> {
                System.out.println(s);
            });

        }
    }

}
