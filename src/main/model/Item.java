package model;

import exceptions.TooManyThingsToDo;

import java.util.ArrayList;

public abstract class Item {
    protected boolean status; //true for checked off- false for not checked off
    protected String itemText;
    protected String category;
    //if checked off then toDoList should be null.
    protected ToDoList toDoList;

    // Constructor
    public Item() {
        status = false;
        itemText = "";
        category = "general";
        toDoList = new ToDoList();
        try {
            toDoList.addItem(this);
        } catch (TooManyThingsToDo tooManyThingsToDo) {
            tooManyThingsToDo.printStackTrace();
        }
    }

    // SETTERS

    // MODIFIES: this
    // EFFECTS: changes this to checked off (true)
    public abstract void checkOffItem();

    // MODIFIES: this
    // EFFECTS: changes this to unchecked off (false)
    public void uncheckItem(ToDoList tdl) throws TooManyThingsToDo {
        if (toDoList == null) {
            this.status = false;
            toDoList = tdl;
            toDoList.addItem(this);
        }
    }

    public ToDoList getToDoList() {
        return toDoList;
    }

    // MODIFIES: this
    // EFFECTS: sets itemText to inputted itemText
    public void setItemText(String itemText) {
        toDoList.getItems().remove(this.itemText, this);
        this.itemText = itemText;
        toDoList.getItems().put(itemText, this);
    }

    // MODIFIES: this
    // EFFECTS: sets this.category to inputted category
    public void setCategory(String category) {
        this.category = category;
    }

    //GETTERS

    // EFFECTS: returns the status of this item
    public Boolean isCheckedOff() {
        return status;
    }

    // EFFECTS: returns this items text
    public String getItemText() {
        return this.itemText;
    }

    // EFFECTS: returns this items category
    public String getCategory() {
        return this.category;
    }

    //MODIFIES: this
    //EFFECTS: sets up a loaded item with the correct fields
    public void setUpLoadedItem(ArrayList<String> partsOfLine) {
        this.setItemText(partsOfLine.get(1));
        this.setCategory(partsOfLine.get(2));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Item item = (Item) o;

        if (status != item.status) {
            return false;
        }
        if (!itemText.equals(item.itemText)) {
            return false;
        }
        return category.equals(item.category);
    }

    @Override
    public int hashCode() {
        int result = (status ? 1 : 0);
        result = 31 * result + itemText.hashCode();
        result = 31 * result + category.hashCode();
        return result;
    }
}
