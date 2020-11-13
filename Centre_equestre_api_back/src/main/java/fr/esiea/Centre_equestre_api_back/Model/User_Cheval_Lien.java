package fr.esiea.Centre_equestre_api_back.Model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class User_Cheval_Lien {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

//    @ManyToMany
  //  private Set<Cours> cours;

    //private User cours_user;
    //private Cheval cours_cheval;

}
