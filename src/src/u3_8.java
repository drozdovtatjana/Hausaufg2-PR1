
//Schreiben Sie ein Programm, welches vom Benutzer eine Zahl n übernimmt. Anschließend sollen vom Benutzer n Wörter in ein Array eingelesen werden. Danach lassen Sie den Benutzer eine weitere Zahl k wählen (größer 0). Es sollen aus dem Array alle Wörter, die kürzer k sind entfernt werden. Zum Schluss geben Sie die übriggebliebenen Elemente des Arrays aus (ohne die gelöschten Stellen).

import java.awt.*;
import java.util.Arrays;
import java.util.Scanner;

public class u3_8 {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.println("Bitte n eigenben: ");
        int n = scan.nextInt();

        String[] worter = new String[n];

        for (int i = 0; i < worter.length; i++) {
            System.out.println("Bitte Wörter in ein Array eingelesen ");
            worter[i] = scan.next();

        }

        System.out.println("Bitte k eigenben: ");
        int k = scan.nextInt();

        int neueGrose = 0;
        for (String wort : worter) {   // if word length is bigger as second input - we are counting it +   to new array
            if (wort.length() > k) {
                neueGrose++;
            }
        }

        String[] gefilterteWorter = new String[neueGrose];  // creating new array with size of length (of quantity words we needed  )
        int index = 0;
        for (String wort : worter) {  // new variable wort, for each word if it is longer than K
            if (wort.length() >k) {
                gefilterteWorter[index] = wort;  // adds word to current index(start position is 0, after we are changing index
                index++; // index is incremented so that the next word (if any) will be assigned to the next position in the gefilterteWorter array
            }
        }

        worter=gefilterteWorter;

        // Ausgabe
        System.out.println("Worter groser als "+ k);
        System.out.println(Arrays.toString(worter));
        /*
        for (String wort : worter) { // for each wort element from  worter(gefilterteWorter) array
            System.out.println(wort); //PRINT IT , EVERY TO EACH LINE
            }*/
        }
}


