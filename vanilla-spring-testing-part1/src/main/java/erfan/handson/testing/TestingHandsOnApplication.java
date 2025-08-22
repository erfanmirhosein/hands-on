package erfan.handson.testing;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.logging.Logger;

public class TestingHandsOnApplication {
    private static final Logger logger = Logger.getLogger(TestingHandsOnApplication.class.getName());

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);
        DummyPojo pojo = new DummyPojo();
        DummyService service = context.getBean(DummyService.class);
        String id = service.savePojo(pojo);
        logger.info("the Database ID of the POJO is: " + id);
    }
}
