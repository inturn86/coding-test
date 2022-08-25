package test.financial;

public class CodingTest3 {

	public static void main(String[] args) {

		solution(3, 6, 3);
	}

	static int result = 0;
	static int[] dis;
	public static int solution(int n, int m, int k) {

		dis = new int[k];
		int[] ans = new int[n];
		for(int i = 0, len = k; i < len; i++) {
			dis[i] = i +1;
		}

		DFS(0, ans, m, n);

		System.out.println(result);
		result = result % 1000007;
		return result;
	}

	public static void DFS(int depth, int[] ans, int max, int n) {

		//n이 갯수와 일치하면.
		if(n == depth) {
			int sum = 0;
			for(int i=0; i<n; i++) {
				sum += ans[i];
			}

			if(sum == max) {
				result++;
			}
			return;
		}

		for(int i = 0, len = dis.length; i < len; i++) {
			ans[depth] = dis[i];
			DFS(depth + 1, ans, max, n);
		}
	}

}
