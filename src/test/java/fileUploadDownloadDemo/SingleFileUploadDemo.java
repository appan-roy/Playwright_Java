package fileUploadDownloadDemo;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import java.nio.file.Path;
import java.nio.file.Paths;

public class SingleFileUploadDemo {

    public static void main(String[] args) throws InterruptedException {

        try(Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
            Page page = browser.newPage();
            page.navigate("https://davidwalsh.name/demo/multiple-file-upload.php");

            // upload single file
            page.setInputFiles("input#filesToUpload", Paths.get("example.png"));
            Thread.sleep(2000);

            // delete the file
            page.setInputFiles("input#filesToUpload", new Path[0]);
            Thread.sleep(2000);
        }

    }

}
