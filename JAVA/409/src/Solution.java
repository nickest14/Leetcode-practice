import java.util.HashMap;
import java.util.Map;

public class Solution {

	public static void main(String[] argv) {

		String s = "asasdasdasddddm";
		int Ans = longestPalindrome(s);
		System.out.println(Ans);
	}

	public static int longestPalindrome(String s) {
		Map<Character, Integer> temp = new HashMap<>();
		int Ans = 0;
		char[] c = s.toCharArray();
		for (char tempchar : c) {
			if (temp.containsKey(tempchar)) {
				Ans += 2;
				temp.remove(tempchar);
			} else
				temp.put(tempchar, 1);
		}
		int length = c.length;

		return Math.min(Ans+1, length);
	}
}