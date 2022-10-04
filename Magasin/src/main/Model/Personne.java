package main.Model;

/**
 * Personne ayant produit un article
 */

public class Personne {
    /** Nom de la personne */
    private String nom;
    /** Prenom de la personne */
    private String prenom;
    /** Date de naissance de la personne */
    private String date_naissance;
    /** Age de la personne */
    private Integer age;

    /**
     * Constructeur d'Instanciation
     * @param nom Nom de la personne
     * @param prenom Prenom de la personne
     * @param date_naissance Date de naissance de la personne
     * @param age Age de la personne
     */
    public Personne(String nom, String prenom, String date_naissance, Integer age) {
        this.nom = nom;
        this.prenom = prenom;
        this.date_naissance = date_naissance;
        this.age = age;
    }

    /**
     * Accède au nom de la personne
     * @return Nom de la personne
     */
    public String getNom() {
        return nom;
    }

    /**
     * Modifie le nom de la personne
     * @param nom Nouveau nom
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Accède au prenom de la personne
     * @return Prenom de la personne
     */
    public String getPrenom() {
        return prenom;
    }

    /**
     * Modifie le prenom de la personne
     * @param prenom Nouveau prenom
     */
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    /**
     * Accède à l'age de la personne
     * @return Age de la personne
     */
    public Integer getAge() {
        return age;
    }

    /**
     * Modifier l'age de la personne
     * @param age Nouvel Age
     */
    public void setAge(Integer age) {
        this.age = age;
    }

    /**
     * Accède à la date de naissance de la personne
     * @return Date de naissance de la personne
     */
    public String getDate_naissance() {
        return date_naissance;
    }

    /**
     * Modifie la date de naissance de la personne
     * @param date_naissance Nouvelle date de naissance
     */
    public void setDate_naissance(String date_naissance) {
        this.date_naissance = date_naissance;
    }

    /**
     * Construit et retourne le nom complet de la personne
     * @return Nom complet de la personne
     */
    public String getNomComplet(){
        return  this.getNom() + " " + this.getPrenom();
    }
}
