package oh29oh29.entity;

import org.springframework.data.domain.Persistable;

import javax.persistence.*;

@Entity
public class BBB implements Persistable<String> {

    @Id
    private String id;

    private int value;

    public BBB() {
    }

    public BBB(String id) {
        this.id = id;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Transient
    private boolean isNew = true;

    @Override
    public String getId() {
        return id;
    }

    @Override
    public boolean isNew() {
        return isNew;
    }

    @PrePersist
    @PostLoad
    private void markNotNew() {
        this.isNew = false;
    }
}
