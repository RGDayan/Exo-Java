package Magasin;

public class Personne {
    private String nom;
    private String prenom;
    private String date_naissance;
    private Integer age;

    public Personne(String nom, String prenom, String date_naissance, Integer age) {
        this.nom = nom;
        this.prenom = prenom;
        this.date_naissance = date_naissance;
        this.age = age;
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

    public String getDate_naissance() {
        return date_naissance;
    }

    public void setDate_naissance(String date_naissance) {
        this.date_naissance = date_naissance;
    }

    public String getNomComplet(){
        return  this.getNom() + " " + this.getPrenom();
    }
}
