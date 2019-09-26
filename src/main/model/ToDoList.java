package model;

import java.util.ArrayList;

public class ToDoList {
    private ArrayList<Item> items;

    // CONSTRUCTOR
    public ToDoList() {
        items = new ArrayList<>();
    }

    // SETTERS

    // MODIFIES: this
    // EFFECTS: adds given item to items
    public void addItem(Item item) {
        items.add(item);
    }

    // GETTERS

    // EFFECTS: returns the to do list's items
    public ArrayList<Item> getItems() {
        return this.items;
    }


    // EFFECTS: returns the amount of unchecked items in the ToDoList
    public int howManyLeftToDo() {
        int counter = 0;
        for (Item i : items) {
            if (i.isCheckedOff() == false) {
                counter = counter + 1;
            }
        }
        return counter;
    }


}
