package page_object;

import command_provider.ActOn;
import command_provider.AssertThat;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Home extends NavigationBar{
    private final By HomeValueInputField = By.id("homeval");
    private final By DownPaymentInputField = By.id("downpayment");
    private final By DownPaymentTypeInDollar = By.name("param[downpayment_type]");
    private final By LoanAmountInputField = By.id("loanamt");
    private final By InterestRateInputField = By.id("intrstsrate");
    private final By LoanTermInputField = By.id("loanterm");
    private final By StartMonthDropDown = By.name("param[start_month]");
    private final By StartYearInputField = By.id("start_year");
    private final By PropertyTaxInputField = By.id("pptytax");
    private final By PmiInputField = By.id("pmi");
    private final By HomeInsuranceInputField = By.id("hoi");
    private final By MonthlyHoaInputField = By.id("hoa");
    private final By LoanTypeDropDown = By.name("param[milserve]");
    private final By BuyOrRefiDropdown = By.name("param[refiorbuy]");
    private final By CalculateButton = By.name("cal");
    private static final Logger LOGGER = LogManager.getLogger(Home.class);

    public Home(WebDriver driver){
        super(driver);
    }
    public Home typeHomePrice(String value) {
        LOGGER.debug("Typing Home Value: " + value);
        ActOn.element(driver, HomeValueInputField).setValue("300000");
        return this;
    }
    public Home typeDownPayment(String value) {
        LOGGER.debug("Typing DownPayment Value: " + value);
        ActOn.element(driver, DownPaymentInputField).setValue("60000");
        return this;
    }

    public Home downPaymentInDollar(){
      LOGGER.debug("Clicking on the $ radio button: ");
        ActOn.element(driver, DownPaymentTypeInDollar).click();
        return this;
    }
    public Home typeLoanAmount(String value) {
        LOGGER.debug("Typing the loan amount: " + value);
        ActOn.element(driver, LoanAmountInputField).setValue(value);
        return this;
    }
    public Home typeInterestRate(String value){
        LOGGER.debug("Typing the interest rate: " + value);
        ActOn.element(driver, InterestRateInputField).setValue(value);
        return this;
    }
    public Home typeLoanTermYears(String value){
        LOGGER.debug("Typing the LoanTerm:" + value);
        ActOn.element(driver, LoanTermInputField).setValue(value);
        return this;
    }
    public Home selectMonth(String month) {
        LOGGER.debug("Select the start date month: "+ month);
        return  this;
    }
    public Home typeYear(String year){
        LOGGER.debug("Typing the loan start year:" +year);
        ActOn.element(driver,StartYearInputField).setValue(year);
        return this;
    }
    public Home typePropertyTax(String value){
        LOGGER.debug("Typing the Property Tax:" + value);
        ActOn.element(driver,PropertyTaxInputField).setValue(value);
        return this;
    }
    public Home typePMI(String value){
        LOGGER.debug("Type the PMI:" + value);
        ActOn.element(driver,PmiInputField).setValue(value);
        return this;
    }
    public Home typeHomeOwnerInsurance(String value){
        LOGGER.debug("Typing the Home Owner Insurance: " + value);
        ActOn.element(driver,HomeInsuranceInputField).setValue(value);
        return this;
    }
    public Home typeMonthlyHOA(String value) {
        LOGGER.debug("Typing the Monthly HOA: " + value);
        ActOn.element(driver,MonthlyHoaInputField).setValue(value);
        return this;
    }
    public Home selectLoanType(String value){
        LOGGER.debug("Selecting loan type: "+ value);
        ActOn.element(driver,LoanTypeDropDown).selectValue(value);
        return this;
    }
    public Home selectBuyOrRefinance(String value){
        LOGGER.debug("Selecting Buy Option: " + value);
        ActOn.element(driver,BuyOrRefiDropdown).selectValue(value);
        return this;
    }
    public Home clickOnCalculateButton(){
        LOGGER.debug("Clicking on Calculate Button:");
        ActOn.element(driver,CalculateButton).click();
        return this;
    }
    public Home validateTotalMonthlyPayment(String totalMonthlyPayment){
        LOGGER.debug("Validating Total Monthly Payment is: " + totalMonthlyPayment);
        String formattedXpath = String.format("//h3[text()='$%s']",totalMonthlyPayment);
        AssertThat.elementAssertions(driver,By.xpath(formattedXpath)).elementIsDisplayed();
        return this;
    }
}
