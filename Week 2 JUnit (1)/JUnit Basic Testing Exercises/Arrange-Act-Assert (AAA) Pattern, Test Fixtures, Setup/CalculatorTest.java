import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;

public class CalculatorTest {

    private Calculator calculator;

    @Before
    public void setUp() {
        calculator = new Calculator();
        System.out.println("Setup done.");
    }

    @After
    public void tearDown() {
        calculator.clearMemory();
        System.out.println("Teardown done.");
    }

    @Test
    public void testAdd() {

        int a = 3, b = 4;

        int result = calculator.add(a, b);

        assertEquals(7, result);
    }

    @Test
    public void testMultiply() {

        int a = 5, b = 6;

        int result = calculator.multiply(a, b);

        assertEquals(30, result);
    }
}
