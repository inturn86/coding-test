package test.bemin;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class CodingTest {

	public static void main(String[] args) {
		int i = 0;
		solution(new String[] {"jaif", "asdaaaaaaaa", "aasf"});
	}

	public static String solution(String[] params) {
        List<String> sArr = Arrays.asList(params);

        Optional<String> answerOpt = sArr.stream().filter(o -> o.length() >= 5 && o.length() <= 10).map(o -> o.toUpperCase()).findFirst();

        String answer = answerOpt.isPresent() ? answerOpt.get() : "없음";

        return answer;
    }
}
