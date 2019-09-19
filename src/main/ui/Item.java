package ui;

public class Item {
    private int label;
    private boolean isCheckedOff;
    private String itemText;

    public Item() {
        label = 0;
        isCheckedOff = false;
        itemText = "";

    }

    public void setItemText(String itemText) {
        this.itemText = itemText;
    }

    public Boolean getIsCheckedOff() {
        return isCheckedOff;
    }


}
