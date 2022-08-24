package test.stack;

import java.util.LinkedList;
import java.util.Queue;

public class CodingTestRightGualho {

//	문제 설명
//	괄호가 바르게 짝지어졌다는 것은 '(' 문자로 열렸으면 반드시 짝지어서 ')' 문자로 닫혀야 한다는 뜻입니다. 예를 들어
//
//	"()()" 또는 "(())()" 는 올바른 괄호입니다.
//	")()(" 또는 "(()(" 는 올바르지 않은 괄호입니다.
//	'(' 또는 ')' 로만 이루어진 문자열 s가 주어졌을 때, 문자열 s가 올바른 괄호이면 true를 return 하고, 올바르지 않은 괄호이면 false를 return 하는 solution 함수를 완성해 주세요.
//
//	제한사항
//	문자열 s의 길이 : 100,000 이하의 자연수
//	문자열 s는 '(' 또는 ')' 로만 이루어져 있습니다.

	public static void main(String[] args) {

		solution("(())()");
	}

	//괄호가 시작하고 닫히는 부분 확인. 아니라면 나가리.
	public static boolean solution(String s) {

		//queue는 (이면 넣는다. )만나면 뺀다.
		boolean answer = false;

		Queue<Integer> que = new LinkedList<Integer>();
		if(s.charAt(0) == ')') {
			return false;
		}
		for(int i = 0, len = s.length(); i < len; i++) {
			if(s.charAt(i) == '(') {
				que.add(i);
			}
			else {
				que.poll();
			}
		}
		if(que.size() == 0) {
			return true;
		}
		System.out.println(answer);
		return answer;
	}
}
