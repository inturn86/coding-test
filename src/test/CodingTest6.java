package test;

import java.util.HashSet;
import java.util.Set;

public class CodingTest6 {

	public static void main(String[] args) {



		solutions(new int[]{1, 2, 1, 3, 1, 4, 1, 2} );
	}


	public static int solutions(int[] topping) {
		int answer = 0;

//		1 2 3 4

		int len = topping.length;
		int result = 0;
		int cheolsuArr[] = new int[len+1];
		int brotherArr[] = new int[len+1];

		int cheolsuCount = 0;
		int brotherCount = 0;
		for (int i = 0; i < len; i++) {
			if(cheolsuArr[topping[i]] == 0) {
				cheolsuCount++;
			}
			cheolsuArr[topping[i]]++;
		}


		for(int i=0; i<len; i++) {
			if(brotherArr[topping[i]] == 0) {
				brotherCount++;
			}
			brotherArr[topping[i]]++;
			cheolsuArr[topping[i]]--;

			if(cheolsuArr[topping[i]] == 0) {
				cheolsuCount--;
			}
			if(cheolsuCount == brotherCount) result++;
		}


		return result;

		//1~7 length 만큼
//
//		for(int i = 1, len = topping.length; i < len; i++) {
//			Set<Integer> s = new HashSet<Integer>();
//			Set<Integer> e = new HashSet<Integer>();
//			for(int j = 0, jlen = i ; j < jlen; j++) {
//				s.add(topping[j]);
//			}
//			for(int z = i, zlen = topping.length ; z < zlen; z++) {
//				e.add(topping[z]);
//			}
//			if(s.size() == e.size()) {
//				answer++;
//			}
//		}

//		return answer;
	} // End of solution



}
