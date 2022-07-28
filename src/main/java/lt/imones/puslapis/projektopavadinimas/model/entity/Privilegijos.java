package lt.imones.puslapis.projektopavadinimas.model.entity;

import javax.management.relation.Role;
import javax.persistence.*;
import java.util.Collection;
import java.util.Set;

@Entity
public class Privilegijos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String vardas;

    public Privilegijos() {
    }

    public Privilegijos(Long id, String vardas) {
        this.id = id;
        this.vardas = vardas;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVardas() {
        return vardas;
    }

    public void setVardas(String vardas) {
        this.vardas = vardas;
    }


}
