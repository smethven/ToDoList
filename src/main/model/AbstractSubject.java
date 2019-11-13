package model;

import java.util.ArrayList;
import java.util.List;

public class AbstractSubject {

    private List<AbstractObserver> observers = new ArrayList<>();

    public void notify(ToDoList tdl) {
        for (AbstractObserver o : observers) {
            o.update(tdl);
        }
    }

    public void addObserver(AbstractObserver observer) {
        observers.add(observer);
    }
}
