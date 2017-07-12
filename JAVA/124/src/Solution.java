import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

 class TreeNode {
      int val;
      TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
  }

public class Solution {

	public static void main(String[] argv) {
		int x = 10;
		TreeNode test = new TreeNode(x);
		test.left = new TreeNode(9);
		test.right = new TreeNode(8);
		test.left.left = new TreeNode(7);
		test.left.right = new TreeNode(6);
		test.right.left = new TreeNode(5);
		test.right.right = new TreeNode(4);
//		test.left.left.left = new TreeNode(3);
//		test.left.left.right = new TreeNode(2);
//		test.right.right.left = new TreeNode(1);
		int ans = maxPathSum(test);

		System.out.println(ans);
	}

    static int sum = Integer.MIN_VALUE;;
    
    public static int maxPathSum(TreeNode root) {
        DNS(root);
        return sum;
    }
    
    private static int DNS(TreeNode root) {
        if (root == null) 
            return 0;
        int left = Math.max(DNS(root.left), 0);
        int right = Math.max(DNS(root.right), 0);
        sum = Math.max(sum, left + right + root.val);
        return Math.max(left, right) + root.val;
    }
}
