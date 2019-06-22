package script_for_portal;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class PortalGradeScript {

    public static void main(String[] args) {
        System.setProperty("webdriver.gecko.driver", "C:\\Gecko\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        String url = "https://portal.aait.edu.et";

        driver.get(url);

        //signing into my account
        driver.findElement(By.id("UserName")).sendKeys("ATR/8563/09");
        driver.findElement(By.id("Password")).sendKeys("2234");
        driver.findElement(By.className("btn-success")).click();

        //go to grade report page
        driver.navigate().to("https://portal.aait.edu.et/Grade/GradeReport");

//        driver.close();
    }
}
