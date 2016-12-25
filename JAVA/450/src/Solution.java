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
     TreeNode(int x) { val = x; }
 }


public class Solution {

	public static void main(String[] argv) {
		
		int key = 10;
		TreeNode root = new TreeNode(10);
		root.left = new TreeNode(5);
		root.right = new TreeNode(15);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(6);
		root.right.left = new TreeNode(12);
		root.right.right = new TreeNode(20);
		root.right.left.left = new TreeNode(11);
		root.right.left.right = new TreeNode(13);
		root.right.left.right.left = new TreeNode(14);
		root.right.right.left = new TreeNode(19);
		root.right.right.right = new TreeNode(22);
		TreeNode Ans ;
		Ans = deleteNode(root, key);

		System.out.println(Ans);
	}

    public static TreeNode deleteNode(TreeNode root, int key) {
    	TreeNode tmp;
        if(root == null)
        	return null;
        
        if(root.val > key)
        	root.left = deleteNode(root.left, key);
        else if(root.val < key)
        	root.right = deleteNode(root.right, key);
        else{
        	if(root.left == null && root.right == null)
        		return null;
        	else if(root.left == null)
        		return root.right;
        	else if(root.right == null)
        		return root.left;
        	else{
        		tmp = root.right;
        		 while(  tmp.left != null){
                     tmp = tmp.left;
                 }
                 root.val = tmp.val;
                 root.right = deleteNode(root.right, tmp.val);
        	}
        }
		return root;
	}
}