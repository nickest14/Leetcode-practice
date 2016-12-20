import java.util.ArrayList;
import java.util.List;

public class Solution {

	public static void main(String args[]) {

		int maxWidth = 3;
		String[] words = { "" };
		// String[] words = { "This", "is", "an", "example", "of", "text",
		// "123.", "www", "asdfgh" };
		List<String> Ans = new ArrayList<>();
		Ans = fullJustify(words, maxWidth);
		for (int i = 0; i < Ans.size(); i++)
			System.out.println(Ans.get(i));
	}

	public static List<String> fullJustify(String[] words, int maxWidth) {
		List<String> Ans = new ArrayList<>();
		if (words.length == 0) {
			Ans.add("");
			return Ans;
		}
		if (words.length == 1 && words[0].length() == 0) {
			String space = "";
			for (int i = 0; i < maxWidth; i++)
				space += " ";
			Ans.add("" + space);
			return Ans;
		}

		int start = 0, end = 0;
		while (start < words.length) {
			end++;
			StringBuffer str = new StringBuffer();
			int temp = words[start].length(), space = 1;
			;
			while (end < words.length
					&& temp + space + words[end].length() <= maxWidth) {
				space++;
				temp += words[end].length();
				end++;
			}
			if (end == words.length) { // 準備結尾
				int remain = maxWidth - temp - (space - 1);
				str.append(words[start]);
				for (int i = start + 1; i < end; i++) {
					str.append(" ");
					str.append(words[i]);
				}
				for (int i = 0; i < remain; i++)
					str.append(" ");
			} else if (end - start == 1) { // 只有1個字, 空格擺最後
				int remain = maxWidth - temp;
				str.append(words[start]);
				for (int i = 0; i < remain; i++)
					str.append(" ");
			} else {
				int averageremain = (maxWidth - temp) / (end - start - 1);
				int leftremain = (maxWidth - temp) % (end - start - 1);
				str.append(words[start]);
				for (int x = start + 1; x < end; x++) {
					if (leftremain-- > 0)
						str.append(" ");
					for (int i = 0; i < averageremain; i++)
						str.append(" ");
					str.append(words[x]);
				}
			}
			Ans.add(str.toString());
			start = end;
		}
		return Ans;
	}

}