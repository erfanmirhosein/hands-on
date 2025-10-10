package erfan.handson.testcontainers.springmanaged;

import erfan.handson.testcontainers.jpa.TestEntityRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

@SpringBootTest
@Import(TestcontainersConfiguration.class)
class AnotherApplicationTest {
    @MockitoBean
    TestEntityRepository testEntityRepository;

    @Test
    void testEntireApplication() {
        Assertions.assertNotNull(testEntityRepository);
    }
}
