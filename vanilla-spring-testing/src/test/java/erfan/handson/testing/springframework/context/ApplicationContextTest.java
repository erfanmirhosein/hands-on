package erfan.handson.testing.springframework.context;

import erfan.handson.testing.springframework.bean.AppConfiguration;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ActiveProfiles("erfan")
class ApplicationContextTest {
    @Autowired
    AppConfiguration appConfiguration;
    @Autowired
    TestConfig testConfig;

    @Test
    void assetContextLoaded() {
        Assertions.assertNotNull(testConfig);
        Assertions.assertEquals(AppConfiguration.class, appConfiguration.getClass());
    }

    @Configuration
    static class TestConfig {
        @Bean
        @Profile("erfan")
        AppConfiguration appConfig() {
            return new AppConfiguration();
        }
    }

}
