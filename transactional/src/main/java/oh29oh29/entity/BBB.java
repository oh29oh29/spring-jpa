package oh29oh29.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class BBB {

    @Id
    private String id;

    private int value;

    public BBB() {}

    public BBB(String id) { this.id = id; }

    public void setValue(int value) {
        this.value = value;
    }
}
