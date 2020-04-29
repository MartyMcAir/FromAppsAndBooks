package a_Tree.WideTree;

import java.io.Serializable;
import java.util.*;

/* 
Построй дерево(1)
*/
public class CustomTreeV3 extends AbstractList<String> implements Cloneable, Serializable {
    Entry<String> root, lastCurrent;
    Entry<String> findIs = null;

    // https://javarush.ru/quests/lectures/questcollections.level01.lecture15
    public static void main(String[] args) {
        List<String> list = new CustomTreeV3();

        for (int i = 1; i < 16; i++) {
            list.add(String.valueOf(i));
        }

        CustomTreeV3.Entry<String> entryByString = ((CustomTreeV3) list).getEntryByString("3");
//        System.out.println(entryByString);

//        ((CustomTree) list).getListChildesByEntry(entryByString).forEach(v -> System.out.println(v));

//        list.remove("3");
//        ((CustomTree) list).display(((CustomTree) list).getRoot(), "root");

//        list.add("20");
//        System.out.println(((CustomTree) list).getParent("20"));

        System.out.println("The list size is " + list.size());
        System.out.println("The expected parent is 3. The actual parent is " + ((CustomTreeV3) list).getParent("8"));
        System.out.println("The expected parent is null. The actual parent is " + ((CustomTreeV3) list).getParent("20"));

        list.remove("3");
        System.out.println("The expected parent is null. The actual parent is " + ((CustomTreeV3) list).getParent("8"));

        list.add("16");  // !--------------------
        System.out.println("The expected parent is 9. The actual parent is " + ((CustomTreeV3) list).getParent("16"));

        list.remove("4");
        list.remove("5");
        list.remove("6");
        System.out.println("Expected: true. Actual: " + list.add("20"));

        System.out.println(list.size());
        // !-------------------------
        System.out.println("The expected parent is 1. The actual parent is " + ((CustomTreeV3) list).getParent("20"));
    }

    int sizeCounter = 0, levelCounter = 1; // с каждым уровнем, кол-во элементов удваивается
    // сохраняем в список родителей, и при след добавлении _ проверка на то пуста ли очередь Parents
    Queue<Entry<String>> parentsQueue1 = new LinkedList<>();
    Queue<Entry<String>> parentsQueue2 = new LinkedList<>();
    boolean flag = true;

    public CustomTreeV3() { // валидатор потребовал пустй конструктор
        this.root = new Entry<>("theRoot");
        root.level = 0;
//        sizeCounter++;
    }

//    public Entry<String> getEntryByString(String s) {
//        Entry<String> res = null;
//        setFindByRecursive(root, s);
//        res = findIs;
//        findIs = null;
//        return res;
//    }

    public CustomTreeV3(Entry<String> root) {
        this.root = root;
        root.level = 0;
//        sizeCounter++;
    }

    static class Entry<T> implements Serializable {
        String elementName;
        int level;
        boolean isCompleteChildes;
        boolean availableToAddLeftChildren, availableToAddRightChildren;
        Entry<T> parent, leftChild, rightChild;

        public Entry(String elementName) {
            this.elementName = elementName;
            this.availableToAddLeftChildren = true;
            this.availableToAddRightChildren = true;
            this.isCompleteChildes = false;
        }

        public boolean isAvailableToAddChildren() {
            // это назвается дизъюнкция _ возвращающий дизъюнкцию полей
            return availableToAddLeftChildren || availableToAddRightChildren;
        }

        public String getElementName() {
            return elementName;
        }

        @Override
        public String toString() {
            String parentElementName = (parent != null) ? parent.getElementName() : "null";
            return "Entry{" +
                    "elementName= '" + this.elementName + '\'' +
                    ", level= " + level +
                    ", parent= " + parentElementName +
                    '}';
        }
    }

