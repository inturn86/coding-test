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

	//κ°??₯ ?°? ??΄.
	public static String solution(int[] numbers) {

		String answer = "";
		//shift ?΄?Ό?κ³?

		//????λ‘? ??΄
		int max = 0;

		String[] strArr = new String[numbers.length];
		for(int i = 0, len = numbers.length; i < len ; i++) {
			strArr[i] = Integer.toString(numbers[i]);
		}

		Arrays.sort(strArr, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				//o1 3, o2 30
				//?€λ¦? μ°¨μ
				//303.compareTo(330) == -3
				//?΄?΄κ²½μ° o1?΄ ??Όλ‘?
				//?΄λ¦? μ°¨μ
				//330.compareTo(303) == 3
				//?΄?΄κ²½μ° o1?΄ ??Όλ‘?

				//o1 30, o2 3
				//330.compareTo(303) == 3
				//?΄?΄κ²½μ° o2?΄ ??Όλ‘?
				return (o2 + o1).compareTo(o1 + o2);
				//a.compareTo(b)
				//- ???λΆ??° λΉκ΅??€ ?€λ₯? λ¬Έμ?΄?΄ ??€λ©? 'a-b' ??λ‘? ?΄?Ή λ¬Έμ? ??€?€μ½λ κ°μ λΊ? κ²°κ³Ό(int)λ₯? λ¦¬ν΄Β 
				// ???΄λ©? aκ°? ??Όλ‘?
				// ???΄λ©? bκ°? ??Όλ‘?
				//?€λ¦μ°¨?Β ? ? ¬Β (o2+o1).compareTo(o1+o2);
			}
		});

		//0κ°μ΄Β μ€λ³΅?Όκ²½μ°Β ex){0,0,0}
		//?΅?΄Β 000?΄Β ??€λ©΄Β μ?λ―?λ‘Β μ²«λ²μ§Έκ°μ΄Β 0?΄λ©΄Β?0?Β λ¦¬ν΄
		if(strArr[0].equals("0")) return "0";

		for(String s : strArr)	answer += s;
		return answer;
	}
}
