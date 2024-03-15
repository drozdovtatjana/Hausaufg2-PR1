//Schreiben Sie ein Programm, welches den Durchschnittswert eines ganzzahligen Arrays zurückgibt.

public class u3_4 {

    public static void main(String[] args) {
        int[] arrayNew = {1, 4, 6, 3, 7, 9, 5, 111};
        int sum = 0;
        float durch=0f;
        for (int i = 0; i < arrayNew.length; i++) {
            sum = sum + arrayNew[i];
        }

         durch=(float)sum/ arrayNew.length;
        System.out.println(durch);
    }
}
