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

    	String[] strNum = new String[numbers.length];
    	for(int i = 0, len = numbers.length; i < len; i++) {
    		strNum[i] = String.valueOf(numbers[i]);
    	}

    	Arrays.sort(strNum, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				//오름 차순으로 정렬
//				(o1 + o2).compareTo(o2 + o1);
				//내림 차순으로 정렬
				return (o2 + o1).compareTo(o1 + o2);
			}
		});

    	//String 비교는 equal로 하자.
    	if(strNum[0].equals("0")) {
    		return "0";
    	}
    	for(String s : strNum) answer+=s;

    	return answer;
	}
}
