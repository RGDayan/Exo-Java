package Bergerie;

public abstract class Animal extends Creature{
    private Maitre maitre;

    public Animal(){}

    public Animal(Maitre maitre) {
        this.maitre = maitre;
    }

    public Animal(String name, Integer age) {
        super(name, age);
    }

    public Animal(String name, Integer age, Maitre maitre) {
        super(name, age);
        this.maitre = maitre;
    }

    public Maitre getMaitre() {
        return maitre;
    }

    public void setMaitre(Maitre maitre) {
        this.maitre = maitre;
    }
}
