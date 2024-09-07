import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class testSwag {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver =new ChromeDriver();
        driver.manage().window().maximize();
        String baseUrl = "https://www.saucedemo.com/";

        String[] userNames={
                "standard_user",
                "locked_out_user",
                "problem_user",
                "performance_glitch_user",
                "error_user",
                "visual_user"
        };

        for (String username : userNames) {
            driver.get(baseUrl);

            driver.findElement(By.cssSelector("[data-test=\"username\"]")).sendKeys(username);


            driver.findElement(By.cssSelector("[data-test=\"password\"]")).sendKeys("secret_sauce");

             driver.findElement(By.cssSelector("[data-test=\"login-button\"]")).click();

            try {
                Thread.sleep(2000);
                WebElement logoutButton = driver.findElement(By.id("logout-button"));
                if (logoutButton.isDisplayed()) {
                    System.out.println("Login successful for user: " + username);
                }
            } catch (Exception e) {
                System.out.println("Login failed for user: " + username);
            }
        }
        driver.findElement(By.cssSelector("[data-test=\"login-button\"]")).click();
    }
}
