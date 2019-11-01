package model;


public class RegularItem extends Item {
    public RegularItem() {
        super();
    }

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
