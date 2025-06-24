import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import org.junit.Test;

public class MyServiceTest {

    @Test
    public void testExternalApi() {
        ExternalApi mockApi = mock(ExternalApi.class); // Step 1: Create mock
        when(mockApi.getData()).thenReturn("Mock Data"); // Step 2: Stub method

        MyService service = new MyService(mockApi); // Step 3: Inject mock
        String result = service.fetchData(); // Step 4: Call real method

        assertEquals("Mock Data", result); // Step 5: Assert result
    }
}
