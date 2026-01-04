package mobile_tests;

import config.AppiumConfig;
import dto.RegistrationBodyDto;
import org.testng.Assert;
import org.testng.annotations.Test;
import screens.ErrorScreen;
import screens.RegistrationScreen;
import screens.SearchScreen;
import screens.SplashScreen;

import java.util.Random;

public class RegistrationTests extends AppiumConfig {
    @Test
    public void registrationPositiveTest() {
        int i = new Random().nextInt(1000);
        RegistrationBodyDto user = RegistrationBodyDto.builder()
                .firstName("Nika")
                .lastName("Persik")
                .username("nika" + i + "persik@gmail.com")
                .password("POtu324$")
                .build();
        new SplashScreen(driver).goToSearchScreen(5);
        SearchScreen searchScreen = new SearchScreen(driver);
        searchScreen.clickBtnDots();
        searchScreen.clickBtnRegistration();
        RegistrationScreen registrationScreen = new RegistrationScreen(driver);
        registrationScreen.typeRegistrationForm(user);
        registrationScreen.clickCheckBox();
        registrationScreen.clickBtnYalla();
        Assert.assertTrue(searchScreen
                .isTextInPopUpMessageSuccessPresent("Registration success!"));
    }

    @Test
    public void registrationNegativeTest_WrongEmail() {
        int i = new Random().nextInt(1000);
        RegistrationBodyDto user = RegistrationBodyDto.builder()
                .firstName("Nika")
                .lastName("Persik")
                .username("nika" + i + "persikgmail.com")
                .password("POtu324$")
                .build();
        new SplashScreen(driver).goToSearchScreen(5);
        SearchScreen searchScreen = new SearchScreen(driver);
        searchScreen.clickBtnDots();
        searchScreen.clickBtnRegistration();
        RegistrationScreen registrationScreen = new RegistrationScreen(driver);
        registrationScreen.typeRegistrationForm(user);
        registrationScreen.clickCheckBox();
        registrationScreen.clickBtnYalla();
        Assert.assertTrue(new ErrorScreen(driver)
                .validateErrorMessage("{username=must be a well-formed email address}"));
    }

    @Test
    public void registrationNegativeTest_WO_CheckBox() {
        int i = new Random().nextInt(1000);
        RegistrationBodyDto user = RegistrationBodyDto.builder()
                .firstName("Nika")
                .lastName("Persik")
                .username("nika" + i + "persik@gmail.com")
                .password("POtu324$")
                .build();
        new SplashScreen(driver).goToSearchScreen(5);
        SearchScreen searchScreen = new SearchScreen(driver);
        searchScreen.clickBtnDots();
        searchScreen.clickBtnRegistration();
        RegistrationScreen registrationScreen = new RegistrationScreen(driver);
        registrationScreen.typeRegistrationForm(user);
        registrationScreen.clickBtnYalla();
        Assert.assertTrue(new ErrorScreen(driver)
                .validateErrorMessage("All fields must be filled and agree terms"));
    }
}
