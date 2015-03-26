package IOOperation;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Project: Interviews
 * Package: IOOperation
 * Date: 22/Mar/2015
 * Time: 00:34
 * System Time: 12:34 AM
 */

public class GetRelativePath {

    public void readFileByBufferedReader(String filename) {
        BufferedReader br = null;

        try {
            br = new BufferedReader(new FileReader(filename));
            String str = "";
            while ((str = br.readLine()) != null) {
                System.out.println(str);
            }

            br.close();
        } catch(IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        GetRelativePath test = new GetRelativePath();
        String filepath = new File("").getAbsolutePath();

        String filename = File.separator + "src" + File.separator + "IOOperation" + File.separator + "TestDataset1";
        filepath = filepath + filename;

        test.readFileByBufferedReader(filepath);
    }
}
