package test.codility;

public class CodingBinaryGapTest {

	public static void main(String[] args) {
		int i = 9;
		solution(i);
	}

	public static int solution(int N) {

		int answer = 0 ;
		String s = Integer.toBinaryString(N);
		int beforeGap = 0;
		boolean beforeBoolean = false;
		for( int i = 0; i < s.length(); i ++){
			if('1' == s.charAt(i)){
				if(beforeBoolean){
					if(answer < (i - beforeGap - 1)){
						answer = (i - beforeGap - 1);
					}
					beforeGap = i;
				}else{
					beforeBoolean = true;
					beforeGap = i;
				}
			}
		}
		System.out.println(answer);
		return answer;
	}
}
