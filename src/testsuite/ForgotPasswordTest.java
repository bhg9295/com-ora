package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ForgotPasswordTest extends BaseTest {
   String baseUrl = "https://opensource-demo.orangehrmlive.com/\n";
   @Before
   public void test(){
       openBrowser(baseUrl);
   }

    @Test
    public void userSholdLoginSuccessfullyWithValidCredentials() {
        //enter valid email
        driver.findElement(By.name("username")).sendKeys("Admin");
        //enter valid password
        driver.findElement(By.name("password")).sendKeys("admin123");
        //click on login in button
        driver.findElement(By.xpath("(//button[@type = 'submit'])")).click();
        //verify Dashboard web element is present
        String expectedText = "Dashboard";
        String actualText = driver.findElement(By.xpath("//div[@class = 'oxd-layout']//h6")).getText();
        Assert.assertEquals("Dashboard text is not displayed",expectedText,actualText);
    }
    @Test
   public void userShouldNavigateToForgotPasswordPageSuccessfully(){
        driver.findElement(By.xpath("//div[@class = 'orangehrm-login-forgot']//p")).click();
        String expectedText = "Reset Password";
        String actualText = driver.findElement(By.tagName("h6")).getText();
        Assert.assertEquals("Reset password text is not display",actualText,expectedText);
    }
    @After
    public void testdrown(){
       closeBrowser();
    }

    }
