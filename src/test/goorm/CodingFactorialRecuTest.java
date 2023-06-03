package test.goorm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CodingFactorialRecuTest {


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
		System.out.println(factorial(5));
	}

	private static int factorial(int n) {
		if(n == 1){
			return n;
		}
		else{
			System.out.println("n = " + n);
			int result = n * (factorial(n -1));
			System.out.println("result = " + result);
			return result;
		}
	}
}
