package calc;

import java.math.BigDecimal;

/**
 * Класс для рассчета кедита по сроку кредита
 * @version 1.0
 * @autor Евгений Киселев
 */

public class CreditTermCalculate extends Calculation{
    @Override
    BigDecimal getMonthlyPayment() {
        return null;
    }

    @Override
    int getCreditTerm() {
        return 0;
    }
}
