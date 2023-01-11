package test.bemin;

import java.util.regex.Pattern;

public class CodingTest4 {

	public static void main(String[] args) {
		String i = "";
		solution("/payment/1234/cancel");
	}

	public static String solution(String pathVariableUrl) {

		String answer = "error" ;

		if(!Pattern.matches("^/payment/([0-9]{1,9})/([a-zA-Z]{1,10})", pathVariableUrl)) {
			return answer;
		}

		String[] arr = pathVariableUrl.split("/");

		answer = String.format("/%s/%s?paymentId=%s", arr[1], arr[3], arr[2]);

//		arr[2];//id
//		arr[3];//method

		return answer;
	}
}
