package calc;

import java.math.BigDecimal;

/**
 * Класс для рассчета кедита по ежемесячному платежу
 * @version 1.0
 * @autor Евгений Киселев
 */

public class PaymentCalculate extends Calculation{
    @Override
    BigDecimal getMonthlyPayment() {
        return null;
    }

    @Override
    int getCreditTerm() {
        return 0;
    }
}
