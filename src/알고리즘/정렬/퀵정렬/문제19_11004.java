package 알고리즘.정렬.퀵정렬;

import java.util.Scanner;

public class 문제19_11004 {

//	문제
//	수 N개 A1, A2, ..., AN이 주어진다. A를 오름차순 정렬했을 때, 앞에서부터 K번째 있는 수를 구하는 프로그램을 작성하시오.
//
//	입력
//	첫째 줄에 N(1 ≤ N ≤ 5,000,000)과 K (1 ≤ K ≤ N)이 주어진다.
//
//	둘째에는 A1, A2, ..., AN이 주어진다. (-109 ≤ Ai ≤ 109)
//
//	출력
//	A를 정렬했을 때, 앞에서부터 K번째 있는 수를 출력한다.
//
//	예제 입력 1
//			5 2
//			4 1 2 3 5
//	예제 출력 1
//			2

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int target = sc.nextInt();
		int[] A = new int[n];

		for(int i = 0; i < n; i++) {
			A[i] = sc.nextInt();
		}

		quickSort1(A, 0, n-1, target-1);

		System.out.println(A[target - 1]);
//		quickSort(A, 0, n-1);
	}

	public static void quickSort1(int[] A, int left, int right, int target) {

		int pivot = changeVal(A, left, right, target);

		if(left < pivot) {
			quickSort1(A, left, pivot - 1, A[pivot]);
		}
		if(pivot < right) {
			quickSort1(A, pivot+1, right, A[pivot]);
		}
	}

	private static int changeVal(int[] A, int left, int right, int target) {
		int pivot = A[(left + right) / 2];
 		while (left <= right
//				|| right - left <= 1
		) {
			int pivotVal = pivot;
			if(pivotVal > A[left]) {
				left++;
			}
 			else if(pivotVal < A[right]) {
				right--;
			}
//			else if(pivotVal < A[left] && pivotVal > A[right]) {
			else if (left <= right) {
				int swapVal = A[left];
				A[left] = A[right];
				A[right] = swapVal;
				left++;
				right--;
			}
		}
		return left;
	}

	public static void quickSort(int[] A, int left, int right) {
		int part = partition(A, left, right);
		if (left < part - 1) {
			quickSort(A, left, part - 1);
		}
		if (part < right) {
			quickSort(A, part, right);
		}
	}
	public static int partition(int[] A, int left, int right) {
		int pivot = A[(left + right) / 2];
		while (left <= right) {
			while (A[left] < pivot) {
				left++;
			}
			while (A[right] > pivot) {
				right--;
			}
			if (left <= right) {
				int swapVal = A[left];
				A[left] = A[right];
				A[right] = swapVal;
				left++;
				right--;
			}
		}
		return left;
	}

}
