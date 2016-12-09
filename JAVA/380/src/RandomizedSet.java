import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;


public class RandomizedSet {

	HashMap<Integer, Integer> map = new HashMap<>();
    ArrayList<Integer> array = new ArrayList<>();
    Random rand = new Random();
	
    public static void main(String[] argv) {
    	boolean a = true;
    	Scanner input = new Scanner(System.in);
    	RandomizedSet randomSet = new RandomizedSet();
    	
    	while(a){
    		//System.out.println("1 is add data\n2 is remove specific data\n3 is randomly print a data");
    		int num1 = input.nextInt();
    		switch(num1) { 
            case 1: 
            	int x = input.nextInt();
            	randomSet.insert(x);
            	break;
            case 2: 
            	int y = input.nextInt();
            	randomSet.remove(y);
            	break;
            case 3: 
            	int show = randomSet.getRandom();
            	System.out.println(show); 
            	break;
            default: 
            	a = false;
            	break;
    	}
		int x = 10;
	}
    	System.out.println("finish");
    }
    
    /** Initialize your data structure here. */
    public RandomizedSet() {
        
    	 
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
          if (map.containsKey(val)) {
            return false;
        }
        map.put(val, array.size());
        array.add(val);
        return true;
        
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
      if(!map.containsKey(val))
    	  return false;
      int del_index = map.get(val);
      int last = array.size()-1;
      if(del_index < last){
    	  int last_value = array.get(last);
    	  array.set(del_index, last_value);
    	  map.put(last_value, del_index);
      }
      map.remove(val);
      array.remove(last);
        return true;
        
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
         return array.get(rand.nextInt(array.size()));
    }
}

