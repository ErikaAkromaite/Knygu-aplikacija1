package lt.imones.puslapis.projektopavadinimas.model.repository;
import lt.imones.puslapis.projektopavadinimas.model.entity.Skaitytojas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkaitytojasRepository extends JpaRepository<Skaitytojas, Long> {
    Skaitytojas findById(long id);
    Skaitytojas findByPrisijungimoVardas (String prisijungimoVardas);
}
