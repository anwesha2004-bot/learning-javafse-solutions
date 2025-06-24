import static org.mockito.Mockito.*;
import org.junit.Test;

public class MyServiceTest {

    @Test
    public void testVoidMethodInteraction() {
        ExternalApi mockApi = mock(ExternalApi.class);

        // Optional: Stub the void method (only needed if it throws or logs)
        doNothing().when(mockApi).sendData(anyString());

        MyService service = new MyService(mockApi);
        service.sendMessage("Test message");

        // Verify that the void method was called with the expected argument
        verify(mockApi).sendData("Test message");
    }
}
