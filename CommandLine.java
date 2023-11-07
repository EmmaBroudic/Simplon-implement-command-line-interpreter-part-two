public class CommandLine {

    // Déclaration de deux champs de type String
    private String fieldOne;
    private String fieldTwo;

    // Constructeur de la classe
    public ExampleFieldsString() {
        // Initialisation des champs
        fieldOne = "Première chaîne";
        fieldTwo = "Deuxième chaîne";

    // Méthode pour afficher les valeurs des champs
    public void printFields() {
        System.out.println("Champ 1 : " + fieldOne);
        System.out.println("Champ 2 : " + fieldTwo);
    }

    public static void main(String[] args) {
        // Création d'une instance de la classe
        ExampleFieldString field = new ExampleFieldsString();

        // Appel de la méthode pour afficher les champs
        field.printFields();
    }
}

/*
public class ExempleChampsString {
    // Déclaration de deux champs de type String
    private String champ1;
    private String champ2;

    // Constructeur de la classe
    public ExempleChampsString() {
        // Initialisation des champs
        champ1 = "Première chaîne";
        champ2 = "Deuxième chaîne";
    }

    // Méthode pour afficher les valeurs des champs
    public void afficherChamps() {
        System.out.println("Champ 1 : " + champ1);
        System.out.println("Champ 2 : " + champ2);
    }

    public static void main(String[] args) {
        // Création d'une instance de la classe
        ExempleChampsString exemple = new ExempleChampsString();

        // Appel de la méthode pour afficher les champs
        exemple.afficherChamps();
    }
}*/