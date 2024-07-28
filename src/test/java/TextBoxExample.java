import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TextBoxExample {


    WebDriver driver;
    @BeforeMethod
    public void openLinkPage(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.leafground.com/input.xhtml");

    }
@Test
    public void textBoxTests(){

        //01 Type your Name

        WebElement name = driver.findElement(By.id("j_idt88:name"));
        name.sendKeys("Shiwanthi Lakshika");

        //02 Append Country to this City

        WebElement appendText = driver.findElement(By.id("j_idt88:j_idt91"));
        appendText.sendKeys("Sri Lankan");

        // 03 Verify if text box is disabled

         boolean enabled= driver.findElement(By.name("j_idt88:j_idt93")).isEnabled();
         System.out.println("Is text box enabled: " +enabled);

         // 04 Clear the typed text

        WebElement clearText = driver.findElement(By.xpath("//*[@id=\"j_idt88:j_idt95\"]"));
        clearText.clear();

        // 05 Retrieve the typed text
        WebElement textElement = driver.findElement(By.id("j_idt88:j_idt97"));
        String value = textElement.getAttribute("value");
        System.out.println(value);

        // 06 Type email & tab.confirm control moved to next element

        driver.findElement(By.id("j_idt88:j_idt99")).sendKeys("shiwa@gmail.com"+ Keys.TAB + "Control confirmed move to next element");

    }
}
