package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class LoginTest extends BaseTest {

    String bseUrl = "https://www.saucedemo.com/";

    @Before
    public void setUp(){
       openBrowser(bseUrl);
    }
    @Test
    public void  userShouldLoginSuccessfullyWithValid(){

        //Enter “standard_user” username
        driver.findElement(By.xpath("//input[@name='user-name']")).sendKeys("standard_user");
        //Enter “secret_sauce” password
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");
        //Click on ‘LOGIN’ button
        driver.findElement(By.xpath("//input[@value='Login']")).click();
        //Verify the text “PRODUCTS”
        driver.findElement(By.xpath("//span[text()='Products']")).getText();
    }
    @Test
    public void verifyThatSixProductsAreDisplayedOnPage(){
        //Enter “standard_user” username
        driver.findElement(By.xpath("//input[@name='user-name']")).sendKeys("standard_user");
        //Enter “secret_sauce” password
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");
        //Click on ‘LOGIN’ button
        driver.findElement(By.xpath("//input[@value='Login']")).click();
        // Verify that six products are displayed on page

        String expectedText="six products are displayed on page";
        String actualText=driver.findElement(By.xpath("//div[@class='inventory_item_desc']")).getText();
        Assert.assertEquals("Massage not found",expectedText,actualText);
    }




    @After
    public void tearDown(){
        closeBrowser();
    }
}
