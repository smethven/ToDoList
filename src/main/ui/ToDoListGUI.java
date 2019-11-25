package ui;

import exceptions.TooManyThingsToDo;
import model.Item;
import model.RegularItem;
import model.ToDoList;
import model.UrgentItem;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ToDoListGUI extends JFrame implements ActionListener {
    private JLabel enterTextLabel;
    private JTextField enterTextField;
    //    private JLabel addUrgentItemLabel;
//    private JTextField addUrgentItemField;
    private ToDoList tdl = new ToDoList();

    public ToDoListGUI() {
        super("To Do List Application");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(400, 200));
        ((JPanel) getContentPane()).setBorder(new EmptyBorder(13, 13, 13, 13));
        setLayout(new FlowLayout());
        GroupLayout layout = new GroupLayout(getContentPane());
        setLayout(layout);
        layout.setAutoCreateContainerGaps(true);
        layout.setAutoCreateGaps(true);
        JButton addItemBtn = setUpButton("Add Item", "addItem");
        JButton addUrgentItemBtn = setUpButton("Add Urgent Item", "addUrgentItem");
        JButton checkOffItemBtn = setUpButton("Check off Item", "checkOffItem");
        enterTextLabel = new JLabel("Enter item text");
        enterTextField = new JTextField();
        layout.setHorizontalGroup(
                layout.createSequentialGroup()
                        .addComponent(enterTextLabel)
                        .addComponent(enterTextField)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(addItemBtn)
                                .addComponent(addUrgentItemBtn)
                                .addComponent(checkOffItemBtn))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(enterTextLabel)
                .addComponent(enterTextField)
                .addGroup(layout.createSequentialGroup()
                .addComponent(addItemBtn)
                .addComponent(addUrgentItemBtn)
                .addComponent(checkOffItemBtn))
        );
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
    }

    private JButton setUpButton(String s, String actionEvent) {
        JButton addItemBtn = new JButton(s);
        addItemBtn.setActionCommand(actionEvent);
        addItemBtn.addActionListener(this);
        return addItemBtn;
    }

    //this is the method that runs when Swing registers an action on an element
    //for which this class is an ActionListener
    public void actionPerformed(ActionEvent e) {
        String text = enterTextField.getText();
        if (e.getActionCommand().equals("addItem")) {
            Item item = new RegularItem();
            item.setItemText(text);
            tryAddItem(item);
        } else if (e.getActionCommand().equals("addUrgentItem")) {
            Item item = new UrgentItem();
            item.setItemText(text);
            tryAddItem(item);
        } else if (e.getActionCommand().equals("checkOffItem")) {
            tdl.checkOffItemWithText(text);
        }
    }

    private void tryAddItem(Item item) {
        try {
            tdl.addItem(item);
        } catch (TooManyThingsToDo tooManyThingsToDo) {
            tooManyThingsToDo.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new ToDoListGUI();
    }
}