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
> **UICheckForFirstWindow**
> **UICalcWindow**
> **UICalculationResult**
> **UIAllCalculationWindow**

## <span style="color: orange"> Configuration:
Класс для хранения и использования настроек и коннекта к бд<br/>
поля: <br/>
>**hasConnect (boolean)**<br/>
**hasTable (boolean)**<br/>

## <span style="color: orange"> DBConnect:
Класс с запросами к бд<br/>
> **checkDBConnect()** - *проверяет коннект к БД, присваивает true/false Configuration.hasConnect* <br/>
>**createTable ()** - * если Configuration.hasConnect == true вызывает checkTableExists(), если таблца есть возвращает true, если нет - создает и возвращает true сприсваиваением значения Configuration.hasTable* <br/>
> **checkTableExists()** - *проверяет есть ли таблица, присваивает true/false Configuration.hasTable* <br/>
> **getCurrentId()** - *если таблица пустая - генерит первый id, если в таблице есть записи - берет последний id и добавляет инкремент* <br/>
> **insertCalculation()** - *записывает в таблицу новый результат вычислений калькулятора* <br/>

## <span style="color: orange"> DBQueries:
Класс с запросами к бд<br/>
> **insertCalculation()** - *записывает в таблицу новый результат вычислений калькулятора* <br/>
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
<br>
**+ здесь же методы расчета и вызов запроса к бд, который делает запись в таблице**

## <span style="color: orange"> UICheckForFirstWindow:
Класс , который выбирает какое окно выводить первым<br/>
> **проверяем Configuration.hasConnect**<br>
> *-если false выводим окно UINoDBConnect*<br>
> *-если true выводим окно UICalcWindow*<br>


## <span style="color: orange"> UINoDBConnect:
Окно с сообщением о том, что нет возможности сохранить рассчет<br/>
> *Окно с сообщением:* **В данный момент нет возможности сохранить результат рассчета
> , но можно произвести рассчет**<br>
> *кнопка:* **рассчитать ипотеку** - *вызывает UICalcWindow*
> *кнопка:* *я терпелив, я подожду** - *закрывает программу*


## <span style="color: orange"> UICalcWindow:
Окно калькулятора<br/>
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


## <span style="color: orange"> UICalculationResult
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