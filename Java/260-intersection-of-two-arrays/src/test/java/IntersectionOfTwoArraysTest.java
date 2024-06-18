import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class IntersectionOfTwoArraysTest {

	@Test
	public void testSingle1() {
		assertArrayEquals(new int[]{2}, IntersectionOfTwoArrays.intersection(new int[]{1,2,2,1}, new int[]{2,2}));
	}

	@Test
	public void testSingle2() {
		assertArrayEquals(new int[]{2,3}, IntersectionOfTwoArrays.intersection(new int[]{1,2,2,3,1}, new int[]{2,2,3,3}));
	}

	@Test
	public void testSingle3() {
		assertArrayEquals(new int[]{1,2}, IntersectionOfTwoArrays.intersection(new int[]{1,2}, new int[]{2,1}));
	}

}