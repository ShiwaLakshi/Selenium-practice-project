import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ButtonExample {

    WebDriver driver;
    @BeforeMethod
    public void OpenLinkPage(){
        driver=new ChromeDriver();
        Dimension newsize = new Dimension(800,600);
        driver.manage().window().setSize(newsize);
//        driver.manage().window().maximize();
        driver.get("https://www.leafground.com/button.xhtml");


    }
@Test
    public void ButtonTest (){
        //01 Click and Confirm title

        driver.findElement(By.xpath("//button[@id='j_idt88:j_idt90']")).click();
        String exceptedTitle = "Dashboard";
        String actualTitle = driver.getTitle();
        if(exceptedTitle.equals(actualTitle)){
            System.out.println("Actual title is same as expected");
        }else {
            System.out.println("Actual title is not same as expected");
        }
    //Assert.assertEquals(actualTitle,exceptedTitle,"Title miss match");

    //02 Find the position of the  submit button

    driver.navigate().back();
    WebElement getPosition = driver.findElement(By.id("j_idt88:j_idt94"));
    Point xyPoint = getPosition.getLocation();
    int x= xyPoint.getX();
    int y= xyPoint.getY();
    System.out.println(" X Position is : " + x + " Y Position is : " + y);


    //03 Find the save button colour

    WebElement buttoncolour = driver.findElement(By.id("j_idt88:j_idt96"));
    String colour = buttoncolour.getCssValue("background-color");
    System.out.println("Button colour is:"+colour);

    //04 Find the height and width of this button

    WebElement size = driver.findElement(By.id("j_idt88:j_idt94"));
    int height = size.getSize().getHeight();
    int width = size.getSize().getWidth();
    System.out.println("Height:" + height +"Width:" + width);




    }
}
