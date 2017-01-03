package Solution;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import java.util.*;

public class Solution {
	public static void main(String args[]) {

		 String s = "aaaaaaaaaaaaaaaaaaaaa";
	
		// String s = "123456789123456789AxHHHHHHH";
		int Ans = strongPasswordChecker(s);
		System.out.println(Ans);
	}

	public static int strongPasswordChecker(String s) {
		if (s.length() < 3)
			return 6 - s.length();

		int last = s.charAt(0), repeat = 1, change = 0;
		int[] over_mod = new int[3];
		boolean digital = last >= '0' && last <= '9';
		boolean upper = last >= 'A' && last <= 'Z';
		boolean lower = last >= 'a' && last <= 'z';

		for (int i = 1; i < s.length(); i++) {
			if (s.charAt(i) == last)
				repeat++;
			else {
				change += repeat / 3;
				if (repeat / 3 > 0)
					++over_mod[repeat % 3];
				last = s.charAt(i);
				repeat = 1;

				digital = digital || (last >= '0' && last <= '9');
				upper = upper || (last >= 'A' && last <= 'Z');
				lower = lower || (last >= 'a' && last <= 'z');
			}
		}
		change += repeat / 3;
		if (repeat / 3 > 0)
			++over_mod[repeat % 3];

		int check = (digital ? 0 : 1) + (upper ? 0 : 1) + (lower ? 0 : 1);
		if (s.length() > 20) {
			int del = s.length() - 20;
			if (del < over_mod[0])
				change -= del;
			else if (del < over_mod[0] + over_mod[1] * 2)
				change -= over_mod[0] + (del - over_mod[0]) / 2;
			else
				change -= over_mod[0] + over_mod[1]
						+ (del - over_mod[0] - 2 * over_mod[1]) / 3;
			return del + Math.max(check, change);
		} else
			return Math.max(6 - s.length(), Math.max(check, change));
	}
}
