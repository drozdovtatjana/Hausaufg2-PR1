public class u4_4main {
    public static void main(String[] args) {


        u4_4 ubung =new u4_4(4, "standard", 14, 12 );



        System.out.println("Preis pro Bett: " + ubung.preisProBett());
        System.out.println("Preis pro Unterkunft: " + ubung.preisProUnterkunft());
        System.out.println("Preis für 3 gebuchte Betten: " + ubung.preisProBuchung(3));
        ubung.bucheBetten(7);
        System.out.println("Ausgebucht: " + ubung.Ausgebucht());
        System.out.println(ubung);
    }
}
