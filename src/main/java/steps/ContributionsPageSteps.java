package steps;

import io.qameta.allure.Step;
import pages.ContributionsPage;

import java.util.List;

public class ContributionsPageSteps {

    ContributionsPage contributionsPage = new ContributionsPage();

    @Step("проверка соответствия заголовка страницы ожидаемому тексту - {0}")
    public void checkHeaderStep(String expectedHeader){
        contributionsPage.compareHeader(expectedHeader);
    }

    @Step("выбран рублевый вклад")
    public void chooseRublesStep() {
        contributionsPage.rublesButtonClick();
    }

    @Step("выбранна суммма вклада - {0}")
    public void chooseAmountStep(String amount){
        contributionsPage.howMuchMoney(amount);
    }

    @Step("вклад на срок - {0}")
    public void setTermStep(String term){
        contributionsPage.chooseTermMethod(term);
    }

    @Step("ежемесячное пополнение - {0}")
    public void setReplenishmentStep(String replenishment){
        contributionsPage.howMuchReplenish(replenishment);
    }

    @Step("выбраны дополнительные параметры - {0,}")
    public void chooseAdditionalParamStep(List<String> parametres){
        contributionsPage.additionalParam(parametres);
    }

    @Step("проверка ожидаемых начислений - {0}")
    public void checkEarnedStep(String earned){
        contributionsPage.compareResultEarned(earned);
    }

    @Step("проверка ожидаемой итоговой ставки - {0}")
    public void checkRateStep(String rate){
        contributionsPage.compareResultRate(rate);
    }

    @Step("проверка ожидаемого пополнения - {0}")
    public void checkReplenishStep(String replenish){
        contributionsPage.compareResultReplenish(replenish);
    }

    @Step("проверка ожидаемой суммы к снятию - {0}")
    public void checkResultStep(String result){
        contributionsPage.compareResult(result);
    }
}
