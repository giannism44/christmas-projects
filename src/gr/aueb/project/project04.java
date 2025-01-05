package gr.aueb.project;

import java.util.Scanner;

public class project04 {

    public static void main(String[] args) {
        int[][] triliza = new int[3][3];
        boolean gamePlay = true;
        int player = 1;

        while (gamePlay) {
            System.out.println("Σείρα του παίχτη: " + player);
            printBoard(triliza);
            if (move(triliza, player)) {
                if (winner(triliza, player)) {
                    printBoard(triliza);
                    System.out.println("Παίχτης " + player + " κέρδισε!!");
                    gamePlay  = false;
                } else if (isDraw(triliza)) {
                    printBoard(triliza);
                    System.out.println("Το παιχνίδι έληξε ισόπαλια");
                    gamePlay = false;
                } else {
                    player = (player == 1) ? 2 : 1;
                }
            }
        }
    }

    public static void printBoard(int[][] triliza) {
        for (int i = 0; i < triliza.length; i++) {
            for (int j = 0; j < triliza.length; j++) {
                System.out.print(triliza[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static boolean move(int[][] triliza, int player) {
        Scanner in = new Scanner(System.in);

        System.out.println("Παρακαλώ εισάγεται την γραμμή στην οποία θέλετε να παίξετε 0-2");
        int row = in.nextInt();
        System.out.println("Παρακαλώ εισάγεται την στήλη στην οποία θέλετε να παίξετε 0-2");
        int col = in.nextInt();

        if (row < 0 || row > 2 || col < 0 || col > 2) {
            System.out.println("Μη έγκυρη τιμή");
            return false;
        }

        if (triliza[row][col] != 0) {
            System.out.println("Η θέση που επιλέται είναι ήδη επιλέγμενη από τον αντίπαλο");
            return false;
        }

        triliza[row][col] = player;
        return true;
    }


    public static boolean winner(int[][] triliza, int player) {

        for (int i = 0; i < triliza.length; i++) {
            if (triliza[i][0] == player && triliza[i][1] == player && triliza[i][2] == player) {
                return true;
            }
        }

        for (int i = 0; i < triliza.length; i++) {
            if (triliza[0][i] == player && triliza[1][i] == player && triliza[2][i] == player) {
                return true;
            }
        }

        if (triliza[0][0] == player && triliza[1][1] == player && triliza[2][2] == player) {
            return true;
        }

        if (triliza[0][2] == player && triliza[1][1] == player && triliza[2][0] == player) {
            return true;
        }

        return false;
    }

    public static boolean isDraw(int[][] triliza) {
        for (int i = 0; i < triliza.length; i++) {
            for (int j = 0; j < triliza[i].length; j++) {
                if (triliza[i][j] == 0) {  // Αν υπάρχει κενή θέση
                    return false;
                }
            }
        }
        return true;
    }
}
