package model;

public interface AbstractObserver {

    // EFFECTS: update the observers- prints the size of the ToDoList
    public void update(ToDoList tdl);
}
