package test.practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class CoupleIntegerCodingTest {

	public static void main(String[] args) {
		int i = 0;
		solution("100", "123450");
	}

	public static String solution(String X, String Y) {

		String answer = "";

		List<String> coupInt = new ArrayList<String>();

//		StringBuilder s = new StringBuilder(Y);

		List<Integer> sr = new ArrayList<Integer>();

		//겹치는 값을 찾아옴.
		for(int i = 0, len = X.length(); i < len; i++) {

			for(int j = 0, jlen = Y.length(); j < jlen; j++) {
				if(sr.contains(j)) {
					continue;
				}
				char c = X.charAt(i);
				if(c == Y.charAt(j)) {
					String target = String.valueOf(c);
					coupInt.add(target);
					sr.add(j);
					break;
				}
			}

		}

		Collections.sort(coupInt, Collections.reverseOrder());

		if(coupInt.size() == 0) {
			return "-1";
		}

		if(coupInt.get(0).equals("0")) {
			return "0";
		}

		return coupInt.stream().map(n -> String.valueOf(n)).collect(Collectors.joining());
	}
}
