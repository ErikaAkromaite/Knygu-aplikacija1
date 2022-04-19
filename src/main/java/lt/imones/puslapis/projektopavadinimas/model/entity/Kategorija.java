package lt.imones.puslapis.projektopavadinimas.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Kategorija {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String pavadinimas;

    @JsonIgnore
    @OneToMany(mappedBy = "knygosKategorija")
    Set<Knygos> visosKnygos;

    public Kategorija() {
    }

    public Kategorija(int id, String pavadinimas, Set<Knygos> visosKnygos) {
        this.id = id;
        this.pavadinimas = pavadinimas;
        visosKnygos = visosKnygos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPavadinimas() {
        return pavadinimas;
    }

    public void setPavadinimas(String pavadinimas) {
        this.pavadinimas = pavadinimas;
    }

    public Set<Knygos> getVisosKnygos() {
        return visosKnygos;
    }

    public void setVisosKnygos(Set<Knygos> visosKnygos) {
        visosKnygos = visosKnygos;

    }

    @Override
    public String toString() {
        return "Kategorija{" +
                "id=" + id +
                ", pavadinimas='" + pavadinimas + '\'' +
                ", VisosKnygos=" + visosKnygos +
                '}';
    }
}
