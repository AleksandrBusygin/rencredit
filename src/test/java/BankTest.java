import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import steps.BaseSteps;
import steps.ContributionsPageSteps;
import steps.MainPageSteps;

import java.util.Collections;

public class BankTest extends BaseSteps {

    @Test
    @DisplayName("Калькулятор вкладов, тест первый")
    public void firstTestContributionCalculator() {
        MainPageSteps mainPageSteps = new MainPageSteps();
        ContributionsPageSteps contributionsPageSteps = new ContributionsPageSteps();

        mainPageSteps.selectCalculator();
        contributionsPageSteps.checkHeaderStep("Рассчитайте доходность по вкладу");
        contributionsPageSteps.chooseRublesStep();
        contributionsPageSteps.chooseAmountStep("2000000");
        contributionsPageSteps.setTermStep("6 месяцев");
        contributionsPageSteps.setReplenishmentStep("30000");
        contributionsPageSteps.chooseAdditionalParamStep(Collections.singletonList("Ежемесячная капитализация, Частичное снятие"));
        contributionsPageSteps.checkRateStep("6.50");
        contributionsPageSteps.checkEarnedStep("67 772,63");
        contributionsPageSteps.checkReplenishStep("150 000");
        contributionsPageSteps.checkResultStep("2 217 772,63");
    }

    @Test
    @DisplayName("Калькулятор вкладов, тест второй")
    public void secondTestContributionCalculator() {
        MainPageSteps mainPageSteps = new MainPageSteps();
        ContributionsPageSteps contributionsPageSteps = new ContributionsPageSteps();

        mainPageSteps.selectCalculator();
        contributionsPageSteps.checkHeaderStep("Рассчитайте доходность по вкладу");
        contributionsPageSteps.chooseRublesStep();
        contributionsPageSteps.chooseAmountStep("50000");
        contributionsPageSteps.setTermStep("9 месяцев");
        contributionsPageSteps.setReplenishmentStep("1000");
        contributionsPageSteps.chooseAdditionalParamStep(Collections.singletonList("Ежемесячная капитализация"));
        contributionsPageSteps.checkRateStep("6.75");
        contributionsPageSteps.checkEarnedStep("2 765,46");
        contributionsPageSteps.checkReplenishStep("8 000");
        contributionsPageSteps.checkResultStep("60 765,46");
    }


}
