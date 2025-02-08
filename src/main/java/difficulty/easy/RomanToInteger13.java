package difficulty.easy;

import java.util.HashMap;

/*
Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.

Symbol       Value
I             1
V             5
X             10
L             50
C             100
D             500
M             1000
For example, 2 is written as II in Roman numeral, just two ones added together. 12 is written as XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.

Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:

I can be placed before V (5) and X (10) to make 4 and 9.
X can be placed before L (50) and C (100) to make 40 and 90.
C can be placed before D (500) and M (1000) to make 400 and 900.
Given a roman numeral, convert it to an integer.
 */
public class RomanToInteger13 {

	/*
	Первый символ сразу сохраянем в результат, дальше в цикле идем с 1 индекса
	Преобразуем в число и прибавляем к результату
	Если предыдующее значение меньше текущего, значит необходимо вычисть из текущего и обновить результат, но так как
	мы уже прибавляли значение раньше, то вычисть придеться два раза

	Получается что если строка = MCMXCIV
	result = 1000

	1 шаг
	result = 1000 + 100

	2 шаг
	result = 1100 + 1000
	result = 2100 - (100 * 2)

	3 шаг
	result = 1900 + 10

	4 шаг
	result = 1910 + 100
	result = 2010 - (10 * 2)

	5 шаг
	result = 1990 + 1

	6 шаг
	result = 1991 + 5
	result = 1996 - (1 * 2)

	Итог
	result = 1994
	 */
	public int solution(String s) {
		var result = 0;

		var map = new HashMap<Character, Integer>();
		map.put('I', 1);
		map.put('V', 5);
		map.put('X', 10);
		map.put('L', 50);
		map.put('C', 100);
		map.put('D', 500);
		map.put('M', 1000);

		result += map.get(s.charAt(0));

		for (int i = 1; i < s.length(); i++) {
			var previousValue = map.get(s.charAt(i - 1));
			var currentValue = map.get(s.charAt(i));

			result += currentValue;

			if (previousValue < currentValue) {
				result -= previousValue * 2;
			}
		}

		return result;
	}

}
