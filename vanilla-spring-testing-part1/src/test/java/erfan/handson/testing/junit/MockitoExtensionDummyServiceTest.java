package erfan.handson.testing.junit;

import erfan.handson.testing.DummyPojo;
import erfan.handson.testing.DummyRepository;
import erfan.handson.testing.DummyService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class MockitoExtensionDummyServiceTest {

    @Mock
    DummyRepository mockedRepository;
    @InjectMocks
    DummyService dummyService;

    @Test
    void givenPojoIsValid_whenISaveThePojo_thenItsDBIdShouldBeReturned() {
        DummyPojo validPojo = new DummyPojo();
        String fakeDBId = "a-unique-id";
        Mockito.when(mockedRepository.save(validPojo)).thenReturn(fakeDBId);
        Assertions.assertEquals(fakeDBId, dummyService.savePojo(validPojo));
    }
}
