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

	//?Š¤?ŒŒ?´ ëª¨ë“  ê°?ì§??ˆ˜?˜ ë¬¸ì œ.
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

        // ë°°ì—´?˜ ì¢…ë¥˜ ë³„ë¡œ ?›?†Œê°? ëª‡ê°œ?¸ì§? map?— ?‹´ê¸?
        for(int i = 0; i < clothes.length; i++) {
            String key = clothes[i][1]; // ì¢…ë¥˜ ê°?

            map.put(key, map.getOrDefault(key, 0) + 1); // ?•´?‹¹ ì¢…ë¥˜?— ?›?†Œ ê°œìˆ˜ ì¶”ê?
            // getOrDefault : key?— ?•´?‹¹?•˜?Š” value ê°’ì´ ì¡´ì¬?•˜ë©? ê°?? ¸???„œ ì¶”ê?, ì¡´ì¬?•˜ì§??•Š?œ¼ë©? 0?— ì¶”ê?
        }

        int answer = 1;

        // Entry : key?? value ?Œ?“¤
        for(Entry<String, Integer> entry : map.entrySet()) {
            answer *= entry.getValue() + 1;
            // ëª¨ë“  ì¢…ë¥˜?— ???•´ ?›?†Œ ê°œìˆ˜ + 1 ?„ ê°?? ¸???„œ ëª¨ë‘ ê³±í•´ì¤? == ê°??Š¥?•œ ì¡°í•©?˜ ê°œìˆ˜
            // +1 ?˜ ?´?œ ?Š” ?•˜?‚˜?˜ ì§‘í•©?—?„œ ?•˜?‚˜?„ ?•ˆë½‘ëŠ” ê²½ìš°ë¥? ì¶”ê??•´ì£¼ê¸° ?œ„?•¨
        }

        return answer - 1; // ?•„ë¬´ê²ƒ?„ ?„ ?ƒ ?•ˆ?•˜?Š” ê²½ìš° 1?´ ì¡°í•©?˜ ê°œìˆ˜?— ?¬?•¨?˜?–´?ˆê¸? ?•Œë¬¸ì— 1?„ ? œ?™¸?•´ì£¼ê¸°
    }
}
