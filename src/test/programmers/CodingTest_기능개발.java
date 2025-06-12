package test.programmers;

import test.doit.search.P11659;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CodingTest_기능개발 {

	public static void main(String[] args) {

//		int[] i = {95, 90, 99, 99, 80, 99};
//		int[] j = {1, 1, 1, 1, 1, 1};
		int[] i = {93,30,55};
		int[] j = {1, 30,5};
		solution(i, j);
	}

	public static int[] solution(int[] progresses, int[] speeds) {
		int[] targetDay = new int[progresses.length];

		for(int i = 0; i < progresses.length; i++) {
			targetDay[i] = ((100 - progresses[i]) / speeds[i]) + (((100 - progresses[i]) % speeds[i]) > 0 ? 1 : 0);
		}

		int max = targetDay[0];
		int releaseCnt = 0;
		List<Integer> a = new ArrayList<>();
		for(int i = 0; i < progresses.length; i++) {
			if(max >= targetDay[i]) {
				releaseCnt++;

			}
			else {
//			else if(max < targetDay[i]) {
				a.add(releaseCnt);
				max = targetDay[i];
				releaseCnt = 1;
			}
		}
		a.add(releaseCnt);
		return a.stream().mapToInt(Integer::intValue).toArray();
	}
}
