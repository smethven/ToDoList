package model;

import java.util.ArrayList;
import java.util.List;

public class AbstractSubject {

    private List<AbstractObserver> observers = new ArrayList<>();

    // EFFECTS: calls update on each observer
    public void notify(ToDoList tdl) {
        for (AbstractObserver o : observers) {
            o.update(tdl);
        }
    }

    // MODIFIES: this
    // EFFECTS: adds a new observer to the observers list
    public void addObserver(AbstractObserver observer) {
        observers.add(observer);
    }
}
