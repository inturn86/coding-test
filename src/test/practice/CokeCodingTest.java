package test.practice;

public class CokeCodingTest {

	public static void main(String[] args) {
		int i = 0;
		System.out.println(solution(2,1,20));

	}

//	콜라를 받기 위해 마트에 주어야 하는 병 수 a, 빈 병 a개를 가져다 주면 마트가 주는 콜라 병 수 b, 상빈이가 가지고 있는 빈 병의 개수 n이 매개변수로 주어집니다. 상빈이가 받을 수 있는 콜라의 병 수를 return 하도록 solution 함수를 작성해주세요.
//	1 ≤ b < a ≤ n ≤ 1,000,000
	//총 빈병수 n
	//받는 콜라 수 b
	//주는 빈병 수 a
	public static int solution(int a, int b, int n) {

		int answer = 0 ;

		//초기에는 빈병으로 시작
		//빈병을 내고 받으면 다시 빈병이 된다.
		//나머지 빈병수가 주는 빈병수 보다 작아질 경우 종료
		int totalCoke = 0;
		while(n >= a || n == 0) {
			int getCoke = (n / a) * b;
			int remainCoke = n % a;
			totalCoke += getCoke;
			n = remainCoke + getCoke;


			System.out.println(getCoke);
			System.out.println(remainCoke);
			System.out.println(n);
		}

		return totalCoke;
	}
}
