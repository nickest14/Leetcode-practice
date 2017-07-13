import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

		int x = 1;
		TreeNode test = new TreeNode(x);
		test.left = new TreeNode(2);
//		test.right = new TreeNode(3);
//		test.left.left = new TreeNode(4);
//		test.left.right = new TreeNode(5);
//		test.right.left = new TreeNode(6);
//		test.right.right = new TreeNode(7);
//		test.left.left.left = new TreeNode(8);
		// test.left.left.right = new TreeNode(9);
		// test.right.right.left = new TreeNode(10);
		TreeNode test2 = null;
		preorderTraversal(test);
		for (int i = 0; i < Ans.size(); i++)
			System.out.println(Ans.get(i));
	}

	static List<Integer> Ans = new ArrayList<>();
	public static List<Integer> preorderTraversal(TreeNode root) {
		if (root == null)
			return Ans;
		Traversal(root);
		return Ans;

	}

	public static void Traversal(TreeNode root) {
		Ans.add(root.val);
		if (root.left != null) {
			Traversal(root.left);
		}
		if (root.right != null) {
			Traversal(root.right);
		}
	}

}
