package step_definitions;

import command_provider.ActOn;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import page_object.Home;
import page_object.RealApr;
import utillities.ReadConfigFiles;

import java.util.List;
import java.util.Map;

public class MortgageSteps {
    private final Logger LOGGER = LogManager.getLogger(this.getClass().getName());
    WebDriver driver = Hooks.driver;
    @Given("^user is in mortgage calculator home page$")
    public void navigateToMortgageCalculatorHomePage(){
        ActOn.browser(driver).openBrowser(ReadConfigFiles.getPropertyValues("MortgageAppURL"));
        LOGGER.info("Landed on the Mortgage Calculator Home Page");
    }
    @And("^user navigate to Real Apr page$")
    public void navigateToRealAprPage(){
        new Home(driver)
                .mouseHoverToRates()
                .navigateToReal();
        LOGGER.info("Navigated to Real APR Page");
    }
    @When("^user clicks on calculate button upon entering the data$")
    public void clickOnCalculateButtonUponEnteringData(DataTable table){
        List<Map<String,String>> data = table.asMaps(String.class,String.class);
        for (Map<String, String> cells: data) {
            new RealApr(driver)
                    .typeHomePrice(cells.get("HomePrice"))
                    .selectDownPaymentInDollar()
                    .typeDownPayment(cells.get("DownPayment"))
                    .typeInterestRate(cells.get("InterestRate"))
                    .clickOnCalculateButton();
        }
        LOGGER.info("Real APR Rate is calculated open entering the data");
    }

    @Then("^the real apr rate is \"(.+?)\"$")
    public void validateRealAprRate(String realAPR) {
        new RealApr(driver)
                .validateRealAprRate(realAPR);
        LOGGER.info("Real APR Rate is validated");
    }
}
