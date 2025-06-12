package test.그리디.백준;

import java.util.PriorityQueue;
import java.util.Scanner;

public class P_1715카드정렬하기 {

//	https://www.acmicpc.net/problem/1715

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		PriorityQueue<Integer> p = new PriorityQueue<>();

		for(int i = 0; i < N; i++) {
			p.add(sc.nextInt());
		}
		int data1 = 0;
		int data2 = 0;
		int sum = 0;
		while (p.size() != 1) {
			data1 = p.remove();
			data2 = p.remove();

			sum += data1 + data2;
			p.add(data1 + data2);
		}
		System.out.println(sum);
	}

}
