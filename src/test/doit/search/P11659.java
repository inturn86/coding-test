package test.doit.search;

import java.io.IOException;
import java.util.Scanner;

public class P11659 {

	public static void main(String[] args) throws IOException {
		Scanner bufferedReader
				= new Scanner(System.in);
		int suNo = bufferedReader.nextInt();
		int quizNo = bufferedReader.nextInt();
		long[] S = new long[suNo + 1];
		for (int i = 1; i <= suNo; i++) {
			S[i] = S[i - 1] + bufferedReader.nextInt();
		}
		for (int q = 0; q < quizNo; q++) {
			int i = bufferedReader.nextInt();
			int j = bufferedReader.nextInt();
			System.out.println(S[j] - S[i - 1]);
		}
//		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
//
//		int suNo = Integer.parseInt(stringTokenizer.nextToken());
//		int quizNo = Integer.parseInt(stringTokenizer.nextToken());
//
//		int[] arr = new int[suNo + 1];
//
//		stringTokenizer = new StringTokenizer(bufferedReader.readLine());
//		for(int i = 1; i <= suNo; i++) {
//			int num = Integer.parseInt(stringTokenizer.nextToken());
//			arr[i] = arr[i-1] + num;
//		}
//
//		for(int i = 0; i < quizNo; i++) {
//			stringTokenizer = new StringTokenizer(bufferedReader.readLine());
//			int start = Integer.parseInt(stringTokenizer.nextToken());
//			int end = Integer.parseInt(stringTokenizer.nextToken());
//
//			System.out.println(arr[end] - arr[start - 1]);
//		}
//		System.exit(0);
	}
}
