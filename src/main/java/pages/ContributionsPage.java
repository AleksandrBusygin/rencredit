package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

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

    @FindBy(xpath = "//span[@class='calculator__check-text'][contains(text(),'Ежемесячная')]")
    public WebElement checkBox1;

    @FindBy(xpath = "//span[@class='calculator__check-text'][contains(text(),'Частичное')]")
    public WebElement checkBox2;

    @FindBy(xpath = "//span[@class='js-calc-rate']")
    public WebElement rate;

    @FindBy(xpath = "//span[@class='js-calc-earned']")
    public WebElement earned;

    @FindBy(xpath = "//span[@class='js-calc-replenish']")
    public WebElement replenish;

    @FindBy(xpath = "//span[@class='js-calc-result']")
    public WebElement result;

//    @FindBy(xpath = "//img[@class='logo__image']")
//    public WebElement logo;

    public void compareHeader(String expectedHeader){
        waitFieldisDisplayed(headerOfContributionsPage);
        scrollToElement(headerOfContributionsPage);
        compareText(headerOfContributionsPage.getText(),expectedHeader);
    }
    public void rublesButtonClick(){
        scrollToElement(rublesButton);
        click(rublesButton);
    }

    public void howMuchMoney(String money){
        scrollToElement(formForMoney);
        fillField(formForMoney,money);
    }

    public void chooseTermMethod(String term){
         new Select(chooseTerm).selectByVisibleText(term);
     }

    public void howMuchReplenish(String repl){
        fillField(replenishment,repl);
    }

    public void additionalParam(List<String> param){
        for (String s : param) {
            if (s.equals("Ежемесячная капитализация")) {
                checkBoxCheck(checkBox1);
            }
            if (s.equals("Частичное снятие")) {
                checkBoxCheck(checkBox2);
            }
        }
    }
    public void compareResultRate(String expectedRate){
        scrollToElement(rate);
        compareText(rate.getText(),expectedRate);
    }
    public void compareResultEarned(String expectedEarned){
        scrollToElement(earned);
        compareText(earned.getText(),expectedEarned);
    }
    public void compareResultReplenish(String expectedReplenish){
        scrollToElement(replenish);
        compareText(replenish.getText(),expectedReplenish);
    }
    public void compareResult(String expectedResult){
        scrollToElement(result);
        compareText(result.getText(),expectedResult);
    }
}
