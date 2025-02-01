package difficulty.easy;

/*
Given the head of a singly linked list, reverse the list, and return the reversed list.

Example 1:
Input: head = [1,2,3,4,5]
Output: [5,4,3,2,1]

Example 2:
Input: head = [1,2]
Output: [2,1]

Example 3:
Input: head = []
Output: []
 */
public class ReverseLinkedList206 {

	/*
	head = [1, 2, 3] (знаечние 1)
	result = null

	пока head != null

	итерация 1
	result = [1] (значение 1)
	head = [1, 2, 3] (значение 2)

	итерация 2
	result = [2, 1] (значение 2)
	head = [1, 2, 3] (значение 3)

	итерация 3
	result = [3, 2, 1] (значение 3)
	head = [1, 2, 3] (значение null)
	 */
	public ListNode solution(ListNode head) {
		ListNode result = null;

		while (head != null) {
			result = new ListNode(head.val, result);
			head = head.next;
		}

		return result;
	}

	public class ListNode {
		int val;
		ListNode next;

		ListNode() {
		}

		ListNode(int val) {
			this.val = val;
		}

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}
}
