package lt.imones.puslapis.projektopavadinimas.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lt.imones.puslapis.projektopavadinimas.model.entity.Privilegijos;
import lt.imones.puslapis.projektopavadinimas.model.entity.Skaitytojas;
import org.springframework.security.core.userdetails.User;

import javax.management.relation.Role;
import javax.persistence.*;
import java.util.Collection;
import java.util.Set;

@Entity
public class Roles {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String vardas;

    public Roles() {
    }

    public Roles(Long id, String vardas) {
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

    @Override
    public String toString() {
        return "Roles{" +
                "id=" + id +
                ", vardas='" + vardas + '\'' +
                '}';
    }
}