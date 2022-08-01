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

    @JsonIgnore
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(
            name = "vartotoju_roles",
            joinColumns = @JoinColumn(name = "roles_id"),
            inverseJoinColumns = @JoinColumn(name = "skaitytojo_id")
    )
    private Set<Skaitytojas> rolesSkaitytojai;

    @JsonIgnore
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(
            name = "roles_privilegijos",
            joinColumns = @JoinColumn(name = "roles_id"),
            inverseJoinColumns = @JoinColumn(name = "privilegijos_id")
    )
    private Set<Privilegijos> rolesPrivilegijos;


    public Roles() {
    }

    public Roles(Long id, String vardas, Set<Skaitytojas> rolesSkaitytojai, Set<Privilegijos> rolesPrivilegijos) {
        this.id = id;
        this.vardas = vardas;
        this.rolesSkaitytojai = rolesSkaitytojai;
        this.rolesPrivilegijos = rolesPrivilegijos;
    }

    public Roles(String vardas) {
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

    public Set<Skaitytojas> getRolesSkaitytojai() {
        return rolesSkaitytojai;
    }

    public void setRolesSkaitytojai(Set<Skaitytojas> rolesSkaitytojai) {
        this.rolesSkaitytojai = rolesSkaitytojai;
    }

    public Set<Privilegijos> getRolesPrivilegijos() {
        return rolesPrivilegijos;
    }

    public void setRolesPrivilegijos(Set<Privilegijos> rolesPrivilegijos) {
        this.rolesPrivilegijos = rolesPrivilegijos;
    }

    @Override
    public String toString() {
        return "Roles{" +
                "id=" + id +
                ", vardas='" + vardas + '\'' +
                ", rolesSkaitytojai=" + rolesSkaitytojai +
                ", rolesPrivilegijos=" + rolesPrivilegijos +
                '}';
    }
}