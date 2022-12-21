package com.keyin.bst;

import java.io.File;
import java.util.List;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import static data.WriteFile.writeFile;


public class Bst {

    File file = new File("src/main/java/data/BST.text");

    public class Node {
//        Variables
        public int value;
        public Node left;
        public Node right;

//        constructor
        public Node(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }

    }
//     instance variable
    public Node root;
//     constructor to initialise the root to null
    public Bst() {
        this.root = null;
    }

//    Constructor to enter a list and insert numbers of that list to the bst
    public Bst(List<Integer> listData) {
        for (int i = 0; i < listData.size(); i++){
            insert(listData.get(i));
        }
    }

//     insert method to insert the new data
    public void insert(int newData) {
        this.root = insert(root, newData);
    }

//    insert method to insert a list as data
    public Boolean insertList(List<Integer> listData) {
        for (int i = 0; i < listData.size(); i++){
            insert(listData.get(i));
        }
        return true;
    }

    public Node insert(Node root, int newData) {
        if (root == null) {
            root = new Node(newData);
            return root;
        }
//         Here checking for root value is greater or equal to the newData or not
        else if (root.value >= newData) {
//             if current root value is greater than the new value, the new value goes into the left node of tree
            root.left = insert(root.left, newData);
        } else {
//             if current root value is less than the new value, the new value goes into the right node of tree
            root.right = insert(root.right, newData);
        }
        return root;
    }


    public String toString() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(this.root);
    }

    public boolean saveBST(){
        writeFile(file, this);
        return true;
    }
}
