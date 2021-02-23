package logs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Log {
    static {
        System.setProperty("logback.configurationFile", "resources/logback.xml");
    }

    private static Logger logger = null;

        public static Logger setName(String name) {
            logger = LoggerFactory.getLogger(String.format("%s", name)); //%s use for string (%1$s %2$s), %d -for digits
            return logger;
        }

        public static Logger getLogger() {
            if (logger != null) {
                return logger;
            } else {
                logger = setName("default test");
                return logger;
            }

        }

        public static void log(String message) {
            getLogger().info(message);
        }

        public static void log(String message, LogType type) {
            switch (type) {
                case INFO:
                    getLogger().info(message);
                    break;
                case ERROR:
                    getLogger().error(message);
                    break;
                case WARNING:
                    getLogger().warn(message);
                    break;
            }
        }
    }
