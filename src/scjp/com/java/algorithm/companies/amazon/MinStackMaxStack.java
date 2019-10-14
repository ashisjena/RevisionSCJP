package scjp.com.java.algorithm.companies.amazon;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class MinStackMaxStack {
	private Map<String, Integer> map = new HashMap<>();
	private Stack<Node> minStack = new Stack<>();
	private Stack<Node> maxStack = new Stack<>();

	public void touchAndIncrease(String key) {
		Integer count = map.get(key);

		if (count == null) {
			map.put(key, 1);
		} else {
			map.put(key, count + 1);
		}

		if (maxStack.peek().count <= count + 1) {
			maxStack.push(new Node(key, count + 1));
		}
	}

	public void touchAndDecrease(String key) {
		Integer count = map.get(key);

		if (count != null) {
			map.put(key, count - 1);

			if (minStack.peek().count >= count - 1) {
				minStack.push(new Node(key, count + 1));
			}
		}

	}

	public Node getMaxNode() {
		return this.maxStack.peek();
	}

	public Node getMinNode() {
		return this.minStack.peek();
	}

	class Node {
		private Integer count;
		private String key;

		Node(String key, Integer count) {
			this.key = key;
			this.count = count;
		}

		@Override
		public String toString() {
			return this.key + ", " + this.count;
		}
	}

	public static void main(String[] args) {
		MinStackMaxStack obj = new MinStackMaxStack();
		
		obj.touchAndIncrease("Ram");
		obj.touchAndIncrease("Sita");
		obj.touchAndIncrease("Hari");
		obj.touchAndIncrease("Shyam");
		obj.touchAndIncrease("Hari");
		obj.touchAndIncrease("Hari");
		obj.touchAndIncrease("Hari");
		obj.touchAndIncrease("Sita");
		obj.touchAndIncrease("Sita");
		
		System.out.println(obj.getMaxNode());
		System.out.println(obj.getMinNode());
	}

}
