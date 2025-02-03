package difficulty.medium;

/*
Given a binary array nums, you should delete one element from it.

Return the size of the longest non-empty subarray containing only 1's in the resulting array. Return 0 if there is no such subarray.



Example 1:
Input: nums = [1,1,0,1]
Output: 3
Explanation: After deleting the number in position 2, [1,1,1] contains 3 numbers with value of 1's.

Example 2:
Input: nums = [0,1,1,1,0,1,1,0,1]
Output: 5
Explanation: After deleting the number in position 4, [0,1,1,1,1,1,0,1] longest subarray with value of 1's is [1,1,1,1,1].

Example 3:
Input: nums = [1,1,1]
Output: 2
Explanation: You must delete one element.
 */
public class LongestSubarrayOf1AfterDeletingOneElement1493 {

	/*
	Если элемент в массиве не равно 0, то инкрементим счетчик идем на следующий элемент

	Если нашли 0, то дальше инкременим счетчик если следующий элемент не равен 0

	записываем максимальный результат между записанным результатом и счетчиком, после чего счетчит обнуляем, таким
	образом мы проверим все возможное исходы

	При этом если счетчик равен числу элементов, то вычитаем 1, так как по условию мы обязаны удалить 1 элемент
	 */
	public int solution(int[] nums) {
		var result = 0;

		var counter = 0;
		for (var i = 0; i < nums.length; i++) {
			if (nums[i] != 0) {
				counter++;
				continue;
			}

			for (var j = i + 1; j < nums.length; j++) {
				if (nums[j] == 0) {
					break;
				}

				counter++;
			}

			result = Math.max(result, counter);

			counter = 0;
		}

		if (counter == nums.length) {
			result = nums.length - 1;
		}

		return result;
	}

}
