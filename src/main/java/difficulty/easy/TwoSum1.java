package difficulty.easy;

import java.util.HashMap;

/*
Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.



Example 1:
Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].

Example 2:
Input: nums = [3,2,4], target = 6
Output: [1,2]

Example 3:
Input: nums = [3,3], target = 6
Output: [0,1]

 */
public class TwoSum1 {

	/*
	перобразование массива в Map
	поиск в Map результата вычитания, если есть такая запись и индексы не равны друг другу то найдено соответствие
	 */
	public int[] solution(int[] nums, int target) {
		var numMap = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			numMap.put(nums[i], i);
		}

		for (int i = 0; i < nums.length; i++) {
			var numNeeded = target - nums[i];
			if (numMap.containsKey(numNeeded) && i != numMap.get(numNeeded)) {
				return new int[] {i, numMap.get(numNeeded)};
			}
		}

		return new int[0];
	}

}
