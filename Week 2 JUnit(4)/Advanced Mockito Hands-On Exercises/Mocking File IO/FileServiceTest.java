import static org.mockito.Mockito.*;
import org.junit.Test;
import static org.junit.Assert.*;

public class FileServiceTest {

    @Test
    public void testServiceWithMockFileIO() {
        FileReader mockFileReader = mock(FileReader.class);
        FileWriter mockFileWriter = mock(FileWriter.class);

        when(mockFileReader.read()).thenReturn("Mock File Content");

        FileService fileService = new FileService(mockFileReader, mockFileWriter);
        String result = fileService.processFile();

        assertEquals("Processed Mock File Content", result);

        // Optional: Verify that write() was called with correct content
        verify(mockFileWriter).write("Processed Mock File Content");
    }
}
