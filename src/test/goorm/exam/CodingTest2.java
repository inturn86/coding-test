package test.goorm.exam;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CodingTest2 {

	public static void main(String[] args) throws Exception{

		List<Integer> smallChiList = new ArrayList<>();
		List<Integer> bigChiList = new ArrayList<>();
		int smallChi = 0;
		int bigChi = 0;
		while (smallChi <= 100 || bigChi <= 100){
			if(smallChi < 100){
				smallChiList.add(smallChi);
				smallChi += 3;
			}

			if(bigChi < 100) {
				bigChiList.add(bigChi);
				bigChi += 7;
			}
		}
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		int testCnt = Integer.valueOf(input);
		List<Integer> wantChiPieces = new ArrayList<>();

		for(int z = 0, zlen = testCnt; z < zlen; z++){
			int chiPieces = Integer.valueOf(br.readLine());
			wantChiPieces.add(chiPieces);
		}

		int testCaseCnt = 1;
		for(Integer pieces : wantChiPieces){
			boolean flag = false;
			System.out.println(String.format("Test Case #%d", testCaseCnt));
			for(int i = 0, ilen = smallChiList.size(); i < ilen; i++){
				for(int j = 0, jlen = bigChiList.size(); j < jlen; j++){
					if(smallChiList.get(i) + bigChiList.get(j) == pieces){
						flag = true;
						break;
					}
				}
				if(flag)    break;
			}
			String result = "";
			if(flag) result = "YES";
			else result = "NO";
			System.out.println(result);
			testCaseCnt ++;
		}
	}
}
