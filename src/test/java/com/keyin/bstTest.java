package com.keyin;

import com.keyin.bst.Bst;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static data.ReadFile.readFile;
import static data.WriteFile.writeFile;

public class bstTest {
    List<Integer> dummyList = new ArrayList<>(Arrays.asList(2,4,1,3,5));

    Bst dummyBST = new Bst(dummyList);
    Bst dummyBST2 = new Bst();

    File file = new File("src/test/java/tempData/DummyData.txt");
    File newFile = new File("src/test/java/tempData/newFilePath.txt");

    @Test
    public void readWriteFileTest(){
        Assertions.assertTrue(writeFile(file, dummyBST));
//        This test ensures it creates a new file :) (if newFilePath.txt is alreadty created the test will still pass)
        Assertions.assertTrue(writeFile(newFile, dummyBST));
    }

    @Test
    public void readFileTest(){
        Assertions.assertFalse(readFile("fakeFileLocation"));
        Assertions.assertTrue(readFile("src/test/java/tempData/DummyData.txt"));
    }

    @Test
    public void bstTest(){
        Assertions.assertTrue(dummyBST.insertList(dummyList));
//        Ensures the BST doesn't equal inserted list
        Assertions.assertNotEquals(dummyList, dummyBST);
        Assertions.assertNotNull(dummyBST.toString());
        Assertions.assertNotEquals(null, dummyBST2);

    }



}
