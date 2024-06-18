import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class IsSubsequenceTest {

	@Test
	public void testSingle1() {
		assertEquals(true, IsSubsequence.isSubsequence("abc", "ahbgdc"));
	}

	@Test
	public void testSingle2() {
		assertEquals(false, IsSubsequence.isSubsequence("acb", "ahbgdc"));
	}

	@Test
	public void testSingle3() {
		assertEquals(false, IsSubsequence.isSubsequence("axc", "ahbgdc"));
	}
	
}