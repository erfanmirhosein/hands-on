package erfan.handson.testcontainers.experiment;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.testcontainers.context.ImportTestcontainers;

@TestConfiguration
@ImportTestcontainers(TestcontainersSetup.class)
class TestcontainersConfiguration {
}
