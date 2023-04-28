package test.codility;

import java.util.*;

public class CodingNestingTest {

//	N개의 문자로 구성된 문자열 S는 다음과 같은 경우 적절하게 중첩되었다고 합니다.
//
//	S는 비어 있습니다.
//			S는 "(U)" 형식을 가집니다. 여기서 U는 적절하게 중첩된 문자열입니다.
//			S는 "VW" 형식을 갖습니다. 여기서 V와 W는 적절하게 중첩된 문자열입니다.
//	예를 들어 문자열 "(()(())())"은 제대로 중첩되지만 문자열 "())"은 중첩되지 않습니다.
//
//	함수 작성:
//
//	class Solution { public int solution(String S); }
//
//	N개의 문자로 구성된 문자열 S가 주어지면 문자열 S가 제대로 중첩되면 1을 반환하고 그렇지 않으면 0을 반환합니다.
//
//	예를 들어 S = "(()(())())"가 주어지면 함수는 1을 반환하고 S = "())"가 주어지면 위에서 설명한 대로 함수는 0을 반환해야 합니다.
//
//	다음 가정에 대한 효율적인 알고리즘을 작성하십시오.
//
//	N은 [0..1,000,000] 범위 내의 정수이고;
//	문자열 S는 문자 '(' 및/또는 ')'로만 구성됩니다.

	public static void main(String[] args) {
		int i = 0;
		solution("()()()(())");
	}

	public static int solution(String S) {
		// Implement your solution here
		Queue<String> qu = new LinkedList<>();

		if(S.length() % 2 == 1){
			return 0;
		}

		for(int i = 0, len = S.length(); i < len; i++){
			if('(' == S.charAt(i)){
				qu.add("(");
			}
			else{
				qu.poll();
			}
		}

		if(qu.size() != 0){
			return 0;
		}
		return 1;
	}
}
