import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.List;

public class DropDownExample {
    WebDriver driver;
    @BeforeMethod
    public void DropDownPageTest(){
        driver= new ChromeDriver();
        driver.manage().window().maximize();

    }


    @Test
    public void leafgrondpageDropDownTest() throws InterruptedException {

        //1 ways of select values in Basic dropdown
        driver.get("https://www.leafground.com/select.xhtml");
        WebElement dropdown= driver.findElement(By.xpath("//select[@class='ui-selectonemenu']"));
        Select select = new Select(dropdown);
        select.selectByIndex(1);
        Thread.sleep(3000);
        select.selectByVisibleText("Playwright");



        //1.2 Get the number of dropdown option

         List<WebElement> listOfOption = select.getOptions();
         int size =listOfOption.size();
         System.out.println("Number of element of dropdown"+size);
         for(WebElement element:listOfOption){
             System.out.println(element.getText());
         }

         //1.3 Using Sendkeys select dropdown values

        dropdown.sendKeys("Playwright");


         //1.4 Selecting value in boostrap dropdown

        WebElement dropdown2 = driver.findElement(By.xpath("//div[@id='j_idt87:country']"));
        dropdown2.click();
        List<WebElement> listofdropdown2value = driver.findElements(By.xpath("//ul[@id='j_idt87:country_items']/li"));
        for (WebElement element:listofdropdown2value){
         String dropdownvalue = element.getText();
         if(dropdownvalue.equals("USA")){
             element.click();
             break;
         }
        }

    }
        //2. Google Search - pick a value from suggestions

       @Test
        public void googlesearch() throws InterruptedException {
        driver.get("https://www.google.com");
        driver.findElement(By.name("q")).sendKeys("palitha");
        Thread.sleep(2000);
        List<WebElement> googlesearchlist =  driver.findElements(By.xpath("//ul[@role='listbox']/li//div[@class='wM6W7d']"));
        System.out.println(googlesearchlist.size());
        for (WebElement element:googlesearchlist){
            System.out.println(element.getText());
        }


    }




}
