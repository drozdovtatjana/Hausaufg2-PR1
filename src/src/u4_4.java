//Erstellen Sie eine Klasse Unterkunft.
//Die Klasse hat folgende Attribute: bettenProStockwerk (int), stockwerke (int), typ (String), anzahlBesetzt (int).
//Generieren Sie einen Konstruktor.
//Die Klasse hat folgende Methoden:
//preisProBett()
//Gibt einen double Wert zurück anhand des Typs („luxus“ -> 105.4, „standard“ -> 57.5, „lowcost“ -> 25)
//preisProUnterkunft()
//Gibt den Preis für die Buchung einer ganzen Unterkunft an -> Anzahl Betten pro Stockwerk * Anzahl Stockwerke * Preis pro Bett
//preisProBuchung(int betten)
//Gibt den Preis für eine Buchung von bestimmter Anzahl von Betten zurück
//bucheBetten(int betten)
//Wenn es noch genügend freie Betten gibt soll die Variable ‚besetzt‘ um die Anzahl von gebuchten Betten erhöht werden
//Es soll eine entsprechende Ausgabe erfolgen
//Ausgebucht()
//Die Methode soll zurückgeben, ob die Unterkunft bereits völlig ausgebucht ist
//Testen Sie Ihre Klasse in einer main.


public class u4_4 {
    static int anzahlBesetzt;

    static int stockwerke;

    static String typ;

    static int bettenProStockwerk;


    public u4_4(int stockwerke, String typ, int anzahlBesetzt, int bettenProStockwerk) {
        this.stockwerke = stockwerke;
        this.typ = typ;
        this.anzahlBesetzt = anzahlBesetzt;
        this.bettenProStockwerk = bettenProStockwerk;
    }

    public static double preisProBett() {
        double price = 0;
        if (typ.equals("luxus")) {
            price = 105.4;
        } else if (typ.equals("standard")) {
            price = 57.5;
        } else if (typ.equals("lowcost")) {
            price = 25;
        }
        return price;
    }

    public static double preisProUnterkunft() {

        return bettenProStockwerk * stockwerke * preisProBett();
    }


    public static int preisProBuchung(int bettenGebucht) {
       return (int) (bettenGebucht* preisProBett());
    }

    public void bucheBetten(int betten) {
        if (anzahlBesetzt + betten <= bettenProStockwerk * stockwerke) {
            anzahlBesetzt += betten;
            System.out.println("Buchung erfolgreich!");
        } else {
            System.out.println("Nicht genügend Betten frei!");
        }
    }

    public static Boolean Ausgebucht() {
            return anzahlBesetzt >= bettenProStockwerk * stockwerke;

        }

    @Override
    public String toString() {
        return "Unterkunft" +
                "bettenProStockwerk=" + bettenProStockwerk +
                ", stockwerke=" + stockwerke +
                ", typ='" + typ +
                ", anzahlBesetzt=" + anzahlBesetzt;
    }
}
