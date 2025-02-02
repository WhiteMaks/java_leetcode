package difficulty.medium;

import java.util.HashMap;
import java.util.Map;

/*
Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.

Implement the LRUCache class:

LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
int get(int key) Return the value of the key if the key exists, otherwise return -1.
void put(int key, int value) Update the value of the key if the key exists. Otherwise, add the key-value pair to the cache. If the number of keys exceeds the capacity from this operation, evict the least recently used key.
The functions get and put must each run in O(1) average time complexity.



Example 1:
Input
["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
[[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
Output
[null, null, null, 1, null, -1, null, -1, 3, 4]

Explanation
LRUCache lRUCache = new LRUCache(2);
lRUCache.put(1, 1); // cache is {1=1}
lRUCache.put(2, 2); // cache is {1=1, 2=2}
lRUCache.get(1);    // return 1
lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
lRUCache.get(2);    // returns -1 (not found)
lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
lRUCache.get(1);    // return -1 (not found)
lRUCache.get(3);    // return 3
lRUCache.get(4);    // return 4

 */
public class LRUCache146 {
	private final int capacity;
	private final Map<Integer, ListNode> cache;
	private final ListNode head;
	private final ListNode tail;

	public LRUCache146(int capacity) {
		this.capacity = capacity;

		cache = new HashMap<>(capacity);

		head = new ListNode();
		tail = new ListNode();

		head.next = tail;
		tail.previous = head;
	}

	public int get(int key) {
		var result = -1;
		if (cache.containsKey(key)) {
			var resultListNode = cache.get(key);
			result = resultListNode.value;

			removeNode(resultListNode);
			addNodeInHead(resultListNode);
		}
		return result;
	}

	public void put(int key, int value) {
		if (cache.containsKey(key)) {
			var resultNode = cache.get(key);
			resultNode.value = value;
			removeNode(resultNode);
			addNodeInHead(resultNode);
			cache.put(key, resultNode);
			return;
		}

		if (cache.size() == capacity) {
			cache.remove(tail.previous.key);
			removeNode(tail.previous);
		}

		var newNode = new ListNode();
		newNode.key = key;
		newNode.value = value;
		addNodeInHead(newNode);
		cache.put(key, newNode);
	}

	/*
	При добавлении нового элемента в начало двусвязного списка необходимо:
	1) У нового элемента выставляем что следующий элемент это первый
	2) У первого элемента выставляем что предыдущий элемент это новый
	3) Заменяем первый элемент на новый
	Было: [first, el2, el3, el4, last]
	Стало: [node, first, el2, el3, el4, last]
	 */
	private void addNodeInHead(ListNode node) {
		var next = head.next;

		node.next = next;
		node.previous = head;

		next.previous = node;

		head.next = node;
	}

	/*
	При добавлении удаления элемента из двусвязного списка необходимо:
	1) Получить данные у текущего нода (current) о его соседах (предыдущий елемент и следующий)
	2) Заменить ссылки так чтобы список забыл о существовании текущего нода:
		У предыдущего нода выставляем что следующий элемент будет тем кто лежит следующим у текущего
		У следующего нода выставляем что предыдущий элемент будет тем кто лежит предыдущим у текущего
		Таким образом мы из памяти удалаем информацию о текущем ноде:
		Было: [el1, el2, el3, prev, curr, next, el7, el8]
		Стало: [el1, el2, el3, prev, next, el7, el8]
	 */
	private void removeNode(ListNode node) {
		var previous = node.previous;
		var next = node.next;

		previous.next = next;
		next.previous = previous;
	}

	/*
	ListNode двусвязный список с возможностью получения следующего элемента и предыдущего
 	*/
	public static class ListNode {
		public int key;
		public int value;
		private ListNode next;
		private ListNode previous;
	}
}
