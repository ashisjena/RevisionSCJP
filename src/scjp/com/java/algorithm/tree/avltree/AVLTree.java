package scjp.com.java.algorithm.tree.avltree;

import scjp.com.java.algorithm.tree.BinaryTree;
import scjp.com.java.algorithm.tree.Node;

/*
 * Height difference between(balance factor) two children/sub tree can't be greater than 1
 */
public class AVLTree<T extends Comparable> extends BinaryTree<T> {

    private int height(Node<T> node) {
        return node == null ? 0 : node.getHeight();
    }

    @SafeVarargs
    private final void updateHeights(Node<T>... nodes) {
        for (Node<T> node : nodes) {
            node.setHeight(1 + Math.max(height(node.getLeft()), height(node.getRight())));
        }
    }

    private int getBalanceFactor(Node<T> node) {
        return node == null ? 0 : height(node.getRight()) - height(node.getLeft());
    }

    @Override
    protected void rebalance(Node<T> newNode) {
        for (Node<T> node = newNode; node != null; node = parentOf(node)) {
            node.setHeight(1 + Math.max(height(node.getLeft()), height(node.getRight())));

            int balanceFactor = getBalanceFactor(node);
            if (balanceFactor > 1) {
                Node<T> right = node.getRight();
                if (getBalanceFactor(right) < 0) {
                    rightRotate(right);
                    updateHeights(right, node);
                }

                leftRotate(node);
                updateHeights(node, parentOf(node));
            } else if (balanceFactor < -1) {
                Node<T> left = node.getLeft();
                if (getBalanceFactor(left) > 0) {
                    leftRotate(left);
                    updateHeights(left, node);
                }

                rightRotate(node);
                updateHeights(node, parentOf(node));
            }
        }
    }

    private Node<T>  getBiggestNodeFromLeftSubtree(Node<T>  node) {
        Node<T>  result = node.getLeft();
        if (result.getRight() == null) {
            // no right child
            node.setLeft(result.getLeft());
            return result;
        }

        while (result.getRight() != null) {
            result = result.getRight();
        }

        result.getParent().setRight(result.getLeft()); // left child of result replace result

        return result;
    }

    @Override
    public T delete(T value) {
        Node<T> node = super.findNode(value);
        if (node == null) {
            return null;
        }

        if (rightOf(node) != null && leftOf(node) != null) {
            Node<T> predecessor = this.getBiggestNodeFromLeftSubtree(node);
            predecessor.setLeft(node.getLeft());
            predecessor.setRight(node.getRight());

            Node<T> predecessorParent = predecessor.getParent();
            if (parentOf(node) == null) {
                predecessor.setParent(null);
                this.setRoot(predecessor);
            } else if (rightOf(parentOf(node)) == node) {
                node.getParent().setRight(predecessor);
            } else if (leftOf(parentOf(node)) == node) {
                node.getParent().setLeft(predecessor);
            }
            rebalance(predecessorParent);
        } else if (leftOf(node) != null || rightOf(node) != null) {
            Node<T> parent = parentOf(node);
            if (leftOf(node) != null) {
                if (parent == null) { // Root Node
                    node.getLeft().setParent(null);
                    this.setRoot(node.getLeft());
                } else if (leftOf(parentOf(node)) == node) {
                    node.getParent().setLeft(node.getLeft());
                } else if (rightOf(parentOf(node)) == node) {
                    node.getParent().setRight(node.getLeft());
                }
                rebalance(node.getLeft());
            } else {
                if (parent == null) {
                    node.getRight().setParent(null);
                    this.setRoot(node.getRight());
                } else if (rightOf(parentOf(node)) == node) {
                    node.getParent().setRight(node.getRight());
                } else if (leftOf(parentOf(node)) == node) {
                    node.getParent().setLeft(node.getRight());
                }
                rebalance(node.getRight());
            }
        } else { // Node is a leaf
            Node<T> parent = node.getParent();
            if (parent == null) {
                this.setRoot(null);
            } else {
                if (rightOf(parentOf(node)) == node) {
                    parent.setRight(null);
                } else {
                    parent.setLeft(null);
                }
                rebalance(parent);
            }
        }

        return node.getValue();
    }
}
