package scjp.com.java.algorithm.datastructures.tree;

public abstract class BinaryTree<T extends Comparable> {

    private Node<T> root;

    public Node<T> getRoot() {
        return this.root;
    }

    protected void setRoot(Node<T> root) {
        this.root = root;
    }

    public static <T extends Comparable> Node<T> parentOf(Node<T> node) {
        return node != null ? node.getParent() : null;
    }

    public static <T extends Comparable> Node<T> leftOf(Node<T> node) {
        return node != null ? node.getLeft() : null;
    }

    public static <T extends Comparable> Node<T> rightOf(Node<T> node) {
        return node != null ? node.getRight() : null;
    }

    protected abstract void rebalance(Node<T> node);

    public abstract T delete(T value);

    public Node<T> findNode(T value) {
        Node<T> current = this.getRoot();
        while (current != null) {
            if (current.getValue().compareTo(value) == 0) {
                return current;
            } else if (current.getValue().compareTo(value) > 0) {
                current = leftOf(current);
            } else {
                current = rightOf(current);
            }
        }
        return null;
    }

    public void insert(T value) {
        if (root == null) {
            root = new Node<>(value, null);
            return;
        }

        Node<T> parent;
        Node<T> current = this.root;

        do {
            parent = current;
            if (current.getValue().compareTo(value) < 0) {
                current = current.getRight();
            } else if (current.getValue().compareTo(value) > 0) {
                current = current.getLeft();
            } else {
                return;
            }
        } while (current != null);

        Node<T> node = new Node(value);
        node.setParent(parent);
        if (parent.getValue().compareTo(value) < 0) {
            parent.setRight(node);
        } else {
            parent.setLeft(node);
        }
        rebalance(node);
    }

    protected void rightRotate(Node<T> node) {
        if (node != null) {
            Node<T> l = node.getLeft();
            node.setLeft(l.getRight());

            if (l.getRight() != null) {
                l.getRight().setParent(node);
            }

            if (parentOf(node) == null) {
                this.root = l;
            } else if (rightOf(parentOf(node)) == node) {
                parentOf(node).setRight(l);
            } else {
                parentOf(node).setLeft(l);
            }

            l.setParent(node.getParent());
            node.setParent(l);
            l.setRight(node);
        }
    }

    protected void leftRotate(Node<T> node) {
        if (node != null) {
            Node<T> r = node.getRight();

            node.setRight(r.getLeft());
            if (r.getLeft() != null) {
                r.getLeft().setParent(node);
            }

            if (node.getParent() == null) {
                this.root = r;
            } else if (leftOf(parentOf(node)) == node) {
                node.getParent().setLeft(r);
            } else {
                node.getParent().setRight(r);
            }

            r.setParent(node.getParent());
            node.setParent(r);
            r.setLeft(node);
        }
    }

    protected Node<T> successor(Node<T> node) {
        if (node == null) {
            return null;
        } else if (rightOf(node) != null) {
            Node<T> successor = rightOf(node);
            while (leftOf(successor) != null) {
                successor = leftOf(successor);
            }
            return successor;
        } else {
            Node<T> parent = parentOf(node);
            Node<T> child = node;
            while (child == rightOf(parent)) {
                child = parent;
                parent = parentOf(child);
            }
            return parent;
        }
    }

    protected Node<T> predecessor(Node<T> node) {
        if (node == null) {
            return null;
        } else if (leftOf(node) != null) {
            Node<T> predecessor = leftOf(node);
            while (rightOf(predecessor) != null) {
                predecessor = rightOf(predecessor);
            }
            return predecessor;
        } else {
            Node<T> parent = parentOf(node);
            Node<T> child = node;
            while (child == leftOf(parent)) {
                child = parent;
                parent = parentOf(child);
            }
            return parent;
        }
    }
}
