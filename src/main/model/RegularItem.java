package model;


public class RegularItem extends Item {
    public RegularItem() {
        super();
    }

    //MODIFIES: this
    //EFFECTS: changes this to checked off (true), and prints to the console
    @Override
    public void checkOffItem() {
        if (toDoList != null) {
            toDoList.removeItem(this);
            toDoList = null;
            this.status = true;
            System.out.println("Good job!");
        }
    }
}
