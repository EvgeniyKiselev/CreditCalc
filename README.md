# ТЗ Калькулятора ипотеки

## 1я версия:

### тип данных для вычислений - <span style="color: orange"> long 
### Классы:

## <span style="color: orange">CreditCalc:
Основной класс программы с точкой входа<br/>
Последовательность вызовов<br/>
>**Проверка подключения к БД** <br/><br/> - *до запуска калькулятора вызывает 
> DBConnect.checkDBConnect(), если Configuration.hasConnect == true вызывает DBConnect.createTable(). Если
> коннекта нет, то присваивает Configuration.hasConnect = false* <br/>
> <br/>
>**Проверка Configuration.hasConnect** <br/> - *если true вызывает отрисовывание калькулятора, 
> если false выводит сообщение, 
> что можно произвести рассчет, но сохранить информацию не удастся* <br/>
> <br/>
> **Вызов Rate.getRate()**<br/>
> **UICalcTable**
> **UICalcWindow**
> **UICalculationResult**
> **UIAllCalculationWindow**

## <span style="color: orange"> Configuration:
Класс для хранения и использования настроек и коннекта к бд<br/>
поля: <br/>
>**hasConnect (boolean)**<br/>


## <span style="color: orange"> DBConnect:
Класс с запросами к бд<br/>
> **checkDBConnect()** - *проверяет коннект к БД, присваивает true/false Configuration.hasConnect* <br/>
>**createTable ()** - * если Configuration.hasConnect == true вызывает checkTableExists(), если таблца есть - ичего не делает, 
> если нет - создает <br/>
> **checkTableExists()** - *проверяет есть ли таблица, если ее нет - создает* <br/>
> **insertCalculation()** - *записывает в таблицу новый результат вычислений калькулятора* <br/>

## <span style="color: orange"> DBQueries:
Класс с запросами к бд<br/>
> **insertCalculation()** - *записывает в таблицу новый результат вычислений калькулятора, проверять, что все необходимые поля есть* <br/>
> **getCalculationById()** - *возвращает результаты рассчета по id* <br/>
> **getAllCalculations()** - *возвращает все результаты рассчета* <br/>
> **deleteCalculationById()** - *удаляет запись с результатами рассчета по id* <br/>

## <span style="color: orange"> Rate:
Класс с http запросом, который берет ставку из интернета<br/>
> **getRate()** - *отправляет запрос и присваивает значение CalculationResult.rate* <br/>

## <span style="color: orange"> CalculationResult:
поля: <br/>
>**calculationId (long)** - *id рассчета* <br/>
**creditAmount (BigDecimal)** - *сумма кредита* <br/>
**monthlyPayment (BigDecimal)** - *ежемесячный платеж* <br/>
**rate (BigDecimal)** - *ставка* <br/>
**realEstatePrice (BigDecimal)** - *стоимость недвижимости* <br/>
**initialFee (BigDecimal)** - *первоначальный взнос* <br/>
**creditTerm (int)** - *срок кредита* <br>

## <span style="color: orange"> abstract Calculation:
методы: <br/>
>**getCreditAmount (BigDecimal)** - *сумма кредита* <br/>
**getMonthlyPayment (BigDecimal)** - *ежемесячный платеж* <br/>
**getRate (BigDecimal)** - *ставка* <br/>
**getCreditTerm (int)** - *срок кредита* <br>

## <span style="color: orange"> CalculateByPayment extends Calculation:
методы static(сохраняют результат в CalculationResult): <br/>
>**метод расчета по ежемесячному платежу** <br/>

> ## <span style="color: orange"> CalculateByTime extends Calculation:
методы static(сохраняют результат в CalculationResult): <br/>
>**метод расчета по сроку кредита** <br/>

## <span style="color: orange"> UICalcTable:
первое окно<br/>
> проверяем Configuration.hasConnect, если есть коннект - не делает ничего, если нет выводит сообщение: **В данный момент нет возможности сохранить результат рассчета
> , но можно произвести рассчет**<br>
> если есть коннект отрисовывает таблицу с рассчетами, если нет таблица пустая
> кнопки: **новый рассчет** - открывает UICalcWindow

## <span style="color: orange"> UICalcWindow:
Окно калькулятора<br/>
> проверяем Configuration.hasConnect, если есть коннект - не делает ничего, если нет выводит сообщение: **В данный момент нет возможности сохранить результат рассчета
> , но можно произвести рассчет**<br>
> кнопки: **Рассчет по ежемесячному платежу** и **Рассчет по сроку кредита**<br/>
> **Рассчет по ежемесячному платежу** - *установлена по дефолту*
><br/>
> *поля ввода:*<br/>
> стоимость недвижимости<br/>
> первоначальный взнос<br/>
> ежемесячный платеж<br/>
> 
> если нажата кнопка **Рассчет по сроку кредита**, то страница выглядит так:
> <br/>
> *поля ввода:*<br/>
> стоимость недвижимости<br/>
> срок кредита<br/>
> первоначальный взнос<br/><br/>
> > *кнопка **Рассчитать** раздизейбливается после заполнения обязателбных полей, 
> вызывает сохранение введенных значений и рассчет и открывает 
> страницу UICalculationResult*<br/>


## <span style="color: orange"> UICalculationResult extends UICalcTable
таблица:
> стоимость недвижимости<br/>
> первоначальный взнос<br/>
> срок кредита<br/>
> ежемесячный платеж<br/>
> ставка<br/>
> сумма кредита<br/><br/>
> кнопки:<br/>
> сохранить рассчет<br/>
> удалить рассчет(задизеблена пока он не сохранен)<br/>
> показать все сохраненные рассчеты - *вызывает UIAllCalculationWindow*<br/><br/>
> назад<br/>
> закрыть<br/>

## <span style="color: orange"> UIAllCalculationWindow:
Окно с выводом всех рассчетов из бд<br/>
перед открытием страницы вызывается DBQueries.getAllCalculations
кнопки:<br/>
> сохранить как<br/>
> назад<br/>
> закрыть<br/>