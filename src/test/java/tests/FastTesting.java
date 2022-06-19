package tests;

import config.ConfigProperties;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.CalculatorPage;
import pages.NumberGamePage;

import java.time.Duration;

public class FastTesting {
    private static CalculatorPage pageFirst;
    private static CalculatorPage pageSecond;
    private static NumberGamePage pageThird;
    private static WebDriver driverFirst;
    private static WebDriver driverSecond;
    private static WebDriver driverThird;

    @BeforeClass
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", ConfigProperties.getProperty("chromeDriver"));
        driverFirst = new ChromeDriver();
        driverSecond = new ChromeDriver();
        driverThird = new ChromeDriver();
        pageFirst = new CalculatorPage(driverFirst);
        pageSecond = new CalculatorPage(driverSecond);
        pageThird = new NumberGamePage(driverThird);
        driverFirst.manage().window().maximize();
        driverSecond.manage().window().maximize();
        driverThird.manage().window().maximize();
        driverFirst.get(ConfigProperties.getProperty("calculatorPage"));
        driverSecond.get(ConfigProperties.getProperty("calculatorPage"));
        driverThird.get(ConfigProperties.getProperty("theNumberGame"));
        driverFirst.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driverSecond.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driverThird.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        JavascriptExecutor js1 = (JavascriptExecutor) driverFirst;
        JavascriptExecutor js2 = (JavascriptExecutor) driverSecond;
        JavascriptExecutor js3 = (JavascriptExecutor) driverThird;
        js1.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        js2.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        js3.executeScript("window.scrollTo(0, document.body.scrollHeight)");

    }

    @Test
    public void uiDifferenceBetweenTwoNumbers() {
        pageFirst.inputFirst("2");
        pageFirst.inputSecond("3");
        pageFirst.clickOperationSubtract();
        pageFirst.clickCalculate();
        Assert.assertEquals("-1", pageFirst.answer());
        driverFirst.close();
    }

    @Test
    public void uiConcatenationTwoStrings() {
        pageSecond.inputFirst("gs");
        pageSecond.inputSecond("bu");
        pageSecond.clickOperationConcatenate();
        pageSecond.clickCalculate();
        Assert.assertEquals("gsbu", pageSecond.answer());
        driverSecond.close();
    }

    @Test
    public void uiMessageAppearance() {
        pageThird.clickBuildDemo();
        pageThird.clickRollTheDace();
        pageThird.inputFirst("string");
        pageThird.submitButton();
        Assert.assertEquals("string: Not a number!", pageThird.answer());
        driverThird.close();
    }
}
