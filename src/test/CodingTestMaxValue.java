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

	//�??�� ?��?�� ?��?��.
	public static String solution(int[] numbers) {

		String answer = "";
		//shift ?��?��?���?

		//?��?��??�? ?��?��
		int max = 0;

		String[] strArr = new String[numbers.length];
		for(int i = 0, len = numbers.length; i < len ; i++) {
			strArr[i] = Integer.toString(numbers[i]);
		}

		Arrays.sort(strArr, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				//o1 3, o2 30
				//?���? 차순
				//303.compareTo(330) == -3
				//?��?��경우 o1?�� ?��?���?
				//?���? 차순
				//330.compareTo(303) == 3
				//?��?��경우 o1?�� ?��?���?

				//o1 30, o2 3
				//330.compareTo(303) == 3
				//?��?��경우 o2?�� ?��?���?
				return (o2 + o1).compareTo(o1 + o2);
				//a.compareTo(b)
				//- ?��?��?���??�� 비교?��?�� ?���? 문자?��?�� ?��?���? 'a-b' ?��?���? ?��?�� 문자?�� ?��?��?��코드 값을 �? 결과(int)�? 리턴 
				// ?��?��?���? a�? ?��?���?
				// ?��?��?���? b�? ?��?���?
				//?��름차?�� ?��?�� (o2+o1).compareTo(o1+o2);
			}
		});

		//0값이 중복?��경우 ex){0,0,0}
		//?��?�� 000?�� ?��?��면 안?���?로 첫번째값이 0?��면�?0?�� 리턴
		if(strArr[0].equals("0")) return "0";

		for(String s : strArr)	answer += s;
		return answer;
	}
}
