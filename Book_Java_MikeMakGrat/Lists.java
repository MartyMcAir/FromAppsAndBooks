import java.util.ArrayList ;

class Lists 
{
	public static void main ( String[] args )
	{

        ArrayList<String> list = new ArrayList<String>() ;

        list.add( "Альфа" ) ;
        list.add( "Дельта" ) ;
	list.add( "Чарли" ) ;
	System.out.println( "Список: " + list ) ;

	System.out.println( "Заменяем: " + list.get(1) + "\n" ) ;
	list.set( 1, "Браво" ) ;

	list.forEach( (x) -> System.out.println("Элемент: " + x) ) ;

	} 
}