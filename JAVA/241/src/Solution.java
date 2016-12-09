import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Arrays;

public class Solution {

	private static HashMap<String, List> hashmap = new HashMap<String, List>();

	public static void main(String args[]) {
		//String input = new String("122*3+4");
		 String input = new String("2*3-4*5");
		List<Integer> Ans = new ArrayList<Integer>();
		Ans = diffWaysToCompute(input);

		Collections.sort(Ans);
		System.out.println(Ans);
	}

	public static List<Integer> diffWaysToCompute(String input) {

		if (hashmap.containsKey(input))
			return hashmap.get(input);
		List<Integer> res = new ArrayList<Integer>();
		for (int i = 0; i < input.length(); i++) {
			char ch = input.charAt(i);
			if (ch == '+' || ch == '-' || ch == '*') {
				for (Integer l : diffWaysToCompute(input.substring(0, i))) {
					for (Integer r : diffWaysToCompute(input.substring(i + 1,input.length()))) {
						if (ch == '+')
							res.add(l + r);
						else if (ch == '-')
							res.add(l - r);
						else
							res.add(l * r);
					}
				}
			}
		}
		if (res.size() == 0)
			res.add(Integer.valueOf(input));
		hashmap.put(input, res);
		return res;
	}
}
