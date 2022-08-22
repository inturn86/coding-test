package test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

public class CodingTestMultiArray {

	public static void main(String[] args) {

		String[][] clo = {{"yellowhat", "headgear"}, {"bluesunglasses", "eyewear"}, {"green_turban", "headgear"}};
		solutions(clo);
	}

	//?€??΄ λͺ¨λ  κ°?μ§??? λ¬Έμ .
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

        // λ°°μ΄? μ’λ₯ λ³λ‘ ??κ°? λͺκ°?Έμ§? map? ?΄κΈ?
        for(int i = 0; i < clothes.length; i++) {
            String key = clothes[i][1]; // μ’λ₯ κ°?

            map.put(key, map.getOrDefault(key, 0) + 1); // ?΄?Ή μ’λ₯? ?? κ°μ μΆκ?
            // getOrDefault : key? ?΄?Ή?? value κ°μ΄ μ‘΄μ¬?λ©? κ°?? Έ??? μΆκ?, μ‘΄μ¬?μ§???Όλ©? 0? μΆκ?
        }

        int answer = 1;

        // Entry : key?? value ??€
        for(Entry<String, Integer> entry : map.entrySet()) {
            answer *= entry.getValue() + 1;
            // λͺ¨λ  μ’λ₯? ???΄ ?? κ°μ + 1 ? κ°?? Έ??? λͺ¨λ κ³±ν΄μ€? == κ°??₯? μ‘°ν©? κ°μ
            // +1 ? ?΄? ? ??? μ§ν©?? ??? ?λ½λ κ²½μ°λ₯? μΆκ??΄μ£ΌκΈ° ??¨
        }

        return answer - 1; // ?λ¬΄κ²? ? ? ??? κ²½μ° 1?΄ μ‘°ν©? κ°μ? ?¬?¨??΄?κΈ? ?λ¬Έμ 1? ? ?Έ?΄μ£ΌκΈ°
    }
}
