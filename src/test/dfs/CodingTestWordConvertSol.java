package test.dfs;

import java.util.LinkedList;
import java.util.Queue;

public class CodingTestWordConvertSol {

	public static void main(String[] args) {


//		solution("hit", "cog", new String[] {"hot", "dot", "dog", "lot", "log", "cog"});
		solution("hit", "cog", new String[] {"hot", "dot", "dog", "lot", "log"});
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

    public static int solution(String begin, String target, String[] words) {
        int n = words.length, ans = 0;

        // for (int i=0; i<n; i++)
        //  if (words[i] != target && i == n-1) return 0;

        Queue<Node> q = new LinkedList<>();


        boolean[] visit = new boolean[n];
        q.add(new Node(begin, 0));

        while(!q.isEmpty()) {
            Node cur = q.poll();
            if (cur.next.equals(target)) {
                ans = cur.edge;
                break;
            }

            for (int i=0; i<n; i++) {
                if (!visit[i] && isNext(cur.next, words[i])) {
                    visit[i] = true;
                    q.add(new Node(words[i], cur.edge + 1));
                }
            }
        }

        return ans;
    }

    static boolean isNext(String cur, String n) {
        int cnt = 0;
        for (int i=0; i<n.length(); i++) {
            if (cur.charAt(i) != n.charAt(i)) {
                if (++ cnt > 1) return false;
            }
        }

        return true;
    }


}
