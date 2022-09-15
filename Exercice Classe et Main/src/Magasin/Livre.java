package Magasin;

public class Livre extends Article{
    private String isbn;
    private Integer nbPage;
    private Auteur auteur;

    public Livre(String reference, String designation, Integer prix,
                 String isbn, Integer nbPage, Auteur auteur) {
        super(reference, designation, prix);
        this.isbn = isbn;
        this.nbPage = nbPage;
        addAuteur(auteur);
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Integer getNbPage() {
        return nbPage;
    }

    public void setNbPage(Integer nbPage) {
        this.nbPage = nbPage;
    }

    public Auteur getAuteur() {
        return auteur;
    }

    public void setAuteur(Auteur auteur) {
        this.auteur = auteur;
    }

    private void addAuteur(Auteur auteur) {
        this.auteur = auteur;
        auteur.getBibliographie().add(this);
    }

    @Override
    public String toString() {
        return super.toString() + ". \nIl a été écrit par " + auteur.getNom_plume() + ", né le " + auteur.getDate_naissance() + ", et comporte " + this.getNbPage() + " pages.";
    }
}
