import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Solution {

	public static void main(String args[]) {

		String secret = new String("1234");
		String guess = new String("0111");
		String hint = getHint(secret, guess);
		System.out.println(hint);
	}

	public static <Arraylist> String getHint(String secret, String guess) {

		int A =0, B=0;
		ArrayList secretarr =  new ArrayList();
		ArrayList guessarr = new ArrayList();

		for(int i=0; i<secret.length(); i++) {
		int tempsecret = secret.charAt(i);
		int tempguess = guess.charAt(i);
		if(tempsecret == tempguess){
			A++;
			continue;
		}
		secretarr.add(tempsecret);
		guessarr.add(tempguess);
		}
		for(int x = 0; x< secretarr.size(); x++){
			for(int y = 0; y<guessarr.size(); y++){
				if(secretarr.get(x) == guessarr.get(y)){
					B++;
					guessarr.remove(y);
					break;
				}
			}
		}

		String hint = A+"A" +B +"B";
		return hint;
	}

}