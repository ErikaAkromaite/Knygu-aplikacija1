package lt.imones.puslapis.projektopavadinimas.Controller;

import lt.imones.puslapis.projektopavadinimas.model.entity.Kategorija;
import lt.imones.puslapis.projektopavadinimas.model.repository.KategorijaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

    @RestController
    public class KategorijaController {
    @Autowired
    KategorijaRepository kategorijaRepository;

    @PostMapping("/kategorija/ideti")
    String idetiKategorija(@RequestParam String pavadinimas) {
    Kategorija naujaKategorija = new Kategorija();
    naujaKategorija.setPavadinimas(pavadinimas);
    kategorijaRepository.save(naujaKategorija);
    return "Kategorija" + pavadinimas + " sėkmingai įdėta";

    }
        @GetMapping("/gauti/kategorija")
        String belekas() {
            return "belekas";
        }

}

