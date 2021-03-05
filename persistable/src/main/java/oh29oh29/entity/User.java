package oh29oh29.entity;

import org.springframework.data.domain.Persistable;

import javax.persistence.*;

@Entity
public class User implements Persistable<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int value;

    public void setValue(int value) {
        this.value = value;
    }

    @Transient
    private boolean isNew = true;

    @Override
    public Long getId() {
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
