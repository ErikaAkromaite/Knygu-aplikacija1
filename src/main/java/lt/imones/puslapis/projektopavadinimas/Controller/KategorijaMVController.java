package lt.imones.puslapis.projektopavadinimas.Controller;

import lt.imones.puslapis.projektopavadinimas.model.entity.Kategorija;
import lt.imones.puslapis.projektopavadinimas.model.entity.Knygos;
import lt.imones.puslapis.projektopavadinimas.model.repository.KategorijaRepository;
import lt.imones.puslapis.projektopavadinimas.model.repository.KnygosRepository;
import lt.imones.puslapis.projektopavadinimas.model.repository.SkaitytojasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class KategorijaMVController {
    @Autowired
    KnygosRepository knygosRepository;

    @Autowired
    KategorijaRepository kategorijaRepository;

    @Autowired
    SkaitytojasRepository skaitytojasRepository;

    @GetMapping("/kategorijos")
    String testKategorijos(Model model, @RequestParam String pavadinimas) {
        Kategorija kategorija = kategorijaRepository.findByPavadinimas(pavadinimas);
        model.addAttribute("id", kategorija.getId());
        model.addAttribute("pavadinimas", kategorija.getPavadinimas());
        return "parodyti_kategorija.html";
    }

    @PostMapping("/kategorija/ideti_kategorija")
    String idetiKategorija(@RequestBody Kategorija ivedamaKategorija) {
        kategorijaRepository.save(ivedamaKategorija);
        return "įdėjo";
    }

    @PostMapping("/redaguota-kategorija")
    String redaguotiKategorija(@ModelAttribute Kategorija ivedamaKategorija) {
        kategorijaRepository.save(ivedamaKategorija);
        return "Kategorija_ideta.html";
    }

    @GetMapping("/Kategorijos_redagavimas/{id}")
    String kategorijaKnyga(Model model, @PathVariable int id) {
        Kategorija kategorija = kategorijaRepository.findById(id);
        model.addAttribute( "kategorija", kategorija);
        return "Kategorijos_redagavimas.html";
    }
    @GetMapping("/kategorija/idejimas")
    String kategorijosIdejimas(Model model) {
        Kategorija kategorija = new Kategorija();
        model.addAttribute("kategorija", kategorija);
        return "ideti_kategorija.html";
    }
    @PostMapping("/istrinta_kategorija/{id}")
    String istrintiKategorija(Model model, @PathVariable int id) {
        kategorijaRepository.delete(kategorijaRepository.findById(id));
        return "istrinta_kategorija.html";
    }
}