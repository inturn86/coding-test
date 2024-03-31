package test.hash.programmers;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Hash_의상 {

	public static void main(String[] args) {
		String[][] i = {{"1", "test"}, {"2", "test"}, {"3", "exam"}};
		solution(i);
	}

	public static int solution(String[][] clothes) {

		int answer = 0 ;
		List<String[]> arrList = Arrays.stream(clothes).collect(Collectors.toList());

		Map<String, List<String[]>> map = arrList.stream().collect(Collectors.groupingBy(o -> o[1]));

		int sum = 1;
//		if(map.size() != 1){
			for (Map.Entry<String, List<String[]>> mapEntry : map.entrySet()) {
				sum *= mapEntry.getValue().size() + 1;
			}
//		}

		return sum - 1;
	}
}
