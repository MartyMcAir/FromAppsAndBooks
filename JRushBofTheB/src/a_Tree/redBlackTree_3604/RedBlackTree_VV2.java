package com.javarush.task.task36.task3604;

// https://github.com/TimeSooShort/AlgorithmLearning/tree/a04378551bd78a895ae176337855565ada7b2016/src/Algorithms4th/search
// - там интересн алгоритмы..
public class RedBlackTree_VV2 {
    protected Node current;
    private Node parent;
    private Node grand;
    private Node great;
    private Node header;

    private static final Node EMPTY = new Node(0);

    static {
        EMPTY.left = EMPTY;
        EMPTY.right = EMPTY;
    }


    public RedBlackTree_VV2() {
        header = new Node(Integer.MIN_VALUE);
        header.left = EMPTY;
        header.right = EMPTY;
    }

    public boolean isEmpty() {
        return current.element < 0;
//        return header.left == EMPTY;
    }

    public void clear() {
        header.right = EMPTY;
    }

    public void insert(int item) {
        // смысл такой линии присваиваний!?
        current = grand = parent = header;
        EMPTY.element = item;
        while (current.element != item) { // текущий элемент
            great = grand;
            grand = parent;
            parent = current;

            // текущим становится элемент:
            //     если больше добовляемого, то становится правым, а иначе левым
            ////////////
            // err in <
            // что и логично если вставляемый меньшь текущ узла то тот идет вниз слева,
            // а иначе на право эмм.. т.е. здесь логика наоборот
            current = item < current.element ? current.right : current.left;

            // если лев child RED и прав child BLACK
            // _ то делаем ребаланс дерева reorient(item);
            if (current.left.color == Color.RED && current.right.color == Color.BLACK) {
                reorient(item);
            }
            // после чего след. интерация
        }

        if (current != EMPTY) {
            return;
        }

        current = new Node(item, EMPTY, EMPTY);

        if (item < parent.element) {
            parent.left = current;
        } else {
            parent.right = current;
        }

        reorient(item);
    }

    protected void reorient(int item) {
        current.color = Color.RED;
        current.left.color = Color.BLACK;
        current.right.color = Color.BLACK;

        if (parent.color == Color.RED) {
            grand.color = Color.RED;
            if (item < grand.element != item < parent.element) {
                parent = rotate(item, grand);
            }
            current = rotate(item, great);
            current.color = Color.BLACK;
        }

        header.right.color = Color.BLACK;
    }

    private Node rotate(int item, Node parent) {
        if (item < parent.element) {
            Node node = parent.left;
            Node resultNode = item < node.element ? rotateWithLeftNode(node) : rotateWithRightNode(node);
            parent.left = resultNode;
            return parent.left;
        } else {
            Node node = parent.right;
            Node resultNode = item < node.element ? rotateWithLeftNode(node) : rotateWithRightNode(node);
            parent.right = resultNode;
            return parent.right;
        }
    }

    private Node rotateWithLeftNode(Node element) {
        Node left = element.left; //  лев текущ сохраняем в Tmp
        element.left = left.right; // на место левого child ставим правый под-child - левого под child'a
        left.right = element; // на место правого ставим текущий
        return left;
    }

    private Node rotateWithRightNode(Node element) {
        Node right = element.right; // прав текущ в сохраняем
        element.right = right.left;  // на место правого текущего ставим лев под Child правого под Child'a
        right.left = element; // на место левого ставим текущ.
        return right;
    }


    // added by me
    public void displayAllTree(Node three) {
        if (three != null) { // StackOverflowError
            displayAllTree(three.left);
            System.out.println(three);
            displayAllTree(three.right);
        }
    }

    public static class Node {
        private int element;
        private Node left;
        private Node right;
        private Color color;

        public Node(int element) {
            this(element, null, null);
        }

        public Node(int element, Node left, Node right) {
            this.left = left;
            this.right = right;
            this.element = element;
            this.color = Color.BLACK;
        }

        @Override   // added by me
        public String toString() {
            return "Node{" +
                    "element=" + element +
                    ", left=" + left.element +
                    ", right=" + right.element +
                    ", color=" + color +
                    '}';
        }

    }

    public static enum Color {
        BLACK,
        RED
    }
}
