package day01_practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_Practice {

/*..........Exercise1............
    BeforeClass ile driver'i olusturun ve class icinde static yapin
    Maximize edin ve 10 sn bekletin
    http://www.google.com adresine gidin
    arama kutusuna "The Lord of the Rings" yazip, cikan sonuc sayisini yazdirin
    arama kutusuna "Brave Heart" yazip, cikan sonuc sayisini yazdirin
    arama kutusuna "Harry Potter" yazip, cikan sonuc sayisini yazdirin
    AfterClass ile kapatin
     */
    static WebDriver driver;

    // BeforeClass ile driver'i olusturun ve class icinde static yapin.
     @BeforeClass
     public static void setUp(){

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        //Maximize edin ve 10 sn bekletin.
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    @Test
    public void test01() throws InterruptedException {

        // http://www.google.com adresine gidin.

        driver.get("http://www.google.com");
        Thread.sleep(2000);

        // Cerezleri reddedin.

        driver.findElement(By.xpath("//div[@class='QS5gu sy4vM'][1]")).click();
        Thread.sleep(2000);

        //Arama kutusuna lokete edin ve "The Lord of the Rings" yazip, cikan sonuc sayisini yazdirin.

        driver.findElement(By.xpath("//input[@class='gLFyf']")).sendKeys("The Lord of the Rings" + Keys.ENTER);
        WebElement sonuc1 = driver.findElement(By.xpath("//div[@id='result-stats']"));
        System.out.println( "Test01 cikan sonuc sayisi : " + sonuc1.getText());
        Thread.sleep(2000);



    }
    @Test
    public void test02() throws InterruptedException {

        // Arama kutusuna "Brave Heart" yazip, cikan sonuc sayisini yazdirin.

        driver.findElement(By.xpath("//input[@class='gLFyf']")).clear();
        driver.findElement(By.xpath("//input[@class='gLFyf']")).sendKeys("Brave Heart" + Keys.ENTER);
        WebElement sonuc2 = driver.findElement(By.xpath("//div[@id='result-stats']"));
        System.out.println("Test02 cikan sonuc sayisi : " + sonuc2.getText());

        Thread.sleep(2000);

    }

    @Test
    public void test03() throws InterruptedException {

        // Arama kutusuna "Brave Heart" yazip, cikan sonuc sayisini yazdirin.

        driver.findElement(By.xpath("//input[@class='gLFyf']")).clear();
        driver.findElement(By.xpath("//input[@class='gLFyf']")).sendKeys("Harry Potter" + Keys.ENTER);
        WebElement sonuc3 = driver.findElement(By.xpath("//div[@id='result-stats']"));
        System.out.println("Test03 cikan sonuc sayisi : " + sonuc3.getText());

        Thread.sleep(2000);
    }

    @AfterClass
    static public void tearDown(){
        driver.close();

    }

}
