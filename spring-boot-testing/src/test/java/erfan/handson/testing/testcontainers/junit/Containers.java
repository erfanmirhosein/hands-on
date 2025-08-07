package erfan.handson.testing.testcontainers.junit;

import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.kafka.KafkaContainer;
import org.testcontainers.utility.DockerImageName;

interface Containers {
    @Container
    KafkaContainer kafkaContainer = new KafkaContainer(DockerImageName.parse("apache/kafka:4.0.0"));
}
