package test.codility.yanolza;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CodingTest {

	public static void main(String[] args) {

		String str = "3[a2[cbc10[b]]]";
		//result
		// 3[a] = aaa
		// 2[ab] = abab
		// 3[a2[c]] = accaccacc
		final Pattern PATTERN_BRACKET = Pattern.compile("[0-9]+\\[[a-zA-Z]+\\]");

		while (str.indexOf("[") != -1) {
			String subStr = "";
			Matcher matcher = PATTERN_BRACKET.matcher(str);
			if (!matcher.find()) break;

			int startIdx = matcher.start();
			int endIdx = matcher.end();

			subStr = str.substring(startIdx, endIdx);
			int includeStd = subStr.indexOf("[");
			String repeatCnt = subStr.substring(0, includeStd);
			String repeatStr = subStr.substring(includeStd + 1, subStr.length() - 1);

//			repeatStr.repeat(Integer.valueOf(repeatCnt));
			String result = str.substring(0, startIdx) + repeatStr.repeat(Integer.valueOf(repeatCnt)) + str.substring(endIdx, str.length());
			str = result;
		}

		System.out.println(str);
	}

	public static int solution(int i) {

		int answer = 0 ;

		String str = "str";
		StringBuilder sb = new StringBuilder(str);
		sb.append("t");
		sb.insert(1, "1");

		System.out.println(sb.toString());

		int[] arr = new int[]{3,2,1};


		PriorityQueue<Integer> sq = new PriorityQueue<>();
		sq.offer(1);

		Arrays.stream(arr).boxed().toArray(Integer[]::new);



		answer = reverse(-1009);

		int[] s = twoSum(new int[]{ 1,4,7,8}, 11);

		int[][] points = new int[][]{{3, 3}, {5, -1}, {-2, 4}};
		int k = 2;
		for (int[] point : kClosest(points, k)) {
			System.out.println(Arrays.toString(point));
		}

		return answer;
	}

	public static int reverse(int x) {
		long res = 0;

		while (x != 0) {
			res *= 10;
			res += x % 10;
			x /= 10;
		}

		if (-Integer.MAX_VALUE <= res && res <= Integer.MAX_VALUE) {
			return (int) res;
		} else {
			return 0;
		}
	}

	public static int[] twoSum(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<>();

		for(int i = 0; i < nums.length; i++){
			if(map.containsKey(nums[i])){
				return new int[]{map.get(nums[i]), i};
			}
			map.put(target - nums[i], i);
		}

		return new int[]{};
	}

	public void moveZeroes(int[] nums) {
		int idx = 0;
		for(int num : nums){
			if(num != 0){
				nums[idx++] = num;
			}
		}
		for(int i = idx, len = nums.length; i < len; i++){
			nums[i] = 0;
		}
	}

	public static int[][] kClosest(int[][] points, int k) {

		// PriorityQueue based on distance calc (min-heap)
		PriorityQueue<int[]> distancePQueue = new PriorityQueue<>((a, b) -> ((a[0]*a[0] + a[1]*a[1]) - (b[0]*b[0] + b[1]*b[1]))); // ASC
		for (int[] point : points) {
			distancePQueue.offer(point);
		}

		// get k amount
		int[][] result = new int[k][2];
		while (k > 0) {
			result[--k] = distancePQueue.poll();
		}

		return result;
	}
}
