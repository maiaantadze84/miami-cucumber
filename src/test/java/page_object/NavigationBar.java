package page_object;

import command_provider.ActOn;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationBar {
    private final By RatesLink = By.linkText("Rates");
    private final By RealAprLink = By.linkText("Real APR");
    private final By MortgageCalculatorLogo = By.xpath("//a/img[@alt='Logo']");
    private static final Logger LOGGER = LogManager.getLogger(NavigationBar.class);

    public WebDriver driver;
    //Create a Constructor
    public NavigationBar(WebDriver driver) {
        this.driver = driver;
    }
    public NavigationBar mouseHoverToRates() {
        LOGGER.debug("Mouse Hover To the rates Link");
        ActOn.element(driver, RatesLink).mouseHover();
        return this;
    }
    public RealApr navigateToReal() {
        LOGGER.debug("Clicking on the Real APR Link");
        ActOn.element(driver,RealAprLink).click();
        return new RealApr(driver);
    }
    public Home navigateToHome(){
        LOGGER.debug("Clicking on Mortgage calculator Logo");
        ActOn.element(driver,MortgageCalculatorLogo).click();
        return new Home(driver);
    }
}
