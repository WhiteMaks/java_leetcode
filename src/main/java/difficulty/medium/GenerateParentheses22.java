package difficulty.medium;

import java.util.ArrayList;
import java.util.List;

/*
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.



Example 1:
Input: n = 3
Output: ["((()))","(()())","(())()","()(())","()()()"]

Example 2:
Input: n = 1
Output: ["()"]
 */
public class GenerateParentheses22 {


	/*
	Закрывающая скобочка ")" не может быть добавлена если нет открывающей "(".
	Т.е. для генрации закрывающей ")" необходима открывающая "("
	Закрывающих скобочек ")" не может быть больше чем открывающих "("
	Открывающих скобочек "(" не может быть больше чем n.
	Графическое представление решения может выглядеть так:

	Первое что нужно сделать - это добавить первую открывающую скобочку, так как без открытых не существует закрытых
	Step: 1
	[ "(" ]

	На втором шаге может быть два решения, первое - закрыть открытую скобочку, второе добавить еще одну открывающую скобочку
	Step: 2
	[ "()" ]			[ "((" ]

	На третьем шаге можеть быть слудующие решения:
	Для решения "()" можно поставить только открывающую скобочку, так как закрывающих не может быть большу чем открытых,
	в нашем случае в "()" 1 открывающая и 1 закрывающая.
	Для решения "((" можно поставить закрывающую скобочку, а так же еще одну открывающую так как число открывающих скобочек
	еще не равно n
	Step: 3
	[ "()(" ]				[ "(()" ]			[ "(((" ]

	На четвертом шаге могуть быть следующие решения (по логике той же что в 3 шаге)
	Step: 4
	[ "()()" ]			[ "()((" ]				[ "(())" ]			[ "(()(" ]				[ "((()" ]

	Step: 5
	[ "()()(" ]				[ "()(()" ]				[ "(())(" ]				[ "(()()" ]				[ "((())" ]

	Step: 6
	[ "()()()" ]				[ "()(())" ]				[ "(())()" ]				[ "(()())" ]				[ "((()))" ]

	Шаг 6 это и есть результат наших решений. Полная визуализация шагов:
															[ "(" ]
							/																		\
						[ "()" ]																[ "((" ]
							|																	/	\
							|																/			\
							|															/					\
							|														/							\
							|													/									\
						[ "()(" ]											[ "(()" ]							[ "(((" ]
						/	\													/	\								|
					/			\											/			\							|
				/					\									/					\						|
			/							\							/							\					|
		[ "()()" ]					[ "()((" ]				[ "(())" ]						[ "(()(" ]			[ "((()" ]
			|							|						|								|					|
		[ "()()(" ]					[ "()(()" ]				[ "(())(" ]						[ "(()()" ]			[ "((())" ]
			|							|						|								|					|
		[ "()()()" ]				[ "()(())" ]			[ "(())()" ]					[ "(()())" ]		[ "((()))" ]

	 */
	public List<String> solution(int n) {
		var result = new ArrayList<String>();
		generateParenthesis(result, "", n, 0, 0);
		return result;
	}

	/*
	Метод для генерации оставшихся скобочек

	1) Если колличество скобочек умноженное на 2 (в строке должны быть как открытые так и закрытые скобочки) равно числу символов в строке,
		то значит пора сохранять результат и выходить из метода генерации
	2) Если колличество открытых скобочек больше чем закрытых, то закрываем скобочку и прибавляем к счетчику закрытых скобочек единицу
	3) Если колличество скобочек больше чем открытых, то открываем скобочку и прибавляем к счетчику открытых скобочек единицу
	 */
	public void generateParenthesis(List<String> result, String solution, int maxParentheses, int openParentheses, int closeParentheses) {
		if (maxParentheses * 2 == solution.length()) {
			result.add(solution);
			return;
		}

		if (openParentheses > closeParentheses) {
			generateParenthesis(result, solution.concat(")"), maxParentheses, openParentheses, closeParentheses + 1);
		}

		if (maxParentheses > openParentheses) {
			generateParenthesis(result, solution.concat("("), maxParentheses, openParentheses + 1, closeParentheses);
		}
	}

}
