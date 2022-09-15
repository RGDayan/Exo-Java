package Magasin;

import java.util.ArrayList;
import java.util.List;

public class Auteur extends Personne {
    private String nom_plume;

    private List<Livre> bibliographie;

    /**
     * Constructeur d'instanciation
     * @param nom nom de l'auteur
     * @param prenom prenom de l'auteur
     * @param nom_plume nom de plume de l'auteur
     * @param age age de l'auteur
     */
    public Auteur(String nom, String prenom, String date_naissance, Integer age, String nom_plume) {
        super(nom, prenom, date_naissance, age);
        this.nom_plume = nom_plume;
        this.bibliographie = new ArrayList<>();
    }

    public String getNom_plume() {
        return nom_plume;
    }

    public void setNom_plume(String nom_plume) {
        this.nom_plume = nom_plume;
    }

    public List<Livre> getBibliographie() {
        return bibliographie;
    }

    public void setBibliographie(List<Livre> bibliographie) {
        this.bibliographie = bibliographie;
    }
}
