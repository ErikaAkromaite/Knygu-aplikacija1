package lt.imones.puslapis.projektopavadinimas.Component;

import lt.imones.puslapis.projektopavadinimas.model.entity.Privilegijos;
import lt.imones.puslapis.projektopavadinimas.model.entity.Roles;
import lt.imones.puslapis.projektopavadinimas.model.entity.Skaitytojas;
import lt.imones.puslapis.projektopavadinimas.model.repository.PrivilegijosRepository;
import lt.imones.puslapis.projektopavadinimas.model.repository.RolesRepository;
import lt.imones.puslapis.projektopavadinimas.model.repository.SkaitytojasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.*;

@Component
public class SetupDataLoader implements
        ApplicationListener<ContextRefreshedEvent>{


        boolean alreadySetup = false;

        @Autowired
        private SkaitytojasRepository skaitytojuRepozitorija;

        @Autowired
        private RolesRepository rolesRepository;

        @Autowired
        private PrivilegijosRepository privilegijosRepository;

   /*     @Autowired
        private BCryptPasswordEncoder passwordEncoder;*/

        @Override
        @Transactional
        public void onApplicationEvent(ContextRefreshedEvent event) {

        if (alreadySetup)
             return;
        Privilegijos readPrivilegijos
                = createPrivilegeIfNotFound("READ_PRIVILEGE");
        Privilegijos writePrivilege
                = createPrivilegeIfNotFound("WRITE_PRIVILEGE");

        Set<Privilegijos> adminoPriviliegijos = new HashSet<>();
        adminoPriviliegijos.add(readPrivilegijos);
        adminoPriviliegijos.add(writePrivilege);

        Set<Privilegijos> skaitytojoPriviliegijos = new HashSet<>();
        skaitytojoPriviliegijos.add(readPrivilegijos);

        createRoleIfNotFound("ROLE_ADMIN", adminoPriviliegijos);
        createRoleIfNotFound("ROLE_USER", skaitytojoPriviliegijos);

        Roles adminRole = rolesRepository.findByVardas("ROLE_ADMIN");
        Set<Roles> hashSet = new HashSet<Roles>();
        hashSet.add (adminRole);
        Skaitytojas skaitytojas = new Skaitytojas();
        skaitytojas.setPrisijungimoVardas("Test");
        skaitytojas.setSlaptazodis("test");
        skaitytojas.setSkaitytojoRoles (hashSet);
        skaitytojas.setEnabled(true);
        skaitytojuRepozitorija.save(skaitytojas);

        alreadySetup = true;

    }

     @Transactional
     Privilegijos createPrivilegeIfNotFound(String vardas) {

          Privilegijos privilegijos = privilegijosRepository.findByVardas(vardas);
          if (privilegijos == null) {
               privilegijos = new Privilegijos(vardas);
               privilegijosRepository.save(privilegijos);
          }
          return privilegijos;
     }
    @Transactional
    Roles createRoleIfNotFound (String vardas, Set<Privilegijos> privilegijos) {

        Roles role = rolesRepository.findByVardas(vardas);
        if (role == null) {
            role = new Roles(vardas);
            role.setRolesPrivilegijos(privilegijos);
            rolesRepository.save(role);
        }
        return role;
    }
   }
