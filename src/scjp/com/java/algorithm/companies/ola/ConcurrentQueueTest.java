package scjp.com.java.algorithm.companies.ola;

import org.junit.Assert;
import org.junit.Test;

public class ConcurrentQueueTest {

	private ConcurrentQueue<Integer> queue;
	@Test
	public void pushTest() {
		queue = new ConcurrentQueue<Integer>();
		queue.push(4);
		Assert.assertTrue(queue.peek() == 4);
	}

	@Test
	public void pushWithMultipleValue() {
		queue = new ConcurrentQueue<Integer>();
		queue.push(4);
		queue.push(10);
		queue.push(12);
		queue.push(12);
		queue.push(12);
		Assert.assertTrue(queue.peek() == 4);
	}

	@Test
	public void pushAndPop() {
		queue = new ConcurrentQueue<Integer>();
		queue.push(4);
		queue.push(10);
		Assert.assertTrue(queue.pop() == 4);
		Assert.assertTrue(queue.peek() == 10);
		queue.push(13);
		Assert.assertTrue(queue.pop() == 10);
		Assert.assertTrue(queue.peek() == 13);
	}

	@Test
	public void pollTest() {
		queue = new ConcurrentQueue<Integer>();
		queue.push(10);
		Assert.assertTrue(queue.pop() == 10);
		Assert.assertTrue(queue.pop() == null);
	}
}