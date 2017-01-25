
public class Solution {

	public static void main(String[] argv) {
		int a = 13;
		int b = 5;
		int Ans = getSum(a, b);
		System.out.println(Ans);
	}
	
	public static int getSum(int a, int b) {
       if(b==0)
    	   return a;
       int ans = 0;
       int plus = 0;
       ans =  a^b;
       plus = (a&b) <<1;
       return getSum(ans, plus);
	}

// 另一種方法
//	public static int getSum(int a, int b) {
//        int ans = 0, carry = 0;
//        for (int i = 0; i < 32; i++) {
//            int lower_a = a & 1, lower_b = b & 1;
//            ans |= (lower_a ^ lower_b ^ carry) << i;
//            carry = (carry & lower_a) | (carry & lower_b) | (lower_a & lower_b);
//            a = a >> 1; 
//            b = b >> 1;
//        }
//        return ans;
//	}
}
