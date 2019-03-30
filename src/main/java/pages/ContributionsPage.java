package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.*;
import steps.BaseSteps;

public class ContributionsPage extends BasePage {

    @FindBy(xpath = "//h2[@class='calculator-block__title block-title']")
    public WebElement headerOfContributionsPage;

    @FindBy(xpath = "//span[text()='Рубли']")
    public WebElement rublesButton;

    @FindBy(xpath = "//input[@name='amount']")
    public WebElement formForMoney;

    @FindBy(xpath = "//div[@class='jq-selectbox__select']")
    public WebElement chooseTerm;

    @FindBy(xpath = "//input[@name='replenish']")
    public WebElement replenishment;

    @FindBy(xpath = "//input[@name=\"capitalization\"]//parent::div")
    public WebElement checkBox1;

    @FindBy(xpath = "//input[@name=\"partial_out\"]//parent::div")
    public WebElement checkBox2;

    @FindBy(xpath = "//div[@class=\"calculator__dep-percent\"]//child::span[@class=\"js-calc-rate\"]")
    public WebElement rate;

    @FindBy(xpath = "//tr//td//child::b//child::span[@class=\"js-calc-earned\"]")
    public WebElement earned;

    @FindBy(xpath = "//tr//td//child::span[@class=\"js-calc-replenish\"]")
    public WebElement replenish;

    @FindBy(xpath = "//div//div//child::span[@class=\"js-calc-result\"]")
    public WebElement result;


    public void compareHeader(String expectedHeader) {
        waitFieldisDisplayed(headerOfContributionsPage);
        scrollToElement(headerOfContributionsPage);
        compareHeader(headerOfContributionsPage.getText(), expectedHeader);
    }

    public void rublesButtonClick() {
        ((JavascriptExecutor) BaseSteps.getDriver()).executeScript("arguments[0].scrollIntoView(false);", rublesButton);
        Wait<WebDriver> wait = new WebDriverWait(BaseSteps.getDriver(), 20, 1000);
        wait.until(ExpectedConditions.visibilityOf(rublesButton));
        click(rublesButton);
    }

    public void howMuchMoney(Integer money) {
        scrollToElement(formForMoney);
        click(formForMoney);
        fillField(formForMoney, money.toString());
    }

    public void chooseTermMethod(String term) {
        click(chooseTerm);
        Select select = new Select(BaseSteps.getDriver().findElement(By.xpath("//select[@class=\"calculator__slide-input js-slide-value\"]")));
        select.selectByVisibleText(term);
    }

    public void howMuchReplenish(Integer repl) {
        click(replenishment);
        fillField(replenishment, repl.toString());
    }

    public void everyMonth() {
        checkBoxCheck(checkBox1);
    }

    public void partial() {
        checkBoxCheck(checkBox2);
    }

    public void compareResultRate(String expectedRate){
        scrollToElement(result);
        compareText(rate,expectedRate);
    }
    public void compareResultEarned(String expectedEarned){
        compareText(earned,expectedEarned);
    }
    public void compareResultReplenish(String expectedReplenish){
        compareText(replenish,expectedReplenish);
    }
    public void compareResult(String expectedResult){
        compareText(result,expectedResult);
    }
}
