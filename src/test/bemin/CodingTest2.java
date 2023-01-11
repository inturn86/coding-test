package test.bemin;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class CodingTest2 {

	public static void main(String[] args) {
		int i = 0;
		solution(new String[] {"e", "d", "d"}, new String[] {"d", "d", "e"});
	}

	public static String solution(String[] leftArray, String[] rightArray) {
        String answer = "";
        // 코드 작성 위치
        final Set<String> matchList = new HashSet<String>();
        Arrays.asList(leftArray).stream().forEach(r -> {
        	if(Arrays.asList(rightArray).stream().anyMatch(l -> r.equals(l))) {
        		matchList.add(r);
        	}
        });

        answer = matchList.stream().sorted().collect(Collectors.joining(","));
        System.out.println(answer);
        return answer;
    }
}
