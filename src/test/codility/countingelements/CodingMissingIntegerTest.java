package test.codility.countingelements;

import java.util.*;

public class CodingMissingIntegerTest {

//	https://app.codility.com/programmers/lessons/4-counting_elements/missing_integer/start/

//	이것은 데모 작업입니다.
//
//	함수 쓰기:
//
//	클래스 솔루션 {public int 솔루션(int[] A); }
//
//	N개 정수의 배열 A가 주어지면 A에서 발생하지 않는 가장 작은 양의 정수(0보다 큼)를 반환합니다.
//
//	예를 들어, A = [1, 3, 6, 4, 1, 2]일 때 함수는 5를 반환해야 합니다.
//
//			A = [1, 2, 3]일 때 함수는 4를 반환해야 합니다.
//
//			A = [-1, -3]이 주어지면 함수는 1을 반환해야 합니다.
//
//	다음 가정에 대한 효율적인 알고리즘을 작성합니다:
//
//	N은 [1] 범위 내의 정수입니다..100,000];
//	배열 A의 각 요소는 [-1,000,000...1,000,000] 범위 내의 정수입니다.
	public static void main(String[] args) {
		int[] i = { -3, 1,2, 3, 4};
		solution(i);
	}

	public static int solution(int[] A) {

		int answer = 0 ;

		int[] J = new int[A.length];
		int min = 0;
		for(int i = 0, len = A.length; i < len; i++){
			if(A[i] > 0){
				J[i] = A[i];
				if(min == 0){
					min = A[i];
				}
				if(min > A[i]){
					min = A[i];
				}
			}
		}
		if(min != 1) {
			 return 1;
		 }

		Arrays.sort(J);
		int maxVal = 0;
		for(int i = 0, len = J.length; i < len; i++){
			//max까지옴.
			if(i + 1 == len) {
				maxVal = J[i];
				break;
			}

			//다음수가 1차이가 나지않고 다음수와 같지 않으면. 정답.
			if(J[i] + 1 != J[i + 1] && J[i] != J[i + 1]){
				maxVal = J[i];
				break;
			}
		}

		if(maxVal <= 0){
			answer = maxVal + 1;
		}
		else{
			answer = maxVal + 1;
		}

		return answer;
	}
}
