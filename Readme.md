
## Usage

```
java -jar target/jptest-1.0-SNAPSHOT.jar eu.jedrzej.jptest.input.Main
```

#### Dividend yield
Example for calculation of dividend yield
```
$>dy POP 10
Dividend yield: 0.8
```


#### P/E ratio
Example for P to E ratio calculations
```
$>pe POP 10
P to E ratio: 1.2500
$>pe GIN 10
P to E ratio: 5.0000
```


#### Volume weighted stock price and transaction recording
Following example records two transactions and calculates the volume weighted price
```
$>record 1 buy 2
StockTransaction{buyIndicator=true, tradePrice=2, quantity=1, dateTime=2018-04-03T00:58:09.811+02:00}
$>record 2 sell 1
StockTransaction{buyIndicator=false, tradePrice=1, quantity=2, dateTime=2018-04-03T00:58:18.773+02:00}
$>vwsp
Volume Weighted Stock Price: 1.3333
```

#### Stocks index calculator
This example calculates GBCE stocks index
```
$>index
BGCE index: 122474
```

### Exit
```
CTRL + D
```