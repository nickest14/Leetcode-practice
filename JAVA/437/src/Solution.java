import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Queue;

public class Solution {

	public static void main(String[] argv) {
		int x = 10;
		TreeNode test = new TreeNode(x);
		test.left = new TreeNode(5);
		test.right = new TreeNode(-3);
		test.left.left = new TreeNode(3);
		test.left.right = new TreeNode(2);
		test.right.right = new TreeNode(11);
		test.left.left.left = new TreeNode(3);
		test.left.left.right = new TreeNode(-2);
		test.left.right.right = new TreeNode(1);
		int sum = 8;
		int Ans = pathSum(test, sum);
		System.out.println(Ans);
	}
	
	public static int pathSum(TreeNode root, int sum) {
		if(root == null)
			return 0;
		return DFS(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
	}
	
	public static int DFS(TreeNode root, int sum) {
		int num = 0;
		if(root == null)
			return num;
		if(sum == root.val)
			num++;
		
		num += DFS(root.left, sum - root.val);
		num += DFS(root.right, sum - root.val);
		
		return num;
	}
}


//另一種方法
/*   static void DFS(TreeNode root, boolean flag, int cur, int sum, int[] ans) {
cur += root.val;
if (cur == sum) {
    ans[0] ++;
}
if (root.left != null) {
    DFS(root.left, false, cur, sum, ans);
    if (flag) {
        DFS(root.left, true, 0, sum, ans);
    }
}
if (root.right != null) {
    DFS(root.right, false, cur, sum, ans);
    if (flag) {
        DFS(root.right, true, 0, sum, ans);
    }
}
}	

public static int pathSum(TreeNode root, int sum) {
if (root == null) {
    return 0;
}
int[] ans = new int[1];
DFS(root, true, 0, sum, ans);
return ans[0];
}
}		*/