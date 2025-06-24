import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class UserIntegrationTest {

    private UserService userService;
    private UserRepository mockRepo;

    @Before
    public void setup() {
        mockRepo = mock(UserRepository.class);
        userService = new UserService(mockRepo);
    }

    @Test
    public void testGetUserById() {
        User mockUser = new User(1L, "Anwesha");
        when(mockRepo.findById(1L)).thenReturn(mockUser); // Not Optional here

        User result = userService.getUserById(1L);
        assertNotNull(result);
        assertEquals("Anwesha", result.getName());
        assertEquals(Long.valueOf(1), result.getId());
    }
}
