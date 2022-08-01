package lt.imones.puslapis.projektopavadinimas.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

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

    @JsonIgnore
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(
            name = "roles_privilegijos",
            joinColumns = @JoinColumn(name = "privilegijos_id"),
            inverseJoinColumns = @JoinColumn(name = "roles_id")
    )
    private Set<Roles> rolesTurinciosSiaPrivilegija;

    public Privilegijos() {
    }

    public Privilegijos(Long id, String vardas, Set<Roles> rolesTurinciosSiaPrivilegija) {
        this.id = id;
        this.vardas = vardas;
        this.rolesTurinciosSiaPrivilegija = rolesTurinciosSiaPrivilegija;
    }

    public Privilegijos(String vardas) {
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

    public Set<Roles> getRolesTurinciosSiaPrivilegija() {
        return rolesTurinciosSiaPrivilegija;
    }

    public void setRolesTurinciosSiaPrivilegija(Set<Roles> rolesTurinciosSiaPrivilegija) {
        this.rolesTurinciosSiaPrivilegija = rolesTurinciosSiaPrivilegija;
    }

    @Override
    public String toString() {
        return "Privilegijos{" +
                "id=" + id +
                ", vardas='" + vardas + '\'' +
                ", rolesTurinciosSiaPrivilegija=" + rolesTurinciosSiaPrivilegija +
                '}';
    }
}