    // добавляет элементы дерева, в качестве параметра принимает имя элемента (elementName),
    // искать место для вставки начинаем слева направо.
    @Override
    public boolean add(String s) {
        lastCurrent = lastCurrent != null ? lastCurrent : root;
        Entry<String> newEntry = new Entry<>(s);
        newEntry.parent = lastCurrent;
        newEntry.level = levelCounter;

        sizeCounter++;

        if (flag) {
            parentsQueue1.add(newEntry); // при след добавлении, он будет parent
            setNewEntry(newEntry);

            if (!parentsQueue2.isEmpty() & lastCurrent == null) { // если очередь не пуста
                lastCurrent = parentsQueue2.poll();
            }
            if (parentsQueue2.isEmpty() & lastCurrent == null) {
                flag = false;
                lastCurrent = parentsQueue1.poll();
                levelCounter++;
            }
            return true;
        }

        if (!flag) {
            parentsQueue2.add(newEntry);
            setNewEntry(newEntry);

            if (!parentsQueue1.isEmpty() & lastCurrent == null) { // если очередь не пуста
                lastCurrent = parentsQueue1.poll();
            } else if (parentsQueue1.isEmpty() & lastCurrent == null) {
                flag = true;
                lastCurrent = parentsQueue2.poll();
                levelCounter++;
            }
            return true;
        }
        return false;
    }

    private void setNewEntry(Entry<String> newEntry) {
        if (lastCurrent.availableToAddLeftChildren) {
            lastCurrent.leftChild = newEntry;
            lastCurrent.availableToAddLeftChildren = false;
        } else if (lastCurrent.availableToAddRightChildren) {
            lastCurrent.rightChild = newEntry;
            lastCurrent.availableToAddRightChildren = false;
            lastCurrent.isCompleteChildes = true;
            lastCurrent = null;
        }
    }

    // возвращает имя родителя элемента дерева, имя которого было полученного в качестве параметра.
    public String getParent(String s) {
        String res = null;

        // Обход используя очередь _ валидатор не прошел пишет, что у 129го родитель должен быть 64ый
//        Queue<Entry<String>> queue = new LinkedList<>();
//        Entry<String> current = root;
//        while (current != null) {
//            if (current.getElementName().equals(s)) {
//                res = current.parent.getElementName();
//                break;
//            }
//
//            if (current.leftChild != null) {
//                queue.add(current.leftChild);
//            }
//            if (current.rightChild != null) {
//                queue.add(current.rightChild);
//            }
//            current = queue.poll();
//        }

        // рекурсивный подход к нахождению родителя _ валидатор прошел
        setFindByRecursive(root, s);
        res = (findIs != null) ? findIs.parent.getElementName() : null;
        findIs = null;
        return res;
        // Другие варианты
        // 1 и 2)Обходы в глубину, или ширину используя метку вершины, true значит посещена..
        // 3) Обход используя знания о том, что с каждым левелом кол-во элементов удваивается..
        //      (и зная это можно предположить, какие числа с левого миним и прав максим на каждом уровне)
    }

    public Entry<String> getParentByEntry(Entry entry) {
        Entry<String> res = null;
        // Обход используя очередь _ валидатор не прошел пишет, что у 129го родитель должен быть 64ый
        Queue<Entry<String>> queue = new LinkedList<>();
        Entry<String> current = root;
        while (current != null) {
            if (current.getElementName().equals(entry.getElementName())) {
                res = current.parent;
                break;
            }
            if (current.leftChild != null) {
                queue.add(current.leftChild);
            }
            if (current.rightChild != null) {
                queue.add(current.rightChild);
            }
            current = queue.poll();
        }
        return res;
    }

    public Entry<String> getEntryMaxLeft() {
        Entry<String> current = root, last = null;
        while (current != null) {
            last = current;
            current = last.leftChild;
        }
        return last;
    }

