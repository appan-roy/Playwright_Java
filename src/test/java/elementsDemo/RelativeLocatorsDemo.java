package elementsDemo;

import com.microsoft.playwright.*;

public class RelativeLocatorsDemo {

    static Page page;

    public static void main(String[] args) {

        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
            BrowserContext browserContext = browser.newContext();
            page = browserContext.newPage();

            page.navigate("https://selectorshub.com/xpath-practice-page/");

            // left-of
            selectUser("Joe.Root");
            selectUser("Kevin.Mathews");

            // right-of
            System.out.println(getUserRole("Jasmine.Morgan"));
            System.out.println(getUserRole("John.Smith"));

            // above
            System.out.println(page.locator("a:above(:text('Joe.Root'))").first().textContent());
            System.out.println(page.locator("a:above(:text('Jasmine.Morgan'))").first().textContent());

            // below
            System.out.println(page.locator("a:below(:text('Garry.White'))").first().textContent());
            System.out.println(page.locator("a:below(:text('Jordan.Mathews'))").first().textContent());
        }
    }

    public static void selectUser(String userName) {
        page.locator("td:left-of(:text('" + userName + "'))").first().click();
    }

    public static String getUserRole(String userName) {
        return page.locator("td:right-of(:text('" + userName + "'))").first().textContent();
    }

}
