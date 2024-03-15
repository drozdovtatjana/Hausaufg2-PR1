//Schreiben Sie ein Programm, welches vom Benutzer die Anzahl seiner Noten einholt, anschließend ein entsprechendes
// Array erstellt und es mit Noten vom Benutzer befüllt. Geben Sie den Notendurchschnitt aus.


import java.sql.Array;
import java.util.Arrays;
import java.util.Scanner;

public class u3_5 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("bitte anzahl noten einfuhlen: ");
        int anzahlNoten = scan.nextInt();
        int[] newArray = new int[anzahlNoten];
        int mitt = newArray.length;

        for (int i = 0; i < newArray.length; i++) {
            System.out.println("Bitte Note eingeben: ");
            newArray[i] = scan.nextInt();
        }
        System.out.println(Arrays.toString(newArray));
        int sum = 0;

        for (int i = 0; i < newArray.length; ++i) {
            sum += newArray[i];
        }
        sum = sum / mitt;
        System.out.println("Notendurchschnitt: " + sum);
    }
}
