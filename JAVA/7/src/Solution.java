import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Solution {

	public static void main(String args[]) {

		int x = -1563847412;
		int Ans = reverse(x);
		System.out.println(Ans);
	}

	public static int reverse(int x) {
		String str = "";
		boolean positive = true;
		int max = Integer.MAX_VALUE;
		int min = (max+1) * -1;
		if(x > max || x< min|| x == 0)
			return 0;
		if (x < 0) {
			positive = false;
			str += "-";
			x *= -1;
		}
		while (x > 0) {
			int temp = x % 10;
			str += temp;
			x /= 10;
		}

		if( positive &&Long.parseLong(str) > max)
			return 0;
		if( !positive && Long.parseLong(str) < min  )
			return 0;
		int Ans = Integer.parseInt(str);
		return Ans;
	}
}

//別人方法  不過並沒有比較快
//public static int reverse(int x) {
//    long result=0;
//    while(x!=0){
//        result=result*10+x%10;
//        if(result>Integer.MAX_VALUE||result<Integer.MIN_VALUE)
//        return 0;
//        x/=10;
//    }
//    return (int)result;
//}