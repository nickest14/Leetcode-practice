import java.util.*;

public class Solution {
	public static void main(String args[]) {
		int n = 10;
		int Ans = arrangeCoins(n);
		System.out.println(Ans);
	}
    public static int arrangeCoins(int n) {
    	if (n ==0)
    		return 0;
    	int row = 1;
    	while(n >= row){
    		n -= row;
    		row++;
    	}
		return row-1;
    }
}
