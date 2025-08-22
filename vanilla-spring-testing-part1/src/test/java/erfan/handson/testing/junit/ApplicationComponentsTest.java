package erfan.handson.testing.junit;

import erfan.handson.testing.ApplicationConfiguration;
import erfan.handson.testing.DummyRepository;
import erfan.handson.testing.DummyService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = ApplicationConfiguration.class)
class ApplicationComponentsTest {
    @Autowired
    ApplicationContext context;

    @Test
    void assertThatApplicationComponentsAreAvailable() {
        Assertions.assertDoesNotThrow(() -> context.getBean(DummyService.class));
        Assertions.assertDoesNotThrow(() -> context.getBean(DummyRepository.class));
    }
}
