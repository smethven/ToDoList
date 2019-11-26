package model;

import exceptions.TooManyThingsToDo;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class ToDoList extends AbstractSubject {
    // Each item's key is it's item string
    private Map<String, Item> items;

    public static final int LIST_CAPACITY = 100;

    // CONSTRUCTOR
    public ToDoList() {
        items = new HashMap<>();
        ConcreteObserver observer = new ConcreteObserver();
        addObserver(observer);
    }


    // MODIFIES: this
    // EFFECTS: adds given item to items with it's item string as its key
    public void addItem(Item item) throws TooManyThingsToDo {
        if (!items.values().contains(item)) {
            if (items.size() >= LIST_CAPACITY) {
                throw new TooManyThingsToDo();
            }
            items.put(item.getItemText(), item);
            item.uncheckItem(this);
            notify(this);
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
    // EFFECTS: checks off Item with given itemText, which changes the item's status to true
    public void checkOffItemWithText(String text) {
        Item item = items.get(text);
        item.checkOffItem();
        removeItem(item);
    }

    //EFFECTS: creates a string of all the keys in the items map with a new line between each key
    public String keysForDisplay() {
        Collection<String> keys = getItemKeys();
        String keysForDisplay = "";
        for (String key: keys) {
            keysForDisplay = keysForDisplay.concat(key + "\n");
        }
        return keysForDisplay;
    }

    //MODIFIES: this, Item
    //EFFECTS: creates an Item which gets its text and category from the loaded file
    //         adds the item to this ToDoList's list or throws an exception if there are too many items
    //         does this for each line in the file
    //Uses code from FileReaderWriter
    //@Override
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

    // MODIFIES: PrintWriter
    // EFFECTS: saves the current to do list by saving each item's status, text and category on a line in outputfile
    //Uses code from FileReaderWriter
    //@Override
    public void save() throws FileNotFoundException, UnsupportedEncodingException {
        PrintWriter writer = new PrintWriter("outputfile.txt","UTF-8");
        for (Item i : items.values()) {
            String line = Boolean.toString(i.isCheckedOff()) + "/" + i.getItemText() + "/" + i.getCategory();
            writer.println(line);
        }
        writer.close();
    }

    // EFFECTS: split a string where ever it finds a "/" and puts the splits into a new ArrayList
    //Adapted from FileReaderWriter
    public static ArrayList<String> splitOnSlash(String line) {
        String[] splits = line.split("/", 3);
        return new ArrayList<>(Arrays.asList(splits));
    }
}
