package test.자료구조;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class TestMain {


	static ScheduledExecutorService ex = Executors.newScheduledThreadPool(10);

	public static void main(String[] args) {

		MyQueue<String> q = new MyQueue<>();

		q.enqueue("test");
		q.enqueue("test1");
		q.enqueue("test2");
		q.enqueue("test3");

		List<String> sl = new ArrayList<>();
		String test = q.dequeue();
		sl.add(test);
		String test1 = q.dequeue();
		sl.add(test1);
		String test2 = q.dequeue();
		sl.add(test2);
		String test3 = q.dequeue();
		sl.add(test3);

		for(String s : sl) {
			System.out.println(s);
		}


	}
}
