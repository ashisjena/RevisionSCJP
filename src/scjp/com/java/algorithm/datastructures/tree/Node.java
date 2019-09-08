package scjp.com.java.algorithm.datastructures.tree;

import java.util.Objects;

public class Node<T extends Comparable> {
    T value;
    Color color = null;
    int height;
    Node<T> parent, left, right;

    public Node(T item, Node<T> parent) {
        this.value = item;
        this.parent = parent;
    }

    public Node(T item) {
        this(item, null);
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Node<T> getLeft() {
        return left;
    }

    public void setLeft(Node<T> left) {
        this.left = left;
    }

    public Node<T> getRight() {
        return right;
    }

    public void setRight(Node<T> right) {
        this.right = right;
    }

    public Node<T> getParent() {
        return parent;
    }

    public void setParent(Node<T> parent) {
        this.parent = parent;
    }

    public Color getColor() {
        return this.color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Node)) return false;
        Node<?> node = (Node<?>) o;
        return getValue().equals(node.getValue());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getValue());
    }

    @Override
    public String toString() {
        return value.toString() + "(" + (this.color == null ? this.height : this.color.toString()) + ")";
    }

    public enum Color {
        RED, BLACK
    }
}
