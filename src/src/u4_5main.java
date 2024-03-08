public class u4_5main {
    public static void main(String[] args) {
       u4_5 messungen = new u4_5(new double[7][3], 1);

        messungen.messungAmTag("Montag", 25.5);
        messungen.messungAmTag("Montag", 26.0);
        messungen.messungAmTag("Montag", 24.0);

        double[] dienstagMessungen = {22.0, 21.5, 23.0};
        messungen.alleMessungenAmTag("Dienstag", dienstagMessungen);

        System.out.println("Tagesdurchschnitt Montag: " + messungen.tagesdurchschnitt("Montag"));
        System.out.println("Tagesdurchschnitt Dienstag: " + messungen.tagesdurchschnitt("Dienstag"));
        System.out.println("Wochendurchschnitt: " + messungen.wochendurchschnitt());
    }
}

