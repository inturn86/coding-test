package 알고리즘.자료구조.슬라이딩윈도우;

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class P_11003 {

//	최솟값 찾기 성공
//	시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
//2.4 초 (하단 참고)	512 MB	47682	15130	9923	31.214%
//	문제
//	N개의 수 A1, A2, ..., AN과 L이 주어진다.
//
//			Di = Ai-L+1 ~ Ai 중의 최솟값이라고 할 때, D에 저장된 수를 출력하는 프로그램을 작성하시오. 이때, i ≤ 0 인 Ai는 무시하고 D를 구해야 한다.
//
//	입력
//	첫째 줄에 N과 L이 주어진다. (1 ≤ L ≤ N ≤ 5,000,000)
//
//	둘째 줄에는 N개의 수 Ai가 주어진다. (-109 ≤ Ai ≤ 109)
//
//	출력
//	첫째 줄에 Di를 공백으로 구분하여 순서대로 출력한다.
//
//	예제 입력 1
//			12 3
//			1 5 2 3 6 2 3 7 3 5 2 6
//	예제 출력 1
//			1 1 1 2 2 2 2 2 3 3 2 2


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 출력을 그때 그때 하는 것보다 버퍼에 넣고 한번에 출력하기 위해 BufferedWriter를 사용
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int size = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		Deque<Node> dq = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			int v = Integer.parseInt(st.nextToken());
			Node n = new Node(v, i);
			while (!dq.isEmpty() && dq.getLast().val > v) {
				dq.removeLast();
			}

			dq.addLast(n);

			if(dq.getFirst().idx <= i - size) {
				dq.removeFirst();
			}
			bw.write(dq.getFirst().val + " ");
		}

		bw.flush();
		bw.close();
	}

	public static class Node {
		private int val;
		private int idx;

		public Node (int val, int idx) {
			this.idx = idx;
			this.val = val;
		}
	}
}
