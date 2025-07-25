package erfan.handson.testing.springframework.beanoverriding;

import erfan.handson.testing.springframework.pojo.AnotherDummyClass;
import erfan.handson.testing.springframework.pojo.DummyClass;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.bean.override.convention.TestBean;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig
class BeanOverridingTest {

    @TestBean(methodName = "overriddenDummy")
    DummyClass dummy;
    @MockitoBean
    AnotherDummyClass anotherDummy;

    @Test
    void testBeanOverride() {
        Mockito.when(anotherDummy.getName()).thenReturn("mockedBean");
        Assertions.assertEquals("mockedBean", anotherDummy.getName());
        Assertions.assertEquals("overriddenBean", dummy.name);
    }

    @Configuration
    static class BeanOverridingTestConfig {
        @Bean
        DummyClass dummyClass() {
            return new DummyClass("actualBean");
        }

        @Bean
        AnotherDummyClass anotherDummyClass() {
            return new AnotherDummyClass("actualBean");
        }
    }

    private static DummyClass overriddenDummy() {
        return new DummyClass("overriddenBean");
    }
}
