package erfan.handson.testing.springframework.context;

import erfan.handson.testing.springframework.bean.AppConfiguration;
import erfan.handson.testing.springframework.bean.SomeComponent;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(SpringExtension.class)
@ActiveProfiles("erfan")
class ApplicationContextTest {
    @Autowired
    AppConfiguration appConfiguration;
    @Autowired
    TestConfig testConfig;
    @Autowired
    SomeComponent someComponent;

    @Test
    void assetContextLoaded() {
        assertNotNull(someComponent);
        assertNotNull(testConfig);
        assertNotNull(appConfiguration);
    }

    @Configuration
    @Import(SomeComponent.class)
    static class TestConfig {
        @Bean
        @Profile("erfan")
        AppConfiguration appConfig() {
            return new AppConfiguration();
        }
    }

}
