import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;

public class Solution {

	public static void main(String args[]) {

		// int[] nums = { 4, 3, 2, 7, 8, 2, 3, 1 };
		int[] nums = { 1, 2, 3, 4, 6, 5, 4, 2, 2, 2, };
		List Ans = findDisappearedNumbers(nums);
		System.out.println(Ans);
	}

	 //O(n) 方法
	 public static List<Integer> findDisappearedNumbers(int[] nums) {
	 int length = nums.length;
	 List<Integer> Ans = new ArrayList<Integer>();
	 for (int i = 0; i < length; i++) {
	 int index = Math.abs(nums[i]) -1;
	 if (nums[index] > 0) {
	 nums[index] = -nums[index];
	 }
	 }
	 for (int i = 0; i < length; i++) {
	 if (nums[i] > 0) {
	 Ans.add(i+1);
	 }
	 }
	 return Ans;
	 }
	 }

	// 使用map 速度差別人非常多
//	public static List<Integer> findDisappearedNumbers(int[] nums) {
//		Arrays.sort(nums);
//		List<Integer> Ans = new ArrayList<Integer>();
//		if (nums.length == 0)
//			return Ans;
//		LinkedHashMap<Integer, Boolean> temp = new LinkedHashMap<Integer, Boolean>();
//		int length = nums.length;
//		for (int value : nums) {
//			temp.put(value, true);
//		}
//		for (int i = 1; i <= length; i++) {
//			if (temp.get(i) == null)
//				Ans.add(i);
//		}
//		return Ans;
//	}
//}
