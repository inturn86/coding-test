package test.dfs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;

public class CodingTestTravelTargetResolveSolution {

	static List<Stack<String>> result;

//	출처: https://tosuccess.tistory.com/36 [EI_HJ:티스토리]
//	주어진 항공권을 모두 이용하여 여행경로를 짜려고 합니다. 항상 "ICN" 공항에서 출발합니다.
//
//	항공권 정보가 담긴 2차원 배열 tickets가 매개변수로 주어질 때, 방문하는 공항 경로를 배열에 담아 return 하도록 solution 함수를 작성해주세요.
	public static void main(String[] args) {

		solution(new String[][] { { "ICN", "SFO" }, { "ICN", "ATL" }, { "SFO", "ATL" }, { "ATL", "ICN" },
				{ "ATL", "SFO" } });
	}

	public static String[] solution(String[][] tickets) {
		result = new ArrayList<>();

		boolean[] visited = new boolean[tickets.length];
		Stack<String> st = new Stack<>();
		st.push("ICN");

		dfs(0, st, visited, tickets);

		if (result.size() > 1) {
			Collections.sort(result, new Comparator<Stack<String>>() {
				@Override
				public int compare(Stack<String> o1, Stack<String> o2) {
					for (int i = 0; i < o1.size(); i++) {
						String s1 = o1.get(i);
						String s2 = o2.get(i);

						if (!s1.equals(s2)) {
							return s1.compareTo(s2);
						}
					}

					return 0;
				}
			});
		}

		Stack<String> res = result.remove(0);
		String[] answer = new String[res.size()];

		for (int i = 0; i < answer.length; i++) {
			answer[i] = res.get(i);
		}

		return answer;
	}

	public static void dfs(int depth, Stack<String> st, boolean[] visited, String[][] tickets) {

		String now = st.peek();

		if(depth == tickets.length) {
			Stack<String> res = new Stack<>();
			for (String s : st) {
				res.push(s);
			}

			result.add(res);
			return;
		}

		for(int i = 0, len = tickets.length; i < len; i++) {
			if(!visited[i] && tickets[i][0].equals(now)) {
				visited[i] = true;
				st.push(tickets[i][1]);
				dfs(depth + 1, st, visited, tickets);
				//자신의 roop가 끝나면 해제.
				st.pop();
				visited[i] = false;
			}
		}
	}



}
