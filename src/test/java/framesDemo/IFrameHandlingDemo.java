package framesDemo;

import com.microsoft.playwright.*;

public class IFrameHandlingDemo {

    public static void main(String[] args) {

        try(Playwright playwright = Playwright.create()){
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
            BrowserContext browserContext = browser.newContext();
            Page page = browserContext.newPage();

            page.navigate("https://www.formsite.com/templates/registration-form-templates/vehicle-registration-form/");

            page.locator("img[title=vehicle-registration-forms-and-templates]").click();

            page.frameLocator("//iframe[contains(@id,'frame-one')]").locator("input[id=RESULT_TextField-8]").fill("Automation");
        }

    }

}
