public class Solution {

	public static void main(String args[]) {

		int n = 12;
		int Ans = integerBreak(n);
		System.out.println(Ans);
	}

	public static int integerBreak(int n) {
		if (n == 2 || n == 3)
			return n - 1;
		
		int Ans = 1;
		int x = n % 3;
		int y = n / 3;
		
		if (x == 0)
			Ans = (int) Math.pow(3, y);
		else if (x == 1) {
			Ans = (int) Math.pow(3, y - 1) * 4;
		} else if (x == 2)
			Ans = (int) Math.pow(3, y) * 2;
	
		return Ans;
	}
}
