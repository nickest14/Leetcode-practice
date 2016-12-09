import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import java.util.*;

public class Solution {
	public static void main(String args[]) {

		int[][] matrix = { { 1, 4, 7, 11, 15 }, 
									{ 2, 5, 8, 12, 19 },
									{ 3, 6, 9, 16, 22 },
									{ 10, 13, 14, 17, 24 },
									{ 19, 21, 23, 26, 30 } };
		int target = 16;
		Boolean Ans = searchMatrix(matrix, target);
			System.out.println(Ans);
	
	}
    public static boolean searchMatrix(int[][] matrix, int target) {
 
    	for(int i = 0; i<matrix.length; i++){
    		if(matrix[i][0] <= target){
    			if(matrix[i][0] == target || matrix[i][matrix[i].length-1] == target)
    				return true;
    			if( matrix[i][matrix[i].length-1] >= target){
    				int start = 1; 
    				int end = matrix[i].length-1;
    				while( start< end){
    					int medinum = (start+end) /2;
    					if(matrix[i][start] == target || matrix[i][end] == target || matrix[i][medinum] == target)
    						return true;
    					if(matrix[i][medinum] > target)
    						end = medinum-1;
    					else
    						start = medinum+1;
    					}
    			}
    		}
    		else 
    			return false;
    	}
    	
    	return false;
    }
}