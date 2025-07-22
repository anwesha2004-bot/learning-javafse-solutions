import static org.mockito.Mockito.*;
import org.junit.Test; // ✅ JUnit 4
import static org.junit.Assert.*; // ✅ JUnit 4 assertions

public class ApiServiceTest {

    @Test
    public void testServiceWithMockRestClient() {
        RestClient mockRestClient = mock(RestClient.class);
        when(mockRestClient.getResponse()).thenReturn("Mock Response");

        ApiService apiService = new ApiService(mockRestClient);
        String result = apiService.fetchData();

        assertEquals("Fetched Mock Response", result);
    }
}
