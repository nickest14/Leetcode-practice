import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Queue;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}

public class Solution {

	public static void main(String[] argv) {
		int x = 10;
		TreeNode test = new TreeNode(x);
		test.left = new TreeNode(9);
		test.right = new TreeNode(8);
		test.left.left = new TreeNode(7);
		test.right.left = new TreeNode(5);
		test.right.right = new TreeNode(4);
		test.left.left.left = new TreeNode(3);
		test.left.left.right = new TreeNode(2);
		test.right.right.left = new TreeNode(1);
		
		TreeNode test2 = new TreeNode(x);
		test2.left = new TreeNode(9);
		test2.right = new TreeNode(8);
		test2.left.left = new TreeNode(7);
		test2.right.left = new TreeNode(5);
		test2.right.right = new TreeNode(4);
		test2.left.left.left = new TreeNode(3);
		test2.left.left.right = new TreeNode(2);
		test2.right.right.left = new TreeNode(1);
		
		boolean Ans = isSameTree(test, test2);

		System.out.println(Ans);
	}


	    public static boolean isSameTree(TreeNode p, TreeNode q) {
	    	if(p == null && q == null)
	    		return true;
	    	
	    	if( (p == null ||q == null) || (p.val != q.val))
	    		return false;
	    	
			return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
	    }
}
