package lt.imones.puslapis.projektopavadinimas.model.repository;

import lt.imones.puslapis.projektopavadinimas.model.entity.Privilegijos;
import lt.imones.puslapis.projektopavadinimas.model.entity.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrivilegijosRepository extends JpaRepository<Privilegijos, Long> {
    Privilegijos findById(long id);
    Privilegijos findByVardas(String vardas);
}
