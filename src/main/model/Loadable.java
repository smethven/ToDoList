package model;

import java.io.IOException;
import java.util.ArrayList;

public interface Loadable {

    //EFFECTS: creates a new item and adds to to do list for each line of a file
    public void load(String file) throws IOException;

}
