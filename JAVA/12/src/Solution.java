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
		int num = 1374;

		String Ans = intToRoman(num);
		System.out.println(Ans);
	}

	public static String intToRoman(int num) {
		int[] value = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
		String[] roman = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };
		StringBuilder Ans = new StringBuilder();
		for (int i = 0; i < value.length; i++) {
			while (num >= value[i]) {
				num -= value[i];
				Ans.append(roman[i]);
			}
		}

		return Ans.toString();

	}

}