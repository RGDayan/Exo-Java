package Bergerie;

public class Chat extends Animal {
    /**
     * Constructeur par défaut
     */
    public Chat(){ super(); }

    /**
     * Constructeur d'instanciation
     * @param name Nom du chat
     * @param age Age du chat
     */
    public Chat(String name, Integer age) {
        super(name, age);
    }

    /**
     * Fait miauler le Bergerie.Chat
     * @return
     */
    public String Miaule(){
        return "Miaou !!!";
    }

    @Override
    public String toString() {
        return super.toString() + " et peut faire : \"" + this.Miaule() + "\"";
    }
}
