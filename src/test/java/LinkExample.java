import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class LinkExample {

    WebDriver driver;
@BeforeMethod
    public void openLinkPage(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.leafground.com/link.xhtml");
       // driver.findElement(By.name("q")).sendKeys("Colombo" + Keys.ENTER);
        //driver.quit();
    }
@Test
    public void linkTests(){

        //01 Take me to dashboard
        WebElement homeLink= driver.findElement(By.linkText("Go to Dashboard"));
        homeLink.click();
        driver.navigate().back();


        //02 Find my destination

        WebElement wheretoGo = driver.findElement(By.partialLinkText("Find the URL"));
        String path= wheretoGo.getAttribute("href");
        System.out.println("This link where to go: "+path);


        //03 Broken link

        WebElement brokenLink= driver.findElement(By.linkText("Broken?"));
        brokenLink.click();
        String title = driver.getTitle();
        if(title.contains("404")){
            System.out.println("This Link is broken");
        }else {
            System.out.println("Not broken");
        }
        driver.navigate().back();


        //04 Dublicate Link
          WebElement homeLink1= driver.findElement(By.linkText("Go to Dashboard"));
          homeLink1.click();

         //05 Counts page links

            List<WebElement> countfullpageLinks = driver.findElements(By.tagName("a"));
            int pagelinkcount = countfullpageLinks.size();
            System.out.println("Counts of full page link:" +pagelinkcount);

          //06 Count layout links
             WebElement layoutElement = driver.findElement(By.className("layout-main-content"));
             List<WebElement> countOfLayoutLinks = layoutElement.findElements(By.tagName("a"));
             System.out.println("Count of layout links: " +countOfLayoutLinks.size());


             driver.quit();

    }

}
