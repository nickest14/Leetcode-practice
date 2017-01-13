
import java.util.*;

public class Solution {
	public static void main(String args[]) {

		int n =   12;
		int Ans = hammingWeight(n);
		System.out.println(Ans);
	}

	public static int hammingWeight(int n) {
	        int count = 0;
	        for(int i = 0; i < 32; i++){
	        	count += (n & 1);
	            n=n>>1;
	        }
	        return count;
	    }
}

//直接用 Integer.toBinaryString(n)  速度很慢
//public static int hammingWeight(int n) {
	// int count = 0;
	// String two = Integer.toBinaryString(n);
	// System.out.println(Integer.toBinaryString(n));
	// for(int i = 0; i< two.length(); i++){
	// if(two.charAt(i) == '1')
	// count++;
	// }
	//return count;
//}
