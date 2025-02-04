package difficulty.medium;

import java.util.*;

/*
Implement the RandomizedSet class:

RandomizedSet() Initializes the RandomizedSet object.
bool insert(int val) Inserts an item val into the set if not present. Returns true if the item was not present, false otherwise.
bool remove(int val) Removes an item val from the set if present. Returns true if the item was present, false otherwise.
int getRandom() Returns a random element from the current set of elements (it's guaranteed that at least one element exists when this method is called). Each element must have the same probability of being returned.
You must implement the functions of the class such that each function works in average O(1) time complexity.



Example 1:
Input
["RandomizedSet", "insert", "remove", "insert", "getRandom", "remove", "insert", "getRandom"]
[[], [1], [2], [2], [], [1], [2], []]
Output
[null, true, false, true, 2, true, false, 2]

Explanation
RandomizedSet randomizedSet = new RandomizedSet();
randomizedSet.insert(1); // Inserts 1 to the set. Returns true as 1 was inserted successfully.
randomizedSet.remove(2); // Returns false as 2 does not exist in the set.
randomizedSet.insert(2); // Inserts 2 to the set, returns true. Set now contains [1,2].
randomizedSet.getRandom(); // getRandom() should return either 1 or 2 randomly.
randomizedSet.remove(1); // Removes 1 from the set, returns true. Set now contains [2].
randomizedSet.insert(2); // 2 was already in the set, so return false.
randomizedSet.getRandom(); // Since 2 is the only number in the set, getRandom() will always return 2.

 */
public class InsertDeleteGetRandom380 {
	private final List<Integer> list;
	private final Map<Integer, Integer> map;
	private final Random random;

	/*
	Так как в задаче сказано что средня сложность должна быть O(1), то тогда для операций вставки и удаления
	нет ничего лучше, чем Map (в Map операции добавлени и удаления за O(1))

	Но для метода получения рандомного элемента нужна другая структура, так как чтобы из Map получить список значений
	или список ключей потребуется метод toArray который в свою очередь имеет сложность O(n), что в нашей заде не приемлемо

	Поэтому пусть у нас будет List где будут хранится значения, а в Map ключами будут новые элементы, а значениями будут
	индексы по которым они лежат в List. Таким образом мы может сократить расходы на метод toArray, так как сами уже имеем его

	При добавлении нового элемента проверяем есть ли в Map такое значение (наш элемент - это ключ)
	Если есть, то по условию структуры Set мы не имеем права хранить дубли, поэтому возвращаем false
	Если нет, то добавляем в List наш элемент и добавляем в Map наш элемент (ключ) со значением индекса в List (всегда
	равно длине массива минус 1)

	При удалении элемента проверяем есть ли он в Map
	Если нет, то возвращаем false
	Если есть, то находим индекс по которому лежил элемент в List, после чего необходимо сохранить последний элемент в
	массиве, для того чтобы его передвинуть на найденный индекс (чтобы мы могли удалить из массива последний элемент -
	это операция пройдет за O(1), так как перестраивать массив не придется), заменяем у передвинутого ключа в Map на значение
	индекса по которому нужно сделать удаление, удаляем последний элемент в List и удаляем елемент в Map
	 */
	public InsertDeleteGetRandom380() {
		map = new HashMap<>();
		list = new ArrayList<>();
		random = new Random();
	}

	public boolean insert(int val) {
		if (map.containsKey(val)) {
			return false;
		}

		list.add(val);
		map.put(val, list.size() - 1);
		return true;
	}

	public boolean remove(int val) {
		if (!map.containsKey(val)) {
			return false;
		}

		var indexForRemove = map.get(val);
		var elementMustBeSaved = list.getLast();

		list.set(indexForRemove, elementMustBeSaved);
		map.put(elementMustBeSaved, indexForRemove);

		list.removeLast();
		map.remove(val);
		return true;
	}

	public int getRandom() {
		return list.get(random.nextInt(list.size()));
	}

}
