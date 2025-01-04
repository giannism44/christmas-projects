package gr.aueb.project;

import java.util.Scanner;

public class project05 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        boolean[][] theatre = new boolean [30][12];
        int choice;
        boolean booking = true;



        while (booking){

            System.out.println("Επιλέξτε μια επιλογή: ");
            System.out.println("1. Κλείσιμο θέσης");
            System.out.println("2. Ακύρωση κράτησης");
            System.out.println("3. Έξοδος");
            System.out.print("Επιλέξτε μια επιλογή: ");
            choice = in.nextInt();

            if (choice == 1){
                System.out.println("Παρακαλώ επιλέψτε την στήλη που επιθυμείτε A-L");
                char column = in.next().charAt(0);
                System.out.println("Παρακαλώ επιλέψτε την γραμμή που επιθυμείτε 1-30");
                int row = in.nextInt();
                book(theatre,column ,row);
            } else if (choice == 2) {
                System.out.println("Παρακαλώ επιλέψτε την στήλη που επιθυμείτε A-L");
                char column = in.next().charAt(0);
                System.out.println("Παρακαλώ επιλέψτε την γραμμή που επιθυμείτε 1-30");
                int row = in.nextInt();
                cancel(theatre, column, row);
            } else if (choice == 3) {
                System.out.println("Έξοδος από το πρόγραμμα");
                booking = false;
            }else{
                System.out.println("Μη εγκυρή τιμή");
            }
        }
    }

    public static void book(boolean[][] theatre,char column, int row){
        int col = column - 'A';

        if (col < 0 || col >= 12 || row <= 0 || row > 30){
            System.out.println("Mη έγκυρη θέση");
            return;
        }

        if (theatre[row - 1 ][col]){
            System.out.println("H θέση: " + column + row + "είναι ήδη κρατημένη");
        }else{
            theatre[row -1 ][col] = true;
            System.out.println("Η θέση: " + column + row + " έχει κρατηθεί");
        }
    }

    public static void cancel (boolean[][] theatre,char column, int row){
        int col = column - 'A';

        if (col < 0  || col >= 12 || row <= 0 || row > 30) {
            System.out.println("Mη έγκυρη θέση");
             return;
        }

        if (!theatre[row -1 ][col]){
            System.out.println("H θέση: " + column + row + " δεν είναι κρατημένη");
        }else{
            theatre[row -1 ][col] = false;
            System.out.println("Η κράτηση σας για την θέση: " + column + row + " ακυρώθηκε");
        }
    }
}
