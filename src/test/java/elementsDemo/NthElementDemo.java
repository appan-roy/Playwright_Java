package elementsDemo;

import com.microsoft.playwright.*;

public class NthElementDemo {

    public static void main(String[] args) {

        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
            BrowserContext browserContext = browser.newContext();
            Page page = browserContext.newPage();

            page.navigate("https://www.bigbasket.com/");

            // first element
            System.out.println(page.locator("div.container.footer-links li a >> nth=0").textContent());

            // sixth element from beginning
            System.out.println(page.locator("div.container.footer-links li a >> nth=5").textContent());

            // last element
            System.out.println(page.locator("div.container.footer-links li a >> nth=-1").textContent());

            // fourth element from end
            System.out.println(page.locator("div.container.footer-links li a >> nth=-4").textContent());
        }

    }

}
