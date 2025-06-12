package 알고리즘.탐색.이진탐색;

import java.util.Arrays;
import java.util.Scanner;

public class P_1920_RETRY {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int arr[] = new int[N];
		for(int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}

		Arrays.sort(arr);
		int fN = sc.nextInt();
		int fArr[] = new int[fN];
		for(int i = 0; i < fN; i++) {
			int t = sc.nextInt();

			int stx = 0;
			int edx = arr.length - 1;
			while (stx <= edx) {
				int mid = stx + ((edx - stx) / 2);
				int target = arr[mid];
				if(target == t) {
					fArr[i] = 1;
					break;
				}
				else {
					if(t > target) {
						stx = mid + 1;
					}
					else {
						edx = mid - 1;
					}
				}
			}
		}

		for(int i = 0; i < fArr.length; i++) {
			System.out.println(fArr[i]);
		}
	}


//	Scanner sc = new Scanner(System.in);
//
//	int N = sc.nextInt();
//	int arr[] = new int[N];
//		for(int i = 0; i < N; i++) {
//		arr[i] = sc.nextInt();
//	}
//
//		Arrays.sort(arr);
//	int fN = sc.nextInt();
//	int fArr[] = new int[fN];
//		for(int i = 0; i < fN; i++) {
//		int t = sc.nextInt();
//		int idx = 0;
//		int edx = arr.length - 1;
//		boolean findFlag = false;
//		while (idx <= edx) {
//			int tIdx = (idx + edx) / 2;
//			if(arr[tIdx] == t) {
//				findFlag = true;
//				break;
//			}
//			else if(arr[tIdx] < t){
//				tIdx++;
//				idx = tIdx;
//			}
//			else {
//				tIdx--;
//				edx = tIdx;
//			}
//		}
//
//		fArr[i] = findFlag ? 1 : 0;
//	}
//
//		for(int i : fArr) {
//		System.out.println(i);
//	}
}
