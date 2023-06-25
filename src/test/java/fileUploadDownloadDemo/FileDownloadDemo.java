package fileUploadDownloadDemo;

import com.microsoft.playwright.*;

import java.nio.file.Paths;

public class FileDownloadDemo {

    public static void main(String[] args) {

        try(Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
            Page page = browser.newPage();
            page.navigate("https://chromedriver.storage.googleapis.com/index.html?path=114.0.5735.90/");

            // Wait for the download to complete
            Download download = page.waitForDownload(() -> {
                page.click("a:text('chromedriver_win32.zip')");
            });

            // get the reason for failure of download
            System.out.println(download.failure());

            // get the downloaded file url
            System.out.println(download.url());

            // save the downloaded file into a specific location
            download.saveAs(Paths.get("chromedriver_104.zip"));

            // return the filename of the downloaded file
            System.out.println(download.suggestedFilename());
        }

    }

}
