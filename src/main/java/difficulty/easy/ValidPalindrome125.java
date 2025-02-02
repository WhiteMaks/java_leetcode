package difficulty.easy;

/*
A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.

Given a string s, return true if it is a palindrome, or false otherwise.



Example 1:
Input: s = "A man, a plan, a canal: Panama"
Output: true
Explanation: "amanaplanacanalpanama" is a palindrome.

Example 2:
Input: s = "race a car"
Output: false
Explanation: "raceacar" is not a palindrome.

Example 3:
Input: s = " "
Output: true
Explanation: s is an empty string "" after removing non-alphanumeric characters.
Since an empty string reads the same forward and backward, it is a palindrome.
 */
public class ValidPalindrome125 {

	/*
	Пока два указателя не сомкнуться проверяем символы на соответствие, при этом скипаем шлак в виде знаков
	 */
	public boolean solution(String s) {
		var lowerCaseString = s.toLowerCase();

		var leftIndex = 0;
		var rightIndex = lowerCaseString.length() - 1;
		while (leftIndex < rightIndex) {
			var leftChar = lowerCaseString.charAt(leftIndex);
			var rightChar = lowerCaseString.charAt(rightIndex);

			if (!Character.isLetterOrDigit(leftChar)) {
				leftIndex++;
				continue;
			}

			if (!Character.isLetterOrDigit(rightChar)) {
				rightIndex--;
				continue;
			}

			if (leftChar != rightChar) {
				return false;
			}

			leftIndex++;
			rightIndex--;
		}

		return true;
	}

}
