package main.Model;

import java.util.ArrayList;
import java.util.List;

/**
 * Auteur d'un livre
 */
public class Auteur extends Personne {
    /** Nom de plume utilisé par l'auteur */
    private String nom_plume;
    /** Liste des livres écrit par l'auteur */
    private List<Livre> bibliographie;

    /**
     * Constructeur d'instanciation
     * @param nom Nom de la personne
     * @param prenom Prenom de la personne
     * @param date_naissance Date de naissance de la personne
     * @param age Age de la personne
     * @param nom_plume Nom de plume de l'auteur
     */
    public Auteur(String nom, String prenom, String date_naissance, Integer age, String nom_plume) {
        super(nom, prenom, date_naissance, age);
        this.nom_plume = nom_plume;
        this.bibliographie = new ArrayList<>();
    }

    /**
     * ACcède au nom de plume de l'auteur
     * @return Nom de plume de l'auteur
     */
    public String getNom_plume() {
        return nom_plume;
    }

    /**
     * Modifie le nom de plume de l'auteur
     * @param nom_plume Nouveau nom de plume
     */
    public void setNom_plume(String nom_plume) {
        this.nom_plume = nom_plume;
    }

    /**
     * Accède à la bibliographie de l'auteur
     * @return Bibliographie de l'auteur
     */
    public List<Livre> getBibliographie() {
        return bibliographie;
    }
}
