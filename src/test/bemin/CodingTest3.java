package test.bemin;

public class CodingTest3 {

	public static void main(String[] args) {
		int i = 0;
		solution(new String[]{"123456789,유기농쌀 4kg,50000", "234578882,배달이캐릭터숟가락,3000"},  new String[]{"20220810,123456789,5", "20220810,234578882,30", "20220811,123456789,7"});
	}

	public static String[] solution(String[] productInfo, String[] dailyProductSales) {

		String[] answer = new String[dailyProductSales.length];

		for(int i = 0, len = dailyProductSales.length; i < len; i++) {
			String[] salesInfo = dailyProductSales[i].split(",");
			String pn = "";
			String pr = "";
			for(int j = 0, jlen = productInfo.length; j < jlen; j++) {
				String[] info = productInfo[j].split(",");
				if(salesInfo[1].equals(info[0])) {
					pn = info[1];
					pr = info[2];
				}
			}

			answer[i] = String.format("%s,%s,%s,%s", salesInfo[0], salesInfo[1], pn, String.valueOf(Integer.valueOf(pr) * Integer.valueOf(salesInfo[2])));
		}

		return answer;
	}
}
