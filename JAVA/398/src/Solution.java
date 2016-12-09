import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;


public class Solution {

	private static int[] findnums;
	private static Random random;
	
	public static void main(String args[]) {
		
		//int[] nums = new int[] {1,2,3,3,3,3,3,3,3};
		int[] nums = new int[] {1};
		int target = 3;
		Solution solution = new Solution(nums);
		int Ans;
		Ans = pick(target);

		System.out.println(Ans);
	}
	
	
    public Solution(int[] nums) {
        this.findnums = nums;
        this.random = new Random();
    	
    }
    
    public static int pick(int target) {
    	int count = 0;
    	int Ans = 0;
    	for(int i = 0; i<findnums.length; i++){
    		if(findnums[i] == target){
    			if(count == 0){
    				Ans = i;

    			}
    			++count;
    			if(random.nextInt(count) == 0)
    				Ans = i;
    		}
    	}
		return Ans;
        
    }
}
