
import java.util.*;

public class Solution {
	public static void main(String args[]) {

		int[] gas = { 1, 2, 3 };
		int[] cost = { 3, 2, 1 };
		int Ans = canCompleteCircuit(gas, cost);
		System.out.println(Ans);
	}

	public static int canCompleteCircuit(int[] gas, int[] cost) {
		int total = 0;
    	int index = 0;
    	int accumulate = 0;
    	for(int i = 0; i< gas.length; i++){
    		total += gas[i] - cost[i];
    		accumulate += gas[i] - cost[i];
    		if(accumulate < 0)
    		{
    			accumulate = 0;
    			index = i+1;
    		}			
    	}
    	if(total < 0 )
    		return -1;
        return index;
    }
}
