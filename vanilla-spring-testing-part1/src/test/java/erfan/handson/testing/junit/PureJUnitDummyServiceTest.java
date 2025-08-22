package erfan.handson.testing.junit;

import erfan.handson.testing.DummyPojo;
import erfan.handson.testing.DummyRepository;
import erfan.handson.testing.DummyService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PureJUnitDummyServiceTest {

    DummyService dummyService;
    DummyRepository mockedRepository;

    @BeforeEach
    void setup() {
        mockedRepository = Mockito.mock(DummyRepository.class);
        dummyService = new DummyService(mockedRepository);
    }

    @Test
    void givenPojoIsValid_whenISaveThePojo_thenItsDBIdShouldBeReturned() {
        DummyPojo validPojo = new DummyPojo();
        String fakeDBId = "a-unique-id";
        Mockito.when(mockedRepository.save(validPojo)).thenReturn(fakeDBId);
        Assertions.assertEquals(fakeDBId, dummyService.savePojo(validPojo));
    }
}
