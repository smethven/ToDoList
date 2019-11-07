package ui;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

import exceptions.TooManyThingsToDo;
import model.Item;
import model.RegularItem;
import model.ToDoList;
import model.UrgentItem;

public class ToDoListRunner {
    private static ToDoList myToDoList = new ToDoList();

    public static void main(String[] args) {
        try {
            myToDoList.load("inputfile.txt");
        } catch (IOException e) {
            System.out.println("failed to load old list");
        }
        startLoop();
    }

    private static void startLoop() {
        while (true) {
            String choice = tellUser();
            if (choice.equals("1")) {
                tryAddItem();
                continue;
            } else if (choice.equals("2")) {
                checkOffItem();
            } else {
                save();
                break;
            }
        }
    }

    private static void tryAddItem() {
        try {
            myToDoList.addItem(itemWithText());
        } catch (TooManyThingsToDo tooManyThingsToDo) {
            System.out.println("You've got too much to do already! Check off some items");
            return;
        } finally {
            System.out.println("You can do this! Get to work checking off items");
        }
    }

    private static void save() {
        try {
            myToDoList.save();
        } catch (FileNotFoundException e) {
            System.out.println("The file could not be found");
        } catch (UnsupportedEncodingException e) {
            System.out.println("System error");
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
        Item newItem;
        System.out.println("[1] Regular Item or [2] Urgent Item?");
        String choice = scanner.nextLine();
        System.out.println("Enter item text");
        String itemText = scanner.nextLine();
        if (choice.equals("1")) {
            newItem = setupRegularItem(itemText);
        } else {
            newItem = setupUrgentItem(itemText);
        }
        return newItem;
    }

    private static Item setupUrgentItem(String itemText) {
        Item newItem;
        newItem = new UrgentItem();
        newItem.setItemText(itemText);
        return newItem;
    }

    private static Item setupRegularItem(String itemText) {
        Item newItem;
        newItem = new RegularItem();
        newItem.setItemText(itemText);
        return newItem;
    }

    private static void checkOffItem() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Which item would you like to check off?");
        String itemText = scanner.nextLine();
        myToDoList.checkOffItemWithText(itemText);
    }

}
