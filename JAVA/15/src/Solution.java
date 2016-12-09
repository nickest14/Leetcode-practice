import java.util.Arrays;
import java.util.Stack;
import java.util.*;


//速度很慢....
public class Solution {
	public static void main(String args[]) {

		// int[] nums = {7,-1,14,-12,-8,7,2,-15,8,8,-8,-14,-4,-5,7,9,11,-4,-15,-6,1,-14,4,3,10,-5,2,1,6,11,2,-2,-5,-7,-6,2,-15,11,-6,8,-4,2,1,-1,4,-6,-15,1,5,-15,10,14,9,-8,-6,4,-6,11,12,-15,7,-1,-9,9,-1,0,-4,-1,-12,-2,14,-9,7,0,-3,-4,1,-2,12,14,-10,0,5,14,-1,14,3,8,10,-8,8,-5,-2,6,-11,12,13,-7,-12,8,6,-13,14,-2,-5,-11,1,3,-6};
		 int[] nums = { -1, 0, 2, 3,0, 0, -4, 4, -2, 1, 1, 5, 7 };
		//int[] nums = {-3,-3,0,-5};
		List<List<Integer>> Ans = new ArrayList<List<Integer>>();
		Ans = threeSum(nums);
		System.out.println(Ans);
	}

	public static List<List<Integer>> threeSum(int[] nums) {
		Arrays.sort(nums);
		boolean c = true;
		List<List<Integer>> zerolist = new ArrayList<List<Integer>>();
		if (nums.length < 3 || nums[nums.length - 1] < 0)
			return zerolist;
		for (int i = 0; i < nums.length - 1; i++) {
			if ( i > 1 && nums[i] == nums[i-2] && nums[i] != 0) 
				++i;
			if (nums[i] > 0)
				break;
			if (nums[i] == 0 && i > 0) {
				if (nums.length - i > 2 && nums[i] == 0) {
					if (nums[i + 1] == 0 && nums[i + 2] == 0) {
						List<Integer> zero = new ArrayList<Integer>();
						zero.add(nums[i]);
						zero.add(nums[i + 1]);
						zero.add(nums[i + 2]);
						if (!zerolist.contains(zero))
							zerolist.add(zero);
						break;
					}
				}
			}
			int start = i + 1;
			int end = nums.length - 1;
			if(start >= end)
				continue;
			boolean a = true;
			while (a) {
				List<Integer> temp = new ArrayList<Integer>();
				if (nums[i] + nums[start] + nums[end] == 0) {
					temp.add(nums[i]);
					temp.add(nums[start]);
					temp.add(nums[end]);
					if (!zerolist.contains(temp))
						zerolist.add(temp);
					start++;
					end--;
				} else if (nums[i] + nums[start] + nums[end] > 0) {
					end--;
				} else if (nums[i] + nums[start] + nums[end] < 0) {
					start++;
				}
				if (start >= end || nums[end] < 0) {
					a = false;
					continue;
				}
				while ( nums[start] != nums[end] && start+2 < nums.length && nums[start] == nums[start + 2])
					start++;
				while (nums[end] == nums[end - 2] && nums[start] != nums[end])
					end--;
				if(start == end)
					a = false;
			}

		}
		return zerolist;

	}
}
