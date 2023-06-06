package test.codility.yanolza;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CodingTest2 {

	public static void main(String[] args) {
		int[] i = {1,2,1,2,1,2};
		solution("aabbcc",i);
	}

	public static int solution(String S, int[] C) {

		int answer = 0;
		int[][] idxVal = new int[S.length()][S.length()];
		int sameIdx = 0;
		List<Integer> val = new ArrayList<>();
		int totalCost = 0;
		val.add(C[0]);
		for(int i = 0, len = S.length() - 1; i < len; i++){
			//문자열이 같으면
			if(S.charAt(i) == S.charAt(i + 1) ){
				val.add(C[i+1]);
			}
			else{
				List<Integer> sorted = val.stream().sorted().collect(Collectors.toList());
				for(int j = 0, jlen = sorted.size() - 1; j < jlen; j++){
					totalCost += sorted.get(j);
				}
				val = new ArrayList<>();
				val.add(C[i+1]);
			}
		}
		if(val.size() != 0){
			List<Integer> sorted = val.stream().sorted().collect(Collectors.toList());
			for(int j = 0, jlen = sorted.size() - 1; j < jlen; j++){
				totalCost += sorted.get(j);
			}
		}

		return totalCost;
	}
}
