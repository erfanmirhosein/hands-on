package erfan.handson.testing;

import external.ExternalComponent;
import external.ExternalConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import({ExternalComponent.class, ExternalConfiguration.class})
public class TestingHandsOnApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestingHandsOnApplication.class, args);
    }

}
