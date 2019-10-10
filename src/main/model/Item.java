package model;

public abstract class Item {
    protected boolean status; //true for checked off- false for not checked off
    protected String itemText;
    protected String category;

    // Constructor
    public Item() {
        status = false;
        itemText = "";
        category = "general";
    }

    // SETTERS

    // MODIFIES: this
    // EFFECTS: changes this to checked off (true)
    public abstract void checkOffItem();

    // MODIFIES: this
    // EFFECTS: changes this to unchecked off (false)
    public void uncheckItem() {
        this.status = false;
    }

    // MODIFIES: this
    // EFFECTS: sets itemText to inputted itemText
    public void setItemText(String itemText) {
        this.itemText = itemText;
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
}
