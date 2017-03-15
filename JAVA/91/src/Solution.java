
public class Solution {

	public static void main(String[] argv) {
		String s = "6102";
		int Ans = numDecodings(s);
		System.out.println(Ans);
	}

	public static int numDecodings(String s) {
		int length = s.length();
		if(length == 0 || s.charAt(0) == '0')
			return 0;
		else if(length ==1)
			return 1;
		int [] dp = new int[length+1];
		dp[0] = 1;
		dp[1] = 1;
		for(int i =2; i<=length; i++){
			int onebit = Integer.valueOf(s.substring(i-1, i));
			int twobit = Integer.valueOf(s.substring(i-2, i));
			if(onebit >=1 && onebit<=9)
				dp[i] += dp[i-1];
			if(twobit >=10 && twobit<=26)
				dp[i] += dp[i-2];
			if(twobit == 0)
				return 0;
		}
		
		return dp[length];
	}
}

// public static int numDecodings(String s) {
// if(s == null || s.length() == 0) {
// return 0;
// }
// int n = s.length();
// int[] dp = new int[n+1];
// dp[0] = 1;
// dp[1] = s.charAt(0) != '0' ? 1 : 0;
// for(int i = 2; i <= n; i++) {
// int first = Integer.valueOf(s.substring(i-1, i));
// int second = Integer.valueOf(s.substring(i-2, i));
// if(first >= 1 && first <= 9) {
// dp[i] += dp[i-1];
// }
// if(second >= 10 && second <= 26) {
// dp[i] += dp[i-2];
// }
// if(second == 0)
// return 0;
// }
// return dp[n];
// }
