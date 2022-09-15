package Mails;


import java.util.Random;

public enum Nom{
    Pierre, Paul, Jacques, Tom, Dick, Harry;

    private static Random rng = new Random();

    public static Nom RandomNom(){
        Nom[] noms = values();
        return  noms[rng.nextInt(noms.length)];
    }
}
