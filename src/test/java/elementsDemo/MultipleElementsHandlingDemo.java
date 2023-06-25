package elementsDemo;

import com.microsoft.playwright.*;

import java.util.List;

public class MultipleElementsHandlingDemo {

    public static void main(String[] args) {

        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        BrowserContext browserContext = browser.newContext();
        Page page = browserContext.newPage();
        page.navigate("https://demo.seleniumeasy.com/basic-select-dropdown-demo.html");

        // get count of multiple elements
        Locator dayOptions = page.locator("select#select-demo option");
        System.out.println(dayOptions.count());

        // multiple elements handling - method 1
        for (int i = 0; i < dayOptions.count(); i++)
            System.out.println(dayOptions.nth(i).textContent());
        System.out.println("=====================================================");

        // multiple elements handling - method 2
        List<String> countriesName = dayOptions.allTextContents();
        for (String country: countriesName) {
            System.out.println(country);
        }

        page.close();
        browserContext.close();
        playwright.close();

    }

}
