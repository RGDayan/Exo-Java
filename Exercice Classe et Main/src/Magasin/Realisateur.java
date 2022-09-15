package Magasin;

import java.util.ArrayList;
import java.util.List;

public class Realisateur extends Personne {
    private String libelle;
    private List<Dvd> discographie;

    public Realisateur(String nom, String prenom, String date_naissance, Integer age, String libelle) {
        super(nom, prenom, date_naissance, age);
        this.libelle = libelle;
        this.discographie = new ArrayList<>();

    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public List<Dvd> getDiscographie() {
        return discographie;
    }

    public void setDiscographie(List<Dvd> discographie) {
        this.discographie = discographie;
    }
}
