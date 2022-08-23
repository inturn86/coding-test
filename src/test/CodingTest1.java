package test;

import java.util.Arrays;
import java.util.Comparator;

public class CodingTest1 {

	public static void main(String[] args) {



		solutions("5525", "1255");
	}

	public static String solutions(String X, String Y) {
		String answer = "";

		String[] xSpl = X.split("");


		StringBuilder sb = new StringBuilder(Y);
		String s = "";
		for(int i = 0 , len = xSpl.length; i < len; i++) {
			int idx =  sb.indexOf(xSpl[i]);
			if(idx == -1) {
				continue;
			}
			sb.setCharAt(idx, '_');
			s += xSpl[i];
		}

		if(s.equals("")) {
			return "-1";
		}

		String[] sArr = s.split("");
		Arrays.sort(sArr, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				return (o2 + o1).compareTo(o1 + o2);
			}
		});


		if(sArr[0] == "0") {
			return "0";
		}
		answer = String.join("",sArr);

		System.out.println(answer);
		return answer;
	}
}
