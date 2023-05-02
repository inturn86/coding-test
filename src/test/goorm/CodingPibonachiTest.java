package test.goorm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CodingPibonachiTest {


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
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		memo = new int[Integer.valueOf(input) + 1];
		// System.out.println(solution(Integer.valueOf(input)));
		int n = Integer.valueOf(input);

		memo[0] = 0;
		memo[1] = 1;
		if(n>0){
			for(int i=2;i<n;i++){
				memo[i] = ( memo[i-1] + memo[i-2] ) % 1000000007;
			}
		}

		System.out.println(memo[n-1]);
	}

	public static int solution(int i) {

		if(memo[i] > 0) {

		}
		int first = 0 ;
		int second = 1 ;
		if(i == 1){
			return memo[i] = first;
		}else if(i == 2){
			return memo[i] = second;
		}else{
			return memo[i] = solution(i - 1) + solution( i - 2);
		}
	}
}
