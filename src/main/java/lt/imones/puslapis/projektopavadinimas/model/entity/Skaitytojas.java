package lt.imones.puslapis.projektopavadinimas.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.management.relation.Role;
import javax.persistence.*;
import java.util.Collection;
import java.util.Set;

@Entity
public class Skaitytojas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String prisijungimoVardas;
    private String slaptazodis;

    @JsonIgnore
    @OneToMany(mappedBy = "knygosRezervacija")
    private Set<Knygos> visosKnygos;

    @JsonIgnore
    @ManyToMany (cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(
            name = "sujungimas_megstamos_knygos",
            joinColumns = @JoinColumn(name = "skaitytojas_id"),
            inverseJoinColumns = @JoinColumn(name = "knygos_id"))
    private Set<Knygos> megstamosKnygos;

    @JsonIgnore
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(
            name = "vartotoju_roles",
            joinColumns = @JoinColumn(name = "skaitytojo_id"),
            inverseJoinColumns = @JoinColumn(name = "roles_id")
    )
    private Set<Skaitytojas> skaitytojoRoles;

    public Skaitytojas() {
    }

    public Skaitytojas(long id, String prisijungimoVardas, String slaptazodis, Set<Knygos> visosKnygos, Set<Knygos> megstamosKnygos, Set<Skaitytojas> skaitytojoRoles) {
        this.id = id;
        this.prisijungimoVardas = prisijungimoVardas;
        this.slaptazodis = slaptazodis;
        this.visosKnygos = visosKnygos;
        this.megstamosKnygos = megstamosKnygos;
        this.skaitytojoRoles = skaitytojoRoles;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPrisijungimoVardas() {
        return prisijungimoVardas;
    }

    public void setPrisijungimoVardas(String prisijungimoVardas) {
        this.prisijungimoVardas = prisijungimoVardas;
    }

    public String getSlaptazodis() {
        return slaptazodis;
    }

    public void setSlaptazodis(String slaptazodis) {
        this.slaptazodis = slaptazodis;
    }

    public Set<Knygos> getVisosKnygos() {
        return visosKnygos;
    }

    public void setVisosKnygos(Set<Knygos> visosKnygos) {
        this.visosKnygos = visosKnygos;
    }

    public Set<Knygos> getMegstamosKnygos() {
        return megstamosKnygos;
    }

    public void setMegstamosKnygos(Set<Knygos> megstamosKnygos) {
        this.megstamosKnygos = megstamosKnygos;
    }

    public Set<Skaitytojas> getSkaitytojoRoles() {
        return skaitytojoRoles;
    }

    public void setSkaitytojoRoles(Set<Skaitytojas> skaitytojoRoles) {
        this.skaitytojoRoles = skaitytojoRoles;
    }

    @Override
    public String toString() {
        return "Skaitytojas{" +
                "id=" + id +
                ", prisijungimoVardas='" + prisijungimoVardas + '\'' +
                ", slaptazodis='" + slaptazodis + '\'' +
                ", visosKnygos=" + visosKnygos +
                ", megstamosKnygos=" + megstamosKnygos +
                ", skaitytojoRoles=" + skaitytojoRoles +
                '}';
    }
}
