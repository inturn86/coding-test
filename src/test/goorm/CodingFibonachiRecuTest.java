package test.goorm;

import java.io.IOException;

public class CodingFibonachiRecuTest {


//	피보나치 수열이 있다. 피보나치 수열은 과 로 시작하며, 그 다음 수는 바로 앞의 두 피보나치 수의 합이 된다.
//
//	이 번째 피보나치 수라면, 다음과 같은 공식이 성립한다.
//
// ,
//	이때 가 주어지면,  값을 출력하시오.
//
//
//
//	입력
//
//	첫째 줄에 가 주어진다.
//
	static int[] memo;
	public static void main(String[] args) throws IOException {
		int n = 6;
		memo = new int[n + 1];
		System.out.println(fiboMemo(n));
	}

	public static int fiboMemo(int n) {

		if(n <= 1){
			return n;
		}
		//0이 아닌 수에 대해서는 먼저 반환.
		else if(memo[n] != 0){
			return memo[n];
		}
		else{
			System.out.println("else " + n);
			return memo[n] = fiboMemo(n - 2 ) + fiboMemo( n - 1);
		}
	}

	public static int fibo(int n) {

		if(n <= 1){

			System.out.println("n <= " + n);
			return n;
		}
		else{
			System.out.println("else " + n);
			return fibo(n - 2 ) + fibo( n - 1);
		}
	}
}
