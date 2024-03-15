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
                return 0;  // if we have return in case we dont need break in this case
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
        int tagIndex = tageszahl(tag); // we are adding a day fro method tageszahl
        if (tagIndex != -1) {
            for (int i = 0; i < 3; i++) { // smaller as 3 because max amount for day is 3
                if (messungen[tagIndex][i] == 0.0) { //it checks if the current slot for the measurement (indexed by i) is empty (has a value of 0.0).
                    messungen[tagIndex][i] = messwert; //If an empty slot is found, it assigns the measurement value messwert to that slot in the messungen array (assuming messungen is a 2D array).
                    return;
                }
            }
            System.out.println("Es gibt keinen freien Slot für eine Messung am angegebenen Tag.");//If no empty slot is found after the loop completes, it prints a message saying there are no free slots for a measurement on the specified day.
        } else {
            System.out.println("Ungültiger Tag.");
        }
    }

    public void alleMessungenAmTag(String tag, double[] messwerte) {
        int tagIndex = tageszahl(tag); //It calls a method named tageszahl(tag) to get the index of the specified day.
        if (tagIndex != -1) {//If the returned index is not -1 (indicating that the day is valid), it proceeds with the conditional check.
            if (Arrays.stream(messungen[tagIndex]).allMatch(value -> value == 0.0)) { //checks if all elements of the array corresponding to the specified day (messungen[tagIndex]) are equal to 0.0. This is done using the allMatch method from the Arrays class.
                messungen[tagIndex] = messwerte; //If all elements are 0.0, it assigns the array of measurement values messwerte to that slot in the messungen array (assuming messungen is a 2D array)
            } else {
                System.out.println("Messungen für diesen Tag existieren bereits."); //If any element is not 0.0, it prints a message stating that measurements for that day already exist.

            }
        } else {
            System.out.println("Ungültiger Tag.");
        }
    }

    public double tagesdurchschnitt(String tag) {
        // Get the index of the specified day using the method tageszahl(tag)
        int tagIndex = tageszahl(tag);

        // Check if the returned index is valid (-1 indicates an invalid day)
        if (tagIndex != -1) {
            // Calculate the sum of all measurements for the specified day
            double summe = Arrays.stream(messungen[tagIndex]).sum();

            // Count the number of non-zero measurements for the specified day
            int anzahlMessungen = (int) Arrays.stream(messungen[tagIndex]).filter(value -> value != 0.0).count();

            // If there are any non-zero measurements for the day, return the average of measurements
            if (anzahlMessungen > 0) {
                return summe / anzahlMessungen;
            } else {
                // If there are no measurements for the day, return 0.0
                return 0.0;
            }
        } else {
            // If the specified day is invalid, print an error message and return -1.0
            System.out.println("Ungültiger Tag.");
            return -1.0;
        }
    }

    public double wochendurchschnitt() {
        // Initialize the sum of measurements and the count of non-zero measurements
        double summe = 0.0;
        int anzahlMessungen = 0;

        // Iterate over each day in the messungen array
        for (double[] tagMessungen : messungen) {
            // Iterate over each measurement value for the current day
            for (double messwert : tagMessungen) {
                // Check if the measurement value is non-zero
                if (messwert != 0) {
                    // If non-zero, add the measurement value to the sum
                    summe += messwert;
                    // Increment the count of non-zero measurements
                    anzahlMessungen++;
                }
            }
        }

        // If there are any non-zero measurements, calculate and return the average
        if (anzahlMessungen > 0) {
            return summe / anzahlMessungen;
        } else {
            // If there are no measurements, return 0.0
            return 0.0;
        }
    }
}