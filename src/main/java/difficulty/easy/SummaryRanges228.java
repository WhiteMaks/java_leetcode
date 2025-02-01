package difficulty.easy;

import java.util.ArrayList;
import java.util.List;

/*
You are given a sorted unique integer array nums.

A range [a,b] is the set of all integers from a to b (inclusive).

Return the smallest sorted list of ranges that cover all the numbers in the array exactly. That is, each element of nums is covered by exactly one of the ranges, and there is no integer x such that x is in one of the ranges but not in nums.

Each range [a,b] in the list should be output as:

"a->b" if a != b
"a" if a == b

Example 1:
Input: nums = [0,1,2,4,5,7]
Output: ["0->2","4->5","7"]
Explanation: The ranges are:
[0,2] --> "0->2"
[4,5] --> "4->5"
[7,7] --> "7"

Example 2:
Input: nums = [0,2,3,4,6,8,9]
Output: ["0","2->4","6","8->9"]
Explanation: The ranges are:
[0,0] --> "0"
[2,4] --> "2->4"
[6,6] --> "6"
[8,9] --> "8->9"
 */
public class SummaryRanges228 {

	/*
	проверяем если текущее значение числа не равно предыдущему плюс 1 (произошел разрыв),
	то сохраняем данные для получения информации по диапазону
	 */
	public List<String> solution(int[] nums) {
		var result = new ArrayList<String>();

		if (nums == null || nums.length == 0) {
			return result;
		}

		var tempNum = nums[0];
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] != nums[i - 1] + 1) {
				result.add(formatRange(tempNum, nums[i - 1]));
				tempNum = nums[i];
			}
		}

		result.add(formatRange(tempNum, nums[nums.length - 1]));

		return result;
	}

	private String formatRange(int start, int end) {
		return start == end ? String.valueOf(start) : start + "->" + end;
	}

}
