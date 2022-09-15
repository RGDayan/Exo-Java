package Bergerie;

public class Chien extends Animal {

    public Chien(){
        super();
    }

    /**
     * Constructeur d'instanciation du Bergerie.Maitre
     */
    public Chien(Maitre maitre){
        super(maitre);
    }

    /**
     * Constructeur d'instanciation du Bergerie.Chien
     * @param name Nom du Bergerie.Chien
     * @param age Age du Bergerie.Chien
     */
    public Chien(String name, Integer age) {
        super(name, age);
    }

    /**
     * Constructeur d'instanciation du Bergerie.Chien
     * @param name Nom du Bergerie.Chien
     * @param age Age du Bergerie.Chien
     * @param maitre Bergerie.Maitre du Bergerie.Chien
     */
    public Chien(String name, Integer age, Maitre maitre) {
        super(name, age, maitre);
    }

    /**
     * Fait aboyer le Bergerie.Chien
     * @return
     */
    public String Aboie(){
        return "Ouaf !!!";
    }

    @Override
    public String toString() {
        return super.toString() + " et peut faire : \"" + this.Aboie() + "\"";
    }
}
