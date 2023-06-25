package recordDemo;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;

public class RecordingDemo {
    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                    .setHeadless(false));
            BrowserContext context = browser.newContext();
            Page page = context.newPage();
            page.navigate("https://demo.playwright.dev/todomvc/");
            page.getByPlaceholder("What needs to be done?").click();
            page.getByPlaceholder("What needs to be done?").fill("playwright learning");
            page.getByPlaceholder("What needs to be done?").press("Enter");
            page.getByRole(AriaRole.CHECKBOX, new Page.GetByRoleOptions().setName("Toggle Todo")).check();
        }
    }
}
