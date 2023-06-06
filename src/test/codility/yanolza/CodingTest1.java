package test.codility.yanolza;

public class CodingTest1 {

	public static void main(String[] args) {
		int[] i = {1,2,3};
		solution("QABAAAWOBL");
	}

	public static int solution(String S) {

		int BCnt = 0;
		int ACnt = 0;
		int NCnt = 0;
		for(int i = 0, len = S.length(); i < len; i++){
			if(S.charAt(i) == 'B'){
				BCnt++;
			}
			else if(S.charAt(i) == 'N'){
				NCnt++;
			}
			else if(S.charAt(i) == 'A'){
				ACnt++;
			}
		}

		int BCutCnt = 1;
		int ACutCnt = 3;
		int NCutCnt = 2;

		int min = ACnt / ACutCnt;
		min = Math.min(min, BCnt / BCutCnt);
		min = Math.min(min, NCnt / NCutCnt);

		return min;
	}
}
