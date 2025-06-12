package test.doit.search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class P11003_최솟값찾기 {

	public static void main(String[] args) throws IOException {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int N = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		int Result = 0;
		int A[] = new int[N];

		Deque<Node> dq = new LinkedList<>();
		st = new StringTokenizer(bf.readLine());
		for(int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}

		List<Integer> result = new ArrayList<>();
		for(int i = 0, len = A.length; i < len; i++) {

			int num = A[i];
			while(!dq.isEmpty() && dq.getLast().val > num) {
				dq.removeLast();
			}
			dq.addLast(new Node(i, num));

			if(dq.getFirst().idx <= i - R) {
				dq.removeFirst();
			}

			result.add(dq.getFirst().val);
		}

		System.out.println(result.stream().map(o -> String.valueOf(o)).collect(Collectors.joining(" ")));

	}

	static class Node {

		public int idx;

		public int val;
		public Node(int idx, int val) {
			this.idx = idx;
			this.val = val;
		}
	}

}
