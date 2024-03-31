package test.hash.programmers;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import java.util.stream.Collectors;

public class Hash_전화번호_목록 {


	//https://school.programmers.co.kr/learn/courses/30/lessons/42577
	public static void main(String[] args) {
		String[] i = new String[]{"12", "123", "1235", "567", "88"};

//		String[] i = new String[]{"12", "123", "1235", "567", "88"};
		var answer = solution(i);
		System.out.println(answer);
	}

	public static boolean solution(String[] phone_book) {

		Set<String> set = Arrays.stream(phone_book).collect(Collectors.toSet());

		Set<String> s = new HashSet<>();
		Set<String> s1 = new HashSet<>(100, 0.75f);

		for (int i = 0; i < 20; i++) {
			s.add(String.valueOf(i));
		}

		for (int i = 0; i < phone_book.length; i++) {
			for (int j = 0; j < phone_book[i].length(); j++) {
				if(set.contains(phone_book[i].substring(0, j))) return false;
			}
		}

		return true;

	}
}
