import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Queue;

public class Solution {

	public static void main(String[] argv) {

		String test = "";
		int numRows = 1;
		test = convert(test, numRows);
		System.out.println(test);
	}

	public static String convert(String s, int numRows) {
		String Answer = "";
		if (s.length() == 0) {
			String str = "\"\"";  //leetcode compile => str = "";
			return str;
		}
		if (numRows == 1)
			return s;
		String[] Ans;
		int stringsize = s.length();
		int mod = 2 * numRows - 2;
		if (stringsize < numRows)
			numRows = stringsize;
		Ans = new String[numRows];
		int temp = 0, temp2 = 0;
		for (int j = 0; j < numRows; j++) {
			Ans[j] = "";
			Ans[j] += s.charAt(j);
		}

		for (int i = numRows; i < s.length(); i++) {
			temp = i % (mod);
			if (temp < numRows) {
				Ans[temp] += s.charAt(i);
			} else {
				temp2 = mod - (temp % mod);
				Ans[temp2] += s.charAt(i);
			}
		}
		for (int x = 0; x < numRows; x++) {
			Answer += Ans[x].toString();
		}
		return Answer;
	}
}