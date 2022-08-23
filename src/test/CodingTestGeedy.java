package test;

public class CodingTestGeedy {

	public static void main(String[] args) {

		int[] stations = {9};
		solution2(16, stations, 2);
	}

	//기지국 설치 greedy
	public static int solutions(int n, int[] stations, int w) {
		int answer = 0;
		int pos = 1;
		int idx = 0;

		//pos이 최대와 같거나 클경우 break;
		while (pos <= n) {
			//station의 최대 길이를 체크.
			if(stations.length != idx && pos >= stations[idx] - w) {
				pos = stations[idx] + w + 1;
				idx ++;
			}
			else {
				pos = pos + (w * 2 + 1);
				answer++;
			}
		}

		System.out.println(answer);
		return answer;

	}

	public static int solution2(int n, int[] stations, int w) {

		int idx = 0;
		int stationSize = stations.length;
		int stationMaxLength = 0;
		int stationMinLength = 0;

		int count = 0;
		for(int pos = 1; pos <= n;) {

			//?��?��?�� station min?�� 구해?�� ?��?�� 값�? -?��?��
			if(idx < stationSize && pos >= stations[idx] - w) {
				pos = stations[idx] + w + 1;
				idx ++;
			}
			else {
				int s = 0;
				int max = 0;
				int target = 0;
				if(idx == stationSize) {
					max = n;
					target = n;
				}
				else {
					max = stations[idx] - w;
					target = stations[idx] + w + 1;
				}

				s = (int) Math.floor((max - pos) / (w * 2 + 1));

				count += s;
				if((max - pos) % (w * 2 + 1) != 0) {
					count++;
				}
				pos = target;
				if(pos == n) {
					break;
				}
			}
		}

		int result = count;
		System.out.println("result " + result);
        return result;
    }


}
