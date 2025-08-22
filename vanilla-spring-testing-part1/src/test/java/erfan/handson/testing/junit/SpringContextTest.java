package erfan.handson.testing.junit;

import erfan.handson.testing.DummyRepository;
import erfan.handson.testing.DummyService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
class SpringContextTest {
    @Autowired
    ApplicationContext context;

    @Test
    void assertThatContextHasBeenCreated() {
        Assertions.assertNotNull(context);
    }

    @Test
    void assertThatInnerConfigurationClassIsScanned() {
        Assertions.assertDoesNotThrow(() -> context.getBean(ToBeABeanInTests.class));
    }

    @Test
    void assertThatApplicationComponentsAreNotAvailable() {
        Assertions.assertThrowsExactly(NoSuchBeanDefinitionException.class, () -> context.getBean(DummyService.class));
        Assertions.assertThrowsExactly(NoSuchBeanDefinitionException.class, () -> context.getBean(DummyRepository.class));
    }

    @Configuration
    static class TestConfiguration {
        @Bean
        ToBeABeanInTests testBean() {
            return new ToBeABeanInTests();
        }
    }
}
