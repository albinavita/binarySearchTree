package tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        int[] nodes = {3, 34, 55, 23, 44, 21, 88, 93};
        List<Integer> lists = Arrays.stream(nodes).sorted().boxed().collect(Collectors.toList());
        List<Node> listNodes = lists.stream().map(Node::new).collect(Collectors.toList());

        BinarySearchTree tree = new BinarySearchTree();
        tree.createBalancedTree(listNodes);

        tree.traversalDeep(tree.getRoot());
        System.out.println("Min: " + tree.findMin());
        System.out.println("Max: " + tree.findMax());
        tree.traversalWide(tree.getRoot());
    }

}
