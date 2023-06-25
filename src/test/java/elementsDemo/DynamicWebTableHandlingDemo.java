package elementsDemo;

import com.microsoft.playwright.*;

public class DynamicWebTableHandlingDemo {

    public static void main(String[] args) {

        try (Playwright playwright = Playwright.create()) {

            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
            Page page = browser.newPage();
            page.navigate("https://primeng.org/table");

            // printing the entire table content on the console
            page.locator("table#pr_id_51-table tr").allInnerTexts().forEach(e -> System.out.println(e));

            // capturing all the table rows
            Locator rows = page.locator("table#pr_id_51-table tr");

            // capturing the status of a specific customer
            String status = rows.locator(":scope", new Locator.LocatorOptions().setHasText("Donette Foller")).locator("span.p-tag-value").textContent();

            System.out.println(status);

        }
    }

}
