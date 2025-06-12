package test.자료구조;

import java.util.Objects;

public class MyHashMap<K, V> {
	private static class Node<K, V> {
		final K key;
		V value;
		Node<K, V> next;

		public Node(K key, V value) {
			this.key = key;
			this.value = value;
		}
	}

	private Node<K, V>[] table;
	private int capacity = 16;      // 초기 용량
	private float loadFactor = 0.75f;
	private int size = 0;

	public MyHashMap() {
		table = new Node[capacity];
	}

	private int hashCopy(K k) {
		return k == null ? 0 : Math.abs(k.hashCode() % capacity);
	}

	public void putCopy(K k, V v) {
		int idx = hashCopy(k);
		Node<K, V> t = table[idx];

		for(Node<K, V> cur = t; cur != null; cur = cur.next) {
			if(Objects.equals(cur.key, k)) {
				cur.value = v;
				return;
			}
		}

		Node<K, V> n = new Node<>(k, v);
		n.next = t;
		table[idx] = n;
		size++;

		if(size >= (capacity * loadFactor)) {
			resizeCopy();
		}
	}


	private void resizeCopy() {

		Node<K, V>[] copy = table;

		Node<K, V>[] newTable = new Node[capacity];
		table = newTable;
		size = 0;

		for(Node<K, V> c : copy) {
			while (c != null) {
				putCopy(c.key, c.value);
				c = c.next;
			}
		}
	}

	public V getCopy(K k) {
		int idx = hashCopy(k);
		Node<K, V> t = table[idx];

		for(Node<K, V> cur = t; cur != null; cur = cur.next) {
			if(Objects.equals(cur.key, k)) {
				return cur.value;
			}
		}

		return null;
	}

	public V removeCopy(K k) {
		int idx = hashCopy(k);

		Node<K, V> cur = table[idx];
		Node<K, V> pre = null;

		while (cur != null) {
			if(Objects.equals(cur.key, k)) {
				if(pre == null) {
					table[idx] = cur.next;
				}
				else {
					pre.next = cur.next;
				}
				return cur.value;
			}
			pre = cur;
			cur = cur.next;
		}
		return null;
	}

	private int hash(K key) {
		return (key == null) ? 0 : Math.abs(key.hashCode() % capacity);
	}

	public void put(K key, V value) {
		int index = hash(key);
		Node<K, V> head = table[index];
		// 이미 존재하는 키인지 확인
		for (Node<K, V> curr = head; curr != null; curr = curr.next) {
			if (Objects.equals(curr.key, key)) {
				curr.value = value;
				return;
			}
		}

		// 새 노드 삽입
		Node<K, V> newNode = new Node<>(key, value);
		newNode.next = head;
		table[index] = newNode;
		size++;

		if (size >= capacity * loadFactor) {
			resize();
		}
	}

	public V get(K key) {
		int index = hash(key);
		for (Node<K, V> curr = table[index]; curr != null; curr = curr.next) {
			if (Objects.equals(curr.key, key)) {
				return curr.value;
			}
		}
		return null;
	}

	public V remove(K key) {
		int index = hash(key);
		Node<K, V> curr = table[index];
		Node<K, V> prev = null;

		while (curr != null) {
			if (Objects.equals(curr.key, key)) {
				//이전값이 null이면
				if (prev == null) {
					table[index] = curr.next;
				} else {
					prev.next = curr.next;
				}
				size--;
				return curr.value;
			}
			
			prev = curr;
			//다음 step으로 이동
			curr = curr.next;
		}
		return null;
	}

	private void resize() {
		capacity *= 2;
		Node<K, V>[] oldTable = table;
		table = new Node[capacity];
		size = 0;

		for (Node<K, V> node : oldTable) {
			while (node != null) {
				put(node.key, node.value);
				node = node.next;
			}
		}
	}

	public int size() {
		return size;
	}
}
