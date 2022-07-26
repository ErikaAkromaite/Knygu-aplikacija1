package lt.imones.puslapis.projektopavadinimas.Controller;

import lt.imones.puslapis.projektopavadinimas.model.entity.Skaitytojas;
import lt.imones.puslapis.projektopavadinimas.model.repository.KategorijaRepository;
import lt.imones.puslapis.projektopavadinimas.model.repository.KnygosRepository;
import lt.imones.puslapis.projektopavadinimas.model.repository.SkaitytojasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SkaitytojasMVController {
    @Autowired
    KnygosRepository knygosRepository;

    @Autowired
    SkaitytojasRepository skaitytojasRepository;

    @PostMapping("/skaitytojas/megstama_knyga/{id}")
    String pamegtiKnygą(@PathVariable long id){
        Skaitytojas skaitytojas = skaitytojasRepository.findById(3);
        System.out.println("skaitytojas.getPrisijungimoVardas() = " + skaitytojas.getPrisijungimoVardas());
        skaitytojas.getMegstamosKnygos().add(knygosRepository.findById(id));
        skaitytojasRepository.save(skaitytojas);
        return "pamegta_knyga";
    }
}

