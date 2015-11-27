package scjp.com.java.companies.ola;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class ConcurrentQueueWithLinkedListTest {
	
	private ExpectedException expEx;
	private IConcurrentQueue<Integer> queue;
	
	@Rule
	public ExpectedException getRule() {
		expEx = ExpectedException.none();
		return expEx;
	}

	@Test
	public void pushAndPop() {
		queue = new ConcurrentQueueWithLinkedList<Integer>();
		queue.push(4);
		queue.push(10);
		Assert.assertTrue(queue.pop() == 4);
		Assert.assertTrue(queue.peek() == 10);
		queue.push(13);
		Assert.assertTrue(queue.pop() == 10);
		Assert.assertTrue(queue.peek() == 13);
	}

	@Test
	public void pushTest() {
		queue = new ConcurrentQueueWithLinkedList<Integer>();
		queue.push(4);
		Assert.assertTrue(queue.peek() == 4);
	}

	@Test
	public void pushWithMultipleValue() {
		queue = new ConcurrentQueueWithLinkedList<Integer>();
		queue.push(4);
		queue.push(10);
		queue.push(12);
		queue.push(12);
		queue.push(12);
		Assert.assertTrue(queue.peek() == 4);
	}

	@Test
	public void pollTest() {
		queue = new ConcurrentQueueWithLinkedList<Integer>();
		queue.push(10);
		Assert.assertTrue(queue.pop() == 10);
		Assert.assertTrue(queue.pop() == null);
		Assert.assertTrue(queue.pop() == null);
	}

	@Test
	public void concurrencyTest() throws InterruptedException {
		queue = new ConcurrentQueueWithLinkedList<Integer>();
		Thread t1 = new Thread(new Runnable() {
			public void run() {
				queue.push(10);
				queue.push(11);
				queue.pop();
				queue.push(12);
			}
		});

		Thread t2 = new Thread(new Runnable() {
			public void run() {
				queue.push(1);
				queue.pop();
				queue.push(2);
				queue.push(3);
				queue.pop();
			}
		});

		t1.start();
		t2.start();

		t1.join();
		t2.join();

		int i = 0;
		while (queue.pop() != null)
			i++;

		Assert.assertTrue(i == 3);
	}

	@Test
	public void concurrencyTestPopToNull() throws InterruptedException {
		queue = new ConcurrentQueueWithLinkedList<Integer>();
		Thread t1 = new Thread(new Runnable() {
			public void run() {
				queue.push(10);
				queue.push(11);
				queue.push(12);
			}
		});

		Thread t2 = new Thread(new Runnable() {
			public void run() {
				try {
					Thread.sleep(2);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				queue.pop();
				queue.pop();
				queue.pop();
				queue.pop();
			}
		});

		t1.start();
		t2.start();

		t1.join();
		t2.join();

		Assert.assertTrue(queue.pop() == null);
	}
}