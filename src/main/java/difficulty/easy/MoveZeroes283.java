package difficulty.easy;

/*
Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.

Note that you must do this in-place without making a copy of the array.



Example 1:
Input: nums = [0,1,0,3,12]
Output: [1,3,12,0,0]

Example 2:
Input: nums = [0]
Output: [0]
 */
public class MoveZeroes283 {

	/*
	Считаем сколько не нулевых элементов в массиве, а так же сразу же переставлем их вперед
	После чего все оставшиеся элементы зануляем
	 */
	public void solution(int[] nums) {
		int nonZeroCount = 0;

		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != 0) {
				nums[nonZeroCount] = nums[i];
				nonZeroCount++;
			}
		}

		for (int i = nonZeroCount; i < nums.length; i++) {
			nums[i] = 0;
		}
	}

}
