package tests;

import pages.LoginPage;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void testValidLogin() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
//        HomePage homePage = new HomePage(driver);

        loginPage.enterEmail("bhatt2002snehil@gmail.com");
        loginPage.enterPassword("Test@123");
        loginPage.clickLoginButton();
        Thread.sleep(5000);
//        assertTrue(homePage.isHomeScreenDisplayed());
    }

//    @Test
//    public void testPasswordVisibilityToggle() {
//        LoginPage loginPage = new LoginPage(driver);
//        loginPage.enterPassword("valid_password");
//
//        loginPage.togglePasswordVisibility();
//        assertEquals("text", loginPage.getPasswordFieldType());
//
//        loginPage.togglePasswordVisibility();
//        assertEquals("password", loginPage.getPasswordFieldType());
//    }

//    @Test
//    public void testRememberMeFunctionality() {
//        LoginPage loginPage = new LoginPage(driver);
//        HomePage homePage = new HomePage(driver);
//
//        loginPage.enterEmail("valid_email@example.com");
//        loginPage.enterPassword("valid_password");
//        loginPage.clickRememberMe();
//        loginPage.clickLoginButton();
//
//        driver.closeApp();
//        driver.launchApp();
//
//        assertTrue(homePage.isHomeScreenDisplayed());
//    }

    @Test
    public void testInvalidEmailFormat() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterEmail("invalidemail.com");
        loginPage.enterPassword("valid_password");
        loginPage.clickLoginButton();

        Assert.assertEquals("Please enter a valid email address", loginPage.getEmailErrorMessage());
    }

    @Test
    public void testIncorrectPassword() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterEmail("valid_email@example.com");
        loginPage.enterPassword("incorrect_password");
        loginPage.clickLoginButton();

        Assert.assertEquals("Incorrect password", loginPage.getPasswordErrorMessage());
    }

    @Test
    public void testEmptyFields() {
        LoginPage loginPage = new LoginPage(driver);

        loginPage.clickLoginButton();
        Assert.assertEquals("Email is required", loginPage.getEmailErrorMessage());
        Assert.assertEquals("Password is required", loginPage.getPasswordErrorMessage());

        loginPage.enterPassword("valid_password");
        loginPage.clickLoginButton();
        Assert.assertEquals("Email is required", loginPage.getEmailErrorMessage());

        loginPage.enterEmail("valid_email@example.com");
        loginPage.enterPassword("");
        loginPage.clickLoginButton();
        Assert.assertEquals("Password is required", loginPage.getPasswordErrorMessage());
    }
}
