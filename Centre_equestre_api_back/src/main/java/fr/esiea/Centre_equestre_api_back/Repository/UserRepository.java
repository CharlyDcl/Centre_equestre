package fr.esiea.Centre_equestre_api_back.Repository;

import fr.esiea.Centre_equestre_api_back.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findOneByMail(String mail);
    User findOneByPhone(String Phone);
}
