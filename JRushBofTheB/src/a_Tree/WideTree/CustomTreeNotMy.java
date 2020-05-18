package a_Tree.WideTree;

import java.io.Serializable;
import java.util.*;

// https://github.com/XFNeo/JavaRushTasks/blob/master/4.JavaCollections/src/com/javarush/task/task20/task2028/CustomTree.java
public class CustomTreeNotMy extends AbstractList<String> implements Cloneable, Serializable {
    Entry<String> root;
    private List<Entry> list = new ArrayList<>();

    public CustomTreeNotMy() {
        root = new Entry<>("0");
        list.add(root);
    }

    public String get(int index) {
        throw new UnsupportedOperationException();
    }

    public String set(int index, String element) {
        throw new UnsupportedOperationException();
    }

    public void add(int index, String element) {
        throw new UnsupportedOperationException();
    }

    public String remove(int index) {
        throw new UnsupportedOperationException();
    }

    public List<String> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    protected void removeRange(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    public boolean addAll(int index, Collection<? extends String> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean add(String s) {
        Entry newEntry = new Entry(s);
        boolean availableAdd = false;
        for (Entry entry : list) {
            if (entry.isAvailableToAddChildren()) {
                if (entry.availableToAddLeftChildren) {
                    entry.leftChild = newEntry;
                    newEntry.parent = entry;
                    entry.availableToAddLeftChildren = false;
                    availableAdd = true;
                    break;
                } else {
                    entry.rightChild = newEntry;
                    newEntry.parent = entry;
                    entry.availableToAddRightChildren = false;
                    availableAdd = true;
                    break;
                }
            }
        }
        if (!availableAdd) {
            for (Entry entry : list) {
                if (entry.rightChild == null) {
                    entry.availableToAddRightChildren = true;
                }
                if (entry.leftChild == null) {
                    entry.availableToAddLeftChildren = true;

                }
            }
            for (Entry entry : list) {
                if (entry.isAvailableToAddChildren()) {
                    if (entry.availableToAddLeftChildren) {
                        entry.leftChild = newEntry;
                        newEntry.parent = entry;
                        entry.availableToAddLeftChildren = false;
                        break;
                    } else {
                        entry.rightChild = newEntry;
                        newEntry.parent = entry;
                        entry.availableToAddRightChildren = false;
                        break;
                    }
                }
            }
        }
        list.add(newEntry);
        return true;
    }

    @Override
    public int size() {
        return list.size() - 1;
    }

    public String getParent(String s) {
        for (Entry entry : list) {
            if (entry.elementName.equals(s)) return entry.parent.elementName;
        }
        return null;
    }

    public boolean remove(Object o) {
        if (!(o instanceof String)) throw new UnsupportedOperationException();

        Iterator<Entry> iterator = list.iterator();
        String str = (String) o;
        Stack<Entry> stack = new Stack<>();
        while (iterator.hasNext()) {
            Entry entry = iterator.next();
            if (entry.elementName.equals(str)) {
                if (entry.parent.leftChild == entry) {
                    entry.parent.leftChild = null;
                } else {
                    entry.parent.rightChild = null;
                }
                stack.push(entry.leftChild);
                stack.push(entry.rightChild);
                iterator.remove();
            }
        }
        while (!stack.empty()) {
            Entry entry = stack.pop();
            if (entry.leftChild != null) stack.push(entry.leftChild);
            if (entry.rightChild != null) stack.push(entry.rightChild);
            list.remove(entry);
        }


        return false;
    }


    static class Entry<T> implements Serializable {
        String elementName;
        boolean availableToAddLeftChildren, availableToAddRightChildren;
        Entry<T> parent, leftChild, rightChild;

        public Entry(String elementName) {
            this.elementName = elementName;
            availableToAddLeftChildren = true;
            availableToAddRightChildren = true;
        }

        public boolean isAvailableToAddChildren() {
            return availableToAddLeftChildren || availableToAddRightChildren;
        }
    }

}
