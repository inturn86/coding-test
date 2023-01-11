package test.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TotalDiscountCodingTest {

	public static void main(String[] args) {
//		int i = 0;
		solution(new String[]{"banana", "apple", "rice", "pork", "pot"}, new int[]{3, 2, 2, 2, 1}, new String[]{"chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana"});
	}


//	1 ≤ want의 길이 = number의 길이 ≤ 10
//	1 ≤ number의 원소 ≤ 10
//	number[i]는 want[i]의 수량을 의미하며, number의 원소의 합은 10입니다.
//	10 ≤ discount의 길이 ≤ 100,000
//	want와 discount의 원소들은 알파벳 소문자로 이루어진 문자열입니다.
//	1 ≤ want의 원소의 길이, discount의 원소의 길이 ≤ 12
	public static int solution(String[] want, int[] number, String[] discount) {

		int answer = 0 ;

		Map<String, Long> wantNumMap = new HashMap<>();
		int total  = 0;
		for(int i = 0, len = number.length; i < len; i++ ) {
			wantNumMap.put(want[i], (long)number[i]);
			total += (int)number[i];
		}
		List<String> disArr = Arrays.asList(discount);

		int remainLength = disArr.size();
		int idx = 0;

		while(remainLength >= total) {
			List<String> sArr = new ArrayList<String>();
			for(int i = idx, len = idx + total; i<len; i ++) {
				sArr.add(discount[i]);
			}

			Map<String, Long> ms = sArr.stream().collect(Collectors.groupingBy((String t) -> t, Collectors.counting()));

			int success = 0;
			for(String s : wantNumMap.keySet()) {
				long n = wantNumMap.get(s);
				long stand = ms.getOrDefault(s, (long) 0);
				if(n <= stand) {
					success++;
				}
				else {
					break;
				}
			}
			if(wantNumMap.size() == success) {
				answer++;
			}
			idx++;
			remainLength = remainLength - 1;
			System.out.println("in");
		}

		System.out.println(answer);
		return answer;
	}
}
