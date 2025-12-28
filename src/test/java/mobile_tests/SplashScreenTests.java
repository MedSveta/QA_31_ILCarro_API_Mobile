package mobile_tests;

import config.AppiumConfig;
import org.testng.Assert;
import org.testng.annotations.Test;
import screens.SplashScreen;

public class SplashScreenTests extends AppiumConfig {
    @Test
    public void splashScreenPositiveTest(){
        Assert.assertTrue(new SplashScreen(driver).validateVersion());
    }
}
