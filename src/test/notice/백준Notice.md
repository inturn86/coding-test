### 백준 제출 시 클래스 명은 Main
- package 명 제외.ㅋ

```java
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

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

```