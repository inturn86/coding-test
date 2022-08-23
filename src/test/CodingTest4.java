package test;

public class CodingTest4 {

	public static void main(String[] args) {


		//want는 원하는 제품
		//number는 원하는 수
		//number의 모든 합은 10
		//discount의 길이는 최소 10
		solutions(new int[]{-3, -2, -1, 0, 1, 2, 3} );
	}

	static int ans[] = new int[3];
	static int numArr[];
	static int N;
	static int resultCount = 0;

	public static int solutions(int[] number) {
		N = number.length;
		numArr = number;

		DFS(0, 0);
		System.out.println(resultCount);
		return resultCount;
	} // End of solution


	private static void DFS(int idx, int depth) {
		if(depth == 3) {
			int sum = 0;
			for(int i=0; i<3; i++) {
				sum += ans[i];
			}

			if(sum == 0) {
				resultCount++;
			}

			return;
		}


		for(int i=idx; i<N; i++) {

			ans[depth] = numArr[i];
			System.out.println("index = " + (i+1));
			System.out.println("depth = " + (depth+1));
			DFS(i+1, depth + 1);
		}
	} // End of DFS

}
