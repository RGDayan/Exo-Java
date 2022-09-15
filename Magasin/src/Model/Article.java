package Model;

/**
 * Article d'un magasin
 */
public abstract class Article {
    /** Code Reférence de l'article */
    private String reference;
    /** Titre de l'article */
    private String designation;
    /** Prix de l'article en euro */
    private Integer prix;

    /**
     * Constructeur d'instanciation
     * @param reference Référence du produit
     * @param designation Désignation du produit
     * @param prix Prix du produit
     */
    public Article(String reference, String designation, Integer prix) {
        this.reference = reference;
        this.designation = designation;
        this.prix = prix;
    }

    /**
     * Accède à la référence du produit
     * @return référence du produit
     */
    public String getReference() {
        return reference;
    }

    /**
     * Modifie la référence du produit
     * @param reference nouvelle reference
     */
    public void setReference(String reference) {
        this.reference = reference;
    }

    /**
     * Accède à la désignation du produit
     * @return désignation du produit
     */
    public String getDesignation() {
        return designation;
    }

    /**
     * Modifie la designation du produit
     * @param designation nouvelle designation
     */
    public void setDesignation(String designation) {
        this.designation = designation;
    }

    /**
     * Accède au prix du produit
     * @return prix du produit
     */
    public Integer getPrix() {
        return prix;
    }

    /**
     * Modifie le prix du produit
     * @param prix nouveau prix
     */
    public void setPrix(Integer prix) {
        this.prix = prix;
    }

    /**
     * Construit la description de l'article
     * @return description de l'article
     */
    @Override
    public String toString() {
        return "La référence " + this.getReference() + " est un "+ this.getClass().getSimpleName() + " \"" + this.getDesignation() + "\" coutant " + this.getPrix().toString() + "€";
    }
}
