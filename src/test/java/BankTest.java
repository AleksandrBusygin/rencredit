import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import steps.BaseSteps;
import steps.ContributionsPageSteps;
import steps.MainPageSteps;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class BankTest extends BaseSteps {

    ContributionsPageSteps contributionsPageSteps = new ContributionsPageSteps();

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                { 2000000, "6 месяцев", 30000, "6.50", "67772,63","150000","2217772,63"},
                { 50000, "9 месяцев", 1000, "6.75", "2765,46","8000","60765,46"},
                });
    }

    @Parameterized.Parameter
    public Integer amount;
    @Parameterized.Parameter(1)
    public String term;
    @Parameterized.Parameter(2)
    public Integer replenish;
    @Parameterized.Parameter(3)
    public String rate;
    @Parameterized.Parameter(4)
    public String earned;
    @Parameterized.Parameter(5)
    public String exReplenish;
    @Parameterized.Parameter(6)
    public String result;



    @Test
    @DisplayName("Калькулятор вкладов")
    public void testContributionCalculator() throws InterruptedException {
        contributionsPageSteps.chooseRublesStep();
        contributionsPageSteps.chooseAmountStep(amount);
        contributionsPageSteps.setTermStep(term);
        contributionsPageSteps.setReplenishmentStep(replenish);
        contributionsPageSteps.checkBoxEveryMonthStep();
        contributionsPageSteps.checkBoxPartialStep();
        Thread.sleep(3000);
        contributionsPageSteps.checkRateStep(rate);
        contributionsPageSteps.checkEarnedStep(earned);
        contributionsPageSteps.checkReplenishStep(exReplenish);
        contributionsPageSteps.checkResultStep(result);

    }



}
