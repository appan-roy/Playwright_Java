package firstTestDemo;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class WithoutHeadlessModeDemo {

    public static void main(String[] args) {

        // create a playwright server
        Playwright playwright = Playwright.create();

        // create a browser context with headless flag - false
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

        // create  a page context
        Page page = browser.newPage();

        // navigate to the url
        page.navigate("https://www.amazon.com");

        // capture page title
        String title = page.title();
        System.out.println("Page title is : " + title);

        // capture page url
        String url = page.url();
        System.out.println("Page url is : " + url);

        // terminate page context
        page.close();

        // terminate browser context
        browser.close();

        // terminate playwright server
        playwright.close();

    }

}
