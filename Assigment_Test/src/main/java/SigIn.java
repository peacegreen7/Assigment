import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

class SignIn {

    public static void main(String[] args) {

        WebDriver driver;
        setChromeDriverProperty();
        driver = new ChromeDriver();
        driver.get("https://anotepad.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement registerBtn = driver.findElement(By.xpath("//span[contains(text(),'Register/Login')]"));
        registerBtn.click();
        WebElement registerEmail = driver.findElement(By.id("registerEmail"));
        WebElement registerPwd = driver.findElement(By.xpath("//input[@id='registerEmail']/ancestor::div[@class='form-group']/following-sibling::div//input[@id='password']"));
        WebElement createBtn = driver.findElement(By.xpath("//button[contains(text(),'Create Account')]"));
        WebElement pageTextEle = driver.findElement(By.xpath("//div[@id='create_login']/p"));

        String expectedText = "To access your notes from anywhere and never lose them, just create an account (it will take less than a minute). If you already have an account, you can login below.";
        String pageText = "";
        String currentURL = "";
        String email = "test20@me.com";
        String password = "123456";

        // Redirect to Sign In page
        pageText = pageTextEle.getText();
        assertEquals(expectedText, pageText);

        // Sign Up new account
        registerEmail.sendKeys(email);
        registerPwd.sendKeys(password);
        createBtn.click();
        currentURL = driver.getCurrentUrl();

        if (currentURL.equals("https://anotepad.com/")) {
            WebElement logoutBtn = driver.findElement(By.xpath("//span[text()='Logout']"));
            logoutBtn.click();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

            //Sign In new account
            driver.get("https://anotepad.com/create_account");
            WebElement loginEmail = driver.findElement(By.id("loginEmail"));
            WebElement loginPwd = driver.findElement(By.xpath("//input[@id='loginEmail']/ancestor::div[@class='form-group']/following-sibling::div//input[@id='password']"));
            WebElement loginBtn = driver.findElement(By.xpath("//button[contains(text(),'Login')]"));
            loginEmail.sendKeys(email);
            loginPwd.sendKeys(password);
            loginBtn.click();
        } else {
            WebElement ErrorEle = driver.findElement(By.xpath("//p[@class='alert alert-danger']/child::strong"));
            if (ErrorEle.isDisplayed()) {

                //Sign In exist account
                driver.get("https://anotepad.com/create_account");
                WebElement loginEmail = driver.findElement(By.id("loginEmail"));
                WebElement loginPwd = driver.findElement(By.xpath("//input[@id='loginEmail']/ancestor::div[@class='form-group']/following-sibling::div//input[@id='password']"));
                WebElement loginBtn = driver.findElement(By.xpath("//button[contains(text(),'Login')]"));
                loginEmail.sendKeys(email);
                loginPwd.sendKeys(password);
                loginBtn.click();
            }
        }

        driver.quit();
    }

    public static void setChromeDriverProperty() {
        if (System.getProperty("os.name").contains("Windows")) {
            System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        } else {
            System.setProperty("webdriver.chrome.driver", "resources/chromedriver");
        }
    }

}
