
import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ReOrderArrayTest {

	ReOrderArray reorderarray;

	@Before
	public void setUp() throws Exception {
		reorderarray = new ReOrderArray();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testReplaceStringSpace1() {
		int[] array = { 2, 3, 6, 8, 5, 9, 23 };
		int[] result = reorderarray.reOrder(array);
		int[] compare = { 3, 5, 9, 23, 2, 6, 8 };
		assertEquals(Arrays.toString(result), Arrays.toString(compare));
	}

	@Test
	public void testReplaceStringSpace2() {
		int[] array = { 1, 2, 3, 4, 5, 6 };
		int[] result = reorderarray.reOrder(array);
		int[] compare = { 1, 3, 5, 2, 4, 6 };
		assertEquals(Arrays.toString(result), Arrays.toString(compare));
	}

	@Test
	public void testReplaceStringSpace3() {
		int[] array = { 1, 3, 5, 7 };
		int[] result = reorderarray.reOrder(array);
		int[] compare = { 1, 3, 5, 7 };
		assertEquals(Arrays.toString(result), Arrays.toString(compare));
	}

	@Test
	public void testReplaceStringSpace4() {
		int[] array = { 2, 4, 8, 6 };
		int[] result = reorderarray.reOrder(array);
		int[] compare = { 2, 4, 8, 6 };
		assertEquals(Arrays.toString(result), Arrays.toString(compare));
	}

}
