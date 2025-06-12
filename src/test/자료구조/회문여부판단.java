package test.자료구조;

public class 회문여부판단 {

	public static void main(String[] args) {

		System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
		System.out.println(is회문("A man, a plan, a canal: Panama"));
	}

	private static boolean is회문(String str) {

		int left = 0;
		int right = str.length() - 1;

		//left 가 더 커지면 out
		while (left < right) {
			while (left < right && !Character.isLetterOrDigit(str.charAt(left)))    left++;
			while (left < right && !Character.isLetterOrDigit(str.charAt(right)))    right--;

			if(Character.toLowerCase(str.charAt(left)) != Character.toLowerCase(str.charAt(right))) {
				return false;
			}
			left++;
			right--;
		}

		return true;
	}























	private static boolean isPalindrome(String s) {
		int left = 0, right = s.length() - 1;
		while (left < right) {
			while (left < right && !Character.isLetterOrDigit(s.charAt(left))) left++;
			while (left < right && !Character.isLetterOrDigit(s.charAt(right))) right--;
			if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
				return false;
			}
			left++;
			right--;
		}
		return true;
	}



}
