package erfan.handson.testing.jpa;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;

@Entity
@Table(name = "test_table", schema = "test_schema")
@Getter
public class TestEntity {
    @Id
    private Integer id;
    private Integer dummyField;
}
