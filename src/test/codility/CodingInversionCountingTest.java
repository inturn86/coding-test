package test.codility;

public class CodingInversionCountingTest {

	static int[] arr;
	static int[] tmp;
	static int inversion;
	public static void main(String[] args) {
		int[] a = {5,4,3,2,1};

		arr = a;
		tmp = new int[a.length];
		inversion = 0;

		mergeSort(0, arr.length-1);


		System.out.println(inversion);
	}
	public int solution(int[] a) {
		// Implement your solution here
		arr = a;
		tmp = new int[a.length];
		inversion = 0;

		mergeSort(0, arr.length-1);

		if(inversion > 1000000000){
			return -1;
		}
		return inversion;
	}

	static void mergeSort(int start, int end) {
		if (start >= end)   // 끝까지 분할 한 경우
			return;

		int mid = (start + end) >> 1; // 중앙 값
		mergeSort(start, mid);  // 좌측 (divide)
		mergeSort(mid+1, end);  // 우측 (divide)
		merge(start, end);  // 병합 (conquer)
	}

	static void merge(int left, int right) {
		int mid = (left + right) >> 1;
		int leftIdx = left;     // 좌측 배열 탐색 인덱스
		int rightIdx = mid+1;   // 우측 배열 탐색 인덱스
		int tempIdx = left;     // 임시 저장 배열 인덱스

		while (leftIdx <= mid && rightIdx <= right) {
			if(arr[leftIdx] <= arr[rightIdx]) {
				tmp[tempIdx++] = arr[leftIdx++];
			} else {
				// inversion 발생 경우 (leftIdx < rightIdx && arr[leftIdx] > arr[rightIdx] )
				tmp[tempIdx++] = arr[rightIdx++];
				inversion += (mid - leftIdx + 1);   // 교차점 count
			}
		}

		// 좌측 잔여 원소 배치
		while(leftIdx <= mid) {
			tmp[tempIdx++] = arr[leftIdx++];
		}

		// 우측 잔여 원소 배치
		while(rightIdx <= right) {
			tmp[tempIdx++] = arr[rightIdx++];
		}

		// copy array
		for(int i = left; i<=right; i++) {
			arr[i] = tmp[i];
		}
	}
}
