import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
	

	public static void main(String[] argv) {
		String ring = "ACDBCE";
		String key = "CEB";
		int Ans = findRotateSteps(ring, key);
		System.out.println(Ans);
	}

	int ret = Integer.MAX_VALUE;

	public static int findRotateSteps(String ring, String key) {
		if (key.length() == 0)
			return 0;
		return action(ring.toCharArray(), key.toCharArray(), 0, 0, new int[ring.length()][key.length()]);
	}
	
	// leetcode 上最快的方法
	public static int action(char[] ring, char[] key, int index, int p, int[][] dp) {
		if (index == key.length)
			return 0;
		if (dp[p][index] != 0)
			return dp[p][index];
		int leftp = p, rightp = p, countl = 0, countr = 0;
		while (ring[leftp] != key[index]) {
			--leftp;
			if (leftp == -1)
				leftp = ring.length - 1;
			++countl;
		}
		int left = 1 + countl + action(ring, key, index + 1, leftp, dp);
		while (ring[rightp] != key[index]) {
			++rightp;
			if (rightp == ring.length)
				rightp = 0;
			++countr;
		}
		int right = 1 + countr + action(ring, key, index + 1, rightp, dp);
		return dp[p][index] = Math.min(left, right);
	}                                                                                                                        
}

// DP
// public static int findRotateSteps(String ring, String key) {
// int n = ring.length();
// int m = key.length();
// int[][] dp = new int[m + 1][n];
// for (int i = m - 1; i >= 0; i--) {
// for (int j = 0; j < n; j++) {
// dp[i][j] = Integer.MAX_VALUE;
// for (int k = 0; k < n; k++) {
// if (ring.charAt(k) == key.charAt(i)) {
// int diff = Math.abs(j - k);
// int step = Math.min(diff, n - diff);
// dp[i][j] = Math.min(dp[i][j], step + dp[i + 1][k]);
// }
// }
// }
// }
// return dp[0][0] + m;
// }
// }



// DFS
// static Map<String, Map<Integer, Integer>> record = new HashMap<>();
//
// public static int findRotateSteps(String ring, String key) {
// if (ring == null || key == null || ring.length() == 0 || key.length() == 0)
// return 0;
// int Ans = findRotateSteps(ring, key, 0);
// return Ans;
// }
//
// public static int findRotateSteps(String ring, String key, int index) {
// if (key.length() == index)
// return 0;
// if (record.containsKey(ring) && record.get(ring).containsKey(index)) {
// return record.get(ring).get(index);
// }
//
// char c = key.charAt(index);
// int first = ring.indexOf(c);
// int last = ring.lastIndexOf(c);
// int step1 = 1 + first + findRotateSteps(new_order(ring, first), key, index +
// 1);
// int step2 = 1 + (ring.length() - last) + findRotateSteps(new_order(ring,
// last), key, index + 1);
// int step = Math.min(step1, step2);
// Map<Integer, Integer> tempstep = new HashMap<>();
// tempstep.put(index, step);
// record.put(ring, tempstep);
// return step;
// }
//
// public static String new_order(String ring, int index) {
// int len = ring.length();
// char[] new_order = new char[len];
// for (int i = 0; i < len; i++) {
// new_order[i] = ring.charAt(index % len);
// index++;
// }
// return String.valueOf(new_order);
// }
// }
