package erfan.handson.testing.springframework.properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.DynamicPropertyRegistrar;

@Configuration
class DynamicPropertySourceConfig {
    @Bean
    DynamicPropertyRegistrar redisPropertiesRegistrar() {
        return registry -> registry.add("redis.host", () -> "127.0.0.1");
    }
}
