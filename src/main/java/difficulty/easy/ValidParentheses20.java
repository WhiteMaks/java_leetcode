package difficulty.easy;

import java.util.Stack;

/*
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Every close bracket has a corresponding open bracket of the same type.


Example 1:
Input: s = "()"
Output: true

Example 2:
Input: s = "()[]{}"
Output: true

Example 3:
Input: s = "(]"
Output: false

Example 4:
Input: s = "([])"
Output: true
 */
public class ValidParentheses20 {

	/*
	Если это открывающаяся скобочка то в стэк добавляем её

	Если это закрывающая то из стека берем верхний элемент и если это скобочка не нашего типа то значит закрытие не верное

	В итоге в стэке не должно быть больше записей после проверки всех элементов
	 */
	public boolean solution(String s) {
		var stack = new Stack<Character>();

		for (var i = 0; i < s.length(); i++) {
			var bracketChar = s.charAt(i);

			if (
				bracketChar == '('
					|| bracketChar == '{'
					|| bracketChar == '['
			) {
				stack.push(bracketChar);
				continue;
			}

			if (stack.isEmpty()) {
				return false;
			}

			var openBracket = stack.pop();

			if (bracketChar == ')' && openBracket != '(') {
				return false;
			}

			if (bracketChar == ']' && openBracket != '[') {
				return false;
			}

			if (bracketChar == '}' && openBracket != '{') {
				return false;
			}
		}

		return stack.isEmpty();
	}

}
