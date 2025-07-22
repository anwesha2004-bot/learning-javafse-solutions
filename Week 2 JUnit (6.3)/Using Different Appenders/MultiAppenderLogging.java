import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MultiAppenderLogging {
    private static final Logger logger = LoggerFactory.getLogger(MultiAppenderLogging.class);

    public static void main(String[] args) {
        logger.info("This message should appear in both console and file.");
        logger.warn("Warning: Check both console and app.log.");
        logger.error("Error occurred. This should be logged in both places.");
    }
}
