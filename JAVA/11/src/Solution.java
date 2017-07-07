
public class Solution {

	public static void main(String[] argv) {
		
		int [] height  = {3, 4,5,6,5,4,66,84,51,20};
		int Ans = maxArea(height);
		
		System.out.println(Ans);
		System.out.println("End");
	}
	
    public static int maxArea(int[] height) {
    	int area = 0;
    	int l = 0, r = height.length-1;
    	while(l < r){
    		area = Math.max(area, Math.min(height[l], height[r]) * (r-l));
    		if(height[l] < height[r])
    			l++;
    		else
    			r--;
    	}
		return area;
        
    }

}
