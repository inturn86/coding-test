package test;

public class CodingTestDP {

	public static void main(String[] args) {

		solution(new int[][]{{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}});

	}

	 public static int solution(int[][] triangle) {

//		int answer = 0;
		int[][] dp = new int[triangle.length][triangle.length];
        dp[0][0] = triangle[0][0];

        for (int i = 1; i < triangle.length; i++) {
            // ë§? ?™¼ìª?
            dp[i][0] = dp[i - 1][0] + triangle[i][0];

            // ì¤‘ê°„
            for (int j = 1; j <= i; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1]) + triangle[i][j];
                System.out.println("i - 1 " + (i - 1));
                System.out.println("i - 1 V" + dp[i - 1][j]);
                System.out.println("j - 1 " + (j - 1));
                System.out.println("i - 1 V" + dp[i - 1][j - 1]);
            }

            // ë§? ?˜¤ë¥¸ìª½
//            dp[i][i] = dp[i - 1][i - 1] + triangle[i][i];
        }

        int answer = 0;

        for (int i = 0; i < triangle.length; i++) {
            answer = Math.max(answer, dp[triangle.length - 1][i]);
        }


        System.out.println(answer);;
        return answer;
    }

}
