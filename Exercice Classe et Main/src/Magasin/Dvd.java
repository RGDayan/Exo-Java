package Magasin;

public class Dvd extends Article{
    private Integer duree;
    private Realisateur realisateur;

    public Dvd(String reference, String designation, Integer prix, Integer duree, Realisateur realisateur) {
        super(reference, designation, prix);
        this.duree = duree;
        addRealisateur(realisateur);
    }

    public Integer getDuree() {
        return duree;
    }

    public void setDuree(Integer duree) {
        this.duree = duree;
    }

    public Realisateur getRealisateur() {
        return realisateur;
    }

    public void setRealisateur(Realisateur realisateur) {
        this.realisateur = realisateur;
    }

    public void addRealisateur(Realisateur realisateur){
        this.realisateur = realisateur;
        realisateur.getDiscographie().add(this);
    }

    @Override
    public String toString() {
        return super.toString() + ".\nCe film est réalisé par " + realisateur.getNomComplet() + ", né le " + realisateur.getDate_naissance()+ ", et dure " + this.getDuree() + " minutes.";
    }
}
