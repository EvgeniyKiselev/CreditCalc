package calc;

import data.CalculationResult;

import java.math.BigDecimal;

/**
 * Основной класс для запуска приложения CreditCalc(Кредитный калькулятор)
 *
 * @version 1.0
 * @autor Евгений Киселев
 */

public class CreditCalc {
    public static void main(String[] args) {

        CalculationResult calculationResult = CalculationResult.getInstance();
        calculationResult.setRate(BigDecimal.valueOf(8.3));

        Calculation calculation = new Calculation();

        CreditTermCalculate creditTermCalculate = new CreditTermCalculate();
        PaymentCalculate paymentCalculate = new PaymentCalculate();

        //Этого блока не будет, просто нужно пока откуда то брать данные

        calculationResult.setInitialFee(new BigDecimal(1500000));
        calculationResult.setRealEstatePrice(new BigDecimal(7000000));

        calculationResult.setMonthlyPayment(new BigDecimal(50000));

        calculationResult.setCreditTerm(20);


        if (calculationResult.getRealEstatePrice().compareTo(calculationResult.getInitialFee()) > 0) {
            calculationResult.setCreditAmount(calculationResult.getRealEstatePrice()
                    .subtract(calculationResult.getInitialFee()));
        } else {
            throw new IllegalStateException("Первоначальный взнос больше/равен стоимости недвижимости");
        }
        System.out.println(paymentCalculate.getMonthlyPayment());

//должно быть примерно 47009,06
    }

}
