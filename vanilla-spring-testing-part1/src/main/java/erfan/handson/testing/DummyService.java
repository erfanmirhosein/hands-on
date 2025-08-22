package erfan.handson.testing;

import org.springframework.stereotype.Service;

@Service
public class DummyService {
    private final DummyRepository repository;

    public String savePojo(DummyPojo pojo) {
        return repository.save(pojo);
    }

    public DummyService(DummyRepository repository) {
        this.repository = repository;
    }
}
