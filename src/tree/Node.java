package tree;

public class Node {
    //значение узла
    protected int value;
    //левый узел
    protected Node left;
    //правый узел
    protected Node right;

    public Node(int value, Node left, Node right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public Node(int value) {
        this.value = value;
    }


}
