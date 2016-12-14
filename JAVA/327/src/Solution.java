public class Solution {

	static long[] sums;
	static int lower = 0, upper = 10;

	public static void main(String args[]) {
		//int[] nums = { -5, -2, -1, 3, 4, 5, 7 };
		// int[] nums = { -2, 5, -1,3,-7,4, };
		 int[] nums = { 3,6};
		int Ans = countRangeSum(nums, lower, upper);
		System.out.println(Ans);
	}

	
	//別人的作法 巧妙設計雙指標 (n logn)
	public static int countRangeSum(int[] nums, int lower, int upper) {
		int ans = 0;
		long[] sum = new long[nums.length + 1];
		for (int i = 0; i < nums.length; ++i) {
			sum[i + 1] = sum[i] + nums[i];
		}
		ans = sort(sum, 0, nums.length + 1, lower, upper);
		return ans;
	}

	public static int sort(long[] sum, int l, int r, int lower, int upper) {
		if (r - l <= 1)
			return 0;
		int ret = 0;
		int mid = (l + r) >> 1;
		long[] temp = new long[r - l];
		ret += sort(sum, l, mid, lower, upper)+ sort(sum, mid, r, lower, upper);
		int rl = mid, rr = mid, j = mid;
		for (int i = l, k = 0; i < mid; ++i) {
			if (rl < r && sum[rl] - sum[i] <= upper) {
				while (rl < r && sum[rl] - sum[i] < lower)
					rl++;
				while (rr < r && sum[rr] - sum[i] <= upper)
					rr++;
				ret += rr - rl;
			}
			while (j < r && sum[j] < sum[i])
				temp[k++] = sum[j++];
			temp[k++] = sum[i];
		}
		System.arraycopy(temp, 0, sum, l, j - l);
		return ret;
	}

}


// 非常慢的作法  單純2分法 (n^2)
//static  long[] counts;
//static  int lower = -2, upper = 2;
// public static int countRangeSum(int[] nums, int lower, int upper) {
//     int length = nums.length;
//
//     if(length <= 0)
//         return 0;
//     counts = new long[nums.length];
//     counts[0] = nums[0];
//     for(int i = 1;i<nums.length;i++){
//         counts[i] = counts[i-1]+nums[i];
//     }
//
//     return countNum(nums,0,length-1);
// }
// private static int countNum(int[] nums,int left,int right){
//     if(left == right){
//         if(nums[left] >=lower && nums[right] <= upper)
//             return 1;
//         return 0;
//     }
//     int mid = (left+right)/2;
//     int total = 0;
//     for(int i = left;i<=mid;i++){
//         for(int j = right; j>mid;j--){
//             long tmpNum = counts[j] - counts[i] + nums[i];
//             if(tmpNum >= lower && tmpNum <= upper)
//                 ++total;
//         }
//     }
//用二分法
//     return total + countNum(nums,left,mid) + countNum(nums,mid+1,right);
// }
//
//}