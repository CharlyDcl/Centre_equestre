package fr.esiea.Centre_equestre_api_back.Controller;

import fr.esiea.Centre_equestre_api_back.Model.User;
import fr.esiea.Centre_equestre_api_back.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class UserController {

    private final String API_USER = "user";

    @Autowired
    private UserRepository userRepo;

    @GetMapping(API_USER)
    public List<User> getUser() {
        return userRepo.findAll();
    }

    @GetMapping(API_USER + "/{id}")
    public User getUserById(@PathVariable Integer id) {
        Optional<User> user = userRepo.findById(id);
        return user.get();
    }

    @PostMapping(API_USER)
    public User addUser(@RequestBody User user) {
        user.setPassword("mot_de_pass_temporaire");
        return userRepo.save(user);
    }

    @DeleteMapping(API_USER + "/{id}")
    public String deleteUser(@PathVariable Integer id) {
        Optional<User> userToDelete = userRepo.findById(id);
        userRepo.delete(userToDelete.get());
        return "user successfully with id : " + id +" deleted";
    }
}
