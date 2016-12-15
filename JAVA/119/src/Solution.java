import java.util.ArrayList;
import java.util.List;

public class Solution {

	public static void main(String args[]) {

		int k = 4;
		List<Integer> Ans;
		Ans = getRow(k);
		System.out.println(Ans);
	}

	//使用較多記憶體
	public static List<Integer> getRow(int rowIndex) {
		int row = 1;
		List<List<Integer>> Anslist = new ArrayList<List<Integer>>();
		List<Integer> initial = new ArrayList<Integer>();
		if (rowIndex == 0) {
			initial.add(1);
			return initial;
		}
		initial.add(1);
		initial.add(1);
		Anslist.add(initial);
		while (row < rowIndex) {
			List<Integer> temp = new ArrayList<Integer>();
			temp.add(1);
			for (int i = 1; i < row + 1; i++) {
				int value = Anslist.get(row - 1).get(i)
						+ Anslist.get(row - 1).get(i - 1);
				temp.add(value);
			}
			temp.add(1);
			if (row + 1 == rowIndex)
				return temp;
			Anslist.add(temp);
			row++;
		}
		return initial;
	}
}

//速度一樣 記憶體使用少 
//public static ArrayList<Integer> getRow(int rowIndex) {
//    ArrayList<Integer> result = new ArrayList<Integer>();
//    rowIndex += 1;
//    result.add(1);
//    for (int i = 1; i < rowIndex; i++) {
//        ArrayList<Integer> tmp = new ArrayList<Integer>(i+1);
//        for (int j = 0; j < i + 1; j++) {
//            tmp.add(-1);
//        }
//        tmp.set(0, result.get(0));
//        tmp.set(i, result.get(i - 1));
//        for (int j = 1; j < i; j++) {
//            tmp.set(j, result.get(j - 1) + result.get(j));
//        }
//        result = tmp;
//    }
//    return result;
//}
