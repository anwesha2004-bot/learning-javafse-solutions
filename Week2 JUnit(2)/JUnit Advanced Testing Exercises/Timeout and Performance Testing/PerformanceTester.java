public class PerformanceTester {
    public void performTask() {
        // Simulating some task that might take time
        try {
            Thread.sleep(500); // 500 ms
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
