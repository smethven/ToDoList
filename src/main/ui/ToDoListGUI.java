package ui;

import apple.laf.JRSUIUtils;
import exceptions.TooManyThingsToDo;
import model.Item;
import model.RegularItem;
import model.ToDoList;
import model.UrgentItem;

import javax.sound.sampled.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class ToDoListGUI extends JFrame implements ActionListener {
    private JLabel enterTextLabel;
    private JTextField enterTextField;
    private JTextArea displayArea;
    private JLabel displayLabel;
    private ToDoList tdl = new ToDoList();

    public ToDoListGUI() {
        super("To Do List Application");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(400, 400));
        ((JPanel) getContentPane()).setBorder(new EmptyBorder(13, 13, 13, 13));
        setLayout(new FlowLayout());
        GroupLayout layout = new GroupLayout(getContentPane());
        setLayout(layout);
        layout.setAutoCreateContainerGaps(true);
        layout.setAutoCreateGaps(true);
        JButton addItemBtn = setUpButton("Add Item", "addItem");
        JButton addUrgentItemBtn = setUpButton("Add Urgent Item", "addUrgentItem");
        JButton checkOffItemBtn = setUpButton("Check off Item", "checkOffItem");
        JButton displayBtn = setUpButton("Display to do list", "display");
        enterTextLabel = new JLabel("Enter item text");
        enterTextField = new JTextField();
        displayArea = new JTextArea();
        displayLabel = new JLabel("To Do List Display Area");
        JScrollPane scrollPane = new JScrollPane(displayArea);
        displayArea.setEditable(false);
        layout.setHorizontalGroup(
                layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                                .addComponent(enterTextLabel)
                                .addComponent(enterTextField)
                                .addComponent(displayLabel)
                                .addComponent(displayArea))
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(addItemBtn)
                                .addComponent(addUrgentItemBtn)
                                .addComponent(checkOffItemBtn)
                                .addComponent(displayBtn))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(enterTextLabel)
                                .addComponent(enterTextField)
                                .addComponent(displayLabel)
                                .addComponent(displayArea))
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(addItemBtn)
                                .addComponent(addUrgentItemBtn)
                                .addComponent(checkOffItemBtn)
                                .addComponent(displayBtn))
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
            playSound();
        } else if (e.getActionCommand().equals("display")) {
            displayArea.setText(tdl.keysForDisplay());
        }
    }

    private void playSound() {
        String soundName = "data/applause3.wav";
        AudioInputStream audioInputStream = null;
        audioInputStream = tryGetAudioInputStream(soundName, audioInputStream);
        Clip clip = null;
        clip = tryGetClip(clip);
        tryOpenClip(audioInputStream, clip);
        clip.start();
    }

    private void tryOpenClip(AudioInputStream audioInputStream, Clip clip) {
        try {
            clip.open(audioInputStream);
        } catch (LineUnavailableException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private Clip tryGetClip(Clip clip) {
        try {
            clip = AudioSystem.getClip();
        } catch (LineUnavailableException ex) {
            ex.printStackTrace();
        }
        return clip;
    }

    private AudioInputStream tryGetAudioInputStream(String soundName, AudioInputStream audioInputStream) {
        try {
            audioInputStream = AudioSystem.getAudioInputStream(new File(soundName).getAbsoluteFile());
        } catch (UnsupportedAudioFileException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return audioInputStream;
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