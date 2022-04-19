package lt.imones.puslapis.projektopavadinimas.Controller;
import lt.imones.puslapis.projektopavadinimas.model.entity.Knygos;
import lt.imones.puslapis.projektopavadinimas.model.entity.Skaitytojas;
import lt.imones.puslapis.projektopavadinimas.model.repository.KnygosRepository;
import lt.imones.puslapis.projektopavadinimas.model.repository.SkaitytojasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
public class SkaitytojasController {
    @Autowired
    KnygosRepository knygosRepository;
    @Autowired
    SkaitytojasRepository skaitytojasRepository;

    @PostMapping ("/skaitytojas/megstamos knygos")
    String pridediMegstamaKnyga(@RequestParam long id,@RequestParam String pavadinimas) {
        Skaitytojas rastasSKaitytojas = skaitytojasRepository.findById(id);
        Knygos rastaKnyga = knygosRepository.findByPavadinimas(pavadinimas);
        Set<Knygos> megstamosKnygos = rastasSKaitytojas.getMegstamosKnygos();
        megstamosKnygos.add(rastaKnyga);
        rastasSKaitytojas.setMegstamosKnygos(megstamosKnygos);
        skaitytojasRepository.save(rastasSKaitytojas);

        return "sėkmingai pridėta knyga";

    }

}
