package elementsDemo;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class AlertsHandlingListenerDemo {

    public static void main(String[] args) throws InterruptedException {

        try(Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
            Page page = browser.newPage();
            page.navigate("https://testpages.herokuapp.com/styled/alerts/alert-test.html");

            // custom alert event listener which will work for the 'page' object
            page.onDialog(dialog -> {
                String msg = dialog.message();
                System.out.println(msg);
                dialog.accept("Hello, this is an alert prompt");
            });

            page.click("//input[@id='alertexamples']");
            Thread.sleep(2000);
            page.click("//input[@id='confirmexample']");
            System.out.println(page.textContent("//p[@id='confirmreturn']"));
            Thread.sleep(2000);
            page.click("//input[@id='promptexample']");
            System.out.println(page.textContent("//p[@id='promptreturn']"));
        }

    }

}
