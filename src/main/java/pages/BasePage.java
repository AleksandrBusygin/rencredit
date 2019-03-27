package pages;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import steps.BaseSteps;

public class BasePage {

    public static WebDriver driver = BaseSteps.getDriver();

    public BasePage(){
        PageFactory.initElements(driver,this);
    }

    public void fillField(WebElement element, String text){
        while (!(element.getAttribute("value").equals(text))) {
            scrollToElement(element);
            click(element);
            element.clear();
            element.sendKeys(text);
        }
    }
    public static void checkBoxCheck(WebElement checkbox){
        if(!(checkbox.isSelected())){
            new WebDriverWait(driver,10).until(ExpectedConditions.elementToBeClickable(checkbox)).click();
        }
    }

    public static void scrollToElement(WebElement find){
        ((JavascriptExecutor) BaseSteps.getDriver()).executeScript("arguments[0].scrollIntoView();", find);
        Wait<WebDriver> wait = new WebDriverWait(BaseSteps.getDriver(), 20, 1000);
        wait.until(ExpectedConditions.visibilityOf(find));
    }

    public static boolean isElementPresented(WebElement element) {
        try {
            WebDriverWait wait = new WebDriverWait(BaseSteps.getDriver(), 10);
            wait.until((WebDriver d) -> element);
            return true;
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static void waitFieldisDisplayed(WebElement element) {
        try {
            WebDriverWait wait = new WebDriverWait(BaseSteps.getDriver(), 10);
            wait.until((WebDriver d) -> element.isDisplayed());
            return;
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
        Assert.fail("Поле не отображено");
    }

    public static void click(WebElement element) {
        waitFieldisDisplayed(element);
        element.click();
    }

    public static void compareText(String actual, String expected) {
        Assert.assertTrue(("Искомого текста нет: " + expected + " вместо него " + actual), actual.contains(expected));
        System.out.println("Искомый текст есть: " + expected);
    }
}