    @Override
    public boolean remove(Object o) {
        if (!(o instanceof String))
            throw new UnsupportedOperationException();

        String entryStr = (String) o;
        Entry<String> entryByString = getEntryByString(entryStr);

        // подчищяем очереди от удаляемых
        List<Entry<String>> listChildesByEntry = getListChildesByEntry(entryByString); // список под узлов, что следует удалить
        sizeCounter = sizeCounter - listChildesByEntry.size(); // вычитаем из size ровно столько, сколь удалили

        if (!parentsQueue1.isEmpty()) {
            for (int i = 0; i < listChildesByEntry.size(); i++) {
                Iterator<Entry<String>> iterator = parentsQueue1.iterator();
                while (iterator.hasNext()) {
                    if (iterator.next().getElementName().equals(listChildesByEntry.get(i).getElementName()))
                        iterator.remove(); // от ConcurrentModificationException
                }
            }
        }
        if (!parentsQueue2.isEmpty()) {
            for (int i = 0; i < listChildesByEntry.size(); i++) {
                Iterator<Entry<String>> iterator2 = parentsQueue2.iterator();
                while (iterator2.hasNext()) {
                    if (iterator2.next().getElementName().equals(listChildesByEntry.get(i).getElementName()))
                        iterator2.remove();
                }
            }
        }
        // проверяем last переменную, на предмет необходимых изменений
        if (lastCurrent != null) {
            for (int i = 0; i < listChildesByEntry.size(); i++) {
                if (lastCurrent.getElementName().equals(listChildesByEntry.get(i).getElementName())) {
                    if (flag & !parentsQueue2.isEmpty()) {
                        lastCurrent = parentsQueue2.poll();
                    } else if (!flag & !parentsQueue1.isEmpty()) {
                        lastCurrent = parentsQueue1.poll();
                    } else { // если все очереди пусты
                        lastCurrent = getEntryMaxLeft(); // ставим сам крайний лев. узел
                    }
                }
            }
        }

        // Отсоединяем удаляемый узел от родителя
        Entry<String> parentByEntry = getParentByEntry(entryByString);
        parentByEntry.isCompleteChildes = false;
        if (parentByEntry.leftChild != null) {
            if (parentByEntry.leftChild.getElementName().equals(entryStr)) {
                parentByEntry.leftChild = null;
                parentByEntry.availableToAddLeftChildren = true;
                return true;
            }
        }
        if (parentByEntry.rightChild != null) {
            if (parentByEntry.rightChild.getElementName().equals(entryStr)) {
                parentByEntry.rightChild = null;
                parentByEntry.availableToAddRightChildren = true;
                return true;
            }
        }

        return false;
    }

    public List<Entry<String>> getListChildesByEntry(Entry<String> entry) {
        List<Entry<String>> list = new ArrayList<>();

        Queue<Entry<String>> queue = new LinkedList<>();
        while (entry != null) {
            list.add(entry);
            if (entry.leftChild != null)
                queue.add(entry.leftChild);
            if (entry.rightChild != null)
                queue.add(entry.rightChild);
            entry = queue.poll();
        }
        return list;
    }

    public Entry<String> getEntryByString(String s) {
        Entry<String> res = null;
        setFindByRecursive(root, s);
        res = findIs;
        findIs = null;
        return res;
    }

    public void display(Entry<String> entry, String leftOrRight) {
        System.out.println(leftOrRight + entry);
        if (entry.leftChild != null)
            display(entry.leftChild, "left: ");
        if (entry.rightChild != null)
            display(entry.rightChild, "right: ");
    }

    private Entry<String> setFindByRecursive(Entry<String> stringEntry, String find) {
//        Entry<String> res = null;
        if (stringEntry != null) {
            boolean equals = stringEntry.getElementName().equals(find);
            if (equals) {
                findIs = stringEntry;
            } else {
                setFindByRecursive(stringEntry.leftChild, find);
                setFindByRecursive(stringEntry.rightChild, find);
            }
        }
        return null; // если не найдено
    }

    public Entry<String> getRoot() {
        return root;
    }

    // возвращает текущее количество элементов в дереве.
    @Override
    public int size() {
        return sizeCounter;
    }

    /////////////////////////////////////////
    @Override
    public void add(int index, String element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String remove(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(int index, Collection<? extends String> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<String> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    @Override
    protected void removeRange(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String get(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String set(int index, String element) {
        throw new UnsupportedOperationException();
    }
}
