import static org.mockito.Mockito.*;
import org.junit.Test;

public class MyServiceTest {

    @Test
    public void testMultipleReturns() {
        ExternalApi mockApi = mock(ExternalApi.class);

        // Stub: Return different values on each call
        when(mockApi.getData())
                .thenReturn("First call")
                .thenReturn("Second call")
                .thenReturn("Final call");

        MyService service = new MyService(mockApi);
        service.callMultipleTimes(); // Should print the 3 different returns

        // Verify it was called 3 times
        verify(mockApi, times(3)).getData();
    }
}
