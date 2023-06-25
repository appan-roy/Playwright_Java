package elementsDemo;

import com.microsoft.playwright.*;

public class AlertsHandlingDemo {

    public static void main(String[] args) throws InterruptedException {

        try(Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
            Page page = browser.newPage();
            page.navigate("https://testpages.herokuapp.com/styled/alerts/alert-test.html");

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
