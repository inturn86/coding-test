package test.programmers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class CodingTest_뒤에있는큰수찾기 {

	public static void main(String[] args) {
		int[] i = {95, 90, 99, 99, 80, 99};
		int[] j = {1, 1, 1, 1, 1, 1};
		solution(i);
	}

	public static int[] solution(int[] numbers) {
		int[] answer = new int[numbers.length];

		Stack<Integer> s = new Stack<>();
		Arrays.fill(answer,-1);

		s.push(0);
		for(int i = 1; i < numbers.length; i++) {

			while (!s.isEmpty()) {
				int idx = s.pop();

				if(numbers[i] > numbers[idx]) {
					answer[idx] = numbers[i];
				}
				else {
					s.push(idx);
					break;
				}
			}
			s.push(i);
		}
		for (int d : answer) {
		System.out.println(d);
	}
		return answer;
	}




//	int[] answer = new int[numbers.length];
//		Arrays.fill(answer, -1);
//	Queue<Integer> s = new LinkedList<>();
//		s.add(0);
//		for(int i = 1; i < numbers.length; i++){
//		while(!s.isEmpty()){
//			int idx = s.poll();
//			if(numbers[i] > numbers[idx]){ // 뒤가 더 클때
//				answer[idx] = numbers[i];
//			} else { // 앞이 더 크거나 같을 때
//				s.add(idx);
//				break;
//			}
//		}
//		s.add(i);
//	}
//
//		for (int d : answer) {
//		System.out.println(d);
//	}
//		return answer;
}
