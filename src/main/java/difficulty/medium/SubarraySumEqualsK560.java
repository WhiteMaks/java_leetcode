package difficulty.medium;

import java.util.HashMap;

/*
Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.

A subarray is a contiguous non-empty sequence of elements within an array.



Example 1:
Input: nums = [1,1,1], k = 2
Output: 2

Example 2:
Input: nums = [1,2,3], k = 3
Output: 2

 */
public class SubarraySumEqualsK560 {

	public int solution(int[] nums, int k) {
		var result = 0;

		var map = new HashMap<Integer, Integer>();
		map.put(0, 1);

		var sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];

			var numNeed = sum - k;
			if (map.containsKey(numNeed)) {
				result += map.get(numNeed);
			}

			map.put(sum, map.getOrDefault(sum,0) + 1);
		}

		return result;
	}

}
