package test;

import java.util.Arrays;
import java.util.Comparator;

public class CodingTestMaxValue {

	public static void main(String[] args) {

		System.out.println("303".compareTo("330"));
		System.out.println("330".compareTo("303"));
		System.out.println("3".compareTo("30"));
		System.out.println("30".compareTo("3"));
		int[] num = {30, 3};
		solution(num);

	}

	//ê°??¥ ?°?ˆ˜ ?‚˜?—´.
	public static String solution(int[] numbers) {

		String answer = "";
		//shift ?•´?•¼?•˜ê³?

		//?ˆœ?„œ??ë¡? ?‚˜?—´
		int max = 0;

		String[] strArr = new String[numbers.length];
		for(int i = 0, len = numbers.length; i < len ; i++) {
			strArr[i] = Integer.toString(numbers[i]);
		}

		Arrays.sort(strArr, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				//o1 3, o2 30
				//?˜¤ë¦? ì°¨ìˆœ
				//303.compareTo(330) == -3
				//?´?Ÿ´ê²½ìš° o1?´ ?•?œ¼ë¡?
				//?‚´ë¦? ì°¨ìˆœ
				//330.compareTo(303) == 3
				//?´?Ÿ´ê²½ìš° o1?´ ?•?œ¼ë¡?

				//o1 30, o2 3
				//330.compareTo(303) == 3
				//?´?Ÿ´ê²½ìš° o2?´ ?•?œ¼ë¡?
				return (o2 + o1).compareTo(o1 + o2);
				//a.compareTo(b)
				//- ?•?—?„œë¶??„° ë¹„êµ?•˜?‹¤ ?‹¤ë¥? ë¬¸ì?—´?´ ?‚˜?˜¤ë©? 'a-b' ?ˆœ?„œë¡? ?•´?‹¹ ë¬¸ì?˜ ?•„?Š¤?‚¤ì½”ë“œ ê°’ì„ ëº? ê²°ê³¼(int)ë¥? ë¦¬í„´Â 
				// ?–‘?ˆ˜?´ë©? aê°? ?•?œ¼ë¡?
				// ?Œ?ˆ˜?´ë©? bê°? ?•?œ¼ë¡?
				//?˜¤ë¦„ì°¨?ˆœÂ ? •? ¬Â (o2+o1).compareTo(o1+o2);
			}
		});

		//0ê°’ì´Â ì¤‘ë³µ?¼ê²½ìš°Â ex){0,0,0}
		//?‹µ?´Â 000?´Â ?‚˜?˜¤ë©´Â ì•ˆ?˜ë¯?ë¡œÂ ì²«ë²ˆì§¸ê°’ì´Â 0?´ë©´Â?0?„Â ë¦¬í„´
		if(strArr[0].equals("0")) return "0";

		for(String s : strArr)	answer += s;
		return answer;
	}
}
