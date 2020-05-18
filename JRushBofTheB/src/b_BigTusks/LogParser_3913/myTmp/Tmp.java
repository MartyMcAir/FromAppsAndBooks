package b_BigTusks.LogParser_3913.myTmp;

public class Tmp {
    // Парсер логов (1)
    // Нашлась целая куча вариантов _ но почти нигде толком нет объяснений отличились:

    // https://javarush.ru/help/714 - решение с классом Record + SimpleDateFormat _ избыточное дублирование кода

    // самый норм пример
    // https://javarush.ru/help/28459 - с классом LogEntry _ который хранит все поля лога + SimpleDateFormat
    // Создай в папке четыре лог-файла со следующим содержимым (разделено табуляцией):
    //127.0.0.1	Amigo	30.08.2012 16:08:13	LOGIN	OK
    //192.168.1.1	Diego	30.08.2012 16:08:40	DOWNLOAD_PLUGIN	OK
    //127.0.0.1	Elly	11.12.2013 10:11:12	LOGIN	FAILED
    //файл2:
    //127.0.0.1	Amigo	30.08.2012 16:08:13	LOGIN	OK
    //192.168.1.1	Diego	30.08.2012 16:08:40	DOWNLOAD_PLUGIN	OK
    //192.168.1.1	Diego	30.01.2014 12:56:22	DOWNLOAD_PLUGIN	ERROR
    //127.0.0.1	Diego	14.11.2015 07:08:01	LOGIN	OK
    //файл3:
    //45.45.45.45	Test	29.2.2018 5:4:7	DOWNLOAD_PLUGIN	ERROR
    //файл4:
    //45.145.45.45	Test2	29.2.2120 05:04:07	DOWNLOAD_PLUGIN	ERROR
    // Самый корректный это все же регулярками выбирать отдельные компоненты,
    // т.к. имя пользователя может содержать несколько пробелов подряд

    // https://javarush.ru/help/27416 - тоже юзает LogEntry + Pattern.compile(..)  _ LogEntry - раздут
    // _ и кода в 2 раза больше чем у javarush.ru/help/28459

    // from https://curiousengineer.ru/2019/07/25/pishem-parser-logov/ :
    // https://github.com/SinyukKirill/LogParser/blob/master/src/com/LogParser.java
    // использует связку двух списков и в каждом методе повторный цикл перебирающий getListDate().. _ дублир код
}
