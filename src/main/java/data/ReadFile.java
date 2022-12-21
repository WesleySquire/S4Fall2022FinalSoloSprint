package data;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadFile {
    public static Boolean readFile(String fileLocation) {
        try {
            System.out.println();
            FileReader reader = new FileReader(fileLocation);
            BufferedReader bufferedReader = new BufferedReader(reader);

            String line;

            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
            reader.close();
            return true;
        } catch (IOException e) {
            System.out.println("Cannot Find File Location");
            e.printStackTrace();
            return false;
        }
    }
}
