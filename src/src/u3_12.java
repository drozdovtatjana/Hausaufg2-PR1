//Schreiben Sie ein Programm, welches mit Hilfe eines 2D Arrays die Noten eines Schülers verwalten kann.
//Im Array werden Noten pro Unterrichtsfach gespeichert.
//Schreiben Sie eine Methode, welche den Notendurchschnitt pro Fach zurückgibt und eine zweite Methode, welche den Notendurchschnitt über alle Fächer zurückgibt.


import java.util.Arrays;

public class u3_12 {

    public static void main(String[] args) {

        float[][] noten = {{3, 5, 1, 2}, {2, 4, 2, 2, 1}, {1, 2, 5, 4, 4}, {1, 2, 3, 4, 5}};


        mittelNoteFach(noten);
        System.out.println("Average fur alle Noten: " + mittelNoteAlle(noten));
    }


    public static void mittelNoteFach(float[][] noten) { //what to do if I want to print out each average separetely
        float[] averages = new float[noten.length];

        for (int i = 0; i < noten.length; i++) {
            int sum = 0;

            for (int j = 0; j < noten[i].length; j++) {
                sum += noten[i][j];
            }

            averages[i] = (float) sum / noten[i].length;
            System.out.println("Average for Fach " + (i + 1) + ": " + averages[i]);
        }
    }

    public static float mittelNoteAlle(float[][] noten) {
        int summ = 0; // to make total summ of notes
        float average = 0;
        int count = 0;

        for (int i = 0; i < noten.length; i++) { //for each array element
             for (int j = 0; j < noten[i].length; j++) { //to access each element in nested array
                 summ += (int) noten[i][j];
                 count++;
             }
                average = (float) summ / count;


            }


        return average;

    }
}