import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Solution {

	public static void main(String args[]) {

		String pattern = new String("accdbbad");
		String str = new String("apple cat cat dog ball ball apple dog");
		boolean correct = wordPattern(pattern, str);
		System.out.println(correct);
	}

	public static boolean wordPattern(String pattern, String str) {

		///*
		String[] arrpattern = pattern.split(""); // 拆成 {"a","b","b", "a"} 陣列
		String[] arr_str = str.split(" "); // 拆成 {"dog","cat","cat", "dog"} 陣列
		// for (int i=0; i<arrpattern.length; i++)
		// System.out.println(arrpattern[i]);
		// for (int i=0; i<arr_str.length; i++)
		// System.out.println(arr_str[i]);
		
        int c = pattern.length();
        int c1 = arr_str.length;
        if(c != c1)
            return false;
 
        int[][] arr = new int [c][c];
		for (int x = 0; x < c; x++) {
			for (int y = 0; y < c; y++) {
				if(arr[x][y] != 1){
				boolean compare1 = arrpattern[x+1].equals(arrpattern[y+1]);  //不知為什麼第1個為空, leetcode上則沒有
				boolean compare2 = arr_str[x].equals(arr_str[y]);
				if (!compare1 == compare2)
					return false;
				}
				arr[x][y] = 1;
				arr[y][x] = 1;
			}
		}
		return true;
	}
	 //*/
	//用MAP 寫法更快速
	/* 
	 String[] arr_str = str.split(" ");  
	 
    if(pattern.length() != arr_str.length  )
    	return false;  
      
    Map<Character, String> map = new HashMap<>();  
    Set<String> unique = new HashSet<>();  
      
    for(int i=0; i<pattern.length(); i++) {  
        char c = pattern.charAt(i);  
        if(map.containsKey(c) ) {  
            if(!map.get(c).equals(arr_str[i])) 
            	return false;  
        } else {  
            if(unique.contains(arr_str[i])) 
            	return false;  
            map.put(c, arr_str[i]);  
            unique.add(arr_str[i]);  
        }  
    }  
    return true;  
}  
*/
	
}