package oh29oh29.entity;

import org.springframework.data.domain.Persistable;

import javax.persistence.*;

@Entity
public class User implements Persistable<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int value;

    @Transient
    private boolean newValue = true;

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public boolean isNew() {
        return newValue;
    }

    @PrePersist
    public void prePersist() {
        this.newValue = false;
    }

    @PostLoad
    public void postLoad() {
        this.newValue = false;
    }
}
