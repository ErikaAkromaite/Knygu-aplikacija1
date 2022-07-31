package lt.imones.puslapis.projektopavadinimas.model.repository;

import lt.imones.puslapis.projektopavadinimas.model.entity.Privilegijos;
import lt.imones.puslapis.projektopavadinimas.model.entity.Roles;
import lt.imones.puslapis.projektopavadinimas.model.entity.Skaitytojas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolesRepository extends JpaRepository<Roles, Long> {
    Roles findById(long id);
    Roles findByVardas(String vardas);
}



