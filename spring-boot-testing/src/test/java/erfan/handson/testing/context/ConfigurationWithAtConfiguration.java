package erfan.handson.testing.context;

import erfan.handson.testing.pojo.ToBeBeanInTestsUsingAtConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class ConfigurationWithAtConfiguration {
    @Bean
    public ToBeBeanInTestsUsingAtConfiguration testBeanUsingAtConfiguration() {
        return new ToBeBeanInTestsUsingAtConfiguration();
    }
}
