// Описание пользовательского класса
class MyFields{
	// Поля класса
	int data;
	char letter;
}
// Описание класса с главным методом программы
// Шаблон описания автоматически создается средой NetBeans
class Listing6_1{
	// Главный метод
	public static void main(String[] args){
	// Создаем объект класса MyFields
	MyFields demo = new MyFields();
	// Присваиваем значения полям
	demo.data = 1234;
	demo.letter = 'B';
	// Выводим значения полей на печать
	System.out.println("Число: "+demo.data);
System.out.println("Буква: "+demo.letter);
	}
}