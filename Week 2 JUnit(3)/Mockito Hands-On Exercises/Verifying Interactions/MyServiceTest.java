import static org.mockito.Mockito.*;
import org.junit.Test;

public class MyServiceTest {

    @Test
    public void testVerifyInteraction() {
        ExternalApi mockApi = mock(ExternalApi.class);
        MyService service = new MyService(mockApi);

        service.fetchData(); // no-arg method
        verify(mockApi).getData(); // verify call with no arguments
    }

    @Test
    public void testVerifyWithArgument() {
        ExternalApi mockApi = mock(ExternalApi.class);
        MyService service = new MyService(mockApi);

        service.sendMessage("Hello World"); // send message
        verify(mockApi).sendData("Hello World"); // verify it was called with that exact argument
    }
}
