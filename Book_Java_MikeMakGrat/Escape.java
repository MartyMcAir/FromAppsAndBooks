class Escape 
{
	public static void main( String[] args ) 
	{
        
		String header = "\n\tНЬЮ-ЙОРК ПРОГНОЗ НА 3 ДНЯ:\n";
        	header += "\n\tДень\t\tМакс\tМин\tОсадки\n";
		header += "\t---\t\t----\t---\t----------\n";

		String forecast = "\tВоскресенье\t68F\t48F\tЯсно\n";
		forecast += "\tПонедельник\t69F\t57F\tЯсно\n";
		forecast += "\tВторник\t\t71F\t50F\tОблачность\n";

		System.out.print( header + forecast );
	}
}

