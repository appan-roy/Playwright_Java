package browserContextDemo;


import com.microsoft.playwright.*;

public class MultipleBrowserContextDemo {

    public static void main(String[] args) {

        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

        // browser context 1
        BrowserContext bc1 = browser.newContext();
        Page p1 = bc1.newPage();
        p1.navigate("https://www.google.com/");
        System.out.println(p1.title());

        // browser context 2
        BrowserContext bc2 = browser.newContext();
        Page p2 = bc2.newPage();
        p2.navigate("https://www.facebook.com/");
        System.out.println(p2.title());

        // browser context 3
        BrowserContext bc3 = browser.newContext();
        Page p3 = bc3.newPage();
        p3.navigate("https://www.linkedin.com/");
        System.out.println(p3.title());

        // close pages and browser contexts
        p1.close();
        bc1.close();

        p2.close();
        bc2.close();

        p3.close();
        bc3.close();

        // close playwright server
        playwright.close();

    }

}
