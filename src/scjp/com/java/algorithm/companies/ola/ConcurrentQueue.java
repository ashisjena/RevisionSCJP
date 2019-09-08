package scjp.com.java.algorithm.companies.ola;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;

public class ConcurrentQueue<E extends Number> implements IConcurrentQueue<E> {

	private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock(true);

	private final int INITIAL_SIZE = 1;
	@SuppressWarnings("unchecked")
	private E[] elements = (E[]) new Number[INITIAL_SIZE]; // LinkedList can be used to optimize
															// poll() performance
	private final float incrementFactor = 1.5f;
	private final AtomicInteger count = new AtomicInteger(0);

	public void push(final E val) {
		if (val == null)
			throw new NullPointerException("Value is null");

		final WriteLock lock = this.lock.writeLock();
		lock.lock();

		try {
			if (isFull())
				increaseSize();

			elements[count.getAndIncrement()] = val;
		} finally {
			lock.unlock();
		}
	}

	public E pop() {
		final WriteLock lock = this.lock.writeLock();
		lock.lock();

		try {
			E item = null;

			if (!isEmpty()) {
				item = elements[0];

				count.decrementAndGet();
				for (int index = 0; index < count.get(); index++)
					elements[index] = elements[index + 1];
			}

			return item;

		} finally {
			lock.unlock();
		}
	}

	public E peek() {
		final ReadLock lock = this.lock.readLock();

		lock.lock();
		try {
			return elements[0];
		} finally {
			lock.unlock();
		}
	}

	private boolean isFull() {
		return count.get() == elements.length;
	}

	private boolean isEmpty() {
		return count.get() == 0;
	}

	private void increaseSize() {
		this.elements = Arrays.copyOf(this.elements, (int) (this.elements.length * incrementFactor) + 1);
	}
}