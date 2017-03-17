public class Solution {

	public static void main(String[] argv) {
		int n = 2147483647;
		int Ans = integerReplacement(n);
		System.out.println(Ans);
	}

    public static int integerReplacement(int n) {
    	long N = n;
        int num = 0;
        while(N >1){
        if( N == 3){
        	num += 2;
        	break;
        }
        else if(N % 2 == 0)
        		N = N/2;
        else{
        		if((N & 2) ==2)
        			N = N +1;
        		else
        			N = N-1;
        	}	
        	num++;
        }
        return num;
    }
}
