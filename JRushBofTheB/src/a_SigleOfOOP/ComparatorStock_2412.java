package a_SigleOfOOP;

import java.text.ChoiceFormat;
import java.text.Format;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/* 
Знания - сила!
*/
// https://javarush.ru/tasks/com.javarush.task.task24.task2412#discussion
// решил но есть одна загвостка с change - не сразу увидел и MessageFormat - не доконца понял

// 1. В методе sort написать компаратор для Stock:
//1.1. Первичная сортировка по name в алфавитном порядке
//1.2. Вторичная сортировка по дате без учета часов, минут, секунд (сверху самые новые), потом по прибыли от положительных к отрицательным
//
//... open 125,64 and last 126,74 - тут прибыль = 126,74-125,64
//... open 125,64 and last 123,43 - тут прибыль = 123,43-125,64
//
//2. Разобраться с *Format-ами и исправить IllegalArgumentException.
//
//Подсказка - это одна строчка.
//
//Пример вывода:
//Fake Apple Inc. AAPL | 17-11-2025 open 125,64 and last 123,43
//Fake Applied Materials, Inc. AMAT | 15-01-1983 change 0,26
//
//Требования:
//•	Во время работы программы не должны возникать исключения.
//•	Программа должна выводить данные на экран.
//•	Метод sort должен корректно сортировать полученный список в соответствии с условием задачи.
//•	Класс Solution.Stock должен быть публичным.
public class ComparatorStock_2412 {
    public static void main(String[] args) {
        List<Stock> stocks = getStocks(); // получаем заполненный список
        sort(stocks);
        Date actualDate = new Date();
        printStocks(stocks, actualDate);
    }

    public static void printStocks(List<Stock> stocks, Date actualDate) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

        // http://khpi-iip.mipk.kharkiv.edu/library/extent/prog/inter/choiceFormat.html
        // https://javarush.ru/groups/posts/590-klass-messageformat

        // пределы значений, при которых будет меняться вывод строк
        double[] filelimits = {0d, actualDate.getTime()}; // диопазон чисел  ChoiceFormat'a

        // это то что будет подставлять в паттерн подбора вывода _ поэлементно массива
        // В скобках задается позиция объекта начиная с 0, а также тип форматирования, если таковой имеется.
        // 4 это последн элемент _ 1 это имя _ 2 это след элемент open - в {2} -подставляется число открытия
        String[] filepart = {"change {4}", "open {2} and last {3}"}; // варианты строк, которые могут быть использованы

        // о в зависимости от значения переменной будет выбираться необходимый текст.
        // Своего рода реализация оператора if...else, только с помощью класса ChoiceFormat.
        ChoiceFormat fileform = new ChoiceFormat(filelimits, filepart);

        // Если объект не нуждается в форматировании, то в массиве Format[] testFormats записывается null.
        Format[] testFormats = {null, null, dateFormat, fileform};

//        Format[] testFormats = {null, dateFormat, fileform}; // нехватало 3го элемента в конструкторе Stock же их 4!
        // в конструкторе MessageFormat(..) шаблон строки
        MessageFormat pattform = new MessageFormat("{0}   {1} | {5} {6}");

        // Устанавливает форматы, чтобы использовать для элементов формата в ранее строка установленного образца
        // говорим объекту MessageFormat pattform, что для всех индексов в шаблоне строки надо использовать
        // форматирование, определенное в массиве Format[] testFormats.
        pattform.setFormats(testFormats);

