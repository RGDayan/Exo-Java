package Mails;

import java.util.Random;

public enum Domaine {
    gmail, hotmail, wanadoo, orange, outlook;

    private static Random rng = new Random();

    public static Domaine RandomDomaine(){
        Domaine[] domaines = values();
        return  domaines[rng.nextInt(domaines.length)];
    }
}
