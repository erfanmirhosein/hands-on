package erfan.handson.testing.context;

import erfan.handson.testing.pojo.ToBeBeanInApp;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class ApplicationConfiguration {
    @Bean
    public ToBeBeanInApp appBean() {
        return new ToBeBeanInApp();
    }
}
