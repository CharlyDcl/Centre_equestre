package fr.esiea.Centre_equestre_api_back.Repository;

import fr.esiea.Centre_equestre_api_back.Model.Cheval;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChevalRepository extends JpaRepository<Cheval, Integer> {
}
