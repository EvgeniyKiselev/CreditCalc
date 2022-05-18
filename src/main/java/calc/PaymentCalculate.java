package calc;

import data.CalculationResult;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

/**
 * Класс для рассчета кедита по ежемесячному платежу
 *
 * @version 1.0
 * @autor Евгений Киселев
 */

public class PaymentCalculate extends Calculation {
    CalculationResult calculationResult = CalculationResult.getInstance();

    public BigDecimal getMonthlyPayment() {
        BigDecimal iPlusOnePowMonths = (BigDecimal.ONE.add(getMonthRate())).pow(getMonthsCreditTerm());
        calculationResult.setMonthlyPayment((((iPlusOnePowMonths).multiply(getMonthRate()))
                .divide((iPlusOnePowMonths.subtract(BigDecimal.ONE)), RoundingMode.UP))
                .multiply(calculationResult.getCreditAmount(), MathContext.DECIMAL32));
        return calculationResult.getMonthlyPayment();
    }

    public int getMonthsCreditTerm() {
        return calculationResult.getCreditTerm() * 12;
    }
}
