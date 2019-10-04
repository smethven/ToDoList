package model;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ToDoList implements Loadable, Saveable {
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

    // MODIFIES: this and Item object
    // EFFECTS: checks off Item with given itemText
    public void checkOffItemWithText(String text) {
        for (Item i : items) {
            if (i.getItemText() == text) {
                i.checkOffItem();
            }
        }

    }


    //Uses code from FileReaderWriter
    @Override
    public void load(String file) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(file));
        for (String line : lines) {
            ArrayList<String> partsOfLine = splitOnSpace(line);
            Item i = new Item();
            if (partsOfLine.get(0).equals("true")) {
                i.checkOffItem();
            }
            i.setItemText(partsOfLine.get(1));
            i.setCategory(partsOfLine.get(2));
            this.addItem(i);
        }
    }

    //Uses code from FileReaderWriter
    @Override
    public void save() throws FileNotFoundException, UnsupportedEncodingException {
        PrintWriter writer = new PrintWriter("outputfile.txt","UTF-8");
        for (Item i : this.items) {
            String line = Boolean.toString(i.isCheckedOff()) + " " + i.getItemText() + " " + i.getCategory();
            writer.println(line);
        }
        writer.close();
    }

    //Taken from FileReaderWriter
    public static ArrayList<String> splitOnSpace(String line) {
        String[] splits = line.split(" ", 3);
        return new ArrayList<>(Arrays.asList(splits));
    }
}
