package difficulty.medium;

import java.util.HashSet;

/*
Given n points on a 2D plane, find if there is such a line parallel to y-axis that reflect the given points.

Example 1: Given points = [[1,1],[-1,1]], return true.
Example 2: Given points = [[1,1],[-1,-1]], return false.
 */
public class LineReflection356 {

	/*
	ось симетрии (xSym) равно средней арифметической между двумя точками ((x1 + x2)/2)
	xSym = (x1 + x2)/2
	в нашем случае есть более чем две точки и нужно найти одну ось симетрии для этих точек
	поэтому ищем минимум и максимум X, вычисляем ось симетрии для них
	проверяем каждую точку на то что для неё есть симетричная в исходном массиве
	для этого стоит преобразовать входные данные в массив который будет содержать строку (x,y)
	в нашем случае для проверки содержания симетричной точки лучшим способо будет вместо массива использовать Set<String>
	в котором будет храниться строка (x,y)
	допустим мы хотим найти x1
	тогда x1=2xSym - x2
	 */
	public boolean solution(int[][] points) {
		var minX = Integer.MAX_VALUE;
		var maxX = Integer.MIN_VALUE;

		//поиск минимума и максимума
		for (var point : points) {
			var x = point[0];

			minX = Math.min(minX, x);
			maxX = Math.max(maxX, x);
		}

		var pointSet = new HashSet<String>();

		//преобразование к упрощенному виду
		for (int[] point : points) {
			var x = point[0];
			var y = point[1];

			pointSet.add(String.format("(%d,%d)", x, y));
		}

		var doubleXSym = minX + maxX;

		//если хотябы одной симетричной точки нет в списке, значит для массива точек нет симетричной линии
		for (var point : points) {
			var x = point[0];
			var y = point[1];

			var xSym = doubleXSym - x;

			if (!pointSet.contains(String.format("(%d,%d)", xSym, y))) {
				return false;
			}
		}

		return true;
	}

}
