package firstTestDemo;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType.*;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class ChromeTestDemo {

    public static void main(String[] args) {

        // create a playwright server
        Playwright playwright = Playwright.create();

        // use launchoptions to run in chrome
        LaunchOptions launchOpt = new LaunchOptions();
        // Can be "msedge", "chrome-beta", "msedge-beta", "msedge-dev", etc.
        launchOpt.setChannel("chrome");
        launchOpt.setHeadless(false);

        // create a browser context
        Browser browser = playwright.chromium().launch(launchOpt);

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
