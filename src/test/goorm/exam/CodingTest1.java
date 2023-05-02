package test.goorm.exam;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CodingTest1 {


	public static Scanner scanner = new Scanner(System.in);
	/* [Notice for Java]
	 * - 기본 제공되는 뼈대 코드는 입출력의 이해를 돕기위해 제공되었습니다.
	 * - 뼈대코드의 활용은 선택사항이며 코드를 직접 작성하여도 무관합니다.
	 *
	 * - 별도의 병렬 처리나 시스템콜, 네트워크/파일접근 등을 하지 마세요 2
	 * - 입출력의 양이 많은 문제는 BufferedReader와 BufferedWriter를 사용하면 시간을 단축할 수 있습니다.
	 * - 클래스 이름은 항상 Main이어야 합니다. 주의하세요.
	 * - 모든 입력과 출력은 System.in과 System.out 스트림을 이용해야 합니다.
	 */
	public static void main(String[] args)
	{   //프로그램의 시작부
		int sh, sm;
		int[] bh = new int[5];
		int[] bm = new int[5];

		String input;
		String[] splited;

		//현재 '시'와 '분'을 입력 받는다
		input = scanner.next();
		splited = input.split(":");
		//시작 시간
		sh = Integer.parseInt(splited[0]);
		//시작 분
		sm = Integer.parseInt(splited[1]);

		List<Integer> resultList = new ArrayList<>();
		int left = 0; //다음 버스까지 남은 시간을 이 변수에 저장 한다.
		for(int i = 0 ; i < 5; i ++){
			//bh[i] := i번째 버스가 도착하는 '시'
			//bm[i] := i번째 버스가 도착하는 '분'
			input = scanner.next();
			splited = input.split(":");
			bh[i] = Integer.parseInt(splited[0]);
			bm[i] = Integer.parseInt(splited[1]);

			int diffh = bh[i] - sh;
			int diffm = bm[i] - sm;
			int calh = 0;
			if(diffh < 0){
				calh = 24 + diffh;
			}
			else if(diffh == 0) {
				if(diffm >= 0){
					calh = 0;
				}
				else{
					calh = 24;
				}
			}else{
				calh = diffh;
			}
			int totalm = (calh * 60) + diffm;
			System.out.println(totalm);
			resultList.add(totalm);
		}

		//정답을 출력한다
		System.out.println(resultList.stream().min(Integer::compareTo).orElse(0));
	}
}
