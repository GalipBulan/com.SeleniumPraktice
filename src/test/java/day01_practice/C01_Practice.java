package day01_practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import java.time.Duration;

public class C01_Practice {

    /*...Exercise1...
    Create a new class under Q1 create main method
    Set Path
    Create chrome driver
    Maximize the window
    Open google home page https://www.google.com/.
    On the same class, Navigate to amazon home page https://www.amazon.com/
    Navigate back to google
    Navigate forward to amazon
    Refresh the page
    Close/Quit the browser
    And last step : print "All Ok" on console
     */

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // thread.sleep uygulamayı dondurur
        // implicitlywait elementin görünür olmasını bekletiyor verdiğimiz süreye göre.
        // implicitlywait verdigimiz sure boyunca verilen islemi yapmayi dener.

        driver.get("https://www.google.com/");
        Thread.sleep(2000);
        driver.navigate ().to("https://www.amazon.com/");
        Thread.sleep(2000);

        driver.navigate().back();
        Thread.sleep(2000);
        driver.navigate().forward();
        Thread.sleep(2000);
        driver.navigate().refresh();
        Thread.sleep(2000);

        Thread.sleep(2000);

        System.out.println("All Ok");
        driver.close();
        driver.quit();

    }

}
