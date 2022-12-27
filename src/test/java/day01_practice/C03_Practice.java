package day01_practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_Practice {

    /* ...Exercise3...
    go to url : https://www.techlistic.com/p/selenium-practice-form.html
    fill the firstname
    fill the lastname
    check the gender
    check the experience
    fill the date
    choose your profession -> Automation Tester
    choose your tool -> Selenium Webdriver
    choose your continent -> Europa
    choose your command  -> Browser Commands
    click submit button
 */

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        Thread.sleep(2000);

        //go to url : https://www.techlistic.com/p/selenium-practice-form.html
        driver.navigate().to("https://www.techlistic.com/p/selenium-practice-form.html");
        Thread.sleep(2000);
        // lokete
        driver.findElement(By.xpath("//button[@id='ez-accept-all']")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("cookieChoiceDismiss")).click();
        Thread.sleep(2000);
        // driver.manage().deleteAllCookies();
        //fill the firstname
        driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Galip" + Keys.ENTER);
        Thread.sleep(2000);

        // fill the lastname
        driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Bulan" + Keys.ENTER);
        Thread.sleep(2000);


        WebElement genderRadioButton=driver.findElement(By.xpath("//input[@id='sex-0']"));
        genderRadioButton.click();
        genderRadioButton.sendKeys(Keys.PAGE_DOWN);

        // check the gender

        driver.findElement(By.xpath("//input[@id='sex-0']")).click();
        Thread.sleep(2000);

        //check the experience
        driver.findElement(By.xpath("//input[@id='exp-0']")).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath("//input[@id='datepicker']")).sendKeys("24.12.2022" + Keys.ENTER);
        Thread.sleep(2000);
        // choose your profession -> Automation Tester

        driver.findElement(By.xpath("//input[@id='profession-1']")).click();
        Thread.sleep(2000);

        //choose your tool -> Selenium Webdriver

        driver.findElement(By.xpath("//input[@id='tool-2']")).click();
        Thread.sleep(2000);

        // choose your continent -> Europa

        driver.findElement(By.xpath("//select[@id='continents']"  )).sendKeys("Europa" + Keys.ENTER);
        Thread.sleep(2000);
        // choose your command  -> Browser Commands

        driver.findElement(By.xpath("//option[text()='Browser Commands']")).click();
        Thread.sleep(2000);

        //click submit button

        driver.findElement(By.xpath("//button[@id='submit']")).click();
        Thread.sleep(2000);

        driver.close();
        driver.quit();












    }
}
