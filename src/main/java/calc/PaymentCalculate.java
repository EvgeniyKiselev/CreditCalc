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
    CalculationResult calculationResult = CalculationResult.getInstance();

    public BigDecimal getMonthlyPayment() {
        return ((((BigDecimal.ONE.add(super.getMonthRate())).pow(this.getMonthsCreditTerm())).multiply(super.getMonthRate())).divide(
                (((BigDecimal.ONE.add(super.getMonthRate())).pow(this.getMonthsCreditTerm())).subtract(BigDecimal.ONE))))
                .multiply(calculationResult.getCreditAmount());
    }

    public int getMonthsCreditTerm() {
        return calculationResult.getCreditTerm() * 12;
    }
}
