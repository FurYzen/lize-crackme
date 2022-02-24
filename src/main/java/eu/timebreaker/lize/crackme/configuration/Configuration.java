package eu.timebreaker.lize.crackme.configuration;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import eu.timebreaker.lize.crackme.check.CheckType;
import lombok.Getter;

import java.io.File;
import java.io.IOException;

public class Configuration {
    @Getter
    @JsonProperty("debugMode") private boolean debugMode;

    @Getter
    @JsonProperty("checkType") private CheckType checkType;

    public static Configuration parseConfiguration(File configFile) throws IOException {
        final ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        return mapper.readValue(configFile, Configuration.class);
    }
}
