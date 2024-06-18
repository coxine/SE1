import java.util.ArrayList;
import java.util.List;

public class ReOrderArray {

	/**
	 * 将所有的奇数位于数组的前半部分，所有的偶数位于位于数组的后半部分。
	 * 需要保证奇数和奇数，偶数和偶数之间的相对位置不变。
	 * 
	 * @param array
	 * @return
	 */
	public int[] reOrder(int[] array) {
		List<Integer> odd = new ArrayList<>();
		List<Integer> even = new ArrayList<>();
		for (int i : array) {
			if (i % 2 == 0) {
				even.add(i);
			} else {
				odd.add(i);
			}
		}
		odd.addAll(even);
		return odd.stream().mapToInt(i -> i).toArray();
	}
}
