package erfan.handson.testing.context;

import erfan.handson.testing.pojo.ToBeBeanInTestsUsingAtTestConfiguration;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

@TestConfiguration
class ConfigurationWithAtTestConfiguration {
    @Bean
    public ToBeBeanInTestsUsingAtTestConfiguration testBeanUsingAtTestConfiguration() {
        return new ToBeBeanInTestsUsingAtTestConfiguration();
    }
}
