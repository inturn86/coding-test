package test.codility;

import java.util.*;

public class ThreeLettersTest {

//	두 개의 정수 A와 B가 주어지면 정확히 A 문자 'a'와 정확히 B 문자 'b'를 포함하는 문자열을 반환하는 함수 솔루션을 작성하십시오. "가 반환된 문자열에 나타날 수 있음).
//
//	예:
//
//			1. A = 5이고 B = 3이면 함수가 "aabaabab"를 반환할 수 있습니다. "abaabbaa"도 정답이 됩니다. 함수는 정답을 반환할 수 있습니다.
//
//2. A = 3이고 B = 3이면 함수는 "ababab", "aababb", "abaabb" 또는 기타 여러 문자열을 반환해야 합니다.
//
//			3. A = 1이고 B = 4인 경우 함수는 이 경우 유일한 정답인 "bbabb"를 반환해야 합니다.
//
//	다음을 가정합니다.
//
//	A와 B는 [0..100] 범위 내의 정수입니다.
//	주어진 A와 B에 대해 적어도 하나의 솔루션이 존재합니다.
//	솔루션에서 정확성에 중점을 둡니다. 솔루션의 성능은 평가의 초점이 아닙니다.
	public static void main(String[] args) {
		int i = 8, j  = 4;
		solution(i, j);
	}


	public static String solution(int A, int B) {

		Map<String, Integer> dataMap = new LinkedHashMap<>();
		if(A >= B){
			dataMap.put("a", A);
			dataMap.put("b", B);
		}
		else {
			dataMap.put("b", B);
			dataMap.put("a", A);
		}
		Map<String, String> diffMap = new HashMap<>();
		diffMap.put("a", "b");
		diffMap.put("b", "a");
		boolean isTask = true;

		String result = "";
		while(isTask){
			var endCount = 0;
			for(String k : dataMap.keySet()){
				var remain = dataMap.get(k);
				if(remain > 0) {
					int anoRemain = dataMap.get(diffMap.get(k));
					int size = 0;
					if(anoRemain <=  remain) {
						size = remain >= 2 ? 2 : remain;
					}
					else{
						size = 1;
					}
					for(int j = 0; j < size; j++){
						result += k;
					}
					var remainInt = remain - size;
					dataMap.put(k, remainInt);
					if(remainInt == 0) {
						endCount++;
					}
				}
				else {
					endCount++;
				}
			}
			if(endCount == 2){
				isTask = false;
			}
		}
		System.out.println(result);
		return result;
	}

}
