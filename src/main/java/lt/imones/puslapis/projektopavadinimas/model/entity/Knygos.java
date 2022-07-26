package lt.imones.puslapis.projektopavadinimas.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Knygos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String autorius;
    private String pavadinimas;
    private String santrauka;
    private String ISBN;
    private String nuotrauka;
    private int puslapiuSkaicius;


    @ManyToOne
    @JoinColumn(name = "kategorijos_id")
    private Kategorija knygosKategorija;

    @ManyToOne
    @JoinColumn(name = "skaitytojo_id")
    private Skaitytojas knygosRezervacija;


    @ManyToMany (cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "sujungimas_megstamos_knygos",
            joinColumns = @JoinColumn(name = "knygos_id"),
            inverseJoinColumns = @JoinColumn(name = "skaitytojas_id"))
    private Set<Skaitytojas> skaiytytojuMegstamosKnygos;


    public boolean arKnygaRezervuota () {
        if (knygosRezervacija == null) {
            return false;
        } else {
            return true;
        }
    }

    public Knygos() {
    }

    public Knygos(long id, String autorius, String pavadinimas, String santrauka, String ISBN, String nuotrauka, int puslapiuSkaicius, Kategorija knygosKategorija, Skaitytojas knygosRezervacija, Set<Skaitytojas> skaiytytojuMegstamosKnygos) {
        this.id = id;
        this.autorius = autorius;
        this.pavadinimas = pavadinimas;
        this.santrauka = santrauka;
        this.ISBN = ISBN;
        this.nuotrauka = nuotrauka;
        this.puslapiuSkaicius = puslapiuSkaicius;
        this.knygosKategorija = knygosKategorija;
        this.knygosRezervacija = knygosRezervacija;
        this.skaiytytojuMegstamosKnygos = skaiytytojuMegstamosKnygos;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAutorius() {
        return autorius;
    }

    public void setAutorius(String autorius) {
        this.autorius = autorius;
    }

    public String getPavadinimas() {
        return pavadinimas;
    }

    public void setPavadinimas(String pavadinimas) {
        this.pavadinimas = pavadinimas;
    }

    public String getSantrauka() {
        return santrauka;
    }

    public void setSantrauka(String santrauka) {
        this.santrauka = santrauka;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getNuotrauka() {
        return nuotrauka;
    }

    public void setNuotrauka(String nuotrauka) {
        this.nuotrauka = nuotrauka;
    }

    public int getPuslapiuSkaicius() {
        return puslapiuSkaicius;
    }

    public void setPuslapiuSkaicius(int puslapiuSkaicius) {
        this.puslapiuSkaicius = puslapiuSkaicius;
    }

    public Kategorija getKnygosKategorija() {
        return knygosKategorija;
    }

    public void setKnygosKategorija(Kategorija knygosKategorija) {
        this.knygosKategorija = knygosKategorija;
    }

    public Skaitytojas getKnygosRezervacija() {
        return knygosRezervacija;
    }

    public void setKnygosRezervacija(Skaitytojas knygosRezervacija) {
        this.knygosRezervacija = knygosRezervacija;
    }

    public Set<Skaitytojas> getSkaiytytojuMegstamosKnygos() {
        return skaiytytojuMegstamosKnygos;
    }

    public void setSkaiytytojuMegstamosKnygos(Set<Skaitytojas> skaiytytojuMegstamosKnygos) {
        this.skaiytytojuMegstamosKnygos = skaiytytojuMegstamosKnygos;
    }

    @Override
    public String toString() {
        return "Knygos{" +
                "id=" + id +
                ", autorius='" + autorius + '\'' +
                ", pavadinimas='" + pavadinimas + '\'' +
                ", santrauka='" + santrauka + '\'' +
                ", ISBN='" + ISBN + '\'' +
                ", nuotrauka='" + nuotrauka + '\'' +
                ", puslapiuSkaicius=" + puslapiuSkaicius +
                ", knygosKategorija=" + knygosKategorija +
                ", knygosRezervacija=" + knygosRezervacija +
                ", SkaiytytojuMegstamosKnygos=" + skaiytytojuMegstamosKnygos +
                '}';
    }

}
