import static org.mockito.Mockito.*;
import org.junit.Test; // ✅ JUnit 4 import
import static org.junit.Assert.*; // ✅ JUnit 4 assertions

public class ServiceTest {

    @Test
    public void testServiceWithMockRepository() {
        Repository mockRepository = mock(Repository.class);
        when(mockRepository.getData()).thenReturn("Mock Data");

        Service service = new Service(mockRepository);
        String result = service.processData();

        assertEquals("Processed Mock Data", result);
    }
}
