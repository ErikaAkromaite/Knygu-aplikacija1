package lt.imones.puslapis.projektopavadinimas.model.repository;
import lt.imones.puslapis.projektopavadinimas.model.entity.Kategorija;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KategorijaRepository extends JpaRepository<Kategorija, Integer> {
}
