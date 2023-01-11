package test.practice;

public class DfsPirodoCodingTest {

	public static void main(String[] args) {
//		int i = 0;
		solution(80, new int[][] {{80,20},{50,40},{30,10}});
	}

//	k는 1 이상 5,000 이하인 자연수입니다.
//	dungeons의 세로(행) 길이(즉, 던전의 개수)는 1 이상 8 이하입니다.
//	dungeons의 가로(열) 길이는 2 입니다.
//	dungeons의 각 행은 각 던전의 ["최소 필요 피로도", "소모 피로도"] 입니다.
//	"최소 필요 피로도"는 항상 "소모 피로도"보다 크거나 같습니다.
//	"최소 필요 피로도"와 "소모 피로도"는 1 이상 1,000 이하인 자연수입니다.
//	서로 다른 던전의 ["최소 필요 피로도", "소모 피로도"]가 서로 같을 수 있습니다.

	public static boolean[] visited = {};
	public static int success= 0;

	public static int solution(int k, int[][] dungeons) {

		visited = new boolean[dungeons.length];
		recu(k, dungeons, 0);

		return success;
	}

	public static void recu(int k, int[][] dungeons, int su) {

		for(int i = 0, len = dungeons.length; i < len; i++) {

			//피로도가 최소 필요 피로도보다 큰경우
			if(!visited[i] && k >= dungeons[i][0]) {
				visited[i] = true;
				recu(k - dungeons[i][1], dungeons, su + 1);
				visited[i] = false;
			}
		}

		success = Math.max(success, su);
	}
}
