import static org.mockito.Mockito.*;
import org.junit.Test;
import org.mockito.InOrder;

public class MyServiceTest {

    @Test
    public void testInteractionOrder() {
        ExternalApi mockApi = mock(ExternalApi.class);
        MyService service = new MyService(mockApi);

        service.sendWorkflow();

        // ✅ Verify order
        InOrder inOrder = inOrder(mockApi);
        inOrder.verify(mockApi).connect();
        inOrder.verify(mockApi).sendData("Important Data");
        inOrder.verify(mockApi).disconnect();
    }
}
