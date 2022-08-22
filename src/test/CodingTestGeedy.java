package test;

public class CodingTestGeedy {

	public static void main(String[] args) {

		int[] stations = {9};
		solution2(16, stations, 2);
	}

	//Í∏∞Ï?Íµ? ?†Ñ?åå greedy
	public static int solutions(int n, int[] stations, int w) {
		int answer = 0;
		int pos = 1;
		int idx = 0;

		//while?? ?ù¥ Ï°∞Í±¥?ù¥ true?ùº?ïå ÍπåÏ? ?èà?ã§.
		while (pos <= n) {
			//station?ùò Í∏∏Ïù¥Î•? Ï≤¥ÌÅ¨
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

			//?ã§?ùå?ùò station min?ùÑ Íµ¨Ìï¥?Ñú ?ï¥?ãπ Í∞íÏ? -?ïò?ó¨
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
