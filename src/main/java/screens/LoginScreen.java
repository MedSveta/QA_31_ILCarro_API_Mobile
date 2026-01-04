package screens;

import dto.RegistrationBodyDto;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.support.FindBy;

public class LoginScreen extends BaseScreen {
    public LoginScreen(AppiumDriver<AndroidElement> driver) {
        super(driver);
    }

    @FindBy(id = "com.telran.ilcarro:id/editLoginEmail")
    AndroidElement fieldEmail;
    @FindBy(id = "com.telran.ilcarro:id/editLoginPassword")
    AndroidElement fieldPassword;
    @FindBy(id = "com.telran.ilcarro:id/loginBtn")
    AndroidElement btnYalla;

    public void typeLoginForm(RegistrationBodyDto user){
        fieldEmail.sendKeys(user.getUsername());
        fieldPassword.sendKeys(user.getPassword());
    }

    public void clickBtnYalla(){
        btnYalla.click();
    }
}
