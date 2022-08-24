package test.dfs;

import java.util.concurrent.atomic.AtomicInteger;

public class CodingTestTargetNumberResol {



//	문제 설명
//
//	n개의 음이 아닌 정수가 있습니다. 이 수를 적절히 더하거나 빼서 타겟 넘버를 만들려고 합니다. 예를 들어 [1, 1, 1, 1, 1]로 숫자 3을 만들려면 다음 다섯 방법을 쓸 수 있습니다.
//
//	-1+1+1+1+1 = 3 +1-1+1+1+1 = 3 +1+1-1+1+1 = 3 +1+1+1-1+1 = 3 +1+1+1+1-1 = 3
//
//	사용할 수 있는 숫자가 담긴 배열 numbers, 타겟 넘버 target이 매개변수로 주어질 때 숫자를 적절히 더하고 빼서 타겟 넘버를 만드는 방법의 수를 return 하도록 solution 함수를 작성해주세요.
//
//	제한사항
//
//	주어지는 숫자의 개수는 2개 이상 20개 이하입니다.
//	각 숫자는 1 이상 50 이하인 자연수입니다.
//	타겟 넘버는 1 이상 1000 이하인 자연수입니다.
	public static void main(String[] args) {

//	answer = 5
		solution(new int[] {4,1,2,1}, 4);
	}

	static int answer = 0;
	static AtomicInteger st = new AtomicInteger();
	static AtomicInteger ed = new AtomicInteger();
	public static int solution(int[] numbers, int target) {


		DFS(0, 0, target, numbers);
		return answer;
	}


	static void DFS(int depth, int result, int target, int[] numbers) {
		if(depth == numbers.length) {
			if(target == result) {
				answer++;
			}
			System.out.println("return");
			return;
		}

		System.out.println("depth = " + depth);
		int add = result + numbers[depth];

		int sub = result - numbers[depth];

		System.out.println("numbers = " + numbers[depth]);
		//더하는 항목에의 한 계산
		System.out.println("Start add Result = " + st.addAndGet(1)+ "=== " + result);
		DFS(depth + 1, add, target, numbers);
		System.out.println("End add Result = " + st.get()+ "=== " + result);

		System.out.println("Start sub Result = " + ed.addAndGet(1)+ "=== " + result);
		DFS(depth + 1, sub, target, numbers);
		System.out.println("End sub Result = " + ed.get()+ "=== " + result);
	}


}
