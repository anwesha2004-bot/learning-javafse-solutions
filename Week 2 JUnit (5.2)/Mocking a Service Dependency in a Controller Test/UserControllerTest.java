import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class UserControllerTest {

    @Mock
    private UserService userService;

    @InjectMocks
    private UserController userController;

    public UserControllerTest() {
        MockitoAnnotations.openMocks(this); // Initialize mocks
    }

    @Test
    public void testGetUserById() {
        // Arrange
        Long userId = 1L;
        User mockUser = new User();
        mockUser.setId(userId);
        mockUser.setName("Anwesha");

        when(userService.getUserById(userId)).thenReturn(mockUser);

        // Act
        ResponseEntity<User> response = userController.getUser(userId);

        // Assert
        assertEquals(200, response.getStatusCodeValue());
        assertNotNull(response.getBody());
        assertEquals("Anwesha", response.getBody().getName());
    }
}
