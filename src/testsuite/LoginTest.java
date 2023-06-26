package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

public class LoginTest extends BaseTest {
    String base ="https://opensource-demo.orangehrmlive.com/\n";
    @Test
    public void userSholdLoginSuccessfullyWithValidCredentials(){
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
    @After
    public void testdrown(){
        closeBrowser();
    }
}
