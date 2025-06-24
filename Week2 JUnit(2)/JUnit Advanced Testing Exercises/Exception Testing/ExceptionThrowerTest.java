import org.junit.Test;

public class ExceptionThrowerTest {

    @Test(expected = IllegalArgumentException.class)
    public void testThrowsExceptionForNullInput() {
        ExceptionThrower et = new ExceptionThrower();
        et.throwException(null);
    }

    @Test
    public void testDoesNotThrowExceptionForValidInput() {
        ExceptionThrower et = new ExceptionThrower();
        et.throwException("Hello"); // Should not throw any exception
    }
}
