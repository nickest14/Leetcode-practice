import java.nio.ShortBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

	public static void main(String[] argv) {

		String s = "    2    6      7    ";
		String Ans;
		Ans = reverseWords(s);
		System.out.println(Ans);
	}

    public static String reverseWords(String s) {
    	String Ans = "";
    	if( !s.equals("")){
//        	System.out.println(s);
    		Boolean start = true;
        	String[] s2;
        	s2 = s.split(" ");
        	StringBuilder s3 = new StringBuilder("");
        	for( int i=s2.length-1 ; i>=0; i--){
    			String temp = s2[i].toString();
    			if( !temp.equals("")){
    				if(start){
    					s3.append(temp);
    					start = false;
    				}
    				else{
        				s3.append(" ");
        				s3.append(temp);
    				}

    			}
        	}
        	 Ans = s3.toString();
//        	System.out.println(s3);
    	}
        return Ans;
    }
}
