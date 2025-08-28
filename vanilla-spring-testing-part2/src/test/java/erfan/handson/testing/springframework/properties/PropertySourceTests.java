package erfan.handson.testing.springframework.properties;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig(classes = DynamicPropertySourceConfig.class)
@TestPropertySource(locations = "classpath:test.properties")
class PropertySourceTests {
    @Autowired
    Environment environment;

    @Value("${redis.host}")
    String redisHost;

    @Test
    void testPropertySource() {
        System.out.println(redisHost);
        System.out.println(environment.getProperty("redis.host"));
    }

    @DynamicPropertySource
    static void redisProperties(DynamicPropertyRegistry registry) {
        registry.add("redis.host", () -> "127.0.0.1");
        registry.add("redis.port", () -> "8085");
    }
}
