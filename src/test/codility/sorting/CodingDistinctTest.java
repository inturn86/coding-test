package test.codility.sorting;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CodingDistinctTest {

	public static void main(String[] args) {
		int[] i = {2,1,1,2,3,1};
		solution(i);
	}

	public static int solution(int[] A) {
		Arrays.sort(A);
		Integer beforeInt = null;
		int result = 0;
//		Set<Integer> s = new HashSet<>();
		for(int i = 0; i < A.length; i++) {
//			s.add(A[i]);
			if(beforeInt == null) {
				beforeInt = A[i];
				result++;
			}
			else {
				if(beforeInt != A[i]) {
					beforeInt = A[i];
					result++;
				}
			}
		}
		return result;
	}
}
