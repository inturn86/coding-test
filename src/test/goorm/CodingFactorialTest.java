package test.goorm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CodingFactorialTest {


//	문제
//
//	팩토리얼 수학 기호는 아래와 같이 정의할 수 있다.
//
//
//
//	이때 이 주어지면,  값을 출력하시오.
//
//
//
//
//	입력
//
//	첫째 줄에 이 주어진다.
//
//
//
//
//	출력
//
//	값을 값으로 나눈 나머지를 출력하시오.

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		int n = Integer.valueOf(input);

		long result = 1;
		for (int i = 1; i <= n; i++) {
			//arr[i-1] = i;
			result = (result *= i) % 1000000007;
		}
		System.out.println(result);
		System.out.println(result % 1000000007);
	}
}
