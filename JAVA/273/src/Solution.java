
public class Solution {
	
	 final static String[] below20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
	 final static String[] ten = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
	 final static String[] thousand  = {"", "Thousand", "Million", "Billion"};
	
	public static void main(String args[]) {
		 //int num = 2104280061;
		 int num = 2104280061;
		String Ans = numberToWords(num);
		System.out.println(Ans);
	}
	
	 public static String numberToWords(int num) {
		 
		 String Ans = "";
		 int temp =0;
		 int remainder = 0;
		if( num == 0){
		   Ans = "Zero"; 
		   return Ans; 
		}
		  
		 if( num >=1000000000){
			 temp = num / 1000000000;
			 Ans +=  help(temp, 1);
			 Ans +=  thousand[3];
			 if(num % 1000000000 != 0)
			    Ans += " ";
			 num = num % 1000000000;
		 }
		 if( num >= 1000000){
			 temp = num / 1000000;
			 Ans +=  help(temp, 1);
			 Ans +=  thousand[2];
			 if(num % 1000000 != 0)
			    Ans += " ";
			 num = num % 1000000;
		 }
		 if( num >= 1000){
			 temp = num / 1000;
			 Ans +=  help(temp, 1);
			 Ans +=  thousand[1];
			 if(num % 1000 != 0)
			    Ans += " ";
			 num = num % 1000;
		 }
		 if(num > 0)
		 Ans +=  help(num, 0);
		 return Ans;
	        
	    }
	 public static  String help(int num2, int space){
		 String hundred = "";
		 int temp2 = num2 / 100;
		 int Two_digits = num2 % 100;
		 if(num2 == 0)
			 return "Zero ";
		 if(num2 >= 100)
			 hundred = below20[temp2] +" " + "Hundred";
		 if(Two_digits > 0 && num2 > 100)
			 hundred += " ";
		 if(Two_digits > 19){
			 int temp3 = Two_digits / 10;
			 int temp4 = Two_digits % 10;
			 hundred += ten[temp3];
			 if(temp4 != 0)
			    hundred += " ";
			 hundred += below20[temp4];
		 }
		 else
			 hundred += below20[Two_digits];
	    if(space == 1)
	         hundred += " ";
		return hundred;
		 
	 }
}
