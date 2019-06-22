package script_for_portal;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;


public class PortalGradeScript {

    public static void main(String[] args) {
        System.setProperty("webdriver.gecko.driver", "C:\\Gecko\\geckodriver.exe");
        FirefoxDriver driver = new FirefoxDriver();

        String baseUrl = "https://portal.aait.edu.et";
        String gradeReportUrl = "https://portal.aait.edu.et/Grade/GradeReport";
        String myUsername = "ATR/8563/09";
        String myPassword = "2234";

        driver.get(baseUrl);

        //signing into my account
        WebElement usernameTextBox = driver.findElement(By.id("UserName"));
        WebElement passwordTextBox = driver.findElement(By.id("Password"));
        WebElement loginButton = driver.findElement(By.className("btn-success"));

        usernameTextBox.sendKeys(myUsername);
        passwordTextBox.sendKeys(myPassword);
        loginButton.click();

        //go to grade report page
        driver.navigate().to(gradeReportUrl);

        //finding all tr elements in the page
        List<WebElement> rows = driver.findElements(By.tagName("tr"));

        for (WebElement  row:
             rows) {
            for (WebElement td:
                 row.findElements(By.tagName("td"))) {
                System.out.print(td.getText() + "  ");
            }
            System.out.println();
        }

        driver.close();
    }
}
