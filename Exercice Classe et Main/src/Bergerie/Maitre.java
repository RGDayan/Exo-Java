package Bergerie;

import java.util.ArrayList;
import java.util.List;

public class Maitre extends Creature {
    private List<Animal> animaux;

    public Maitre(){
        this.animaux = new ArrayList<>();
    }

    public Maitre(List<Animal> animals) {
        this.animaux = animals;
    }

    public Maitre(String name, Integer age, List<Animal> animals) {
        super(name, age);
        this.animaux = animals;
    }

    @Override
    public String toString() {
        StringBuilder description = new StringBuilder(super.toString());
        description.append(" et il a " + animaux.stream().count() + " animaux : ");



        for (Animal animal: animaux) {
            description.append( "\n    - " + animal.toString());
        }

        return description.toString();
    }
}
