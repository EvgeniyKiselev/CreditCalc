package calc;

import data.CalculationResult;

import java.math.BigDecimal;

/**
 * Класс для рассчета кедита по ежемесячному платежу
 *
 * @version 1.0
 * @autor Евгений Киселев
 */

public class PaymentCalculate extends Calculation {
    CalculationResult calculationResult = new CalculationResult();

    @Override
    BigDecimal getMonthlyPayment() {
        return ((((BigDecimal.ONE.add(getMonthRate())).pow(getMonthsCreditTerm())).multiply(getMonthRate())).divide(
                (((BigDecimal.ONE.add(getMonthRate())).pow(getMonthsCreditTerm())).subtract(BigDecimal.ONE))))
                .multiply(calculationResult.getCreditAmount());
    }

    @Override
    int getMonthsCreditTerm() {
        return calculationResult.getCreditTerm() * 12;
    }
}
