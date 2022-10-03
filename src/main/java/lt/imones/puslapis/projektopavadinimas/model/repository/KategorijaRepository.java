package lt.imones.puslapis.projektopavadinimas.model.repository;
import lt.imones.puslapis.projektopavadinimas.model.entity.Kategorija;
import lt.imones.puslapis.projektopavadinimas.model.entity.Skaitytojas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KategorijaRepository extends JpaRepository<Kategorija, Integer> {

        Kategorija findById(int id);
        Kategorija findByPavadinimas (String pavadinimas);
}
