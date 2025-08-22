package erfan.handson.testing;

import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public class DummyRepositoryImpl implements DummyRepository {
    @Override
    public String save(DummyPojo pojo) {
        return UUID.randomUUID().toString();
    }
}
