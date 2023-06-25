package elementsDemo;

import com.microsoft.playwright.*;

public class UserFormUsingRelativeLocatorsDemo {

    static Page page;

    public static void main(String[] args) {

        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
            BrowserContext browserContext = browser.newContext();
            page = browserContext.newPage();

            page.navigate("https://selectorshub.com/xpath-practice-page/");

            page.locator("input:below(:text('User Email'))").first().click();
            page.locator("input:below(:text('User Email'))").first().fill("john.smith@example.com");
            page.locator("input:below(:text('Password'))").first().click();
            page.locator("input:below(:text('Password'))").first().fill("john.smith");
        }

    }

}
