package test.codility.examine;

public class CodingTest2 {

	public static void main(String[] args) {
		int N = 10;
		int K = 5;
		System.out.println(solution(N,K));
	}

	public static int solution(int N, int K) {

		//K 리터의 물을
		int answer = 0;
		int sum = 0 ;
		int[] arr = new int[N];
		for (int i = N; i >= 1; i--){
			sum += i;
			arr[i-1] = i;
		}


		//용량이 작으면
		if(sum < K){
			return -1;
		}
		if(sum == K){
			return N;
		}
		//계산 역순으로
		int remain = K;
		for(int i = arr.length - 1; i >= 0; i--){
			remain = remain - arr[i];
			answer++;
			if(remain <= 0){
				return answer;
			}
		}
		return answer;
	}
}
