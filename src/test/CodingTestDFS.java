package test;

public class CodingTestDFS {

	public static void main(String[] args) {
		solution(5);
	}
	static int count = 0;
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

}
