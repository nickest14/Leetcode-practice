import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Queue;

public class Solution {

	public static void main(String[] argv) {
		String s = "DCXXI";

		int Ans = romanToInt(s);
		System.out.println(Ans);
	}

	public static int romanToInt(String s) {
		int now = 0;
		int Ans = 0;
		int[] value = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
		String[] roman = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };
		StringBuilder S = new StringBuilder(s);
		for (int i = 0; i < roman.length; i++) {
			if (now > S.length())
				break;
			if (roman[i].length() == 2) {
				while (now < (S.length() - 1) && S.charAt(now) == roman[i].charAt(0)
						&& S.charAt(now + 1) == roman[i].charAt(1)) {
					Ans += value[i];
					now += 2;
				}
			} else {
				while (now < (S.length()) && S.charAt(now) == roman[i].charAt(0)) {
					Ans += value[i];
					now++;
				}
			}

		}
		return (Ans);
	}
}