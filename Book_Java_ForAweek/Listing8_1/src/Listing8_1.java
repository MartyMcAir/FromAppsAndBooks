// абстрактный суперкласс
abstract class Animals{
    String name;
    String sound;
    int weight;
    // конструктор класса
    Animals(String nm, String snd, int wt){
        name=nm;
        sound=snd;
        weight=wt;
    }
    // абстрактный метод
    abstract void doAnimal();
}
// подкласс (кошка)
class Cat extends Animals{
    // конструктор
    Cat(String nm, String snd, int wt){
        super(nm,snd,wt);
    }
    // описание метода, наследованного из суперкласса
    @Override
    void doAnimal(){
        System.out.println("Животное "+name+" весит примерно "+weight+"кг, издает звук "+sound);
        System.out.println("Это животное выполняет действие:");
        System.out.println("Ловит мышей.");
    }
}
// подкласс (собака)
class Dog extends Animals{
    // конструктор
    Dog(String nm, String snd, int wt){
        super(nm,snd,wt);
    }
    // описание метода, наследованного из суперкласса
    @Override
    void doAnimal(){
        System.out.println("Животное "+name+" весит примерно "+weight+"кг, издает звук "+sound);
        System.out.println("Это животное выполняет действие:");
        System.out.println("Охраняет дом и хозяина.");
    }
}
public class Listing8_1 {

    public static void main(String[] args) {
        /*
		for(i=0; i<5; i++; ){
		Cat objCat[i] = new Cat("Мару","Му-му-му",3);
		objCat[i].doAnimal();
	} */
        // объект кошка Маруся подкласса Cat
        Cat objCat=new Cat("Маруся","Мур-мур-мур",3);
        // объект пес Тузик подкласса Dog
        Dog objDog1=new Dog("Тузик","Гав-гав-гав",9);
        // объект пес Барбос подкласса Dog
        Dog objDog2=new Dog("Барбос","Р-р-р-р-р",15);
        // метод объекта подкласса Cat
        objCat.doAnimal();
        // метод первого объекта подкласса Dog
        objDog1.doAnimal();
        // метод второго объекта подкласса Dog
        objDog2.doAnimal();
    }
}
