package test.dp;

import java.util.HashSet;
import java.util.Set;

public class CodingTestNDisplay {

//	아래와 같이 5와 사칙연산만으로 12를 표현할 수 있습니다.
//
//	12 = 5 + 5 + (5 / 5) + (5 / 5)
//	12 = 55 / 5 + 5 / 5
//	12 = (55 + 5) / 5
//
//	5를 사용한 횟수는 각각 6,5,4 입니다. 그리고 이중 가장 작은 경우는 4입니다.
//	이처럼 숫자 N과 number가 주어질 때,
//	N과 사칙연산만 사용해서 표현 할 수 있는 방법 중 N 사용횟수의 최솟값을 return 하도록 solution 함수를 작성하세요.
//
//	제한사항
//	N은 1 이상 9 이하입니다.
//	number는 1 이상 32,000 이하입니다.
//	수식에는 괄호와 사칙연산만 가능하며 나누기 연산에서 나머지는 무시합니다.
//	최솟값이 8보다 크면 -1을 return 합니다.
//	입출력 예

	//N은 사용할 수
	//number는 목표 수
	//4칙 연산의 사용 수
	//최소값이 8보다 크면 return -1
	public static void main(String[] args) {

		solution(5, 12);
	}
	public static int solution(int N, int number) {
	       int answer = -1;
	        Set<Integer>[] setArr = new Set[9];
	        int t = N;
	        //최대값을 만들어 둔다.
	        //최대가지수 . 해당 부분을 곱하고 하여 저장.
	        for(int i = 1; i < 9; i++) {
	            setArr[i] = new HashSet<>();
	            setArr[i].add(t);
	            t = t * 10 + N;
	        }
	        for(int i = 1; i < 9; i++) {
	            for(int j = 1; j < i; j++) {
	                for(Integer a : setArr[j]) {
	                    for(Integer b : setArr[i - j]) {
	                        setArr[i].add(a + b);
	                        setArr[i].add(a - b);
	                        setArr[i].add(b - a);
	                        setArr[i].add(a * b);
	                        if(b != 0) {
	                            setArr[i].add(a / b);
	                        }
	                        if(a != 0) {
	                            setArr[i].add(b / a);
	                        }
	                    }
	                }
	            }
	        }
	        for(int i = 1; i < 9; i++) {
	            if(setArr[i].contains(number)) {
	                answer = i;
	                break;
	            }
	        }
	        return answer;
	    }
}
