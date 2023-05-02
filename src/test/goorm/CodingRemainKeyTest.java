package test.goorm;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CodingRemainKeyTest {

//	문제
//
//	정수 가 주어진다. 정수 는 부터 까지 정수 를 제외한 모든 정수를  합한 값이다. 정수 는 항상 이상 이하의 수라고 할 때,  값을 출력하시오.
//
//	입력
//
//	첫째 줄에 정수 가 공백을 두고 주어진다.
//
//	조건을 만족하는 가 존재하는 입력만 주어진다.
//
//	출력
//
//	정수 를 출력하시오.
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		String[] arr = input.split(" ");
		long result = 0;
		for(int i = 1, len = Integer.valueOf(arr[0]); i <= len; i++) {
			result += i;
		}
		System.out.println(result - Long.valueOf(arr[1]));
	}

}
