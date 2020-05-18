package a_SingleTusks;

import java.util.*;

/* 
Круговой итератор
*/
// https://javarush.ru/quests/lectures/questcollections.level07.lecture04
// Перегрузи правильным образом метод iterator в классе SolutionV2.
//Напишите свой класс RoundIterator внутри SolutionV2, который будет итератором для списка SolutionV2.
//Итератор должен ходить по кругу по всем элементам.
public class Iterator_3701<T> extends ArrayList<T> {
    public static void main(String[] args) {
        Iterator_3701<Integer> list = original();
        Collections.addAll(list, 4, 5, 6, 7, 8, 9);
        System.out.println();
        list.forEach(v -> System.out.print(v + ", "));

        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            if (iterator.next() == 8) {
                iterator.remove();
                break;
            }
        }
        System.out.println();
        list.forEach(v -> System.out.print(v + ", "));
    }

    private static Iterator_3701<Integer> original() {
        Iterator_3701<Integer> list = new Iterator_3701<>();
        list.add(1);
        list.add(2);
        list.add(3);

        int count = 0;
        for (Integer i : list) {
            //1 2 3 1 2 3 1 2 3 1
            System.out.print(i + " ");
            count++;
            if (count == 10) {
                break;
            }
        }
        return list;
    }

    @Override
    public Iterator<T> iterator() {
        return new RoundIterator();
    }

    public class RoundIterator implements Iterator<T> {
        private Iterator<T> superIterator = Iterator_3701.super.iterator();

        @Override
        public boolean hasNext() {
            if (size() == 0)
                return false;
            if (!superIterator.hasNext())
                superIterator = Iterator_3701.super.iterator();
            return true;
        }

        @Override
        public T next() {
            return superIterator.next();
        }

        @Override
        public void remove() {
            superIterator.remove();
        }
    }

    public class RoundIteratorMy<E> implements Iterator<T> {
        int cursor; // указатель на индекс
        int lastRet = -1;
        int expectedModCount = modCount;

        @Override
        public boolean hasNext() {
            // size() - юзается внутренний метод коллекции
            if (cursor == size()) // если указатель не равен size
                cursor = 0; // переставляем курсор на начало
            return true;
        }

        @Override
        public T next() {
            checkForComodification(); // проверка на ConcurrentModificationException
            try {
                int i = cursor;
                T next = get(i); // получаем по внутреннему индексу коллекции
                lastRet = i; // указатель на текущий элемент
                cursor = i + 1; // сдвиг курсора на +1 к след элементу
                return next;
            } catch (IndexOutOfBoundsException e) {
                checkForComodification();
                throw new NoSuchElementException();
            }
        }

        @Override
        public void remove() { // remove без параметров должен удалять текущий элемент.
            if (lastRet < 0)
                throw new IllegalStateException();
            checkForComodification();

            try {
                Iterator_3701.this.remove(lastRet);
                cursor = lastRet;
                lastRet = -1;
                expectedModCount = modCount;
            } catch (IndexOutOfBoundsException ex) {
                throw new ConcurrentModificationException();
            }
        }

        final void checkForComodification() {
            if (modCount != expectedModCount)
                throw new ConcurrentModificationException();
        }
    }

    public class NormalIteratorMy<E> implements Iterator<T> {
        int cursor; // указатель на индекс
        int lastRet = -1;
        int expectedModCount = modCount;

        @Override
        public boolean hasNext() {
            return cursor != size(); // пока указатель не равен size
        }

        @Override
        public T next() {
            checkForComodification(); // проверка на ConcurrentModificationException
            try {
                int i = cursor;
                T next = get(i); // получаем по внутреннему индексу коллекции
                lastRet = i; // указатель на текущий элемент
                cursor = i + 1; // сдвиг курсора на +1 к след элементу
                return next;
            } catch (IndexOutOfBoundsException e) {
                checkForComodification();
                throw new NoSuchElementException();
            }
        }

        @Override
        public void remove() { // remove без параметров должен удалять текущий элемент.
            // странно но он удаляет как надо..
            if (lastRet < 0)
                throw new IllegalStateException();
            checkForComodification();

            try {
                Iterator_3701.this.remove(lastRet);
                cursor = lastRet;
                lastRet = -1;
                expectedModCount = modCount;
            } catch (IndexOutOfBoundsException ex) {
                throw new ConcurrentModificationException();
            }
        }

        final void checkForComodification() {
            if (modCount != expectedModCount)
                throw new ConcurrentModificationException();
        }
    }
}
