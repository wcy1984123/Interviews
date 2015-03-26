package IOOperation;

import java.io.*;
import java.util.Scanner;

/**
 * Project: Interviews
 * Package: IOOperation
 * Date: 22/Mar/2015
 * Time: 00:34
 * System Time: 12:34 AM
 */

public class InputFromFile {

    public void readByBufferReader(String filename) {

        try {
            BufferedReader br = new BufferedReader(new FileReader(filename));
            String line;

            while ((line = br.readLine()) != null) {
                String[] temp = line.split(" ");

                System.out.print("ID: " + temp[0] + " ");
                System.out.print("Name: " + temp[1] + " ");
                System.out.print("Age: " + temp[2] + " ");
                System.out.print("Weight: " + temp[3] + " ");
                System.out.print("Height: " + temp[4] + " ");
                System.out.print("Hobby: " + temp[5] + " ");
                System.out.println();
            }

            br.close();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public void readByScanner(String filename) {

        Scanner sc = null;
        try {
            sc = new Scanner(new File(filename));
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        while(sc.hasNext()) {
            int ID = sc.nextInt();
            String Name = sc.next();
            int Age = sc.nextInt();
            int Weight = sc.nextInt();
            int Height = sc.nextInt();
            String Hobby = sc.next();
            String data = ID + " " + Name + " " + Age + " " + Weight + " " + Height + " " + Hobby + "\n";
            String outputfilename = File.separator + "Users" + File.separator +
                    "wangchiying" + File.separator + "Dropbox" + File.separator + "eworkspace" + File.separator + "My_Cracking_Coding_Interview" +
                    File.separator + "src" + File.separator + "IOOperation" + File.separator + "TestDatasetOutput";
            writeByBufferedWriter(outputfilename, data);
            System.out.println(data);
        }

        sc.close();

    }

    public void writeByBufferedWriter(String filename, String data) {
        try {

            BufferedWriter bw = new BufferedWriter(new FileWriter(filename, true));

            bw.write(data);
            bw.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        InputFromFile test = new InputFromFile();
        String filename = File.separator + "Users" + File.separator +
                "wangchiying" + File.separator + "Dropbox" + File.separator + "eworkspace" + File.separator + "My_Cracking_Coding_Interview" +
                File.separator + "src" + File.separator + "IOOperation" + File.separator + "TestDataset1";
//		test.readByBufferReader(filename);

        System.out.println("==============================================");

        filename = File.separator + "Users" + File.separator +
                "wangchiying" + File.separator + "Dropbox" + File.separator + "eworkspace" + File.separator + "My_Cracking_Coding_Interview" +
                File.separator + "src" + File.separator + "IOOperation" + File.separator + "TestDataset2";
        test.readByScanner(filename);
    }
}
