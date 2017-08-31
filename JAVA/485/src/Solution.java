import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

	public static void main(String[] argv) {

		int[] nums = { 1, 1, 0, 1, 1, 1, 1, 1, 1, 1 };
		int Ans = findMaxConsecutiveOnes(nums);
		System.out.println(Ans);
	}

	public static int findMaxConsecutiveOnes(int[] nums) {
		int max = 0;
		int now = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 1)
				now += 1;
			else {
				max = Math.max(now, max);
				now = 0;
			}
		}
		if (now != 0)
			max = Math.max(now, max);

		return max;
	}

}
