import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Queue;

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
		levelOrder(test);

		System.out.println("test");
	}

	public static List<List<Integer>> levelOrder(TreeNode root) {
		List list = new ArrayList<List>();
	    if (root == null)
	        return list;
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		while (queue.size() != 0) {
			List templist = new ArrayList<List>();
			for (TreeNode child : queue)
				templist.add(child.val);
			if(list.size() %2 != 0 )      //反轉
				Collections.reverse(templist);
			list.add(new ArrayList(templist));
			ListIterator<Integer> litr1=templist.listIterator(); 
			while(litr1.hasNext()) // 正向走訪元素
				 System.out.print(litr1.next()+" "); // 印出元素內容
			Queue<TreeNode> queue2 = queue;
			queue = new LinkedList<TreeNode>();
			for (TreeNode child : queue2) {
				if (child.left != null)
					queue.add(child.left);
				if (child.right != null)
					queue.add(child.right);
			}
		}
		int a = 1;
		return list;
	}
}