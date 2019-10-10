package model;


public class RegularItem extends Item {
    public RegularItem() {
        super();
    }

    @Override
    public void checkOffItem() {
        this.status = true;
        System.out.println("Good job!");

    }
}
