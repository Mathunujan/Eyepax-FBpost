
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class FacebookLogin {
        static String userNameTxt="YOUR_USERNAME";
        static String passwordTxt="YOUR_PASSWORD";

        public static void main(String[] args) throws InterruptedException {
            System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
            WebDriver driver = new ChromeDriver();
            Actions act= new Actions(driver);

            driver.get("https://www.facebook.com/login.php");
            driver.manage().window().maximize();


            WebElement username = driver.findElement(By.id("email"));
            username.sendKeys(userNameTxt);
            WebElement password = driver.findElement(By.id("pass"));
            password.sendKeys(passwordTxt);


            WebElement loginBtn = driver.findElement(By.name("login"));
            loginBtn.click();
            Thread.sleep(10000);
            act.sendKeys(Keys.ESCAPE).build().perform();
            WebElement statusCTA = driver.findElement(By.xpath("//*[contains(text (),'your mind')]"));
            statusCTA.click();
            Thread.sleep(5000);
            WebElement StatusBox = driver.findElement(By.xpath("//*[@aria-label=\"What's on your mind, MaThu?\"]"));
            act.doubleClick(StatusBox);
            act.sendKeys("Just for test").build().perform();
            //statusBox.sendKeys("ded");
 WebElement postBtn = driver.findElement(By.xpath("//*[text()='Post']"));
postBtn.click();

            driver.quit();
        }
    }
