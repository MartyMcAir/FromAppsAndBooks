package z_OOP_BiG_Pack.OOPintrfAnonumusCatDog_2408;

import java.util.List;

/* 
Как избежать Copy+Paste
*/
// https://javarush.ru/tasks/com.javarush.task.task24.task2407#discussion
// решил сам интересный пример
public class Solution {
    public static void main(String[] args) {
        // тут происходит примерно тоже что и в
        // https://javarush.ru/tasks/com.javarush.task.task24.task2407#discussion
        List<Pet> pet = Util.getPets();
        List<Sayable> pets = Util.convertPetToSayable(pet);
        Util.printDialog(pets);
    }
}
