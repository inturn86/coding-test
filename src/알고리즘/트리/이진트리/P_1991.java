package 알고리즘.트리.이진트리;

import java.util.Scanner;

public class P_1991 {

	static int[][] tree;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		tree = new int[26][2];

		for(int i = 0; i < N; i++) {
			int idx = sc.next().charAt(0) - 'A';
			char s = sc.next().charAt(0);
			char e = sc.next().charAt(0);

			tree[idx][0] = s == '.' ? -1 : s - 'A';
			tree[idx][1] = e == '.' ? -1 : e - 'A';
		}


		preOrder(0);
		System.out.println();

		inOrder(0);
		System.out.println();

		postOrder(0);
		System.out.println();
	}

	public static void preOrder(int v) {
		if(v == -1) {
			return;
		}
		System.out.print((char)(v + 'A'));
		preOrder(tree[v][0]);
		preOrder(tree[v][1]);
	}

	public static void inOrder(int v) {
		if(v == -1) {
			return;
		}
		inOrder(tree[v][0]);
		System.out.print((char)(v + 'A'));
		inOrder(tree[v][1]);
	}

	public static void postOrder(int v) {
		if(v == -1) {
			return;
		}
		postOrder(tree[v][0]);
		postOrder(tree[v][1]);
		System.out.print((char)(v + 'A'));
	}
}
