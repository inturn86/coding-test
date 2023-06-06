package test.codility.yanolza;

import java.util.HashSet;
import java.util.Set;

public class CodingTest3 {

	public static void main(String[] args) {
		int[] i = {0,0,0,0,2,3,3};
		int[] b = {2,5,6};
		solution(i, b);
	}

	static Set<Integer> s = new HashSet<>();
	public static int solution(int[] T, int[] A) {

		int answer = 0;
		s.add(0);
		for(int i = 0 , len = A.length; i < len; i++){
			s.add(A[i]);
			recu(A[i], T);
		}

		return s.size();
	}

	public static void recu(int n, int[] T){

		if(T[n] == 0){
			return;
		}
		else if(s.contains(T[n])) {
			return;
		}
		else{
			s.add(T[n]);
			recu(T[n], T);
		}
	}
}
