package erfan.handson.testing.junit;

import erfan.handson.testing.ApplicationConfiguration;
import erfan.handson.testing.DummyPojo;
import erfan.handson.testing.DummyService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.util.UUID;

@SpringJUnitConfig(classes = ApplicationConfiguration.class)
class IntegrationTest {
    @Autowired
    DummyService dummyService;

    @Test
    void givenPojoIsValid_whenISaveThePojo_thenAUuidShouldBeReturned() {
        DummyPojo validPojo = new DummyPojo();
        String id = dummyService.savePojo(validPojo);
        Assertions.assertDoesNotThrow(() -> UUID.fromString(id));
    }
}
