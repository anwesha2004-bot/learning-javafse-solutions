import static org.mockito.Mockito.*;
import static org.mockito.ArgumentMatchers.*;

import org.junit.Test;

public class MyServiceTest {

    @Test
    public void testArgumentMatcher() {
        ExternalApi mockApi = mock(ExternalApi.class);
        MyService service = new MyService(mockApi);

        service.sendMessage("Any input string");

        verify(mockApi).sendData(anyString());
    }
}
