package test;

public class CodingLevelTest2 {


	public static void main(String[] args) {
		solution("EIO");
	}
	static String arr[] = { "A", "E", "I", "O", "U" };
	static int cnt = 0, ans = 0;
	static String findWord = "";
	public static int solution(String word) {
		findWord = word;
		rece("", 0);
		System.out.println("ans = " + ans);

		return ans;
	}

	public static void rece(String ch, int idx) {

		if(ans != 0 ) {
			return;
		}
		if(idx == 5) {
			return;
		}


		for(int i = 0, len = arr.length; i < len; i++) {
			String targetCh = ch + arr[i];

			cnt++;
			if(targetCh.equals(findWord)) {
				ans = cnt;
				return;
			}
			System.out.println("targetCh = " + targetCh);

			rece(targetCh, idx+1);
		}
	}



























	private static void perm(int idx, String s, String word) {
		if (idx == 5)
			return;
		for (int i = 0; i < arr.length; i++) {
			String ss = s + arr[i];
			cnt++;
			if (ss.equals(word)) {
				ans = cnt;
				return;
			}
			System.out.println("ss + " + ss);
			perm(idx + 1, ss, word);
		}
	}


}
