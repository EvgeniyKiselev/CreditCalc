package calc;

import data.CalculationResult;

import java.math.BigDecimal;

/**
 * Класс для рассчета кедита по сроку кредита
 *
 * @version 1.0
 * @autor Евгений Киселев
 */

public class CreditTermCalculate extends Calculation {
    CalculationResult calculationResult = CalculationResult.getInstance();

    public static void CalculateCreditTerm() {
    }

    public BigDecimal getMonthlyPayment() {
        return calculationResult.getMonthlyPayment();
    }

    public int getMonthsCreditTerm() {
        return 0;
    }
}
