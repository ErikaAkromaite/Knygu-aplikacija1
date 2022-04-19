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

@RestController
public class KnygosController {

    @Autowired
    KnygosRepository knygosRepository;

    @Autowired
    SkaitytojasRepository skaitytojasRepository;


    @GetMapping("/test/greeting")
    String testinisEndpoint() {
        return "šis puslapis veikia";
    }

    @GetMapping("/knygos/gauti_pav")
    Knygos gautiPagalPavadinima(@RequestParam String pavadinimas) {
        return knygosRepository.findByPavadinimas(pavadinimas);
    }
    @PostMapping("/knyg/ideti_knyga")
    String idetiKnyga() {
        return "įdėjo";
    }

    @GetMapping("/knygos/rezervuoti")
   String rezervuotiKnyga(@RequestParam String pavadinimas, @RequestParam long id) {
        Knygos rastaKnyga = knygosRepository.findByPavadinimas(pavadinimas);
        Skaitytojas rastasSKaitytojas = skaitytojasRepository.findById(id);
        if (rastaKnyga.getKnygosRezervacija()==null){
            rastaKnyga.setKnygosRezervacija(rastasSKaitytojas);
            knygosRepository.save (rastaKnyga);
            return "nerezervuota";
        }
        else {
            return "rezervuota";
        }

    }

}
