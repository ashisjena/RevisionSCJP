package scjp.com.java.companies.ola;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;
// To DO
// Need to use two separate locks for push and pop and take care when there is only 1 element is available.
public class ConcurrentQueueWithLinkedList<E> implements IConcurrentQueue<E> {

	private volatile Node<E> head;
	private volatile Node<E> finger;
	private final AtomicInteger count = new AtomicInteger(0);
	private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock(true);

	public void push(final E val) {
		if (!(val instanceof Double || val instanceof Long || val instanceof String || val instanceof Integer))
			throw new IllegalArgumentException();

		final WriteLock lock = this.lock.writeLock();
		lock.lock();
		try {
			final Node<E> node = new Node<E>(val);
			if (count.get() == 0) {
				head = node;
				finger = head;
			} else {
				finger.setNext(node);
				finger = node;
			}

			count.incrementAndGet();
		} finally {
			lock.unlock();
		}
	}

	public E pop() {
		final WriteLock lock = this.lock.writeLock();
		lock.lock();

		try {
			final Node<E> firstNode = head;
			if (count.get() > 0) {
				head = head.getNext();
				firstNode.setNext(null);
				count.decrementAndGet();
				return firstNode.getValue();
			} else
				return null;

		} finally {
			lock.unlock();
		}
	}

	public E peek() {
		final ReadLock lock = this.lock.readLock();
		lock.lock();
		try {
			if (count.get() == 0)
				return null;
			else {
				final E val = this.head.getValue();
				return val;
			}
		} finally {
			lock.unlock();
		}
	}
}