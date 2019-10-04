package model;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

public interface Saveable {

    //EFFECTS: Saves each item's status, text and category in a to do list on a new line of a file
    public void save() throws FileNotFoundException, UnsupportedEncodingException;
}
