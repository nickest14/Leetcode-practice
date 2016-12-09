import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Solution {

	public static void main(String args[]) {

		String isnumber = new String("-347e5+3 ");
		boolean correct = isNumber(isnumber);
		System.out.println("\n" + correct);
	}

	public static boolean isNumber(String s) {
	//int qwe = Integer.valueOf(s.charAt(0)).intValue();
		int begin = 0;
		int end = 0;
		String news = "";
		for(int q = 0; q<s.length(); q++){
			if(Integer.valueOf(s.charAt(q)).intValue() == 32){
				begin++;
				continue;
			}
			break;
		}
		for(int q = s.length()-1; q >= 0; q--){
			if(Integer.valueOf(s.charAt(q)).intValue() == 32){
				end++;
				continue;
			}
			break;
		}
		for(int q = begin; q<s.length()-end ; q++){
			news += s.charAt(q);
		}
		int e = 0, dot = 0, before_e = 0, after_e = 0, symbol = 0, after_symbol = 0;
		
		for (int i = 0; i < news.length(); i++) {
			if(news.charAt(i) >= 65 && news.charAt(i)<= 90)
				return false;
			if(news.charAt(i) >=97 && news.charAt(i) <= 122 ){
				if(news.charAt(i) != 101 || e > 0){
					return false;
				}
				else
					e++;
			}
			if(news.charAt(i) >=48 && news.charAt(i) <= 57){
				if(symbol >0 )
					after_symbol++;
				if(e == 0)
					before_e++;
				if(e>0)
					after_e++;
			}
			if(news.charAt(i) == 32 || news.charAt(i)==42 || news.charAt(i)== 47 || news.charAt(i) == 61)
				return false;

			if(news.charAt(i)  == 45 ||news.charAt(i)  == 43 ){
				if( i == 0)
					continue;
				if(e>0 && symbol == 0){
					symbol++;
					continue;
				}
				return false;
			}
			if(news.charAt(i) == 46){
				if (e > 0 || dot > 0)
					return false;
				else 
					dot++;
			}
		}
		if(symbol > 0 && after_symbol ==0)
			return false;
		if(before_e == 0 && after_e==0)
			return false;
		if( e > 0)
			if(before_e ==0 || after_e ==0)
				return false;
		if(dot >0)
			if(before_e ==0 && after_e ==0 )
				return false;
	
			//System.out.println(news.charAt(i));
		return true;
	}
}