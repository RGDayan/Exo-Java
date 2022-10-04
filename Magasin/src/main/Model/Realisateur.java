package main.Model;

import java.util.ArrayList;
import java.util.List;

/**
 * Réalisateur d'un dvd
 */
public class Realisateur extends Personne {
    /** Libelle du Réalisateur (peut être un studio) */
    private String libelle;
    /** Liste des dvd produits pas le Realisateur */
    private List<Dvd> discographie;

    /**
     * Constructeur d'instanciation
     * @param nom Nom de la personne
     * @param prenom Prenom de la personne
     * @param date_naissance Date de naissance de la personne
     * @param age Age de la personne
     * @param libelle Libelle du realisateurd
     */
    public Realisateur(String nom, String prenom, String date_naissance, Integer age, String libelle) {
        super(nom, prenom, date_naissance, age);
        this.libelle = libelle;
        this.discographie = new ArrayList<>();

    }

    /**
     * Accède au libelle du réalisateur
     * @return Libelle du réalisateur
     */
    public String getLibelle() {
        return libelle;
    }

    /**
     * Modifie le libelle du réalisateur
     * @param libelle Libelle du réalisateur
     */
    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    /**
     * Accède à la discographie du réalisateur
     * @return Discographie du réalisateur
     */
    public List<Dvd> getDiscographie() {
        return discographie;
    }
}
