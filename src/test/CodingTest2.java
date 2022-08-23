package test;

import java.util.Arrays;
import java.util.Comparator;

public class CodingTest2 {

	public static void main(String[] args) {


		//want는 원하는 제품
		//number는 원하는 수
		//number의 모든 합은 10
		//discount의 길이는 최소 10
		String[] s = {"banana", "apple", "rice", "pork", "pot"};
				int[] n ={3, 2, 2, 2, 1};
						String[] d = {"chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana"};
		solutions(s, n, d);
	}

	public static int solutions(String[] want, int[] number, String[] discount) {
		int answer = 0;
		int max = Arrays.stream(number).sum();

		String[] wantNumber = new String[max];

		int nextCnt = 0;
		for(int i = 0, len = want.length; i< len;i++) {

			for(int j = 0, jlen = number[i]; j < jlen; j++) {
				nextCnt = j;
				wantNumber[nextCnt] = want[i];
			}
		}
		Arrays.sort(wantNumber);
		String strWantNumber = Arrays.toString(wantNumber);

		String[] targetWant = new String[max];
		String strWant = Arrays.toString(want);
		for(int i = 0, len = discount.length; i < len; i++) {
			//해당 제품이 구매 목록에 있으면
			if(strWant.indexOf(discount[i]) != -1) {
				if(i + max < discount.length) {
					break;
				}
				else {
					for(int j = i, jlen = i + max; j < jlen; j++) {
						targetWant[j - i] = want[j];
					}
					Arrays.sort(targetWant);
					String targetWantNumber = Arrays.toString(wantNumber);
					if(targetWantNumber.equals(strWantNumber)) {
						answer++;
					}
				}
			}
		}
		return answer;
	}
}
