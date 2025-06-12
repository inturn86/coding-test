package test.자료구조;

import java.util.concurrent.locks.ReentrantLock;

public class ThreadSafeReentrantLockLinkedStack<T> {

	private ReentrantLock lock = new ReentrantLock();

	public static class Node<T> {
		T data;
		Node<T> next;
		Node(T data) {
			this.data = data;
		}
	}

	private Node<T> top;

	private int size;

	public ThreadSafeReentrantLockLinkedStack() {
		this.top = null;
		this.size = 0;
	}

	public void push(T item) {
		lock.lock();
		try {
			Node<T> n = new Node<>(item);
			n.next = top;
			top = n;
			size++;
		}
		finally {
			lock.unlock();
		}
	}

	public T pop() {
		lock.lock();
		try {
			if (isEmpty()) {
				throw new IllegalStateException("Stack is empty");
			}

			//top을 가지고 오고. top의 next를 top에 넣어준다.
			T data = top.data;
			top = top.next;
			size--;
			return data;
		}
		finally {
			lock.unlock();
		}
	}

	public T peek() {
		lock.lock();
		try {
			if (isEmpty()) {
				throw new IllegalStateException("Stack is empty");
			}
			return top.data;
		}
		finally {
			lock.unlock();
		}
	}

	public boolean isEmpty() {
		return size == 0 ? true : false;
	}

	public int size() {
		return size;
	}
}
