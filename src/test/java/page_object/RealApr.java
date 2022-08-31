package page_object;

import command_provider.ActOn;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RealApr extends NavigationBar{
    private final By CalculatorTab = By.xpath("//label[text()='Calculator']");
    private final By HomePriceInputField = By.name("HomeValue");
    private final By DownPaymentInDollar = By.id("DownPaymentSel0");
    private final By DownPaymentInputField = By.name("DownPayment");
    private final By InterestRateInputField = By.name("Interest");
    private final By CalculateButton = By.name("calculate");
    private final By ActualAprRate = By.xpath("//*[@id='analysisDiv']/table/tbody/tr/td/strong[text()='Actual APR:']/../../td[2]/strong");
    private static final Logger LOGGER = LogManager.getLogger(RealApr.class);

    public RealApr(WebDriver driver) {
       super(driver);
    }

    public RealApr waitForPageLoad() {
        LOGGER.debug("waiting to the Page to load:");
        ActOn.wait(driver, CalculatorTab).waitForElementToBeVisible();
        return this;
    }

    public RealApr typeHomePrice(String value) {
        LOGGER.debug("Typing Home value: " + value);
        ActOn.element(driver, HomePriceInputField).setValue(value);
        return this;
    }
    public RealApr selectDownPaymentInDollar() {
        LOGGER.debug("Clicking on the $ as down payment:");
        ActOn.element(driver, DownPaymentInDollar).click();
        return this;
    }

    public RealApr typeDownPayment(String value) {
        LOGGER.debug("typing the down payment value:" + value);
        ActOn.element(driver, DownPaymentInputField).setValue(value);
        return this;
    }

    public RealApr typeInterestRate(String value) {
        LOGGER.debug("typing Interest Rate Value:" + value);
        ActOn.element(driver, InterestRateInputField).setValue(value);
        return this;
    }
    public RealApr clickOnCalculateButton(){
        LOGGER.debug("click on calculate button:");
        ActOn.element(driver,CalculateButton).click();
        return this;
    }
    public RealApr validateRealAprRate(String expectedValue){
        LOGGER.debug("Validate the Real APR Rate is:"+ expectedValue);
        String actualRealAprRate = ActOn.element(driver,ActualAprRate).getTextValue();
        Assert.assertEquals(expectedValue,actualRealAprRate);
        return this;
    }

}
