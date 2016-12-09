import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import java.util.*;

public class Solution {
	public static void main(String args[]) {
		int a = (int) Math.sqrt(2147395600);
		//int num = 2147395600;
		int num = 876;
		boolean Ans = isPerfectSquare(num);
		System.out.println(Ans);
	}

	public static boolean isPerfectSquare(int num) {
		int count = 0;
		int base = 1;
		boolean a = true;
		if (num < 401) {
			if (num == 1 || num == 4 || num == 9 || num == 16 || num == 25
					|| num == 36 || num == 49 || num == 64 || num == 81
					|| num == 100)
				return true;
			else if (num == 121 || num == 144 || num == 169 || num == 196
					|| num == 225 || num == 256 || num == 289 || num == 324
					|| num == 361 || num == 400)
				return true;
			else
				return false;
		} else if (num < 901) {
			for (int i = 21; i < 31; i++) {
				int compare = i * i;
				if (compare > num)
					break;
				if (compare < num)
					continue;
				else if (compare == num)
					return true;
			}
			return false;
		} else if (num < 1601) {
			for (int i = 31; i < 41; i++) {
				int compare = i * i;
				if (compare > num)
					break;
				if (compare < num)
					continue;
				else if (compare == num)
					return true;
			}
		} else if (num < 2501) {
			for (int i = 41; i < 51; i++) {
				int compare = i * i;
				if (compare > num)
					break;
				if (compare < num)
					continue;
				else if (compare == num)
					return true;
			}
		} else
			while (a) {
				// double compare = Math.abs(base * base);
				if ((num / base) < base) {
					int end = base + 1;
					int start = base - count * 10000;
					while (a && start < end) {
						if ((end - start) < 50) {
							for (int i = start - 1; i < end + 1; i++) {
								if ((num/i) > i) {
									a = false;
									continue;
								}
								if ((num/i)< i){
									a = false;
									break;
								}
									
								else if ((num/i) == i && num % i == 0)
									return true;
							}
						}
						int medinum = (end + start) / 2;
						if ((num/medinum) > medinum)
							start = medinum;
						else
							end = medinum;
					}

				}
				base = base + 10000;
				count++;
			}
		return false;
	}
}
