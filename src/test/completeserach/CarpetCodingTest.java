package test.completeserach;

public class CarpetCodingTest {
//
//	카펫
//	문제 설명
//	Leo는 카펫을 사러 갔다가 아래 그림과 같이 중앙에는 노란색으로 칠해져 있고 테두리 1줄은 갈색으로 칠해져 있는 격자 모양 카펫을 봤습니다.
//
//	carpet.png
//
//	Leo는 집으로 돌아와서 아까 본 카펫의 노란색과 갈색으로 색칠된 격자의 개수는 기억했지만, 전체 카펫의 크기는 기억하지 못했습니다.
//
//	Leo가 본 카펫에서 갈색 격자의 수 brown, 노란색 격자의 수 yellow가 매개변수로 주어질 때 카펫의 가로, 세로 크기를 순서대로 배열에 담아 return 하도록 solution 함수를 작성해주세요.
//
//	제한사항
//	갈색 격자의 수 brown은 8 이상 5,000 이하인 자연수입니다.
//	노란색 격자의 수 yellow는 1 이상 2,000,000 이하인 자연수입니다.
//	카펫의 가로 길이는 세로 길이와 같거나, 세로 길이보다 깁니다.
//	입출력 예
//	brown	yellow	return
//	10	2	[4, 3]
//	8	1	[3, 3]
//	24	24	[8, 6]
	public static void main(String[] args) {
		int i = 0;
		solution(42, 1);
	}

	public static int[] solution(int brown, int yellow) {

		int total = brown + yellow;

		int x = 1;

		int[] arr = new int[2];
		while(x <= total) {
			//total을 x로 나눈 값이 0이면
			if(total % x == 0 ) {
				int width = total / x;
				System.out.println("x" + x);

				//brown이 한줄로 감싸고 있기때문에 위아래/좌우를하여 yellow의 갯수가 맞아야함.

				if(width >= x && ((width - 2)*(x - 2)) == yellow) {
					arr[0] = width;
					arr[1] = x;
				}
			}
			x++;
		}

		System.out.println("s");
		return arr;
	}


}
