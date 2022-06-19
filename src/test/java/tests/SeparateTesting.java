package tests;

import config.ConfigProperties;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.CalculatorPage;
import pages.NumberGamePage;
import java.time.Duration;

public class SeparateTesting {

    private static CalculatorPage calculatorPage;
    private static NumberGamePage gamePage;
    private static WebDriver driver;



    public static void setupCalculatePage() {
        System.setProperty("webdriver.chrome.driver", ConfigProperties.getProperty("chromeDriver"));
        driver = new ChromeDriver();
        calculatorPage = new CalculatorPage(driver);
        driver.manage().window().maximize();
        driver.get(ConfigProperties.getProperty("calculatorPage"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        JavascriptExecutor js1 = (JavascriptExecutor) driver;
        js1.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    public static void setupNumberGamePage() {
        System.setProperty("webdriver.chrome.driver", ConfigProperties.getProperty("chromeDriver"));
        driver = new ChromeDriver();
        gamePage = new NumberGamePage(driver);
        driver.manage().window().maximize();
        driver.get(ConfigProperties.getProperty("theNumberGame"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        JavascriptExecutor js1 = (JavascriptExecutor) driver;
        js1.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    @Test
    public void uiDifferenceBetweenTwoNumbers() {
        setupCalculatePage();
        calculatorPage.inputFirst("2");
        calculatorPage.inputSecond("3");
        calculatorPage.clickOperationSubtract();
        calculatorPage.clickCalculate();
        Assert.assertEquals("-1", calculatorPage.answer());
        driver.close();
    }

    @Test
    public void uiConcatenationTwoStrings() {
        setupCalculatePage();
        calculatorPage.inputFirst("gs");
        calculatorPage.inputSecond("bu");
        calculatorPage.clickOperationConcatenate();
        calculatorPage.clickCalculate();
        Assert.assertEquals("gsbu", calculatorPage.answer());
        driver.close();
    }

    @Test
    public void uiMessageAppearance() {
        setupNumberGamePage();
        gamePage.clickBuildDemo();
        gamePage.clickRollTheDace();
        gamePage.inputFirst("string");
        gamePage.submitButton();
        Assert.assertEquals("string: Not a number!", gamePage.answer());
        driver.close();
    }
}