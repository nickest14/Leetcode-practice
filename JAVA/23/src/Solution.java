import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Queue;

public class Solution {

	public static void main(String[] argv) {

		ListNode test = new ListNode(0);
		ListNode temp = test;
		for (int i = 1; i < 3; i++)
			temp = insert(temp, i);

		ListNode test1 = new ListNode(3);
		temp = test1;
		for (int i = 4; i < 10; i++)
			temp = insert(temp, i);

		ListNode test2 = new ListNode(10);
		temp = test2;
		for (int i = 11; i < 20; i++)
			temp = insert(temp, i);

		ListNode test3 = new ListNode(20);
		temp = test3;
		for (int i = 21; i < 25; i++)
			temp = insert(temp, i);

		ListNode test4 = new ListNode(25);
		temp = test4;
		for (int i = 26; i < 30; i++)
			temp = insert(temp, i);

		ListNode test5 = new ListNode(30);
		temp = test5;
		for (int i = 31; i < 40; i++)
			temp = insert(temp, i);

		ListNode[] lists = new ListNode[8];
		
		lists[0] = test;
		lists[1] = test1;
		lists[2] = test2;
		lists[3] = test3;
		lists[4] = test4;
		lists[5] = test5;
		ListNode Ans = mergeKLists(lists);
		while (Ans != null) {
			System.out.println(Ans.val);
			Ans = Ans.next;
		}
		System.out.println("test");
	}

	public static ListNode insert(ListNode add, int data) {
		if (add.next == null) {
			add.next = new ListNode(data);
		}
		return add.next;
	}

	public static ListNode mergeKLists(ListNode[] lists) {
		int l = lists.length;

		if (lists == null || l == 0)
			return null;
		if (l == 1)
			return lists[0];

		while (l > 1) {
			int mid = (l + 1) / 2;
			for (int i = 0; i < l / 2; i++) {
				lists[i] = mergeTwoLists(lists[i], lists[i + mid]);
			}
			l = mid;
		}
		return lists[0];
	}

	public static ListNode mergeTwoLists(ListNode List1, ListNode List2) {
		if (List1 == null)
			return List2;
		if (List2 == null)
			return List1;

		ListNode newlist = new ListNode(0);
		ListNode head = newlist;

		while (List1 != null && List2 != null) {
			if (List1.val <= List2.val) {
				head.next = List1;
				head = head.next;
				List1 = List1.next;
			} else {
				head.next = List2;
				head = head.next;
				List2 = List2.next;
			}
		}
		if (List1 != null)
			head.next = List1;
		else
			head.next = List2;

		return newlist.next;
	}

}