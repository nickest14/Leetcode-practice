import java.util.Stack;

import java.util.*;

public class Solution {
	public static void main(String args[]) {

		//String path = "/a/./b/../../c/";
		 String path = "/456/.//as/../123/gas/../";
		String Ans = simplifyPath(path);
		System.out.println(Ans);
	}

	public static String simplifyPath(String path) {

		String[] part = path.split("/");
		String Ans = "";
		int ignore = 0;
		for (int i = part.length - 1; i > 0; i--) {
			if (part[i].equals("") || part[i].equals("."))
				continue;
			if (part[i].equals("..")) {
				ignore++;
				continue;
			}
			if (ignore == 0)
				Ans = "/" + part[i] + Ans;
			else
				ignore--;
		}
		if (Ans.length() == 0)
			Ans = "/";
		return Ans;
	}
}

// 使用 stack 方法 速度較慢
// public static String simplifyPath(String path) {
// Stack<String> stack = new Stack<String>();
// String[] test = path.split("/");
// while (path.length() > 0) {
// int begin = path.indexOf("/");
// path = path.substring(begin + 1);
// int end = path.indexOf("/");
// if (end == -1)
// end = path.length();
// String part = path.substring(0, end);
// path = path.substring(end);
//
// if (part.equals(".") || part.equals(""))
// continue;
// if (part.equals("..")) {
// if (stack.isEmpty() == false)
// stack.pop();
// } else
// stack.push("/" + part);
// }
// String Ans = "";
// while (stack.isEmpty() == false) {
// Ans = stack.pop() + Ans;
// }
// if (Ans.length() == 0)
// Ans = "/";
// return Ans;
// }
// }
