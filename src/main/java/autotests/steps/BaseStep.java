package autotests.steps;

import autotests.util.DriverManager;
import autotests.util.TestProperties;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseStep {
    public static Properties properties = TestProperties.getInstance().getProperties();

    @Before
    public void startScenario() {
        System.out.println("1. Выполняется открытие страницы");
        WebDriver driver = DriverManager.getDriver();
        driver.manage().window().maximize();
        driver.get(properties.getProperty("url"));
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
    }

    @After
    public void afterScenario() {
       DriverManager.quitDriver();

    }

    @When("Открыть сайт")
    public void compareProducts()throws Exception{
        DriverManager.getDriver().get(properties.getProperty("url"));
        System.out.println("Открываем сайт");
    }


    public static void sleep(int milliseconds){
        try{
            Thread.sleep(milliseconds);
        }catch (Exception e){}
    }
}
