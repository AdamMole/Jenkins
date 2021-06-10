package pl.testeroprogramowania.steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import pl.testeroprogramowania.utils.DriverFactory;

import java.util.concurrent.TimeUnit;

public class Hooks {

    @Before
    public void setup() {
        DriverFactory.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        DriverFactory.getDriver().manage().window().maximize();
        DriverFactory.getDriver().get("http://seleniumdemo.com/");
    }

    @After
    public void tearDown() {
        DriverFactory.quitDriver();
    }

}
