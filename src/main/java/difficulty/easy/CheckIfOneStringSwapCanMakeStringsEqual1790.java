package difficulty.easy;

/*
You are given two strings s1 and s2 of equal length. A string swap is an operation where you choose two indices in a string (not necessarily different) and swap the characters at these indices.

Return true if it is possible to make both strings equal by performing at most one string swap on exactly one of the strings. Otherwise, return false.



Example 1:
Input: s1 = "bank", s2 = "kanb"
Output: true
Explanation: For example, swap the first character with the last character of s2 to make "bank".

Example 2:
Input: s1 = "attack", s2 = "defend"
Output: false
Explanation: It is impossible to make them equal with one string swap.

Example 3:
Input: s1 = "kelb", s2 = "kelb"
Output: true
Explanation: The two strings are already equal, so no string swap operation is required.
 */
public class CheckIfOneStringSwapCanMakeStringsEqual1790 {

	/*
	Посимвольно сравниваем строки, считаем количество разных символов и сохраняем их индексы в массив

	Если у нас колличество поторяющихся символов равно 2 и приэтом мы наткнулись на еще одно не соответствие, то
	возвращаем false так как мы можем сделать только одну замену между два символами

	Если количество разных символов равно 1, то его нескем менять местами, возвращаем false

	Сравниваем заменяемый символ в первой строки со вторым символом во второй строке (должны быть равны) и тоже самое
	наоборот сравниваем заменяемый символ во второй строке со вторым символом в первой строке (должны быть равны)
	 */
	public boolean solution(String s1, String s2) {
		var indexesForSwap = new int[2];

		var countDifferentChars = 0;
		for (int i = 0; i < s2.length(); i++) {
			if (s1.charAt(i) == s2.charAt(i)) {
				continue;
			}

			if (countDifferentChars == 2) {
				return false;
			}

			indexesForSwap[countDifferentChars] = i;
			countDifferentChars++;
		}

		if (countDifferentChars == 1) {
			return false;
		}

		return s1.charAt(indexesForSwap[0]) == s2.charAt(indexesForSwap[1]) && s1.charAt(indexesForSwap[1]) == s2.charAt(indexesForSwap[0]);
	}

}
