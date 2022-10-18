package test.completeserach;

import java.util.Set;

public class FindSosuCodingTest {

//	문제 설명
//	한자리 숫자가 적힌 종이 조각이 흩어져있습니다. 흩어진 종이 조각을 붙여 소수를 몇 개 만들 수 있는지 알아내려 합니다.
//
//	각 종이 조각에 적힌 숫자가 적힌 문자열 numbers가 주어졌을 때, 종이 조각으로 만들 수 있는 소수가 몇 개인지 return 하도록 solution 함수를 완성해주세요.
//
//	제한사항
//	numbers는 길이 1 이상 7 이하인 문자열입니다.
//	numbers는 0~9까지 숫자만으로 이루어져 있습니다.
//	"013"은 0, 1, 3 숫자가 적힌 종이 조각이 흩어져있다는 의미입니다.
//	입출력 예
//	numbers	return
//	"17"	3
//	"011"	2
//	입출력 예 설명
//	예제 #1
//	[1, 7]으로는 소수 [7, 17, 71]를 만들 수 있습니다.
//
//	예제 #2
//	[0, 1, 1]으로는 소수 [11, 101]를 만들 수 있습니다.
//
//	11과 011은 같은 숫자로 취급합니다.
	public static void main(String[] args) {

		solution("");
	}

	public static int solution(String numbers) {

		int answer = 0 ;

//		String[] strArr = numbers.split("");

		//idx에 따라 시작 값을 잡는다.
		//
		recursive("", "125");
		return answer;
	}

	public static void recursive(String comb, String others) {
        // 1. 현재 조합을 set에 추가한다.
        if (!comb.equals(""))
        {
        	System.out.println("comb = " + comb); //            numbersSet.add(Integer.valueOf(comb));
        }
        System.out.println("oterhs = " + others);

        // 2. 남은 숫자 중 한 개를 더해 새로운 조합을 만든다.
        for (int i = 0; i < others.length(); i++) {
        	System.out.println("int i = " + i);

        	System.out.println(others.substring(0, i) + others.substring(i + 1));
            recursive(comb + others.charAt(i), others.substring(0, i) + others.substring(i + 1));
        }

    }


	//소수 판별. 루트 계산에 따른
	public static boolean isPrime(int num){
        for(int i=2; i*i<=num; i++){
            if(num % i == 0) return false;
        }
        return true;
    }
}
