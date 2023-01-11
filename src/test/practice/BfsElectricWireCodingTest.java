package test.practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class BfsElectricWireCodingTest {


//	n개의 송전탑이 전선을 통해 하나의 트리 형태로 연결되어 있습니다.
//	당신은 이 전선들 중 하나를 끊어서 현재의 전력망 네트워크를 2개로 분할하려고 합니다.
//	이때, 두 전력망이 갖게 되는 송전탑의 개수를 최대한 비슷하게 맞추고자 합니다.
//
//	송전탑의 개수 n, 그리고 전선 정보 wires가 매개변수로 주어집니다.
//	전선들 중 하나를 끊어서 송전탑 개수가 가능한 비슷하도록 두 전력망으로 나누었을 때,
//	두 전력망이 가지고 있는 송전탑 개수의 차이(절대값)를 return 하도록 solution 함수를 완성해주세요.
	public static void main(String[] args) {
		int i = 0;

//		solution(9, new int [][]{{1,3},{2,3},{3,4},{4,5},{4,6},{4,7},{7,8},{7,9}});
		solution(7, new int [][]{{1,2},{2,7},{3,7},{3,4},{4,5},{6,7}});
	}

//	n은 2 이상 100 이하인 자연수입니다.
//	wires는 길이가 n-1인 정수형 2차원 배열입니다.
//	wires의 각 원소는 [v1, v2] 2개의 자연수로 이루어져 있으며, 이는 전력망의 v1번 송전탑과 v2번 송전탑이 전선으로 연결되어 있다는 것을 의미합니다.
//	1 ≤ v1 < v2 ≤ n 입니다.
//	전력망 네트워크가 하나의 트리 형태가 아닌 경우는 입력으로 주어지지 않습니다.
	public static int solution(int n, int[][] wires) {

		int answer = 0 ;

		List<Integer> sArr = new ArrayList<>() ;
		List<Integer> eArr = new ArrayList<>() ;
		for(int i = 0, len = wires.length; i < len; i++) {
			sArr.add(wires[i][0]);
			sArr.add(wires[i][1]);
		}

		System.out.println("s");
		Map<Integer, Long> sMap = sArr.stream().collect(Collectors.groupingBy(o -> o, Collectors.counting()));
//		Map<Integer, Long> eMap = eArr.stream().collect(Collectors.groupingBy(o -> o, Collectors.counting()));


		List<Long> sLong = sMap.entrySet().stream().map(o -> o.getValue()).sorted(Comparator.comparingLong(Long::longValue).reversed()).collect(Collectors.toList());
		Long sMax = sLong.get(0);
		Long eMax = sLong.get(1);
//		Long eMax = sMap.entrySet().stream().filter(o -> sMax == o.getValue()).toList();

		List<Integer> sValue = new ArrayList<Integer>();
		List<Integer> eValue = new ArrayList<Integer>();

		for(Entry<Integer, Long> s : sMap.entrySet()) {
			if(s.getValue() == sMax) {
				sValue.add(s.getKey());
			}
		}

		for(Entry<Integer, Long> e : sMap.entrySet()) {
			if(e.getValue() == eMax) {
				eValue.add(e.getKey());
			}
		}

		int returnMax = 0;
		List<Integer> jkd = new ArrayList<Integer>();
		for(Integer e : eValue) {
			for(Integer s : sValue) {
				if(s == e) {
					continue;
				}
				int max = Math.max(e, s);
				int min = Math.min(e, s);
				int[] se = new int[] {min, max};

				int idx = 0;
				for(int i = 0, len = wires.length; i < len; i++) {
					if(wires[i][0] == se[0] && wires[i][1] == se[1]) {
						idx = i;
					}

				}
				if(idx != -1) {
					int start = idx;
					int end = wires.length - idx - 1;

					jkd.add(Math.abs(start - end));
				}
			}
		}

		if(jkd.size() == 0)
			return 0;

		;
		return jkd.stream().sorted().findFirst().get();
	}

}
