package gr.aueb.project;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import java.util.Arrays;

public class project01 {

    public static void main(String[] args) {
        try(Scanner in = new Scanner(new File("C:/tmp/lotto.txt"));
            PrintStream ps = new PrintStream("C:/tmp/lotto-out.txt", StandardCharsets.UTF_8)) {

            final int LOTTO_SIZE = 6;
            int[] inPutNumber = new int[49];
            int pivot = 0;
            int num;
            int window ;
            int[] result = new int[LOTTO_SIZE];

            while(in.hasNextInt() && pivot <= 48 ){
                num = in.nextInt();
                inPutNumber[pivot++] = num;
            }

            int[] number = Arrays.copyOfRange(inPutNumber, 0 , pivot);
            Arrays.sort(number);

            window = pivot - LOTTO_SIZE;
            for(int i = 0; i <= window;i++){
                for (int j = i + 1; j <= window + 1; j++){
                    for (int k = j + 1; k <= window + 2; k++){
                        for (int l = k + 1; l <= window + 3; l++){
                            for (int m = l + 1; m <= window + 4; m++){
                                for (int n = m + 1; n <= window + 5; n++){
                                    result[0] = number[i];
                                    result[1] = number[j];
                                    result[2] = number[k];
                                    result[3] = number[l];
                                    result[4] = number[m];
                                    result[5] = number[n];


                                    if (isEven(result, 4) && isOdd(result, 4)&& isConsecutive(result)
                                            && sameEnding(result) && sameTen(result)){
                                        ps.printf("%d %d %d %d %d %d\n", result[0], result[1], result[2], result[3], result[4], result[5]);
                                        System.out.printf("%d %d %d %d %d %d\n", result[0], result[1], result[2], result[3], result[4], result[5]);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static boolean isEven(int[] number, int threshold){
        int count = 0;

        for (int el : number) {
            if (el % 2 == 0) {
                count++;
            }
        }

        return count <= threshold;
    }

    public static boolean isOdd(int[] number, int threshold){
        int count = 0;

        for (int el : number){
            if (el % 2 != 0) count++;
        }

        return count <= threshold;
    }

    public static boolean isConsecutive(int[] number){
        boolean consecutive = true;

        for (int i = 0; i < number.length - 2; i++){
            if (number[i] == number[i + 1] - 1 && number[i] == number[i +2] - 2){
                consecutive = false;
                break;
            }
        }

        return  consecutive;
    }

    public static boolean sameEnding(int[] number){
        int[] ending = new int[10];
        boolean sameEnding = true;

        for (int el : number){
            ending[el % 10]++;
        }

        for (int count : ending){
            if (count > 3){
                sameEnding = false;
                break;
            }
        }
        return sameEnding;
    }

    public static boolean sameTen(int[] number){
        int[] ten = new int[5];
        boolean sameTen = true;

        for (int el : number){
            ten[el/10]++;
        }

        for (int count : ten){
            if (count > 3){
                sameTen = false;
                break;
            }
        }

        return sameTen;
    }
}
