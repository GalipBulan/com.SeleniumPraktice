package day01_practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_Practice {

    /* ...Exercise2...
 1 - Driver olusturalim
 2 - Java class'imiza chromedriver.exe'yi tanitalim
 3 - Driver'in tum ekrani kaplamasini saglayalim
 4 - Driver'a sayfanın yuklenmesini 10.000 milisaniye (10 saniye) boyunca beklesini
     söyleyelim. Eger oncesinde sayfa yuklenirse, beklemeyi bıraksin.
 5 - "https://www.otto.de" adresine gidelim
 6 - Bu web adresinin sayfa basligini (title) ve adres (url)ini alalim
 7 - Title ve url'nin "OTTO" kelimesini icerip icermedigini kontrol edelim
 8 - Ardindan "https://wisequarter.com/" adresine gidelim
 9 - Bu adresin basligini ve Url alalim ve "Quarter" kelimesini icerip icermedigini
     kontrol edelim
 10- Bir onceki web sayfamiza geri donelim
 11- Sayfayi yenileyelim
 12- Daha sonra web sayfamiza tekrar donelim ve oldugumuz sayfayi kapatalim
 13- En son adim olarak butun sayfalarimizi kapatmis olalim
     */

    public static void main(String[] args) throws InterruptedException {

        // 1 - Driver olusturalim
        // 2 - Java class'imiza chromedriver.exe'yi tanitalim

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();

        //3 - Driver'in tum ekrani kaplamasini saglayalim
        driver.manage().window().maximize();

        //4 - Driver'a sayfanın yuklenmesini 10.000 milisaniye (10 saniye) boyunca beklesini
        //     söyleyelim. Eger oncesinde sayfa yuklenirse, beklemeyi bıraksin.

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //5 - "https://www.otto.de" adresine gidelim

        driver.get("https://www.otto.de");

        Thread.sleep(3000);

        // 6 - Bu web adresinin sayfa basligini (title) ve adres (url)ini alalim
        String titleOtto= driver.getTitle();
        String urlOtto = driver.getCurrentUrl();

        // 7 - Title ve url'nin "OTTO" kelimesini icerip icermedigini kontrol edelim
        String expData = "OTTO";
        if(titleOtto.contains(expData)){
            System.out.println("Test PASSED");
        }else {
            System.out.println("Otto titel test FAILED");
        }
        if(urlOtto.contains(expData)){
            System.out.println("Test PASSED");
        }else {
            System.out.println("Otto url test FAILED");
        }
        // 8 - Ardindan "https://wisequarter.com/" adresine gidelim
        driver.navigate().to("https://wisequarter.com/");
        Thread.sleep(3000);


        // 9 - Bu adresin basligini ve Url alalim ve "Quarter" kelimesini icerip icermedigini
        // kontrol edelim.
        String titleQuarter = driver.getTitle();
        String urlQuarter = driver.getCurrentUrl();

        String expDataQuarter="Quarter";

        if (titleQuarter.contains(expDataQuarter))
            System.out.println("Test PASSED");
        else
            System.out.println("Quarter title Test FAILED");
        if (urlQuarter.contains(expDataQuarter))
            System.out.println("Test PASSED");
        else
            System.out.println("Quarter url Test FAILED");


        // 10- Bir onceki web sayfamiza geri donelim
        driver.navigate().back();
        Thread.sleep(3000);

        // 11- Sayfayi yenileyelim
        driver.navigate().refresh();
        Thread.sleep(3000);

        // 12- Daha sonra web sayfamiza tekrar donelim ve oldugumuz sayfayi kapatalim
        driver.navigate().forward();
        Thread.sleep(3000);
        driver.close();

        // 13- En son adim olarak butun sayfalarimizi kapatmis olalim
        driver.quit();



    }
}
