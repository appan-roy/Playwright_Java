package elementsDemo;

import com.microsoft.playwright.*;

public class XpathHandlingDemo {

    public static void main(String[] args) {

        try(Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
            Page page = browser.newPage();
            page.navigate("https://selectorshub.com/xpath-practice-page/");

            // list of elements with xpath
            Locator usefulLinks = page.locator("//h2[text()='Useful Links']/../../following-sibling::div/descendant::h2/a");

            for (int i = 0; i < usefulLinks.count(); i++) {
                System.out.println(usefulLinks.nth(i).textContent());
            }

            // xpath indexing
            Locator lastUsefulLink = page.locator("xpath=(//h2[text()='Useful Links']/../../following-sibling::div/descendant::h2/a)[last()]");
            System.out.println(lastUsefulLink.textContent());

        }

    }

}
