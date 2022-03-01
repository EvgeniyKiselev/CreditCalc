#<p style="text-align: center;"> ТЗ Калькулятора ипотеки</p>

## 1я версия:

### тип данных для вычислений - <span style="color: orange"> long 
### <p style="text-align: center;">Классы:</p>

###<p style="text-align: center;">CreditCalc:</p>
Основной класс программы с точкой входа<br/>
Последовательность вызовов<br/>
>**Проверка подключения к БД** <br/>
>**Проверка наличия таблицы в БД** <br/>
>**Генерация id и присваивание id объекту класса** *CalculationResult* <br/>

###<p style="text-align: center;">Configuration:</p>
Класс для хранения и использования настроек и коннекта к бд 

###<p style="text-align: center;">DBQueries:</p>
Класс с запросами к бд<br/>
>**createTable ()** - *вызывает checkTableExists(), если таблца есть ничего не делает, если нет - создает* <br/>
> **checkTableExists()** - *проверяет есть ли таблица* <br/>
> **getCurrentId()** - *если таблица пустая - генерит первый id, если в таблице есть записи - берет последний id и добавляет инкремент* <br/>
> **insertCalculation()** - *записывает в таблицу новый результат вычислений калькулятора* <br/>

###<p style="text-align: center;">CalculationResult:</p>
поля: <br/>
>**calculationId (long)** - *id рассчета* <br/>
**creditAmount (long)** - *сумма кредита* <br/>
**monthlyPayment (long)** - *ежемесячный платеж* <br/>
**rate (double)** - *ставка* <br/>
**realEstatePrice (long)** - *стоимость недвижимости* <br/>
**initialFee (long)** - *первоначальный взнос* <br/>
**creditTerm (int)** - *срок кредита* <br>
