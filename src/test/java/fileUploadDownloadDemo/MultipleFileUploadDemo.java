package fileUploadDownloadDemo;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import java.nio.file.Path;
import java.nio.file.Paths;

public class MultipleFileUploadDemo {

    public static void main(String[] args) throws InterruptedException {

        try(Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
            Page page = browser.newPage();
            page.navigate("https://davidwalsh.name/demo/multiple-file-upload.php");

            // upload multiple files
            page.setInputFiles("input#filesToUpload", new Path[] {
                    Paths.get("example.png"),
                    Paths.get("orangeHrmLogin.json"),
                    Paths.get("trace.zip")
            });
            Thread.sleep(2000);

            // delete all the files
            page.setInputFiles("input#filesToUpload", new Path[0]);
            Thread.sleep(2000);
        }

    }

}
