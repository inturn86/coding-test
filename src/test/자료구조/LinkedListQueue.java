package test.자료구조;

import java.util.LinkedList;

public class LinkedListQueue<T> {
	private LinkedList<T> list;

	public LinkedListQueue() {
		list = new LinkedList<>();
	}

	// 큐의 뒤에 원소 추가
	public void add(T item) {
		list.addLast(item);
	}

	// 큐의 앞에서 원소 제거하고 반환
	public T poll() {
		if (isEmpty()) {
			throw new IllegalStateException("Queue is empty");
		}
		return list.removeFirst();
	}

	// 큐의 앞 원소 조회 (제거하지 않음)
	public T peek() {
		if (isEmpty()) {
			throw new IllegalStateException("Queue is empty");
		}
		return list.getFirst();
	}

	// 큐가 비었는지 확인
	public boolean isEmpty() {
		return list.isEmpty();
	}

	// 큐의 크기 반환
	public int size() {
		return list.size();
	}
}
