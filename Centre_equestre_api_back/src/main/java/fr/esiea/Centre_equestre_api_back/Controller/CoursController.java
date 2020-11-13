package fr.esiea.Centre_equestre_api_back.Controller;

import fr.esiea.Centre_equestre_api_back.Model.Cours;
import fr.esiea.Centre_equestre_api_back.Model.User;
import fr.esiea.Centre_equestre_api_back.Repository.CoursRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class CoursController {

    private final String API_GET_COURS = "/cours";

    @Autowired
    private CoursRepository CoursRepo;

    @GetMapping(API_GET_COURS)
    public List<Cours> getCours() {
        return CoursRepo.findAll();
    }

    @GetMapping(API_GET_COURS + "/{id}")
    public Cours getUserById(@PathVariable Integer id) {
        Optional<Cours> user = CoursRepo.findById(id);
        return user.get();
    }

    @PostMapping(API_GET_COURS)
    public Cours addCours(@RequestBody Cours cours) {
        Cours newCours = new Cours(/*cours.getMoniteur(),*/ cours.getNiveau(), cours.getDate(), cours.getTime(), cours.getMaximum_eleve());
        return CoursRepo.save(newCours);
    }

    @PutMapping(API_GET_COURS + "/{id}")
    public Cours updateCours(@RequestBody Cours cours, @PathVariable Integer id) {
        Optional<Cours> Coursdb = CoursRepo.findById(id);
        Cours updateCours = Coursdb.get();

        updateCours.setDate(cours.getDate());
        updateCours.setTime(cours.getTime());
        updateCours.setMaximum_eleve(cours.getMaximum_eleve());
        updateCours.setNiveau(cours.getNiveau());
        //updateCours.setMoniteur(cours.getMoniteur());

        return CoursRepo.save(updateCours);
    }

    @DeleteMapping(API_GET_COURS + "/{id}")
    public String deleteUser(@PathVariable Integer id) {
        Optional<Cours> coursToDelete = CoursRepo.findById(id);
        CoursRepo.delete(coursToDelete.get());
        return "cours successfully with id : " + id +" deleted";
    }
}
