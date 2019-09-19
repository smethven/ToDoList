package ui;

import java.util.ArrayList;
import java.util.List;
import ui.Item;

public class ToDoList {
    private ArrayList<Item> items;

    public ToDoList() {
        items = new ArrayList<>();
    }

    public ArrayList<Item> getItems() {
        return this.items;
    }


    public void addToItems(Item newItem) {
        items.add(newItem);
    }

    public int howManyLeftToDo() {
        int counter = 0;
        for (Item i : items) {
            if (i.getIsCheckedOff() == false) {
                counter = counter + 1;
            }
        }
        return counter;
    }


}
