package 알고리즘.자료구조.투포인터;

import java.util.Scanner;

public class P_2018 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		int sIdx = 1;
		int eIdx = 1;
		int result = 1;
		int sum = 1;
		while (eIdx != N) {
			if(sum > N) {
				sum = sum - sIdx;
				sIdx++;
			}
			else if(sum < N) {
				eIdx++;
				sum = sum + eIdx;
			}
			else {
				result++;
				eIdx++;
				sum = sum + eIdx;
			}
		}
		System.out.println(result);
	}
}
