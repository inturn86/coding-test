package 알고리즘.트리.세그먼트트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class P_2042_시험후다시풀자 {

	static List<Long> selected = new ArrayList<>();
	static long[] arr;
	public static void main(String[] args) throws IOException {

		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int nCnt = Integer.parseInt(st.nextToken());
		int changeCnt = Integer.parseInt(st.nextToken());
		int sumCnt = Integer.parseInt(st.nextToken());

		//2^k <= N;
		int k = 1;
		while (true) {
			if(Math.pow(2, k) >= nCnt) {
				break;
			}
			k++;
		}
		int max = (int)(Math.pow(2, k) * 2);
		int startIndex = (int)Math.pow(2, k) - 1;

		arr = new long[max + 1];

		for(int i = 0; i < nCnt; i++) {
			arr[startIndex + i] = Long.parseLong(br.readLine());
		}

		//뒤에서 2개씩 쪼개서
		int min = max - 1;
		while (min != 1){
			arr[min / 2] += arr[min];
			min--;
		}

		for(int i = 0; i < changeCnt + sumCnt; i++) {
			st = new StringTokenizer(br.readLine());
			int q = Integer.parseInt(st.nextToken());
			int q1 = Integer.parseInt(st.nextToken());
			long q2 = Long.parseLong(st.nextToken());

			//갱신
			if(q == 1) {
				changeVal(startIndex + q1, q2);
				//index 찾기
//				int targetIndex = (int)(q1 + Math.pow(2, k) - 1);
//				arr[targetIndex] = q2;
//				while (targetIndex > 0) {
//					long sum = 0;
//					//나머지가 1이면
//					sum += arr[targetIndex];
//					if(targetIndex % 2 == 1) {
//						sum += arr[targetIndex - 1];
//					}
//					else {
//						sum += arr[targetIndex + 1];
//					}
//					targetIndex = targetIndex / 2;
//					arr[targetIndex] = sum;
//				}
			}
			//출력.
			else {
				int qStartIndex = (int) (q1 + Math.pow(2, k) - 1);
				int qEndIndex = (int) (q2 + Math.pow(2, k) - 1);

				selected.clear();
				printVal(qStartIndex, qEndIndex);
				System.out.println(selected.stream().mapToLong(o -> o).sum());
			}
		}
		br.close();
	}

	private static void changeVal(int index, long val) {
		long diff = val - arr[index];
		while (index > 0) {
			arr[index] = arr[index] + diff;
			index = index / 2;
		}
	}

	public static void printVal(int qStartIndex, int qEndIndex) {

		if(qStartIndex % 2 == 1) {
			selected.add(arr[qStartIndex]);
		}

		if(qEndIndex % 2 == 0) {
			selected.add(arr[qEndIndex]);
		}

		if(qStartIndex >= qEndIndex ) {
			return;
		}
		printVal((qStartIndex + 1) / 2, (qEndIndex - 1) / 2);
	}
}
