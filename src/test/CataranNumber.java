package test;

public class CataranNumber {

	public static void main(String[] args) {
		solution(4);
	}

	//()()() ê´„í˜¸?˜ ê°œìˆ˜ êµ¬í• ?•Œ.
	public static int solution(int n) {
        int[] dp = new int[n+1];

        dp[0] = 1;
        dp[1] = 1;

        for(int i = 2; i<=n; i++){
            for(int j=1; j<=i; j++){
            	//dp[2] = dp[1] * dp[0];
            	
                dp[i] += dp[i-j] * dp[j-1];
            }
        }



//ê²°ë¡ ? ?œ¼ë¡? C4 = C0*C3 + C1*C2 + C2*C1 + C3*C0 = 5+2+2+5 = 14
        return dp[n];
    }
}
