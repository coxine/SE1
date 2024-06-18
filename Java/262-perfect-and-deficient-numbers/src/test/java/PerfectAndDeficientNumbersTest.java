import static org.junit.Assert.*;

public class PerfectAndDeficientNumbersTest {

    @org.junit.Test
    public void isPerfect1() {
        assertEquals(true,PerfectAndDeficientNumbers.isPerfect(6));
    }

    @org.junit.Test
    public void isPerfect2() {
        assertEquals(false,PerfectAndDeficientNumbers.isPerfect(10));
    }

    @org.junit.Test
    public void isPerfect3() {
        assertEquals(true,PerfectAndDeficientNumbers.isPerfect(28));
    }



    @org.junit.Test
    public void isDeficient1() {
        assertEquals(true,PerfectAndDeficientNumbers.isDeficient(3));
    }
    @org.junit.Test
    public void isDeficient2() {
        assertEquals(true,PerfectAndDeficientNumbers.isDeficient(2));
    }
    @org.junit.Test
    public void isDeficient3() {
        assertEquals(true,PerfectAndDeficientNumbers.isDeficient(10));
    }

}