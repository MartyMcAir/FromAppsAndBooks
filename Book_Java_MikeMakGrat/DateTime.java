import java.time.LocalDateTime ;

class DateTime
{
  public static void main ( String [] args )
  {
    LocalDateTime date = LocalDateTime.now();
    System.out.println("\n������ " + date );

    date = date.withYear( 2018 );
    System.out.println("\n������ ������� ����� " + date );

    String fields = "\n���:\t\t\t" + date.getYear();
    fields += "\n�����:\t\t\t" + date.getMonth();
    fields += "\n����� ������:\t\t" + date.getMonthValue();

    fields += "\n���� ������:\t\t" + date.getDayOfWeek();
    fields += "\n���� ������:\t\t" + date.getDayOfMonth();
    fields += "\n���� � ����:\t\t" + date.getDayOfYear();

    fields += "\n���(0-23):\t\t" + date.getHour();
    fields += "\n������:\t\t\t" + date.getMinute();
    fields += "\n�������:\t\t" + date.getSecond();

    System.out.println( fields );
  } 
}