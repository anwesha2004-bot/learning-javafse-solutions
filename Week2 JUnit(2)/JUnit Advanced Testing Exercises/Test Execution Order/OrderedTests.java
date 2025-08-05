import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING) // Orders tests by method name
public class OrderedTests {

    @Test
    public void testA_first() {
        System.out.println("Running testA_first");
        assertTrue(true);
    }

    @Test
    public void testB_second() {
        System.out.println("Running testB_second");
        assertTrue(true);
    }

    @Test
    public void testC_third() {
        System.out.println("Running testC_third");
        assertTrue(true);
    }
}
