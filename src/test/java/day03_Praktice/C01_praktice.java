package day03_Praktice;

import io.github.bonigarcia.wdm.WebDriverManager;
import jdk.jfr.Timespan;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;



public class C01_praktice {



    /*
     Bir class oluşturun: C3_DropDownAmazon
     ● https://www.amazon.com/ adresine gidin.
     - Test 1
     Arama kutusunun yanindaki kategori menusundeki kategori sayisinin 45
     oldugunu test edin
     -Test 2
     1. Kategori menusunden Books secenegini secin
     2. Arama kutusuna Java yazin ve aratin
     3. Bulunan sonuc sayisini yazdirin
     4. Sonucun Java kelimesini icerdigini test edin

     */

    
    WebDriver driver;
    @Before
    public void setUp () {

        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @After
    public void tearDown (){

        driver.close();
    }
    @Test
    public void test01(){
        //https://www.amazon.com/ adresine gidin.

        driver.get("https://www.amazon.com/");

        WebElement aramaKutusu = driver.findElement(By.id("searchDropdownBox"));


    }


}
