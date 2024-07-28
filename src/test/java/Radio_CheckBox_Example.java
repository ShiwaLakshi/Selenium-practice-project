import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Radio_CheckBox_Example {

    WebDriver driver;
    @BeforeMethod
    public void radio_checkbox_BeforeTests(){
        driver= new ChromeDriver();
        driver.manage().window().maximize();
    }
@Test
    public void radioTest(){
        //01 find the default select radio button
    driver.get("https://www.leafground.com/radio.xhtml");

    boolean chromeradiooption = driver.findElement(By.id("j_idt87:console2:0")).isSelected();
    boolean firefoxradiooption = driver.findElement(By.id("j_idt87:console2:1")).isSelected();
    boolean safariradiooption = driver.findElement(By.id("j_idt87:console2:2")).isSelected();
    boolean edgeradiooption = driver.findElement(By.id("j_idt87:console2:3")).isSelected();

    if(chromeradiooption){
        String chromeText = driver.findElement(By.xpath("//label[@for='j_idt87:console2:0']")).getText();
        System.out.println("default select radio button"+chromeText);
    } else if (firefoxradiooption) {
        String firefoxText = driver.findElement(By.xpath("//label[@for='j_idt87:console2:1']")).getText();
        System.out.println("default select radio button"+firefoxText);
    } else if (safariradiooption) {
        String safariText = driver.findElement(By.xpath("//label[@for='j_idt87:console2:2']")).getText();
        System.out.println("default select radio button"+safariText);
    } else if (edgeradiooption) {
        String edgeText = driver.findElement(By.xpath("//label[@for='j_idt87:console2:3']")).getText();
        System.out.println("default select radio button"+edgeText);

    }
}

}
