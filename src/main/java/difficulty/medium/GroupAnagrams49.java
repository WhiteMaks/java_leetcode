package difficulty.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/*
Given an array of strings strs, group the
anagrams
 together. You can return the answer in any order.



Example 1:
Input: strs = ["eat","tea","tan","ate","nat","bat"]

Output: [["bat"],["nat","tan"],["ate","eat","tea"]]

Explanation:

There is no string in strs that can be rearranged to form "bat".
The strings "nat" and "tan" are anagrams as they can be rearranged to form each other.
The strings "ate", "eat", and "tea" are anagrams as they can be rearranged to form each other.

Example 2:
Input: strs = [""]

Output: [[""]]

Example 3:
Input: strs = ["a"]

Output: [["a"]]
 */
public class GroupAnagrams49 {

	/*
	Сортируем каждую строку и сохраняем в мапу по ключу сортированной строки и оригинал
	 */
	public List<List<String>> solution(String[] strs) {
		var tempMap = new HashMap<String, List<String>>();
		for (var str : strs) {
			var chars = str.toCharArray();
			Arrays.sort(chars);
			var sortedString = new String(chars);

			if (!tempMap.containsKey(sortedString)) {
				tempMap.put(sortedString, new ArrayList<>());
			}
			tempMap.get(sortedString).add(str);
		}

		return new ArrayList<>(tempMap.values());
	}

}
