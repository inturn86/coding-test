package test.codility.examine;

import java.util.HashSet;
import java.util.Set;

public class CodingTest1 {

	public static void main(String[] args) {

		int[] A = {};
		solution(A);
	}

	public static boolean solution(int[] A){

		//1이 다른
		if(A.length <= 1){
			return false;
		}

		for(int i = 0, len = A.length; i < len; i++){
			for(int j = i + 1, jlen = A.length; j < jlen; j++){
				if((A[i] + 1) == A[j] || (A[i] - 1) == A[j]){
					return true;
				}
			}
		}

		return false;
	}
}
