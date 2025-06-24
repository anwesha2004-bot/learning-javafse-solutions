import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ParameterizedLoggingExample {
    private static final Logger logger = LoggerFactory.getLogger(ParameterizedLoggingExample.class);

    public static void main(String[] args) {
        String username = "Anwesha";
        int age = 21;

        logger.info("User {} has logged in.", username);
        logger.warn("User {} is {} years old and accessed a restricted section.", username, age);
        logger.error("An error occurred while processing request for user: {}", username);
    }
}
