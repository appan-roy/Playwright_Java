package tracingDemo;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;

import java.nio.file.Paths;

public class TraceViewerDemo {

    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                    .setHeadless(false));
            BrowserContext context = browser.newContext();

            // Start tracing before creating / navigating a page.
            context.tracing().start(new Tracing.StartOptions()
                    .setScreenshots(true)
                    .setSnapshots(true));

            Page page = context.newPage();
            page.navigate("https://demo.playwright.dev/todomvc/");
            page.getByPlaceholder("What needs to be done?").click();
            page.getByPlaceholder("What needs to be done?").fill("playwright learning");
            page.getByPlaceholder("What needs to be done?").press("Enter");
            page.getByRole(AriaRole.CHECKBOX, new Page.GetByRoleOptions().setName("Toggle Todo")).check();

            // Stop tracing and export it into a zip archive.
            context.tracing().stop(new Tracing.StopOptions()
                    .setPath(Paths.get("trace.zip")));
        }
    }

}
