package Model;

/**
 * Livre : type d'article du magasin
 */
public class Livre extends Article{
    /** Identificateur international du livre */
    private String isbn;
    /** Nombre de page du livre */
    private Integer nbPage;
    /** Auteur du livre*/
    private Auteur auteur;

    /**
     * Constructeur d'instanciation
     * @param reference Référence de l'article
     * @param designation Désignation de l'article
     * @param prix Prix de l'article
     * @param isbn Identificateur international du livre
     * @param nbPage Nombre de page du livre
     * @param auteur Auteur du livre
     */
    public Livre(String reference, String designation, Integer prix,
                 String isbn, Integer nbPage, Auteur auteur) {
        super(reference, designation, prix);
        this.isbn = isbn;
        this.nbPage = nbPage;
        addAuteur(auteur);
    }

    /**
     * Accède à l'identificateur du livre
     * @return Identificateur du livre
     */
    public String getIsbn() {
        return isbn;
    }

    /**
     * Modifie l'identificateur du livre
     * @param isbn Nouvel identificateur
     */
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    /**
     * Accède au nombre de pages du livre
     * @return Nombre de page du livre
     */
    public Integer getNbPage() {
        return nbPage;
    }

    /**
     * Modifie le nombre de page du livre
     * @param nbPage Nouveau nombre de pages
     */
    public void setNbPage(Integer nbPage) {
        this.nbPage = nbPage;
    }

    /**
     * Accède à l'auteur du livre
     * @return Auteur du livre
     */
    public Auteur getAuteur() {
        return auteur;
    }

    /**
     * Change l'auteur du livre (bidirectionnel) et retire le livre de la bibliographie de l'ancien auteur
     * @param auteur
     */
    private void addAuteur(Auteur auteur) {
        if (this.auteur != null) {
            this.auteur.getBibliographie().remove(this);
        }

        this.auteur = auteur;
        auteur.getBibliographie().add(this);
    }

    /**
     * Contruit la description du Livre
     * @return Description du Livre
     */
    @Override
    public String toString() {
        return super.toString() + ". \nIl a été écrit par " + auteur.getNom_plume() + ", né le " + auteur.getDate_naissance() + ", et comporte " + this.getNbPage() + " pages.";
    }
}
