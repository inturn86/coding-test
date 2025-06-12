package test.자료구조;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class MyQueue <T>{

	private static class Node<T> {
		T data;
		Node<T> next;
		Node(T data) {
			this.data = data;
			this.next = null;
		}
	}

	private Node<T> front; // dequeue 대상
	private Node<T> rear;  // enqueue 대상
	private int size;

	public MyQueue() {
		this.front = null;
		this.rear = null;
		this.size = 0;
	}

	// 큐에 데이터 추가
	public void enqueue(T item) {
		Node<T> newNode = new Node<>(item);
		if (rear != null) { //rear가 없으면 rear에 직접 넣고.
			rear.next = newNode;    //rear가 있을 경우는 next에 넣은 후 rear를 변경.
		}
		rear = newNode;

		if (front == null) {    //front가 없을 경우만 rear에 있는 데이터를 넣는다. front로 dequeue 처리
			front = rear;
		}

		size++;
	}

	// 큐에서 데이터 제거 및 반환
	public T dequeue() {
		if (isEmpty()) {
			throw new IllegalStateException("Queue is empty");
		}
		//프론트의 데이터를 가지고옴.
		T data = front.data;
		//next가 있을 경우 front로 옮겨 처리
		front = front.next;
		//모든 것이 dequeue 처리 되면.
		if (front == null) {
			//rear에도 데이터를 없애줘야 한다.
			rear = null;
		}
		size--;
		return data;
	}

	// 큐의 가장 앞 원소 반환
	public T peek() {
		if (isEmpty()) {
			throw new IllegalStateException("Queue is empty");
		}
		return front.data;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public int size() {
		return size;
	}
}
