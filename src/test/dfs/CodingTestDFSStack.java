package test.dfs;

import java.util.Stack;

public class CodingTestDFSStack {

	public static void main(String[] args) {
		solution(5);
	}

	static class P {
		int open, close;

		P(int open, int close) {
			this.open = open;
			this.close = close;
		}
	}

	static int count = 0;

	// 숫자를 입력할 때 ()가 숫자만큼 생성된다
	// 이 때 ()의 조합으로 만들 수 있는 가지수를 생성
	//
	public static int solution(int n) {
		int answer = 0;

		// 열리는 괄호의 갯수, 닫히는 괄호의 갯수 추적
		Stack<P> stack = new Stack<>();
		// Stack 대신 Queue를 사용해도 답을 얻을 수 있음
		stack.push(new P(0, 0));

		while (!stack.isEmpty()) {
			P p = stack.pop();

			System.out.println("====");
			System.out.println(p.open);
			System.out.println(p.close);
			System.out.println("====");

			if (p.open > n)
				continue;
//			닫히는 괄호의 개수가 열리는 괄호 개수보다 클 수 없다.
			if (p.open < p.close)
				continue;
			if (p.open + p.close == 2 * n) {
				answer++;
				continue;
			}

			stack.push(new P(p.open + 1, p.close));
			stack.push(new P(p.open, p.close + 1));
		}

		System.out.println("answer = " + answer);
		return answer;
	}

}
