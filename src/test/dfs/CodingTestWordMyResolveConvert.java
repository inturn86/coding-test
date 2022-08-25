package test.dfs;

import java.util.LinkedList;
import java.util.Queue;

public class CodingTestWordMyResolveConvert {

	public static void main(String[] args) {


		solution("hit", "cog", new String[] {"hot", "dot", "dog", "lot", "log", "cog"});
//		solution("hit", "cog", new String[] {"hot", "dot", "dog", "lot", "log"});
	}

//	두 개의 단어 begin, target과 단어의 집합 words가 있습니다.
//	아래와 같은 규칙을 이용하여 begin에서 target으로 변환하는 가장 짧은 변환 과정을 찾으려고 합니다.
//	1. 한 번에 한 개의 알파벳만 바꿀 수 있습니다.
//	2. words에 있는 단어로만 변환할 수 있습니다.
//	* 제한사항
//	각 단어는 알파벳 소문자로만 이루어져 있습니다.
//	각 단어의 길이는 3 이상 10 이하이며 모든 단어의 길이는 같습니다.
//	words에는 3개 이상 50개 이하의 단어가 있으며 중복되는 단어는 없습니다.
//	begin과 target은 같지 않습니다.
//	변환할 수 없는 경우에는 0를 return 합니다.

	static class Node {
        String next;
        int edge;

        public Node(String next, int edge) {
            this.next = next;
            this.edge = edge;
        }
    }

	static Queue<Node> que = new LinkedList<>();
	public static int solution(String begin, String target, String[] words) {

		int cnt = 0;
		boolean[] visit = new boolean[words.length];

		Node nod = new Node(begin, 0);
		que.add(nod);

		while(!que.isEmpty()) {


			Node now = que.poll();
			if(now.next.equals(target)) {
				cnt = now.edge;
				break;
			}
			//반복문 시작
			for(int i = 0, len = words.length; i < len; i++) {
				//방문한적이 없어야함.
				if(!visit[i]) {
					int notMatch = 0;
					for(int j = 0, jlen = words[i].length(); j < jlen; j++) {
						if(now.next.charAt(j) != words[i].charAt(j)) {
							if(notMatch++ > 1) {
								break;
							};
						}
					}
					if(notMatch <= 1) {
						que.add(new Node(words[i], now.edge + 1));
						visit[i] = true;
					}
				}
			}
		}

		return cnt;
	}


}
