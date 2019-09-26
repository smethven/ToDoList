package ui;

import java.util.Scanner;

import model.Item;
import model.ToDoList;

public class ToDoListRunner {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ToDoList myToDoList = new ToDoList();

        while (true) {
            String choice = askUser();
            System.out.println("You selected " + choice);

            if (choice.equals("1")) {
                System.out.println("Enter item text");
                String itemText = scanner.nextLine();
                Item newItem = new Item();
                newItem.setItemText(itemText);
                myToDoList.addItem(newItem);
            } else {
                System.out.println(myToDoList.getItems());
                System.out.println("Which item would you like to check off?");
            }
        }
    }

    private static String askUser() {
        Scanner scanner = new Scanner(System.in);
        String userChoice = "";
        System.out.println("Would you like to: [1] add a to do list item, [2] cross off an item");
        userChoice = scanner.nextLine();
        return userChoice;
    }

}
