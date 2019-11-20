import java.time.LocalDateTime ;

class DateTime
{
  public static void main ( String [] args )
  {
    LocalDateTime date = LocalDateTime.now();
    System.out.println("\nСейчас " + date );

    date = date.withYear( 2018 );
    System.out.println("\nТеперь текущее время " + date );

    String fields = "\nГод:\t\t\t" + date.getYear();
    fields += "\nМесяц:\t\t\t" + date.getMonth();
    fields += "\nНомер месяца:\t\t" + date.getMonthValue();

    fields += "\nДень недели:\t\t" + date.getDayOfWeek();
    fields += "\nДень месяца:\t\t" + date.getDayOfMonth();
    fields += "\nДень в году:\t\t" + date.getDayOfYear();

    fields += "\nЧас(0-23):\t\t" + date.getHour();
    fields += "\nМинута:\t\t\t" + date.getMinute();
    fields += "\nСекунда:\t\t" + date.getSecond();

    System.out.println( fields );
  } 
}