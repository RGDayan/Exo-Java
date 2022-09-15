package Mails;

public class Mail {
    private Nom nom;
    private Domaine domaine;
    private Complement complement;

    public Mail(Nom nom, Domaine domaine, Complement complement) {
        this.nom = nom;
        this.domaine = domaine;
        this.complement = complement;
    }

    public Nom getNom() {
        return nom;
    }

    public void setNom(Nom nom) {
        this.nom = nom;
    }

    public Domaine getDomaine() {
        return domaine;
    }

    public void setDomaine(Domaine domaine) {
        this.domaine = domaine;
    }

    public Complement getComplement() {
        return complement;
    }

    public void setComplement(Complement complement) {
        this.complement = complement;
    }

    @Override
    public String toString() {
        return this.getNom() + "@" + this.getDomaine() + "." + this.complement;
    }
}
