import org.junit.Test;
import static org.junit.Assert.*;

public class GreetingTest {

    @Test
    public void testMorning() {
        Greeting g = new Greeting();
        assertEquals("Good morning!", g.morning());
    }

    @Test
    public void testNight() {
        Greeting g = new Greeting();
        assertEquals("Good night!", g.night());
    }
}
