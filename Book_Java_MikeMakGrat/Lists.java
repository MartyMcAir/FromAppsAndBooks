import java.util.ArrayList ;

class Lists 
{
	public static void main ( String[] args )
	{

        ArrayList<String> list = new ArrayList<String>() ;

        list.add( "�����" ) ;
        list.add( "������" ) ;
	list.add( "�����" ) ;
	System.out.println( "������: " + list ) ;

	System.out.println( "��������: " + list.get(1) + "\n" ) ;
	list.set( 1, "�����" ) ;

	list.forEach( (x) -> System.out.println("�������: " + x) ) ;

	} 
}