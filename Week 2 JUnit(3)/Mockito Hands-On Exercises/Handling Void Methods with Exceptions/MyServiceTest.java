import static org.mockito.Mockito.*;
import org.junit.Test;

public class MyServiceTest {

    @Test
    public void testVoidMethodThrowsException() {
        ExternalApi mockApi = mock(ExternalApi.class);

        // ✅ Stub the void method to throw an exception
        doThrow(new RuntimeException("Simulated error"))
                .when(mockApi).sendData("fail");

        MyService service = new MyService(mockApi);
        service.safeSend("fail");

        // ✅ Still verify the interaction
        verify(mockApi).sendData("fail");
    }
}
