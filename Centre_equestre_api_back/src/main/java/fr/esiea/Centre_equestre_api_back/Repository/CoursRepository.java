package fr.esiea.Centre_equestre_api_back.Repository;

import fr.esiea.Centre_equestre_api_back.Model.Cours;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoursRepository extends JpaRepository<Cours, Integer> {
}
