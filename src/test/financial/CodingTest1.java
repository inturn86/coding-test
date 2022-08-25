package test.financial;

import java.util.HashMap;
import java.util.Map;

public class CodingTest1 {

	public static void main(String[] args) {
//		int[][] numbers = new int[][]{{1,2,3,4,5,6,7,8,9},{3,4,5,3,4,5,3,4,5},{2,2,2,2,2,2,2,2,2}};
		int[][] numbers = new int[][]{{1,2,3,4,1,2,3,4,100},{1,2,1,2,1,2,1,2,1},{1,2,3,4,5,6,7,8,9}};
		solution(numbers);
	}

	static int[] result;
	public static int[] solution(int[][] numbers) {

		int[] answer = new int[numbers[0].length];

		result = new int[numbers.length];

		boolean[] visit = new boolean[numbers[0].length];

		//sum이 6개가 같으면 된다.
		for(int i = 0, len = numbers.length; i < len; i++) {
			DFS(0, 0, answer, numbers[i], i, visit);
			answer = new int[numbers[0].length];
		}

		System.out.println(result);
		return result;
	}

	static int[][] cal = {{0,1,2}, {3,4,5}, {6,7,8}, {0,3,6}, {1,4,7}, {2,5,8}};
	public static void DFS(int idx, int depth, int[] ans, int[] nums, int upper, boolean[] visit) {

		if(depth == 9) {


			//sum을 123, 456, 789
			//sum 147, 258, 369

			Map<Integer, Integer> m = new HashMap<Integer, Integer>();
			for(int i = 0, len = cal.length; i < len; i++) {
				int sum = 0;
				int[] calArr = cal[i];

				for(int j=0; j < calArr.length; j++) {
					sum += ans[calArr[j]];
				}
				m.put(sum, m.getOrDefault(sum, 0) + 1) ;
			}


			if(m.size() == 1) {
				result[upper] = 1;
			}
			return;
		}

		if(result[upper] == 1) {
			return;
		}
		for(int i = idx, len = nums.length; i < len; i++) {

			if(!visit[i]) {
				ans[depth] = nums[i];
				visit[i] = true;
				DFS(idx, depth + 1, ans, nums, upper, visit);
				visit[i] = false;
			}
		}
	}
}
