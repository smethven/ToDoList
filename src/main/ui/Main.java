package ui;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import ui.Item;
import ui.ToDoList;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ToDoList myToDoList = new ToDoList();
        String userChoice = "";


        while (true) {
            System.out.println("Would you like to: [1] add a to do list item, [2] cross off an item");
            userChoice = scanner.nextLine();
            System.out.println("You selected " + userChoice);

            if (userChoice.equals("1")) {
                System.out.println("Enter item text");
                String itemText = scanner.nextLine();
                Item newItem = new Item();
                newItem.setItemText(itemText);
                myToDoList.addToItems(newItem);
            } else {
                //need to make a getter for items
                //System.out.println(ToDoList.getItems());
                System.out.println("Which item would you like to check off?");
                //create method in Item that is a setter for isCheckedOff
            }
        }
    }

}
