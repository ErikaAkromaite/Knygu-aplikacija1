package lt.imones.puslapis.projektopavadinimas.model.repository;

import lt.imones.puslapis.projektopavadinimas.model.entity.Knygos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface KnygosRepository extends JpaRepository<Knygos, Long> {
    Knygos findByPavadinimas (String pavadinimas);
    Knygos findById(long id);
    List<Knygos> findByPuslapiuSkaiciusBetween(int pradinisPuslapiuSkaicius, int galutinisPuslapiuSkaicius);
}
