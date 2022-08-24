package test.dfs;

public class CodingTestDFSRecul {

	public static void main(String[] args) {
		solution(5);
	}
	static int count = 0;
	//숫자를 입력할 때 ()가 숫자만큼 생성된다
	//이 때 ()의 조합으로 만들 수 있는 가지수를 생성
	//
	 public static int solution(int n) {
		 count = 0;

        dfs(0, 0, n);
        return count;
    }


    public static void dfs(int left, int right, int n) {
        if(left < right) return;
        if(left == n && right == n) {
            count++;
            System.out.println("count return " + count);
            return;
        }

        if(left > n || right > n) {
        	System.out.println("in left " + left);
            System.out.println("in right " + right);
        	System.out.println("return");
        	return;
        }

        System.out.println("left " + left);
        System.out.println("right " + right);
        System.out.println("count " + count);
        dfs(left + 1, right, n);
        dfs(left, right + 1, n);
    }

    //카탈랑 수
    public int solution2(int n) {
        int[] dp = new int[n+1];

        dp[0] = 1;
        dp[1] = 1;

        for(int i = 2; i<=n; i++){
            for(int j=1; j<=i; j++){
                dp[i] += dp[i-j] * dp[j-1];
            }
        }

        return dp[n];
    }

}
