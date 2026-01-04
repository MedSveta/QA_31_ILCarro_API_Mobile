package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.support.FindBy;

public class SearchScreen extends BaseScreen {
    public SearchScreen(AppiumDriver<AndroidElement> driver) {
        super(driver);
    }

    @FindBy(xpath = "//android.widget.ImageView[@content-desc='More options']")
    AndroidElement btnDots;
    @FindBy(xpath = "//*[@resource-id='com.telran.ilcarro:id/title' and @text='Registration']")
    AndroidElement btnRegistration;
    @FindBy(xpath = "//*[@resource-id='com.telran.ilcarro:id/title' and @text='Login']")
    AndroidElement btnLogin;
    @FindBy(xpath = "//hierarchy/android.widget.Toast")
    AndroidElement popUpMessageSuccess;

    public boolean isTextInPopUpMessageSuccessPresent(String text){
        return isTextInElementPresent(popUpMessageSuccess, text, 5);

    }

    public void clickBtnDots() {
        clickWait(btnDots, 3);
    }

    public void clickBtnRegistration(){
        clickWait(btnRegistration, 3);
    }

    public void clickBtnLogin(){
        clickWait(btnLogin, 3);
    }

}
