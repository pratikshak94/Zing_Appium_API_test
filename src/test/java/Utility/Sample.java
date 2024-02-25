package Utility;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import java.io.IOException;

public class Sample {
    public static String setEnvVariable(String variable) throws IOException, ConfigurationException {
        PropertiesConfiguration config = new PropertiesConfiguration("./src/test/resources/config.properties");
        config.setProperty("token", variable);
        config.save();
        return variable;

    }
}

