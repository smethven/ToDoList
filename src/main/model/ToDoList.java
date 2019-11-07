package model;

import exceptions.TooManyThingsToDo;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class ToDoList implements Loadable, Saveable {
    // Each item's key is it's item string
    private Map<String, Item> items;

    public static final int LIST_CAPACITY = 100;

    // CONSTRUCTOR
    public ToDoList() {
        items = new HashMap<>();
    }

    // SETTERS

    // MODIFIES: this
    // EFFECTS: adds given item to items with it's item string as its key
    public void addItem(Item item) throws TooManyThingsToDo {
        if (!items.values().contains(item)) {
            if (items.size() >= LIST_CAPACITY) {
                throw new TooManyThingsToDo();
            }
            items.put(item.getItemText(), item);
            item.uncheckItem(this);
        }
    }

    // MODIFIES: this
    // EFFECTS: removes item from the items map, if item isn't found, does nothing
    public void removeItem(Item item) {
        if (items.values().contains(item)) {
            items.remove(item.getItemText());
            item.checkOffItem();
        }

    }

    // GETTERS

    // EFFECTS: returns the to do list's items's keys
    public Collection<String> getItemKeys() {
        return items.keySet();
    }

    public Collection<Item> getItemValues() {
        return items.values();
    }

    public Map<String, Item> getItems() {
        return items;
    }

    // EFFECTS: returns the amount of items in the ToDoList
    public int howManyLeftToDo() {
        return items.size();
    }

    // MODIFIES: this and Item object
    // EFFECTS: checks off Item with given itemText
    public void checkOffItemWithText(String text) {
        Item item = items.get(text);
        item.checkOffItem();
    }


    //Uses code from FileReaderWriter
    @Override
    public void load(String file) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(file));
        for (String line : lines) {
            ArrayList<String> partsOfLine = splitOnSlash(line);
            Item i;
            if (partsOfLine.get(2).contains("URGENT!: ")) {
                i = new UrgentItem();
            } else {
                i = new RegularItem();
            }
            i.setUpLoadedItem(partsOfLine);
            try {
                this.addItem(i);
            } catch (TooManyThingsToDo tooManyThingsToDo) {
                System.out.println("The loaded list had too many items");
            }
        }
    }

    //Uses code from FileReaderWriter
    @Override
    public void save() throws FileNotFoundException, UnsupportedEncodingException {
        PrintWriter writer = new PrintWriter("outputfile.txt","UTF-8");
        for (Item i : items.values()) {
            String line = Boolean.toString(i.isCheckedOff()) + "/" + i.getItemText() + "/" + i.getCategory();
            writer.println(line);
        }
        writer.close();
    }

    //Adapted from FileReaderWriter
    public static ArrayList<String> splitOnSlash(String line) {
        String[] splits = line.split("/", 3);
        return new ArrayList<>(Arrays.asList(splits));
    }
}
