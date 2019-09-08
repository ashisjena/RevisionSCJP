package scjp.com.java.algorithm.datastructures.tree.redblacktree;

import scjp.com.java.algorithm.datastructures.tree.BinaryTree;
import scjp.com.java.algorithm.datastructures.tree.Node;

public class RedBlackTree<T extends Comparable> extends BinaryTree<T> {

    private Node.Color colorOf(Node<T> node) {
        return node == null ? Node.Color.BLACK : node.getColor();
    }

    private void setColor(Node<T> node, Node.Color color) {
        if (node != null) {
            node.setColor(color);
        }
    }

    public T delete(T value) {
        Node<T> node = findNode(value);
        T oldValue = node.getValue();

        if (rightOf(node) != null && leftOf(node) != null) { // Node has 2 children
            Node<T> successor = successor(node);
            node.setValue(successor.getValue());
            node = successor;
        }

        Node<T> replacement = leftOf(node) != null ? leftOf(node) : rightOf(node);

        if (replacement != null) {
            replacement.setParent(parentOf(node));

            if (parentOf(replacement) == null) {
                super.setRoot(replacement);
            } else if (node == leftOf(parentOf(node))) {
                parentOf(node).setLeft(replacement);
            } else {
                parentOf(node).setRight(replacement);
            }

            // Null out all the links of node.
            node.setParent(null);
            node.setLeft(null);
            node.setRight(null);

            if (colorOf(node) == Node.Color.BLACK) {
                fixAfterDeletion(replacement);
            }
        } else if (parentOf(node) == null) {
            super.setRoot(null); // Only one node.
        } else {
            if (colorOf(node) == Node.Color.BLACK) {
                fixAfterDeletion(node);
            }

            if (parentOf(node) != null) {
                if (node == leftOf(parentOf(node))) {
                    parentOf(node).setLeft(null); // replacement is null
                } else {
                    parentOf(node).setRight(null);
                }
                node.setParent(null);
            }
        }

        return oldValue;
    }

    private void fixAfterDeletion(Node<T> node) {
        while (node != super.getRoot() && colorOf(node) == Node.Color.BLACK) {
            if (node == leftOf(parentOf(node))) {
                Node sib = rightOf(parentOf(node));
                if (colorOf(sib) == Node.Color.RED) {
                    setColor(sib, Node.Color.BLACK);
                    setColor(parentOf(node), Node.Color.RED);
                    leftRotate(parentOf(node));
                    sib = rightOf(parentOf(node));
                }

                if (colorOf(leftOf(sib)) == Node.Color.BLACK && colorOf(rightOf(sib)) == Node.Color.BLACK) {
                    setColor(sib, Node.Color.RED);
                    node = parentOf(node);
                } else {
                    if (colorOf(rightOf(sib)) == Node.Color.BLACK) {
                        setColor(leftOf(sib), Node.Color.BLACK);
                        setColor(sib, Node.Color.RED);
                        rightRotate(sib);
                        sib = rightOf(parentOf(node));
                    }
                    setColor(sib, colorOf(parentOf(node)));
                    setColor(parentOf(node), Node.Color.BLACK);
                    setColor(rightOf(sib), Node.Color.BLACK);
                    leftRotate(parentOf(node));
                    node = super.getRoot();
                }
            } else { // symmetric
                Node<T> sib = leftOf(parentOf(node));

                if (colorOf(sib) == Node.Color.RED) {
                    setColor(sib, Node.Color.BLACK);
                    setColor(parentOf(node), Node.Color.RED);
                    rightRotate(parentOf(node));
                    sib = leftOf(parentOf(node));
                }

                if (colorOf(rightOf(sib)) == Node.Color.BLACK && colorOf(leftOf(sib)) == Node.Color.BLACK) {
                    setColor(sib, Node.Color.RED);
                    node = parentOf(node);
                } else {
                    if (colorOf(leftOf(sib)) == Node.Color.BLACK) {
                        setColor(rightOf(sib), Node.Color.BLACK);
                        setColor(sib, Node.Color.RED);
                        leftRotate(sib);
                        sib = leftOf(parentOf(node));
                    }
                    setColor(sib, colorOf(parentOf(node)));
                    setColor(parentOf(node), Node.Color.BLACK);
                    setColor(leftOf(sib), Node.Color.BLACK);
                    rightRotate(parentOf(node));
                    node = super.getRoot();
                }
            }
        }

        setColor(node, Node.Color.BLACK);
    }

    @Override
    protected void rebalance(Node<T> node) {
        node.setColor(Node.Color.RED);

        while (node != null && node != super.getRoot() && colorOf(parentOf(node)) == Node.Color.RED) {
            if (parentOf(node) == leftOf(parentOf(parentOf(node)))) {
                Node<T> rightUncle = rightOf(parentOf(parentOf(node)));
                if (colorOf(rightUncle) == Node.Color.RED) {
                    node = fixUncleRed(node, rightUncle);
                } else {
                    if (node == rightOf(parentOf(node))) {
                        node = parentOf(node);
                        leftRotate(node);
                    }
                    setColor(parentOf(node), Node.Color.BLACK);
                    setColor(parentOf(parentOf(node)), Node.Color.RED);
                    rightRotate(parentOf(parentOf(node)));
                }
            } else {
                Node<T> leftUncle = leftOf(parentOf(parentOf(node)));
                if (colorOf(leftUncle) == Node.Color.RED) {
                    node = fixUncleRed(node, leftUncle);
                } else {
                    if (node == leftOf(parentOf(node))) {
                        node = parentOf(node);
                        rightRotate(node);
                    }
                    setColor(parentOf(node), Node.Color.BLACK);
                    setColor(parentOf(parentOf(node)), Node.Color.RED);
                    leftRotate(parentOf(parentOf(node)));
                }
            }
        }
        super.getRoot().setColor(Node.Color.BLACK);
    }

    private Node<T> fixUncleRed(Node<T> node, Node<T> uncle) {
        setColor(parentOf(node), Node.Color.BLACK);
        setColor(uncle, Node.Color.BLACK);
        setColor(parentOf(parentOf(node)), Node.Color.RED);
        return parentOf(parentOf(node));
    }
}
