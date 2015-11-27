package scjp.com.java.companies.ola;

public class Node<E> {
	private E value = null;
	private Node<E> next = null;

	public Node(final E value, final Node<E> next) {
		this.value = value;
		this.next = next;
	}

	public Node(final E value) {
		this.value = value;
	}

	public E getValue() {
		return this.value;
	}

	public void setNext(final Node<E> next) {
		this.next = next;
	}

	public Node<E> getNext() {
		return this.next;
	}
}