package day03_Praktice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_Praktice {

    WebDriver driver;
    String https;
    @Before
    public void setUp () {

        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @After
    public void tearDown (){
        driver.quit();
        // driver.close();
    }

    @Test
    public void test01() throws InterruptedException {

        driver.get("https://www.amazon.com/");
        // driver.get(https+"www.youtube.com");
        System.out.println(driver.getTitle()); // SAyfa basligini getirir
        System.out.println(driver.getCurrentUrl()); /* sayfa linkini getirir */
        Thread.sleep(3000);
        driver.navigate().to("https://www.google.com");// Bir siteden baska siteye gitmemizi saglar.
        Thread.sleep(3000);
        driver.navigate().back(); // Onceki sayfaya geri gelmemizi saglar.
        Thread.sleep(3000);
        driver.navigate().forward(); // Tekrar geldigimiz sayfaya gider
        String gelenTitle = "Google";
        String gercekTitle = driver.getTitle();

        Assert.assertEquals(gelenTitle,gercekTitle);

    }
    @Test
    public void test02 () throws InterruptedException {

        driver.get("https://www.google.com");
        Thread.sleep(3000);

        System.out.println(driver.getWindowHandle()); // Bu handl degeri her seferde degisir.
        driver.navigate().back(); // fakat ileri geri yaparsak sabit kalir.
        System.out.println(driver.getWindowHandle());
        driver.navigate().forward();
        System.out.println(driver.getWindowHandle());
        // Yeni bir sekme acarsak handl degerleri degisir.


    }
    @Test
    public void test03 () throws InterruptedException {

        driver.get("https://www.google.com");
        Thread.sleep(3000);
        String ilkSayfaHandlDegeri = driver.getWindowHandle();

        driver.switchTo().newWindow(WindowType.TAB); // yeni bir ""sekme" acar.
        Thread.sleep(3000);

        driver.navigate().to("https://www.amazon.com"); // daha sonra bu yeni sekmede amazon sayfasini acar
        Thread.sleep(3000);

        System.out.println(driver.getWindowHandles()); // iki sekme actigimiz icin iki adet windowhandles degeri getirir.
        driver.switchTo().window(ilkSayfaHandlDegeri); // Basta ilk sayfaninb handle degerini kayit edersek daha sonra
        // bu degeri kullanarak ilk sayfaya donebiliriz.
        Thread.sleep(3000);

        driver.switchTo().newWindow(WindowType.WINDOW); // Yeni bir "sayfa" acariz
        Thread.sleep(3000);

        driver.navigate().to("https://wisequarter.com"); // Yeni sekmede yenir bir siteye gidebiliriz.
        Thread.sleep(3000);

    }
}
