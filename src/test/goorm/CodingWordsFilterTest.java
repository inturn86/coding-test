package test.goorm;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CodingWordsFilterTest {

//	문제
//
//	보안 코드를 작성하고 있는 구름이는 사용자로부터 메시지를 전달 받았을 때, 특정 단어 가 포함되어 있으면 시스템이 위험할 수 있다는 사실을 파악했다. 그래서 구름이는 전달 받은 메시지 에서 단어 를 걸러내는 단어 필터를 만들기로 한다.
//
//	단어 필터는 메시지 에 단어 가 포함되어 있다면, 이를 가장 앞에서 등장하는 단어 부터 순서대로 제거한 후 안전한 메시지를 구름이에게 전달한다. 단어 필터는 대소문자도 모두 동일해야 지워야 할 단어라고 판단하며, 메시지 에 더 이상 단어 가 존재하지 않을 때까지 반복해서 필터링을 적용한다.
//
//	구름이를 도와 단어 필터를 만들고, 어떤 메시지 를 받았을 때, 구름이가 전달 받은 메시지 의 내용을 출력하시오.
//
//
//
//			입력
//
//	첫째 줄에 단어 의 길이와 메시지 의 길이가 공백을 두고 주어진다.
//	둘째 줄에 단어 가 주어진다.
//	마지막 줄에는 메시지 가 주어진다.
//
//
//	단어와 메시지는 알파벳 대소문자로만 이루어져 있다.
//
//
//	출력
//
//	구름이가 받은 메시지를 출력하시오. 만약에 메시지의 내용이 없다면 EMPTY를 출력하시오.
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		String filterCode = br.readLine();
		String code = br.readLine();

//		StringBuilder s = new StringBuilder(filterCode);

		String[] arr = input.split(" ");
		long errLen = Long.valueOf(arr[0]);
		long securityLen = Long.valueOf(arr[1]);
//		for(int i = 0; i < errLen; i++){
//
//		}

		String result = "";
		result = code.replaceAll(filterCode, "");
		while (result.contains(filterCode)){

			result = result.replaceAll(filterCode, "");
		}

		if(result.length() == 0){
			result = "EMPTY";
		}
		System.out.println(result);
	}

}
