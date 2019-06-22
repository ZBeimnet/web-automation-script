package script_for_portal;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
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

        //declaring a string builder to store the grade report
        StringBuilder gradeReport;
        gradeReport = new StringBuilder();

        //traversing each row and printing values
        for (WebElement  row:
             rows) {
            for (WebElement td:
                 row.findElements(By.tagName("td"))) {
                 gradeReport.append(td.getText()).append("  ");
            }
            gradeReport.append("\n");
        }

        //writing to a file
        writeToFile(gradeReport.toString());

        driver.close();
    }

    private static void writeToFile(String content) {
        String fileNameToStoreGradeReport = ".\\src\\script_for_portal\\GradeReport.txt";

        try {
            Writer writer = new FileWriter(fileNameToStoreGradeReport);
            writer.write(content);
            writer.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
