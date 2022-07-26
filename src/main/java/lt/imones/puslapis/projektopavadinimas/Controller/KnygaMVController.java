package lt.imones.puslapis.projektopavadinimas.Controller;

import lt.imones.puslapis.projektopavadinimas.model.entity.Knygos;
import lt.imones.puslapis.projektopavadinimas.model.entity.Skaitytojas;
import lt.imones.puslapis.projektopavadinimas.model.repository.KategorijaRepository;
import lt.imones.puslapis.projektopavadinimas.model.repository.KnygosRepository;
import lt.imones.puslapis.projektopavadinimas.model.repository.SkaitytojasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class KnygaMVController {

    @Autowired
    KnygosRepository knygosRepository;

    @Autowired
    KategorijaRepository kategorijaRepository;

    @Autowired
    SkaitytojasRepository skaitytojasRepository;

    @GetMapping("/test/sveikinimas")
    String testineFunkcija(Model model, @RequestParam String vardas) {
        model.addAttribute("vardas", vardas);
        return "TestinisPuslapis.html";
    }
    @GetMapping("/test/knygos")
    String testKnygos(Model model, @RequestParam String pavadinimas) {
        Knygos knygos = knygosRepository.findByPavadinimas(pavadinimas);
        model.addAttribute("pavadinimas", knygos.getPavadinimas());
        model.addAttribute("santrauka", knygos.getSantrauka());
        model.addAttribute("autorius", knygos.getAutorius());
        model.addAttribute("ISBN", knygos.getISBN());
        model.addAttribute("nuotrauka", knygos.getNuotrauka());
        model.addAttribute("puslapiuSkaicius", knygos.getPuslapiuSkaicius());
        model.addAttribute("skaiytytojuMegstamosKnygos", knygos.getSkaiytytojuMegstamosKnygos());
        model.addAttribute("knygosKategorija", knygos.getKnygosKategorija());
        model.addAttribute("knygosRezervacija", knygos.getKnygosRezervacija());
        model.addAttribute("id", knygos.getId());

        knygos.getSkaiytytojuMegstamosKnygos().size();
        return "parodyti_knyga.html";
    }
    @GetMapping("/test/paieska")
    String testPaieska(Model model) {
        return "rasti_knyga.html";

    }
    @PostMapping("/ideta_knyga")
    String pridetiKnyga(@ModelAttribute Knygos ivedamaKnyga) {
        knygosRepository.save(ivedamaKnyga);
        return "ideta_knyga.html";

    }
    @GetMapping("/knyga/idejimas")
    String knygosIdejimas(Model model) {
        Knygos knyga = new Knygos();
        model.addAttribute("knyga", knyga);
        model.addAttribute("kategorijos", kategorijaRepository.findAll());
        return "ideti_knyga.html";
    }
    @GetMapping("/Knygos_redagavimas/{id}")
    String redaguotiKnyga(Model model, @PathVariable long id){
        Knygos knyga = knygosRepository.findById(id);
        model.addAttribute( "knyga", knyga);
        model.addAttribute("kategorijos", kategorijaRepository.findAll());
        return "Knygos_redagavimas.html";
    }
    @PostMapping("/istrinta_knyga/{id}")
    String istrintiKnyga(Model model, @PathVariable long id) {
        knygosRepository.delete(knygosRepository.findById(id));
        return "istrinta_knyga.html";
    }

    @PostMapping ("/knygos_rezervacija/{id}")
    String rezervuotiKnyga (Model model, @PathVariable long id){
        Knygos knyga = knygosRepository.findById(id);
        System.out.println("knyga.arKnygaRezervuota() = " + knyga.arKnygaRezervuota());
        if (knyga.arKnygaRezervuota()) {
            System.out.println ("Atsiprasome_knyga_rezervuota.html ");
            return "Atsiprasome_knyga_rezervuota.html ";
        }
        else {
            Skaitytojas rastasSkaitytojas = skaitytojasRepository.findById(3);
            knyga.setKnygosRezervacija(rastasSkaitytojas);
            knygosRepository.save (knyga);
            return "knygos_rezervacija.html";
        }
    }
    @GetMapping ("/knygos_virs_300puslapiu/")
    String atvaizduotiKnygas (Model model) {
        List <Knygos> visosKnygos = knygosRepository.findAll();
        List <Knygos> naujasSarasas = new ArrayList<>();

        for (Knygos sekantiKnyga : visosKnygos)
        {
            if (sekantiKnyga.getPuslapiuSkaicius() >400)
            {
                naujasSarasas.add(sekantiKnyga);
            }
        }
        model.addAttribute("naujasSarasas", naujasSarasas);
        return "knygos_virs_300puslapiu.html";

    }
}
