package calc;

import java.math.BigDecimal;

/**
 * Класс для рассчета кедита по ежемесячному платежу
 * @version 1.0
 * @autor Евгений Киселев
 */

public class PaymentCalculate extends Calculation{

    public static void CalculateMonthlyPayment(){

    }

    @Override
    int getCreditTerm() {
        return 0;
    }
}
