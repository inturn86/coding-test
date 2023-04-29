package test.codility;

import java.util.Stack;

public class CodingDisappearingPairsTest {
//	문자 "A", "B" 및 "C"만 포함하는 문자열 S가 제공됩니다. "AA", "BB" 또는 "CC" 중 하나를 제거하여 문자열을 변환할 수 있습니다.
//
//	문자열 변환은 위에서 설명한 규칙에 따라 문자열에서 문자를 제거하는 프로세스입니다. 하나 이상의 규칙을 적용할 수 있는 한 프로세스를 반복해야 합니다. 둘 이상의 규칙을 사용할 수 있는 경우 그 중 하나를 선택할 수 있습니다.
//
//	함수 작성:
//
//	class Solution { public String solution(String S); }
//
//	N개의 문자로 구성된 문자열 S가 주어지면 위에서 설명한 대로 변환 시퀀스의 결과일 수 있는 모든 문자열을 반환합니다.
//
//	예를 들어 주어진 문자열 S = "ACCAABBC"에서 함수는 "AC"를 반환할 수 있습니다. 가능한 변환 시퀀스 중 하나가 다음과 같기 때문입니다.
//
//
//
//	또한 주어진 문자열 S = "ABBCBBCBA"에서 함수는 ""를 반환할 수 있습니다. 가능한 변환 시퀀스 중 하나는 다음과 같기 때문입니다.
//
//
//
//	마지막으로 문자열 S = "BABABA"의 경우 문자열 S에 적용할 수 있는 규칙이 없기 때문에 함수는 "BABABA"를 반환해야 합니다.
//
//	다음 가정에 대한 효율적인 알고리즘을 작성하십시오.
//
//	문자열 S의 길이는 [0..50,000] 범위 내에 있습니다.
//	문자열 S는 'A', 'B' 및/또는 'C' 문자로만 구성됩니다.

	public static void main(String[] args) {
		String i = "ABBACCAC";
		solution(i);
	}

	public static String solution(String s) {

		Stack<String> st = new Stack<>();

		for(int i = 0, len = s.length(); i < len; i++){
			String ta = String.valueOf(s.charAt(i));
			if(st.size() > 0){
				if(st.peek().equals(ta)){
					st.pop();
				}
				else{
					st.push(ta);
				}
			}
			else{
				st.push(ta);
			}
		}
		return st.toString().replace(" ", "").replace("[", "").replace("]", "").replace(",", "");
	}
}
