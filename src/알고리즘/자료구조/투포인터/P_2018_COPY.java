package 알고리즘.자료구조.투포인터;

import java.util.Scanner;

public class P_2018_COPY {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		int sIdx = 1;
		int eIdx = 1;

		int sum = 1;
		int result = 1;
		while (eIdx != N) {
			if(sum == N) {
				eIdx++;
				sum += eIdx;
				result++;
			}
			else if(sum > N){
				sum -= sIdx;
				sIdx++;
			}
			else {
				eIdx++;
				sum += eIdx;
			}
		}
		System.out.println(result);
	}

}
