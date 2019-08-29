package scjp.com.java.algorithm.tree;

import scjp.com.java.algorithm.tree.avltree.AVLTree;
import scjp.com.java.algorithm.tree.redblacktree.RedBlackTree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TreeEx {
    public static void main(String[] args) {
        Integer arr[] = {1, 2, 3, 4, 5, 6, 6, 6, 6};
        Node<Integer> root = insertLevelOrder(arr, null, 0);
        print(root);

        Integer arr2[] = {40, 35, 20, 10, 45, 50, 65, 60};
        RedBlackTree<Integer> tree = new RedBlackTree<>();
        Arrays.stream(arr2).forEach(value -> tree.insert(value));
        print(tree.getRoot());
        /*System.out.println(tree.delete(35));
        print(tree.getRoot());*/

        Integer arr3[] = {40, 35, 20, 10, 45, 50, 65, 60, 80, 75, 70, 63, 85, 68};
        AVLTree<Integer> avlTree = new AVLTree<>();
        Arrays.stream(arr3).forEach(value -> avlTree.insert(value));
        print(avlTree.getRoot());
        avlTree.delete(75);
        print(avlTree.getRoot());
    }

    static <T> Node<T> insertLevelOrder(T[] arr, Node<T> root, int i) {
        if (i < arr.length) {
            root = new Node<>(arr[i]);

            root.left = insertLevelOrder(arr, root.left, 2 * i + 1);
            root.right = insertLevelOrder(arr, root.right, 2 * i + 2);
        }
        return root;
    }

    public static <T extends Comparable<T>> void print(Node<T> root) {
        List<List<String>> lines = new ArrayList<>();

        List<Node<T>> level = new ArrayList<>();
        List<Node<T>> next = new ArrayList<>();

        level.add(root);
        int nn = 1;

        int widest = 0;

        while (nn != 0) {
            List<String> line = new ArrayList<String>();

            nn = 0;

            for (Node n : level) {
                if (n == null || n.toString() == null) {
                    line.add(null);

                    next.add(null);
                    next.add(null);
                } else {
                    String aa = n.toString();
                    line.add(aa);
                    if (aa.length() > widest) widest = aa.length();

                    next.add(n.getLeft());
                    next.add(n.getRight());

                    if (n.getLeft() != null) nn++;
                    if (n.getRight() != null) nn++;
                }
            }

            if (widest % 2 == 1) widest++;

            lines.add(line);

            List<Node<T>> tmp = level;
            level = next;
            next = tmp;
            next.clear();
        }

        int perpiece = lines.get(lines.size() - 1).size() * (widest + 4);
        for (int i = 0; i < lines.size(); i++) {
            List<String> line = lines.get(i);
            int hpw = (int) Math.floor(perpiece / 2f) - 1;

            if (i > 0) {
                for (int j = 0; j < line.size(); j++) {

                    // split node
                    char c = ' ';
                    if (j % 2 == 1) {
                        if (line.get(j - 1) != null) {
                            c = (line.get(j) != null) ? '^' : '|';
                        } else {
                            if (j < line.size() && line.get(j) != null) c = '|';
                        }
                    }
                    System.out.print(c);

                    // lines and spaces
                    if (line.get(j) == null) {
                        for (int k = 0; k < perpiece - 1; k++) {
                            System.out.print(" ");
                        }
                    } else {

                        for (int k = 0; k < hpw; k++) {
                            System.out.print(j % 2 == 0 ? " " : "-");
                        }
                        System.out.print(j % 2 == 0 ? "|" : "|");
                        for (int k = 0; k < hpw; k++) {
                            System.out.print(j % 2 == 0 ? "-" : " ");
                        }
                    }
                }
                System.out.println();
            }

            // print line of numbers
            for (int j = 0; j < line.size(); j++) {

                String f = line.get(j);
                if (f == null) f = "";
                int gap1 = (int) Math.ceil(perpiece / 2f - f.length() / 2f);
                int gap2 = (int) Math.floor(perpiece / 2f - f.length() / 2f);

                // a number
                for (int k = 0; k < gap1; k++) {
                    System.out.print(" ");
                }
                System.out.print(f);
                for (int k = 0; k < gap2; k++) {
                    System.out.print(" ");
                }
            }
            System.out.println();

            perpiece /= 2;
        }
    }
}