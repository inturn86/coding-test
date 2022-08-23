package test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

public class CodingTestClothes {

	public static void main(String[] args) {

		String[][] clo = {{"yellowhat", "headgear"}, {"bluesunglasses", "eyewear"}, {"green_turban", "headgear"}};
		solutions(clo);
	}

	//?��?��?�� 모든 �?�??��?�� 문제.
	public static int solutions(String[][] clothes) {
		int answer = 1;

		HashMap<String, List<String>> typeMap = new HashMap<>();

		for(int i = 0, ilen = clothes.length; i < ilen; i++) {
			List<String> clothesByType = typeMap.getOrDefault(clothes[i][1], new ArrayList<String>());
			clothesByType.add(clothes[i][0]);
			typeMap.put(clothes[i][1], clothesByType);
		}
//        for(int i =0; i<clothes.length; i++){
//        	typeMap.put(clothes[i][1], typeMap.getOrDefault(clothes[i][1],0)+1);
//        }

		for(String type : typeMap.keySet()) {
			answer *= (typeMap.get(type).size()+1);
        }
        answer -=1;

		return answer;

		//https://junghn.tistory.com/55
	}

	public int solution2(String[][] clothes) {
        HashMap<String, Integer> map = new HashMap<String, Integer>();

        // 배열?�� 종류 별로 ?��?���? 몇개?���? map?�� ?���?
        for(int i = 0; i < clothes.length; i++) {
            String key = clothes[i][1]; // 종류 �?

            map.put(key, map.getOrDefault(key, 0) + 1); // ?��?�� 종류?�� ?��?�� 개수 추�?
            // getOrDefault : key?�� ?��?��?��?�� value 값이 존재?���? �??��???�� 추�?, 존재?���??��?���? 0?�� 추�?
        }

        int answer = 1;

        // Entry : key?? value ?��?��
        for(Entry<String, Integer> entry : map.entrySet()) {
            answer *= entry.getValue() + 1;
            // 모든 종류?�� ???�� ?��?�� 개수 + 1 ?�� �??��???�� 모두 곱해�? == �??��?�� 조합?�� 개수
            // +1 ?�� ?��?��?�� ?��?��?�� 집합?��?�� ?��?��?�� ?��뽑는 경우�? 추�??��주기 ?��?��
        }

        return answer - 1; // ?��무것?�� ?��?�� ?��?��?�� 경우 1?�� 조합?�� 개수?�� ?��?��?��?��?���? ?��문에 1?�� ?��?��?��주기
    }
}
