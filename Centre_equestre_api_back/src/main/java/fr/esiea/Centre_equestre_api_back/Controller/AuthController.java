package fr.esiea.Centre_equestre_api_back.Controller;

import fr.esiea.Centre_equestre_api_back.Model.User;
import fr.esiea.Centre_equestre_api_back.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/auth")
public class AuthController {

    private final String API_LOGIN_MAIL = "/loginByMail";
    private final String API_LOGIN_PHONE = "/loginByPhone";
    private final String API_SIGN_UP = "/sign_up";
    private final String API_RESET_PASSWORD = "/reset-password";
    private final Integer MAX_ATTEMPTS = 3;

    @Autowired
    UserRepository userRepo;

    @PostMapping(API_LOGIN_MAIL)
    public User loginByMail(@RequestBody Map<String, Object> login) throws Exception {
        User userdb = userRepo.findOneByMail(login.get("mail").toString());

        if (userdb.getPassword().equals(login.get("password").toString())) {
            userdb.setNombre_tentative_de_connexion(0);
            userdb.setLocked(false);
            return userdb;
        } else if (userdb.isLocked()) {
            throw new ResponseStatusException(HttpStatus.LOCKED, "Compte utilisateur bloqué");
        } else {
            Integer nbConnexion = userdb.getNombre_tentative_de_connexion();
            if (nbConnexion == null) {
                nbConnexion = 0;
            }
            userdb.setNombre_tentative_de_connexion(nbConnexion + 1);
            if (userdb.getNombre_tentative_de_connexion() >= MAX_ATTEMPTS) {
                userdb.setLocked(true);
            }
            userRepo.save(userdb);
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "L'identifiant ou le mote de passe n'est pas correct");
        }
    }

    @PostMapping(API_LOGIN_PHONE)
    public User loginByPhone(@RequestBody Map<String, Object> login) throws Exception {
        String phone = login.get("phone").toString();
        User userdb = userRepo.findOneByPhone(phone);

        if (userdb.getPassword().equals(login.get("password")) && !userdb.isLocked()) {
            userdb.setNombre_tentative_de_connexion(0);
            return userdb;
        } else if (userdb.isLocked()) {
            throw new ResponseStatusException(HttpStatus.LOCKED, "Compte utilisateur bloqué");
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "L'identifiant ou le mote de passe n'est pas correct");
        }
    }

    @PostMapping(API_SIGN_UP)
    public User sign_up(@RequestBody User user) {
        System.out.println(user);
        User newUser = new User(user.getNom(), user.getPrenom(), user.getAge(), user.getPassword(), user.getRole(), user.getLicence(), user.getMail(), user.getPhone());
        return userRepo.save(newUser);
    }

    @PostMapping(API_RESET_PASSWORD)
    public void resetPassword(@RequestBody String mail) {
    }
}
