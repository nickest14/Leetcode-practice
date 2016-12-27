
class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}

public class Solution {
	static int G;
	static int count;
	public static void main(String args[]) {
		
		int n = 4;

		ListNode test = new ListNode(0);
		ListNode temp = test;
		for (int i = 1; i < 4; i++)
			temp = insert(temp, i);

		ListNode Ans = removeNthFromEnd(test, n);
		System.out.println(Ans);
	}

	public static ListNode insert(ListNode add, int data) {
		if (add.next == null) {
			add.next = new ListNode(data);
		}
		return add.next;
	}

	public static ListNode removeNthFromEnd(ListNode head, int n) {
		if(head.next == null){
			head = null;
			return head;
		}
		G = n;
		 count = 1;
		boolean tail = false;
		ListNode temp = head;
		if( !tail && temp.next == null){
			tail = true;
			return temp;
		}
		removeNthFromEnd( temp.next, n);
		if( G == 1 ){
				head.next = head.next.next;
		}
		G--;
		count++;
		if(G == 1 && count == n)
			head = head.next;
		return head;
	}
}
