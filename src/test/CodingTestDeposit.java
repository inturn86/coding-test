package test;

import java.util.Arrays;

public class CodingTestDeposit {

	public static void main(String[] args) {

//		[120, 110, 140, 150], 485
		int[] budgets = {120, 110, 140, 150};
		solutions(budgets, 485);
	}

	//이분 탐색.
	//M은 예산, budgets은 예산을 요청한 목록
	//1. 모든 요청이 배정될 수 있는 경우에는 요청한 금액을 그대로 배정합니다.
	//2. 모든 요청이 배정될 수 없는 경우에는 특정한 정수 상한액을 계산하여 그 이상인 예산요청에는 모두 상한액을 배정합니다.
	//   상한액 이하의 예산요청에 대해서는 요청한 금액을 그대로 배정합니다.
	//
	public static int solutions(int[] budgets, int M) {

		int min = 0;
        int max = 0;
        int answer = 0;
        for(int budget:budgets) {
            if(budget > max) {
                max = budget;
            }
        }

        while(min <= max) {
            int mid = (min+max)/2;
            int sum = 0;
            for(int budget:budgets) {
                if(budget > mid) {
                	System.out.println("in mid " + mid);
                    sum = sum + mid;
                } else {
                	System.out.println("in budget " + budget);
                    sum = sum + budget;
                }
            }


            if(sum <= M) {
            	System.out.println("sum <= M " + sum + " mid  = " + mid);
                min = mid+1;
                answer = mid;
            } else {
            	System.out.println("else  " + mid);
                max = mid-1;
            }
            System.out.println("min " + min);

            System.out.println("max " + max);
            System.out.println(answer);
        }
        return answer;
	}
}
