package test;

import java.util.ArrayList;

public class CodingTestHanoi {

	public static void main(String[] args) {

		solution(4);
	}


	//하노이의 탑 왼쪽기준으로 오르쪽으로 옮기는 작업의 가지수.
	static ArrayList<int[]> seq;
    public static int[][] solution(int n) {
        seq = new ArrayList<>();

        hanoi(n, 1, 3, 2);

        int[][] answer = new int[seq.size()][2];
        for(int i = 0 ; i < seq.size() ; ++i){
            int[] cmd = seq.get(i);
            answer[i][0] = cmd[0];
            answer[i][1] = cmd[1];
        }

        return answer;
    }

    private static void hanoi(int n, int from, int to, int via){
        int[] move = {from, to};

        if(n == 1) {
            seq.add(move);
        } else {
            hanoi(n - 1, from, via, to);
            seq.add(move);
            hanoi(n - 1, via, to, from);
        }
    }

}
