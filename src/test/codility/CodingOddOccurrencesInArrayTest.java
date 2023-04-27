package test.codility;

import java.util.HashMap;
import java.util.Map;

public class CodingOddOccurrencesInArrayTest {

	public static void main(String[] args) {
		int[] i = {1, 2,2};
		solution(i);
	}

	public static int solution(int[] A) {

		Map<Integer, Integer> result = new HashMap<>();

		for(int i = 0; i < A.length; i ++){
			result.put(A[i], result.getOrDefault(A[i], 0) + 1);
		}

		for(Integer v : result.keySet()){
			var value =  result.get(v);
			if(value % 2 == 1){
				System.out.println(v);
				return v;
			}
		}
		return 0;
	}
}
