import com.keyin.bst.Bst;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static data.ReadFile.readFile;
import static data.WriteFile.writeFileList;

public class Main {
    public static void main(String[] args) {
        final String SET_PLAIN_TEXT = "\033[0;0m";
        final String SET_BOLD_TEXT = "\033[0;1m";

        Scanner input = new Scanner(System.in);
        File file = new File("src/main/java/data/BST.text");

        System.out.println();
        System.out.println(SET_BOLD_TEXT + "Binary Search Tree's" + SET_PLAIN_TEXT);
        System.out.println();
        System.out.println(SET_BOLD_TEXT + "VERSION" + SET_PLAIN_TEXT);
        System.out.println("  1.4");
        System.out.println();
        System.out.println(SET_BOLD_TEXT + "COMMANDS:" + SET_PLAIN_TEXT);
        System.out.println("  1     Retrieve All BST Info");
        System.out.println("  2     Create New BST");
        System.out.println("  3     Documentation");
        System.out.println("  help  Display help for cli");
        System.out.println("  exit  Exit CLI");

        String systemInput = "";
        while (systemInput != "exit") {
            System.out.println();
            System.out.println(SET_BOLD_TEXT + "Input" + SET_PLAIN_TEXT);
            systemInput = input.nextLine();

            switch (systemInput) {
                case "1":
                    readFile("src/main/java/data/BST.text");
                    break;

                case "2":
                    System.out.println(SET_BOLD_TEXT + "Creating New Binary Search Tree..." + SET_PLAIN_TEXT);
                    System.out.println("Enter Number's - Enter -0 to stop");
//          While new member is NOT created keep doing loop
                    Boolean created = false;
                    List<Integer> list = new ArrayList<>(Arrays.asList());
                    while (created != true) {

                        String createInput;
                        createInput = input.nextLine();

                        if (createInput.equals("-0")) {
                            Bst createdBST = new Bst(list);
                            System.out.println(SET_BOLD_TEXT + "Confirm..." + SET_PLAIN_TEXT);
                            System.out.println();
                            System.out.println(createdBST);
                            System.out.println();
                            System.out.println("Y/N");
                            switch (input.nextLine().toLowerCase()) {
                                case "y":
                                    writeFileList(file, list);
                                    createdBST.saveBST();
                                    break;
                                default:
                                    break;
                            }
                            break;
                        } else {
                            list.add(Integer.parseInt(createInput));
                            System.out.println("Added " + createInput);
                        }
                    }
                    break;

                case "3":
                    readFile("src/main/Documentation.txt");
                    break;

                case "help":
                    System.out.println();
                    System.out.println(SET_BOLD_TEXT + "COMMANDS:" + SET_PLAIN_TEXT);
                    System.out.println("  help  Display help for cli");
                    System.out.println("  exit  Exit CLI");
                    System.out.println("  1     Retrieve All BST Info");
                    System.out.println("  2     Create New BST");
                    System.out.println("  3     Documentation");
                    break;

//          Exits program
                case "exit":
                    System.exit(0);
//          Default to unknown command
                default:
                    System.out.println();
                    System.out.println(SET_BOLD_TEXT + "Unknown Command" + SET_PLAIN_TEXT);
                    System.out.println("Use command 'help' for list of commands");
                    break;
            }
        }

    }
}
