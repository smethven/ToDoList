package model;

public class UrgentItem extends Item {
    public UrgentItem() {
        super();
        category = "URGENT!: " + category;
    }

    //MODIFIES: this
    //EFFECTS: changes this to checked off (true), and prints to the console
    @Override
    public void checkOffItem() {
        if (toDoList != null) {
            toDoList.removeItem(this);
            toDoList = null;
            this.status = true;
            System.out.println("Yay! Urgent item complete");
        }
    }

    // MODIFIES: this
    // EFFECTS: sets this.category to inputted category with "URGENT!: " in front
    @Override
    public void setCategory(String category) {
        if (category.contains("URGENT!: ")) {
            this.category = category;
        } else {
            this.category = "URGENT!: " + category;
        }
    }

}
