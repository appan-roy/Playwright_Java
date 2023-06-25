package fileUploadDownloadDemo;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.FilePayload;

import java.nio.charset.StandardCharsets;

public class CreateFileAndUploadDemo {

    public static void main(String[] args) throws InterruptedException {

        try(Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
            Page page = browser.newPage();
            page.navigate("https://cgi-lib.berkeley.edu/ex/fup.html");

            // upload multiple files
            page.setInputFiles("//input[@name='upfile']", new FilePayload("Fileupload.text", "text/plain", "This is a demo file".getBytes(StandardCharsets.UTF_8)));
            Thread.sleep(2000);

            // delete all the files
            page.click("//input[@value='Press']");
            Thread.sleep(2000);
        }

    }

}
