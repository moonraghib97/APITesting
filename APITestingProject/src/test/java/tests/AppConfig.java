package tests;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class AppConfig {

    private static final Properties properties = new Properties();

    static {
        try (InputStream inputStream = AppConfig.class
                .getClassLoader()
                .getResourceAsStream("config.properties")) {
            if (inputStream != null) {
                properties.load(inputStream);
            } else {
                throw new IOException("Unable to find config.properties");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getBaseUri() {
        return properties.getProperty("api_base_url");
    }

    public static String getRepoPath() {
        return properties.getProperty("repo_path");
    }

    public static String getOwner() {
        return properties.getProperty("owner");
    }

    public static String getRepoName() {
        return properties.getProperty("repo_name");
    }

    public static String getPetEndpoint() {
        return properties.getProperty("pet_endpoint");
    }
}
