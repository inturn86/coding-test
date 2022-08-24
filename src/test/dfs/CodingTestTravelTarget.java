package test.dfs;

import java.util.Arrays;
import java.util.Comparator;

public class CodingTestTravelTarget {

//	주어진 항공권을 모두 이용하여 여행경로를 짜려고 합니다. 항상 "ICN" 공항에서 출발합니다.
//
//	항공권 정보가 담긴 2차원 배열 tickets가 매개변수로 주어질 때, 방문하는 공항 경로를 배열에 담아 return 하도록 solution 함수를 작성해주세요.
	
	public static void main(String[] args) {

		solution(new String[][] { { "ICN", "SFO" }, { "ICN", "ATL" }, { "SFO", "ATL" }, { "ATL", "ICN" },
				{ "ATL", "SFO" } });
	}

	public static String[] solution(String[][] tickets) {
		System.out.println(tickets.length);

		// answer는 tickets의 수보다 +1;

		Arrays.sort(tickets, new Comparator<String[]>() {

			@Override
			public int compare(String[] o1, String[] o2) {
				// TODO Auto-generated method stub
				return (o1[1] + o2[1]).compareTo(o2[1] + o1[1]);
			}

		});

		String[] answer = {};
		boolean[] visit = new boolean[tickets.length];

		answer = new String[tickets.length + 1];

		answer[0] = "ICN";

		String now = "ICN";

		int answerCnt = 0;
		recul(now, answerCnt, tickets, answer, visit);

		return answer;
	}

	public static void recul(String now, int answerCnt, String[][] tickets, String[] answer, boolean[] visit) {

//		while (answerCnt != tickets.length) {

		if(answerCnt == tickets.length) {
			answer[answerCnt] = now;
			return;
		}
			for (int i = 0, len = tickets.length; i < len; i++) {
				if (!visit[i] && tickets[i][0].equals(now)) {
					now = tickets[i][1];
//					answerCnt+1;
					answer[answerCnt+1] = now;
					visit[i] = true;
					recul(now, answerCnt+1, tickets, answer, visit);
					break;
				}
			}
//		}
	}
}
