package windowHandlingDemo;

import com.microsoft.playwright.*;

public class HandleBlankBrowserWindowDemo {

    public static void main(String[] args) {

        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

            // create a browser context
            BrowserContext browserContext1 = browser.newContext();

            // create a page from the browser context
            Page page1 = browserContext1.newPage();

            page1.navigate("https://academy.naveenautomationlabs.com/");

            // open a blank popup window
            Page popup = page1.waitForPopup(() -> {
                page1.click("a[target = '_blank']");
            });

            // wait for popup to load
            popup.waitForLoadState();

            // navigate different url in the popup window
            popup.navigate("https://www.google.com");

            // capture pop up window url
            System.out.println("Pop up window url : " + popup.url());

            // close the popup window
            popup.close();

            // capture parent window title
            System.out.println("Parent window title : " + page1.title());
        }

    }

}
