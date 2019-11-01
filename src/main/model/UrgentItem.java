package model;

public class UrgentItem extends Item {
    public UrgentItem() {
        super();
        category = "URGENT!: " + category;
    }

    @Override
    public void checkOffItem() {
        if (toDoList != null) {
            toDoList.removeItem(this);
            toDoList = null;
            this.status = true;
            System.out.println("Yay! Urgent item complete");
        }
    }

    @Override
    public void setCategory(String category) {
        if (category.contains("URGENT!: ")) {
            this.category = category;
        } else {
            this.category = "URGENT!: " + category;
        }
    }

}
