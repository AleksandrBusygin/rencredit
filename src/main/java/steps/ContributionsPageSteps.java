package steps;

import io.qameta.allure.Step;
import pages.ContributionsPage;


public class ContributionsPageSteps {

    ContributionsPage contributionsPage = new ContributionsPage();

    @Step("проверка соответствия заголовка страницы ожидаемому тексту - {0}")
    public void checkHeaderStep(String expectedHeader) {
        contributionsPage.compareHeader(expectedHeader);
    }

    @Step("выбран рублевый вклад")
    public void chooseRublesStep() {
        contributionsPage.rublesButtonClick();
    }

    @Step("выбранна суммма вклада - {0}")
    public void chooseAmountStep(Integer amounts) {
        contributionsPage.howMuchMoney(amounts);
    }

    @Step("вклад на срок - {0}")
    public void setTermStep(String term) {
        contributionsPage.chooseTermMethod(term);
    }

    @Step("ежемесячное пополнение - {0}")
    public void setReplenishmentStep(Integer replenishment) {
        contributionsPage.howMuchReplenish(replenishment);
    }

    @Step("выбрана \"Ежемесячная капитализация\"")
    public void checkBoxEveryMonthStep() {
        contributionsPage.everyMonth();
    }

    @Step("выбрано \"Частичное снятие\"")
    public void checkBoxPartialStep() {
        contributionsPage.partial();
    }

    @Step("проверка ожидаемых начислений - {0}")
    public void checkEarnedStep(String earned) {
        contributionsPage.compareResultEarned(earned);
    }

    @Step("проверка ожидаемой итоговой ставки - {0}")
    public void checkRateStep(String rate){ contributionsPage.compareResultRate(rate); }

    @Step("проверка ожидаемого пополнения - {0}")
    public void checkReplenishStep(String replenish){
        contributionsPage.compareResultReplenish(replenish);
    }

    @Step("проверка ожидаемой суммы к снятию - {0}")
    public void checkResultStep(String result){
        contributionsPage.compareResult(result);
    }

}