import org.junit.Test;

public class PerformanceTesterTest {

    @Test(timeout = 1000) // Test must complete in under 1000ms (1 second)
    public void testPerformance() {
        PerformanceTester tester = new PerformanceTester();
        tester.performTask(); // Should pass (takes 500ms)
    }
}
