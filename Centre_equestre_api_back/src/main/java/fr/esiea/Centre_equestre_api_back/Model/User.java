package fr.esiea.Centre_equestre_api_back.Model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class User {

    public User(String nom, String prenom, Integer age, String password, String role, String licence, String mail, String phone) {
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
        this.password = password;
        this.role = role;
        this.licence = licence;
        this.mail = mail;
        this.phone = phone;
    }

    public User(){}

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String nom;
    private String prenom;
    private Integer age;

    private String password;
    private String role;
    private String licence;
    private String mail;
    private String phone;

    private Integer nombre_tentative_de_connexion;
    private boolean locked;

    @OneToMany(mappedBy = "moniteur")
    private Set<Cours> coursDuMoniteur;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getLicence() {
        return licence;
    }

    public void setLicence(String licence) {
        this.licence = licence;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getNombre_tentative_de_connexion() {
        return nombre_tentative_de_connexion;
    }

    public void setNombre_tentative_de_connexion(Integer nombre_tentative_de_connexion) {
        this.nombre_tentative_de_connexion = nombre_tentative_de_connexion;
    }

    public boolean isLocked() {
        return locked;
    }

    public void setLocked(boolean locked) {
        this.locked = locked;
    }
}
