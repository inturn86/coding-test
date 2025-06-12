package test.programmers;

import java.util.Stack;

public class CodingTest_주식가격 {

	public static void main(String[] args) {
		int[] i = {1, 2, 3, 2, 3};

		String s = "TTSS";
		String[] p = s.split("");
		solution(i);
	}

	public static int[] solution(int[] prices) {

		Stack<Integer> beginIdxs = new Stack<>();
		int i=0;
		int[] terms = new int[prices.length];

		beginIdxs.push(i);
		for (i=1; i<prices.length; i++) {
			while (!beginIdxs.empty() && prices[i] < prices[beginIdxs.peek()]) {
				int beginIdx = beginIdxs.pop();
				terms[beginIdx] = i - beginIdx;
			}
			beginIdxs.push(i);

		}
		while (!beginIdxs.empty()) {
			int beginIdx = beginIdxs.pop();
			terms[beginIdx] = i - beginIdx - 1;
		}

		return terms;
	}
}
