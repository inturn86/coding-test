package test.자료구조;

public class ThreadSafeLinkedStack<T> {

	private static class Node<T> {
		T data;
		Node<T> next;
		Node(T data) {
			this.data = data;
		}
	}

	private Node<T> top;
	private int size;

	public ThreadSafeLinkedStack() {
		this.top = null;
		this.size = 0;
	}

	public synchronized void push(T item) {
		Node<T> newNode = new Node<>(item);
		newNode.next = top;
		top = newNode;
		size++;
	}

	public synchronized T pop() {
		if (isEmpty()) {
			throw new IllegalStateException("Stack is empty");
		}
		T item = top.data;
		top = top.next;
		size--;
		return item;
	}

	public synchronized T peek() {
		if (isEmpty()) {
			throw new IllegalStateException("Stack is empty");
		}
		return top.data;
	}

	public synchronized boolean isEmpty() {
		return size == 0;
	}

	public synchronized int size() {
		return size;
	}
}
