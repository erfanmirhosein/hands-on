package erfan.handson.testing.context;

import erfan.handson.testing.pojo.ToBeBeanInApp;
import erfan.handson.testing.pojo.ToBeBeanInTestsUsingAtConfiguration;
import erfan.handson.testing.pojo.ToBeBeanInTestsUsingAtTestConfiguration;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThatNoException;

@SpringBootTest
class NestedConfigurationClassTest {
    @Autowired
    ApplicationContext applicationContext;

    @Test
    void testBeanCreation() {
        assertThatNoException().isThrownBy(() -> applicationContext.getBean(NestedClass.class));

        assertThatExceptionOfType(NoSuchBeanDefinitionException.class)
                .isThrownBy(() -> applicationContext.getBean(ToBeBeanInTestsUsingAtTestConfiguration.class));

        assertThatExceptionOfType(NoSuchBeanDefinitionException.class)
                .isThrownBy(() -> applicationContext.getBean(ToBeBeanInTestsUsingAtConfiguration.class));

        assertThatExceptionOfType(NoSuchBeanDefinitionException.class)
                .isThrownBy(() -> applicationContext.getBean(ToBeBeanInApp.class));
    }

    @Configuration
    static class NestedConfiguration {
        @Bean
        NestedClass nestedClass() {
            return new NestedClass();
        }
    }

    static class NestedClass {
    }
}
