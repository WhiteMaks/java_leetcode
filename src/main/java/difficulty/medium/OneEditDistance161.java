package difficulty.medium;

/*
Given two strings s and t, determine if they are both one edit distance apart.

Note:

There are 3 possibilities to satisfy one edit distance apart:

Insert a character into s to get t
Delete a character from s to get t
Replace a character of s to get t

Example 1:
Input: s = "ab", t = "acb"
Output: true
Explanation: We can insert 'c' into s to get t.

Example 2:
Input: s = "cab", t = "ad"
Output: false
Explanation: We cannot get t from s by only one step.

Example 3:
Input: s = "1203", t = "1213"
Output: true
Explanation: We can replace '0' with '1' to get t.
 */
public class OneEditDistance161 {

	/*
	Вначале стоит проверить что у строк максимальное отличие между длинами не болельше единицы, в противном случае
	нет смыла проверять дальше так как у нас только 1 попытка изменения строки

	Дальше сравниваем посимвольно строки, если символы отличаются то пытаемся сделать замену, удаление или вставку
	в зависимость от длины строки s
	 */
	public boolean solution(String s, String t) {
		var sLength = s.length();
		var tLength = t.length();

		if (Math.abs(sLength - tLength) > 1) {
			return false;
		}

		for (int i = 0; i < Math.min(sLength, tLength); i++) {
			var sChar = s.charAt(i);
			var tChar = t.charAt(i);

			if (sChar == tChar) {
				continue;
			}

			if (sLength == tLength) {
				return s.substring(i + 1).equals(t.substring(i + 1));
			}

			if (sLength > tLength) {
				return s.substring(i + 1).equals(t.substring(i));
			}

			return s.substring(i).equals(t.substring(i + 1));
		}

		return true;
	}
}
