package dockpack;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class dockerWithChrome {

    public static void main(String[] args) {
        // Path to your Chrome profile inside the Docker container
        String chromeProfilePath = "/home/seluser/chrome-profile";

        // Set up Chrome options
        ChromeOptions options = new ChromeOptions();
        options.addArguments("user-data-dir=" + chromeProfilePath);

        // Remote WebDriver URL
        URL remoteUrl;
        try {
            remoteUrl = new URL("http://localhost:4444/wd/hub");
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return;
        }

        // Create Remote WebDriver instance
        WebDriver driver = new RemoteWebDriver(remoteUrl, options);

        // Open a website to verify
        driver.get("http://www.gmail.com");

        // Perform your tests or actions here
        System.out.println("Page title is: " + driver.getTitle());
        System.out.println(driver.getCurrentUrl());

        // Close the browser
        driver.quit();
    }
}
