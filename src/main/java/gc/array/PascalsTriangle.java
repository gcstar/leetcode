package gc.array;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;


/**
 * @author gc
 */
public class PascalsTriangle {
	public List<List<Integer>> generate(int numRows) {
		List list = new ArrayList();
		if (numRows <= 0) {
			return list;
		}
		List<Integer> list1 = new ArrayList<Integer>();
		list1.add(1);
		List<Integer> list2 = new ArrayList<Integer>();
		list2.add(1);
		list2.add(1);
		if (numRows == 1) {
			list.add(list1);
			return list;
		} else if (numRows == 2) {
			list.add(list1);
			list.add(list2);
			return list;
		} else {
			list.add(list1);
			list.add(list2);
			for (int i = 3; i <= numRows; i++) {
				List<Integer> subList = new ArrayList<Integer>();
				for (int j = 0; j < i; j++) {
					if (j == 0 || j == i - 1) {
						subList.add(1);
					} else {
						List temp = (ArrayList<Integer>) list.get(i - 2);
						int value = ((Integer) temp.get(j))
								+ ((Integer) temp.get(j - 1));
						subList.add(value);
					}
				}
				list.add(subList);
			}
			return list;
		}
	}

	@Test
	public void PascalsTriangleTest() {
		List list = generate(10);
		for (int i = 0; i < list.size(); i++) {
			List<Integer> temp = (ArrayList<Integer>) list.get(i);
			for (int j = 0; j < temp.size(); j++) {
				int value = temp.get(j);
				System.out.print(value + " ");
			}
			System.out.println();
		}
	}
}
