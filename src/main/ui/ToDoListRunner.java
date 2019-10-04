package ui;

import java.io.IOException;
import java.util.Scanner;

import model.Item;
import model.Loadable;
import model.ToDoList;

public class ToDoListRunner {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        ToDoList myToDoList = new ToDoList();
        myToDoList.load("inputfile.txt");

        while (true) {
            String choice = tellUser();

            if (choice.equals("1")) {
                myToDoList.addItem(itemWithText());
            } else if (choice.equals("2")) {
                System.out.println(myToDoList.getItems());
                System.out.println("Which item would you like to check off?");
                String itemText = scanner.nextLine();
                myToDoList.checkOffItemWithText(itemText);
            } else {
                myToDoList.save();
                break;
            }
        }
    }

    private static String askUser() {
        Scanner scanner = new Scanner(System.in);
        String userChoice = "";
        System.out.println("Would you like to: [1] add a to do list item, [2] cross off an item, [3] save and quit");
        userChoice = scanner.nextLine();
        return userChoice;
    }

    private static String tellUser() {
        String choice = askUser();
        System.out.println("You selected " + choice);
        return choice;
    }

    private static Item itemWithText() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter item text");
        String itemText = scanner.nextLine();
        Item newItem = new Item();
        newItem.setItemText(itemText);
        return newItem;
    }

}
