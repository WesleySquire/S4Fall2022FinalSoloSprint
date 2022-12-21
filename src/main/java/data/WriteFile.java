package data;

import com.keyin.bst.Bst;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.List;

public class WriteFile {
    public static Boolean writeFile(File fileLocation, Bst bst){
        try {
            FileWriter fw = new FileWriter(fileLocation.getAbsoluteFile(), true);
            BufferedWriter bw = new BufferedWriter(fw);
//            Two \n so it formats the saves to not append to previous file and format
//            it to have a blank line in between items
            String strBst = bst.toString() + "\n" + "\n";
            bw.write(strBst);
            bw.close();
            return true;
        } catch (Exception e){
            System.out.println(e);
            return false;
        }
    }

    public static Boolean writeFileList(File fileLocation, List input){
        try {
            FileWriter fw = new FileWriter(fileLocation.getAbsoluteFile(), true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write("Input: " + input + " Output:" + "\n");
            bw.close();
            return true;
        } catch (Exception e){
            System.out.println(e);
            return false;
        }
    }
}
