import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class IntersectionOfTwoArrays {

	public static int[] intersection(int[] nums1, int[] nums2) {
		List<Integer> list1 = Arrays.stream(nums1).boxed().collect(Collectors.toList());
		List<Integer> list2 = Arrays.stream(nums2).boxed().collect(Collectors.toList());
		List<Integer> result = list1.stream().distinct().filter(list2::contains).collect(Collectors.toList());
		return result.stream().mapToInt(i -> i).toArray();
	}
}
