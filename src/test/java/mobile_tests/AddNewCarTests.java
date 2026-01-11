package mobile_tests;

import config.AppiumConfig;
import dto.CarDto;
import dto.RegistrationBodyDto;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import screens.*;

import java.util.Random;

public class AddNewCarTests extends AppiumConfig {
    @BeforeMethod
    public void login(){
        new SplashScreen(driver).goToSearchScreen(5);
        SearchScreen searchScreen = new SearchScreen(driver);
        searchScreen.clickBtnDots();
        searchScreen.clickBtnLogin();
        RegistrationBodyDto user = RegistrationBodyDto.builder()
                .username("sima_simonova370@gmail.com")
                .password("BSas124!")
                .build();
        LoginScreen loginScreen = new LoginScreen(driver);
        loginScreen.typeLoginForm(user);
        loginScreen.clickBtnYalla();
    }

    @Test
    public void addNewCarPositiveTest(){
        int i = new Random().nextInt(1000)+1000;
        CarDto car = CarDto.builder()
                .serialNumber("999-"+i)
                .manufacture("Mazda")
                .model("CX-30")
                .city("Haifa")
                .pricePerDay(4.4)
                .carClass("F")
                .fuel("Diesel")
                .year("2025")
                .seats(4)
                .build();
        SearchScreen searchScreen = new SearchScreen(driver);
        searchScreen.clickBtnDots();
        searchScreen.clickBtnMyCars();
        new MyCarsScreen(driver).clickBtnAddNewCar();
        AddNewCarScreen addNewCarScreen = new AddNewCarScreen(driver);
        addNewCarScreen.typeAddNewCarForm(car);
        addNewCarScreen.clickBtnAddCar();
        Assert.assertTrue(new MyCarsScreen(driver)
                .isTextInPopUpMessageSuccessPresent("Car was added!"));
    }
}
