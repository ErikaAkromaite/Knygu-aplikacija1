package lt.imones.puslapis.projektopavadinimas.Component;

import lt.imones.puslapis.projektopavadinimas.model.entity.Knygos;
import lt.imones.puslapis.projektopavadinimas.model.entity.Privilegijos;
import lt.imones.puslapis.projektopavadinimas.model.entity.Roles;
import lt.imones.puslapis.projektopavadinimas.model.entity.Skaitytojas;
import lt.imones.puslapis.projektopavadinimas.model.repository.PrivilegijosRepository;
import lt.imones.puslapis.projektopavadinimas.model.repository.RolesRepository;
import lt.imones.puslapis.projektopavadinimas.model.repository.SkaitytojasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.*;

@Component
public class SetupDataLoader implements
        ApplicationListener<ContextRefreshedEvent>{


        boolean alreadySetup = false;

        @Autowired
        private SkaitytojasRepository SkaitytojasRepository;

        @Autowired
        private RolesRepository RolesRepository;

        @Autowired
        private PrivilegijosRepository PrivilegijosRepository;

        @Autowired
        private PasswordEncoder passwordEncoder;

        @Override
        @Transactional
        public void onApplicationEvent(ContextRefreshedEvent event) {

        if (alreadySetup)
             return;
        Privilegijos readPrivilegijos
                = createPrivilegeIfNotFound("READ_PRIVILEGE");
        Privilegijos writePrivilege
                = createPrivilegeIfNotFound("WRITE_PRIVILEGE");

        List<Privilegijos> adminPrivileges = Arrays.asList(
                readPrivilegijos, writePrivilege);
        createRoleIfNotFound("ROLE_ADMIN", adminPrivileges);
        createRoleIfNotFound("ROLE_USER", Arrays.asList(readPrivilegijos));

        Roles adminRole = RolesRepository.findByVardas("ROLE_ADMIN");
        Set<Roles> hashSet = new HashSet<Roles>;
        hashSet.add (adminRole);
        Skaitytojas skaitytojas = new Skaitytojas();
        skaitytojas.setPrisijungimoVardas("Test");
        skaitytojas.setSlaptazodis(passwordEncoder.encode("test"));
        skaitytojas.setSkaitytojoRoles (hashSet);
        skaitytojas.setEnabled(true);
        SkaitytojasRepository.save(skaitytojas);

        alreadySetup = true;

    }

     @Transactional
     Privilegijos createPrivilegeIfNotFound(String vardas) {

          Privilegijos privilegijos = PrivilegijosRepository.findByVardas(vardas);
          if (privilegijos == null) {
               privilegijos = new Privilegijos(vardas);
               PrivilegijosRepository.save(privilegijos);
          }
          return privilegijos;
     }
    @Transactional
    Roles createRoleIfNotFound(
            String vardas, Collection<Privilegijos> privileges) {

        Roles role = RolesRepository.findByVardas(vardas);
        if (role == null) {
            role = new Roles(vardas);
            role.rolesPrivilegijos(Privilegijos);
            RolesRepository.save(role);
        }
        return role;
    }
   }
