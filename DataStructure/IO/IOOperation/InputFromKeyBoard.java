package IOOperation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Project: Interviews
 * Package: IOOperation
 * Date: 22/Mar/2015
 * Time: 00:34
 * System Time: 12:34 AM
 */

public class InputFromKeyBoard {

    public void readByBufferReader() {

        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String temp = "";

            while(!temp.equals("#")) {

                System.out.println("Please input a number : ");
                temp = br.readLine();
                System.out.println(temp);
            }

            System.out.println("Input is finished.");

        } catch (IOException e) {

            e.printStackTrace();
        }


    }

    public void readByScanner() {

        Scanner sc = new Scanner(System.in);
        System.out.println("Please input value:");

        while(sc.hasNextLine()) {
            String temp = sc.nextLine();
            System.out.println(temp);

            // Scanner's nextline would be infinite loop when System.in works as input
            // Therefore it is necessary to set up a stopping condition
            if(temp.equals("#")) {
                System.out.println("Input is finished.");
                break;
            }
        }

    }

    public static void main(String[] args) {
        InputFromKeyBoard test = new InputFromKeyBoard();
//		test.readByBufferReader();
        test.readByScanner();
    }
}

