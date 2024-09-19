package pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.android.AndroidDriver;

import org.openqa.selenium.WebElement;


public class LoginPage extends BasePage {

    // Locators
    @AndroidFindBy(accessibility = "Mobile number or email address")
    private WebElement emailField;

    @AndroidFindBy(accessibility = "Password")
    private WebElement passwordField;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Log in\")")
    private WebElement loginButton;

    @AndroidFindBy(id = "com.example:id/togglePasswordVisibility")
    private WebElement passwordVisibilityToggle;

    @AndroidFindBy(id = "com.example:id/rememberMeCheckbox")
    private WebElement rememberMeCheckbox;

    @AndroidFindBy(id = "android:id/alertTitle")
    private WebElement emailErrorMessage;

    @AndroidFindBy(id = "android:id/alertTitle")
    private WebElement passwordErrorMessage;

    // Constructor
    public LoginPage(AndroidDriver driver) {
        super(driver);  
    }

    // Actions
    public void enterEmail(String email) {
        waitForVisibility(emailField);
        emailField.sendKeys(email);
    }

    public void enterPassword(String password) {
        waitForVisibility(passwordField);
        passwordField.sendKeys(password);
    }

    public void clickLoginButton() {
        waitForClickability(loginButton);
        loginButton.click();
    }

    public void togglePasswordVisibility() {
        waitForClickability(passwordVisibilityToggle);
        passwordVisibilityToggle.click();
    }

    public void clickRememberMe() {
        waitForClickability(rememberMeCheckbox);
        rememberMeCheckbox.click();
    }

    public String getEmailErrorMessage() {
        waitForVisibility(emailErrorMessage);
        return emailErrorMessage.getText();
    }

    public String getPasswordErrorMessage() {
        waitForVisibility(passwordErrorMessage);
        return passwordErrorMessage.getText();
    }

    public String getPasswordFieldType() {
        waitForVisibility(passwordField);
        return passwordField.getAttribute("type");
    }
}
