
import java.util.Stack;

import java.util.*;

public class Solution {
	public static void main(String args[]) {

//		int A = -3; 
//		int B = -2;
//		int C = -1;
//		int D = 2;
//		int E = -2;
//		int F = -4;
//		int G = 3;
//		int H = -1;
		
		int A = -2; 
		int B = -2;
		int C = 2;
		int D = 2;
		int E = -1;
		int F = -1;
		int G = 1;
		int H = 1;
		
		int Ans = computeArea(A,B,C,D,E,F,G,H);
		System.out.println(Ans);
	}

    public static int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
    
    	int R1 = Math.abs((A - C) * (B - D));
    	int R2 = Math.abs((E - G) * (F - H));
    	if(R1 == 0)
    		return R2;
		if(R2 == 0)
			return R1;
    	if(A>=G || B>=H || C<=E || D<=F){
			return R1 + R2;
		}

    	int overlap = Math.abs((Math.max(A, E) - Math.min(C, G )) * (Math.max(B, F) - Math.min(D, H )));
    	
    	return R1 +R2 - overlap;
        
    }

}