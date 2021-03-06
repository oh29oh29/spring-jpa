package oh29oh29.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CCC {

    @Id
    private String id;

    private int value;

    public CCC() {}

    public CCC(String id) {
        this.id = id;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
