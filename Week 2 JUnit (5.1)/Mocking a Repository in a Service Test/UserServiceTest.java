import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.Optional;

public class UserServiceTest {

    @Test
    public void testGetUserById() {
        // Arrange
        UserRepository mockRepo = mock(UserRepository.class);
        User mockUser = new User(1L, "Anwesha");

        when(mockRepo.findById(1L)).thenReturn(Optional.of(mockUser));
        UserService userService = new UserService(mockRepo);

        // Act
        User result = userService.getUserById(1L);

        // Assert
        assertNotNull(result);
        assertEquals("Anwesha", result.getName());
        assertEquals(Long.valueOf(1L), result.getId());
    }
}
