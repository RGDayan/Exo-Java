package main.Model;

/**
 * DvD : type d'article du magasin
 */
public class Dvd extends Article{
    /** Duree de la video */
    private Integer duree;
    /** Réalisateur de la vidéo */
    private Realisateur realisateur;

    /**
     * Constructeur d'instanciation
     * @param reference Référence de l'article
     * @param designation Désignation de l'article
     * @param prix Prix de l'article
     * @param duree Durée de la vidéo
     * @param realisateur Réalisateur de la vidéo
     */
    public Dvd(String reference, String designation, Integer prix, Integer duree, Realisateur realisateur) {
        super(reference, designation, prix);
        this.duree = duree;
        addRealisateur(realisateur);
    }

    /**
     * Accède à la durée de la vidéo
     * @return Durée de la vidéo
     */
    public Integer getDuree() {
        return duree;
    }

    /**
     * Modifie la durée de la vidéo
     * @param duree Nouvelle durée
     */
    public void setDuree(Integer duree) {
        this.duree = duree;
    }

    /**
     * Accède au réalisateur de la video
     * @return Réalisateur de la video
     */
    public Realisateur getRealisateur() {
        return realisateur;
    }

    /**
     * Ajoute un réalisateur au Dvd (bidirectionnel) et retire le dvd de la discographie de l'ancien réalisateur
     * @param realisateur Nouveau réalisateur
     */
    public void addRealisateur(Realisateur realisateur){
        if (this.realisateur != null) {
            this.realisateur.getDiscographie().remove(this);
        }

        this.realisateur = realisateur;
        realisateur.getDiscographie().add(this);
    }

    /**
     * Construit la description du Dvd
     * @return Description du Dvd
     */
    @Override
    public String toString() {
        return super.toString() + ".\nCe film est réalisé par " + realisateur.getNomComplet() + ", né le " + realisateur.getDate_naissance()+ ", et dure " + this.getDuree() + " minutes.";
    }
}
