package selectorsDemo;

import com.microsoft.playwright.*;

public class TextSelectorDemo {

    public static void main(String[] args) {

        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
            BrowserContext browserContext = browser.newContext();
            Page page = browserContext.newPage();
            page.navigate("https://demo.opencart.com/index.php?route=account/login&language=en-gb");

            // 1
            String header = page.locator("'New Customer'").textContent();
            System.out.println(header);

            // 2
            header = page.locator("text = New Customer").textContent();
            System.out.println(header);

            // 3
            page.locator("a:has-text('Continue')").click();
        }
    }

}
