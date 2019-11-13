package model;

public class ConcreteObserver implements AbstractObserver {

    @Override
    public void update(ToDoList tdl) {
        System.out.println("Your ToDo List now has " + tdl.getItems().size() + " items");

    }
}
