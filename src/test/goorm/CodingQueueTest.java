package test.goorm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class CodingQueueTest {

//	크기가 인 Queue 자료 구조를 구현하려고 합니다. 아래의 조건에 따라서 구현하세요.
//
//	Queue에 대한 명령어는 push와 pop 입니다.
//	push는 Queue에 크기가 인 data를 추가합니다.
//	만약에 이미 Queue이 가득 차 있을 때, push명령이 있다면, Overflow를 출력합니다.
//	pop은 Queue에서 가장 최근에 삽입된 data를 제거하고 제거된 data를 출력합니다.
//	만약에 이미 Queue이 비어있을 때, pop명령이 있다면, Underflow를 출력합니다.
//	위와 같은 Queue 자료구조를 구현하고, 개의 명령을 수행하시오.

//	첫째 줄에 과 가 공백을 두고 주어진다.
//	그 다음 줄에 걸쳐서 명령어가 주어진다. 명령어는 가지 종류이다.
//	push라면 공백을 두고 입력되는 정수 데이터가 주어진다. 정수 데이터는 이상 이하의 정수이다. pop은 명령어만 주어진다.
//
//


	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		//System.out.println("Hello Goorm! Your input is " + input);
		String[] arr = input.split(" ");

		int cnt = Integer.valueOf(arr[0]);
		int max = Integer.valueOf(arr[1]);

		Queue<String> qu = new LinkedList<>();
		String finalResult = "";
		while(cnt > 0){
			String cmd = br.readLine();
			String typingStr = "";

			String[] cmdArr = cmd.split(" ");
			//push
			if(cmdArr[0].equals("push")){
				if(qu.size() >= max){
					typingStr = "Overflow";
				}
				else {
					qu.add(cmdArr[1]);
				}
			}
			//pop
			else {
				String result = qu.poll();
				typingStr = result == null ? "Underflow" : result;
			}
			if(!"".equals(typingStr)){
				typingStr += "\n";
				finalResult += typingStr;
			}
			cnt--;
		}

		System.out.println(finalResult);
		//solution(i);
	}

	public static int solution(int i) {

		int answer = 0 ;
		return answer;
	}
}