        for (Stock stock : stocks) {
            String name = ((String) stock.get("name"));
            String symbol = (String) stock.get("symbol");
            double open = !stock.containsKey("open") ? 0 : ((double) stock.get("open"));
            double last = !stock.containsKey("last") ? 0 : ((double) stock.get("last"));
            double change = !stock.containsKey("change") ? 0 : ((double) stock.get("change"));
            Date date = (Date) stock.get("date");
            // передаются аргументами шаблон строки и, собственно, объекты, которые будут вставлены в места,
            // ограниченные скобками {}. В скобках задается позиция объекта начиная с 0,
            // а также тип форматирования, если таковой имеется.
            Object[] testArgs = {name, symbol, open, last, change, date, date.getTime()};
            System.out.println(pattform.format(testArgs));
        }
    }

    public static void sort(List<Stock> list) {
        // list хранит Stock объект, а у того 2 конструктора
        // 2 String и 2 Double или
        // 2 String и 1 double и 1 Date
        // полей, getter'ов и сеттеров в нем нет
        // НО Stock extends HashMap<String, Object> - а значит и его методы
        // и заполняет ключ = значение: put("name", name);
        list.sort(new Comparator<Stock>() {
            public int compare(Stock stock1, Stock stock2) {
                ////////
                int res = 0;
                // по алфавиту
                int resName = stock1.get("name").toString().compareTo(stock2.get("name").toString());
                // по дате сначала самые новые
                int resDate = ((Date) stock2.get("date")).compareTo((Date) stock1.get("date"));
                int resProfit = 0;

                if (resName != 0) { // если по имени сортировка НЕ complete
                    res = resName;
                } else if (resDate == 0) { // если по дате сортировка complete
                    Double profit1;   // по прибыли от положителных к отрицат
                    Double profit2;
                    Object open1 = stock1.get("open");
                    Object open2 = stock2.get("open");

                    if (open1 == null) {
                        profit1 = (Double) stock1.get("change");
                    } else {
                        profit1 = (Double) stock1.get("last") - (Double) open1;
                    }
                    if (open2 == null) {
                        profit2 = (Double) stock2.get("change");
                    } else {
                        profit2 = (Double) stock2.get("last") - (Double) open2;
                    }
                    res = resProfit = Double.compare(profit2, profit1);
                } else { // иначе отправляем результ даты
                    res = resDate;
                }
                return res;
                ////////
            }
        });
    }

    public static class Stock extends HashMap<String, Object> {
//        private String name, symbol;
//        private double open, last, change;
//        private Date date;

        public Stock(String name, String symbol, double open, double last) {
//            this.name = name;
            put("name", name);
            put("symbol", symbol);
            put("open", open);
            put("last", last);
            put("date", getRandomDate(2020));
//            put("date", new Date());
        }

        public Stock(String name, String symbol, double change, Date date) {
            put("name", name);
            put("symbol", symbol);
            put("date", date);
            put("change", change);
        }
    }

    public static List<Stock> getStocks() {
        List<Stock> stocks = new ArrayList<>();

        stocks.add(new Stock("Fake Apple Inc.", "AAPL", 125.64, 123.43));
//        stocks.add(new Stock("Fake Apple Inc.", "AAPL", 125.64, 300.43));
        stocks.add(new Stock("Fake Cisco Systems, Inc.", "CSCO", 25.84, 26.3));
        stocks.add(new Stock("Fake Google Inc.", "GOOG", 516.2, 512.6));
        stocks.add(new Stock("Fake Intel Corporation", "INTC", 21.36, 21.53));
        stocks.add(new Stock("Fake Level 3 Communications, Inc.", "LVLT", 5.55, 5.54));
        stocks.add(new Stock("Fake Microsoft Corporation", "MSFT", 29.56, 29.72));

        stocks.add(new Stock("Fake Nokia Corporation (ADR)", "NOK", .1, getRandomDate()));
        stocks.add(new Stock("Fake Oracle Corporation", "ORCL", .15, getRandomDate()));
        stocks.add(new Stock("Fake Starbucks Corporation", "SBUX", .03, getRandomDate()));
        stocks.add(new Stock("Fake Yahoo! Inc.", "YHOO", .32, getRandomDate()));
        stocks.add(new Stock("Fake Applied Materials, Inc.", "AMAT", .26, getRandomDate()));
        stocks.add(new Stock("Fake Comcast Corporation", "CMCSA", .5, getRandomDate()));
        stocks.add(new Stock("Fake Sirius Satellite", "SIRI", -.03, getRandomDate()));

        return stocks;
    }

    public static Date getRandomDate() {
        return getRandomDate(1970);
    }

    public static Date getRandomDate(int startYear) {
        int year = startYear + (int) (Math.random() * 30);
        int month = (int) (Math.random() * 12);
        int day = (int) (Math.random() * 28);
        GregorianCalendar calendar = new GregorianCalendar(year, month, day);
        return calendar.getTime();
    }
}

