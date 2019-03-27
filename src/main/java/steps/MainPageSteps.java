package steps;

import io.qameta.allure.Step;
import pages.MainPage;

public class MainPageSteps {

    MainPage mainPage = new MainPage();

    @Step("выбран калькулятор для вкладов")
    public void selectCalculator(){
        mainPage.calculatorClick();
    }
}
