import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

	public static void main(String[] argv) {
		// String board = "WWBBWW";
		String board = "WWBBWW";
		String hand = "B";
		int Ans = findMinStep(board, hand);
		System.out.println(Ans);
	}

	public static int findMinStep(String board, String hand) {
		if (board == null || hand == null)
			return -1;
		char[] charboard = board.toCharArray();
		List<Character> boards = new ArrayList<>();
		for (int i = 0; i < board.length(); i++)
			boards.add(charboard[i]);

		Map<Character, Integer> myhand = new HashMap<>();
		myhand.put('R', 0);
		myhand.put('Y', 0);
		myhand.put('B', 0);
		myhand.put('G', 0);
		myhand.put('W', 0);
		for (char h : hand.toCharArray())
			myhand.put(h, myhand.get(h) + 1);

		int Ans = findMin(boards, myhand);
		return Ans;
	}

	private static int findMin(List<Character> boards, Map<Character, Integer> myhand) {
		examine(boards);
		if (boards.isEmpty())
			return 0;
		if (checkhand(myhand))
			return -1;

		int count = 0;
		int min = Integer.MAX_VALUE;

		for (int i = 0; i < boards.size(); i++) {
			char c = boards.get(i);
			count++;

			if (i == boards.size() - 1 || boards.get(i + 1) != c) {
				int missing = 3 - count;
				if (myhand.get(c) >= missing) {
					myhand.put(c, myhand.get(c) - missing);
					List<Character> smallerBoard = new ArrayList<>(boards);
					for (int j = 0; j < count; j++) {
						smallerBoard.remove(i - j);
					}
					int smallerFind = findMin(smallerBoard, myhand);
					if (smallerFind != -1) {
						min = Math.min(smallerFind + missing, min);
					}
					myhand.put(c, myhand.get(c) + missing);
				}
				count = 0;
			}
		}
		return (min == Integer.MAX_VALUE) ? -1 : min;

	}

	private static void examine(List<Character> currentboards) {
		boolean isFind = true;
		while (isFind) {
			isFind = false;
			for (int i = 0; i < currentboards.size() - 2; i++) {
				if (currentboards.get(i) == currentboards.get(i + 1)
						&& currentboards.get(i + 1) == currentboards.get(i + 2)) {
					int j = i + 2;
					while (j + 1 < currentboards.size() && currentboards.get(i) == currentboards.get(j + 1)) {
						j++;
					}
					for (int m = j; m >= i; m--)
						currentboards.remove(m);
					isFind = true;
					break;
				}
			}
		}
	}

	private static boolean checkhand(Map<Character, Integer> myhand) {
		for (int count : myhand.values())
			if (count > 0)
				return false;
		return true;
	}
}
