package erfan.handson.testing.context;

import erfan.handson.testing.pojo.ToBeBeanInApp;
import erfan.handson.testing.pojo.ToBeBeanInTestsUsingAtConfiguration;
import erfan.handson.testing.pojo.ToBeBeanInTestsUsingAtTestConfiguration;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThatNoException;

@SpringBootTest(classes = ConfigurationWithAtTestConfiguration.class)
class TestConfigurationClassAsAnnotationAttributeTest {
    @Autowired
    ApplicationContext applicationContext;

    @Test
    void testBeanCreation() {

        assertThatNoException()
                .isThrownBy(() -> applicationContext.getBean(ToBeBeanInTestsUsingAtConfiguration.class));

        assertThatNoException()
                .isThrownBy(() -> applicationContext.getBean(ToBeBeanInTestsUsingAtTestConfiguration.class));

        assertThatNoException()
                .isThrownBy(() -> applicationContext.getBean(ToBeBeanInApp.class));
    }

}
