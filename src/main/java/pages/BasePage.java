package pages;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
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
        element.clear();
        element.sendKeys(text);
        }

    public static void checkBoxCheck(WebElement checkbox){
        Wait<WebDriver> wait = new WebDriverWait(BaseSteps.getDriver(), 30, 1000);
        wait.until(ExpectedConditions.elementToBeClickable(checkbox));
        if(!(checkbox.isSelected())){
            new WebDriverWait(driver,10).until(ExpectedConditions.elementToBeClickable(checkbox)).click();
        }
    }

    public static void scrollToElement(WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) BaseSteps.getDriver();
        js.executeScript("arguments[0].scrollIntoView(true);", element);
        WebDriverWait wait = new WebDriverWait(BaseSteps.getDriver(), 10, 2000);
        wait.until(ExpectedConditions.elementToBeClickable(element));
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
        WebDriverWait wait = new WebDriverWait(BaseSteps.getDriver(), 30);
        wait.withMessage(String.format("Ожидаемое значение [%s]", expected))
                .until((ExpectedCondition<Boolean>) driver -> {
                    if (actual.replace("%", "").replaceAll(" ", "").equals(expected)) {
                        return Boolean.TRUE;
                    }
                    return false;
                });
    }

    public static void compareHeader(String actual, String expected) {
        Assert.assertTrue(("Искомого текста нет: " + expected + " вместо него " + actual), actual.equals(expected));
        System.out.println("Искомый текст есть: " + expected);
    }
}
