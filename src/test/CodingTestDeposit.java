package test;

import java.util.Arrays;

public class CodingTestDeposit {

	public static void main(String[] args) {

//		[120, 110, 140, 150], 485
		int[] budgets = {120, 110, 140, 150};
		solutions(budgets, 485);
	}

	//맥스 �?.
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
