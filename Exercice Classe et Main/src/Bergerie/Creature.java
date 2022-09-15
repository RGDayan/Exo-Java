package Bergerie;

/**
 * Classe-mère des créatures vivantes (Animaux et Humains)
 */
public abstract class Creature {
    private String Name;

    private Integer Age;

    /**
     * Constructeur par défaut
     */
    public Creature(){}

    /**
     * Constructeur d'instanciation
     * @param name Nom de l'Bergerie.Animal
     * @param age Age de l'Bergerie.Animal
     */
    public Creature(String name, Integer age) {
        Name = name;
        Age = age;
    }

    /**
     * Retourne le nom de l'Bergerie.Animal
     * @return le nom de l'Bergerie.Animal
     */
    public String getName() {
        return Name;
    }

    /**
     * Modifie le nom de l'Bergerie.Animal
     * @param name le nom de l'Bergerie.Animal
     */
    public void setName(String name) {
        this.Name = name;
    }

    /**
     * Retourne l'age de l'Bergerie.Animal
     * @return l'age de l'Bergerie.Animal
     */
    public Integer getAge() {
        return Age;
    }

    /**
     * Modifie l'age de l'Bergerie.Animal
     * @param age l'age de l'Bergerie.Animal
     */
    public void setAge(Integer age) {
        Age = age;
    }

    /**
     * Retourne la description de l'Bergerie.Animal
     * @return description de l'Bergerie.Animal
     */
    @Override
    public String toString() {
        return this.getName() + " a " + this.getAge() + " ans";
    }
}
