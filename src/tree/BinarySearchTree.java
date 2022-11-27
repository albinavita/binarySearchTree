package tree;

import java.util.*;

public class BinarySearchTree {

    private Node root;
    private List<Node> trees = new ArrayList<>();

    public Node createBalancedTree(List<Node> trees) {

        if (root == null) {
            root = createTree(trees, 0, trees.size() - 1);
            System.out.println("root-> " + root.value);
        }
        return createTree(trees, 0, trees.size() - 1);
    }

    private Node createTree(List<Node> trees, int indexStart, int indexEnd) {

        if (indexEnd < indexStart) {
            return null;
        }
        int mid = (indexStart + indexEnd) / 2;
        Node node = new Node(trees.get(mid).value);

        node.left = createTree(trees, indexStart, mid - 1);
        node.right = createTree(trees, mid + 1, indexEnd);

        return node;
    }

    public int findMin() {
        if (root == null) {
            return 0;
        }
        Node currNode = root;
        while (currNode.left != null) {
            currNode = currNode.left;
        }
        return currNode.value;
    }

    public int findMax() {
        if (root == null) {
            return 0;
        }
        Node currNode = root;
        while (currNode.right != null) {
            currNode = currNode.right;
        }
        return currNode.value;
    }
    //обход в глубину
    public void traversalDeep(Node root) {
        Stack<Node> stack = new Stack<>();
        stack.push(root);

        while (!stack.empty()) {
            Node node = stack.pop();

            System.out.print(node.value + ", ");

            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }
        }
        System.out.println();
    }

    //обход в ширину
    public void traversalWide(Node root) {
        Deque<Node> deque = new ArrayDeque<>();
        deque.addLast(root);
        System.out.println("root -> " + root.value);
        while (!deque.isEmpty()) {
            Node node = deque.removeFirst();
            System.out.print(node.value + ", ");

            if (node.left != null) {
                deque.addLast(node.left);
            }
            if (node.right != null) {
                deque.addLast(node.right);
            }
        }
    }

    public Node getRoot() {
        return root;
    }

    public List<Node> getTrees() {
        return new ArrayList<>(trees);
    }
}
