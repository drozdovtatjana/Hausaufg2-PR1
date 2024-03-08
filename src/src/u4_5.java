//Erstellen Sie eine Klasse Messungen, welche Temperaturen in einer Woche abspeichert (3 Messungen pro Tag möglich).
//Die Klasse hat folgende Attribute: double[][] messungen (7 * 3 Elemente), int woche.
//Generieren Sie einen Konstruktor.
//Die Klasse hat folgende Methoden:
//Tageszahl(String tag)
//Die Methode soll für „Montag“ 0, für „Dienstag“ 1, usw. bis „Sonntag“ 6 zurückgeben
//messungAmTag(String tag, double messwert)
//Es soll im messungen-Array der messwert gespeicher werden, falls es bei dem Tag noch einen freien Slot gibt (freier Slot -> Wert auf default 0.0 -> arbeiten Sie mit Werten > 0 beim Befüllen)
//alleMessungenAmTag(String tag, double[] messwerte)
//Wenn an einem Tag noch keine Messungen gespeichert wurden, sollen im messungen-Array an Index, der dem übergebenen Tag entspricht, die ebenfalls übergebenen messwerte gespeichert werden
//Tagesdurchschnitt(String tag)
//Gibt den Temperatur-Durchschnitt am übergebenen Tag zurück
//Wochendurchschnitt()
//Gibt den Temperatur-Durchschnitt der gesamten Woche zurück
//Testen Sie Ihre Klasse in einer main.

import java.util.Arrays;

public class u4_5 {
    private double[][] messungen;
    private int woche;

    public u4_5(double[][] messungen, int woche) {
        this.messungen = new double[7][3];
        this.woche = woche;
    }

    public int tageszahl(String tag) {
        tag = tag.toLowerCase();
        switch (tag) {
            case "montag":
                return 0;
            case "dienstag":
                return 1;
            case "mittwoch":
                return 2;
            case "donnerstag":
                return 3;
            case "freitag":
                return 4;
            case "samstag":
                return 5;
            case "sonntag":
                return 6;
            default:
                return -1;
        }
    }

    public void messungAmTag(String tag, double messwert) {
        int tagIndex = tageszahl(tag);
        if (tagIndex != -1) {
            for (int i = 0; i < 3; i++) {
                if (messungen[tagIndex][i] == 0.0) {
                    messungen[tagIndex][i] = messwert;
                    return;
                }
            }
            System.out.println("Es gibt keinen freien Slot für eine Messung am angegebenen Tag.");
        } else {
            System.out.println("Ungültiger Tag.");
        }
    }

    public void alleMessungenAmTag(String tag, double[] messwerte) {
        int tagIndex = tageszahl(tag);
        if (tagIndex != -1) {
            if (Arrays.stream(messungen[tagIndex]).allMatch(value -> value == 0.0)) {
                messungen[tagIndex] = messwerte;
            } else {
                System.out.println("Messungen für diesen Tag existieren bereits.");
            }
        } else {
            System.out.println("Ungültiger Tag.");
        }
    }

    public double tagesdurchschnitt(String tag) {
        int tagIndex = tageszahl(tag);
        if (tagIndex != -1) {
            double summe = Arrays.stream(messungen[tagIndex]).sum();
            int anzahlMessungen = (int) Arrays.stream(messungen[tagIndex]).filter(value -> value != 0.0).count();
            if (anzahlMessungen > 0) {
                return summe / anzahlMessungen;
            } else {
                return 0.0;
            }
        } else {
            System.out.println("Ungültiger Tag.");
            return -1.0;
        }
    }

    public double wochendurchschnitt() {
        double summe = 0.0;
        int anzahlMessungen = 0;
        for (double[] tagMessungen : messungen) {
            for (double messwert : tagMessungen) {
                if (messwert != 0.0) {
                    summe += messwert;
                    anzahlMessungen++;
                }
            }
        }
        if (anzahlMessungen > 0) {
            return summe / anzahlMessungen;
        } else {
            return 0.0;
        }
    }
}