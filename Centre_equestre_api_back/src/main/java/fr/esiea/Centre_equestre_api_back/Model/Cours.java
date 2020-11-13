package fr.esiea.Centre_equestre_api_back.Model;

import javax.persistence.*;

@Entity
public class Cours {

    public Cours() {
    }

    public Cours(/*User moniteur,*/ String niveau, String date, String time, Integer maximum_eleve) {
        //this.moniteur = moniteur;
        this.niveau = niveau;
        this.date = date;
        this.time = time;
        this.maximum_eleve = maximum_eleve;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "moniteur_id")
    private User moniteur;

    private String niveau;
    private String date;
    private String time;
    private Integer nombre_eleves;
    private Integer maximum_eleve;

//    @ManyToMany
//    private Set<User_Cheval_Lien> eleves_cheval;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    /*public User getMoniteur() {
        return moniteur;
    }

    public void setMoniteur(User moniteur) {
        this.moniteur = moniteur;
    }*/

    public String getNiveau() {
        return niveau;
    }

    public void setNiveau(String niveau) {
        this.niveau = niveau;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Integer getNombre_eleves() {
        return nombre_eleves;
    }

    public void setNombre_eleves(Integer nombre_eleves) {
        this.nombre_eleves = nombre_eleves;
    }

    public Integer getMaximum_eleve() {
        return maximum_eleve;
    }

    public void setMaximum_eleve(Integer maximum_eleve) {
        this.maximum_eleve = maximum_eleve;
    }
}
