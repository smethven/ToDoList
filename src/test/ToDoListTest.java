import model.Item;
import model.ToDoList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.omg.CORBA.PUBLIC_MEMBER;

import static org.junit.jupiter.api.Assertions.*;

public class ToDoListTest {
    ToDoList tdl;
    Item i1;
    Item i2;
    Item i3;
    Item i4;
    Item i5;
    Item i6;
    Item i7;
    Item i8;
    Item i9;

    @BeforeEach
    public void setup() {
        tdl = new ToDoList();
        i1 = new Item();
        i2 = new Item();
        i3 = new Item();
        i4 = new Item();
        i5 = new Item();
        i6 = new Item();
        i7 = new Item();
        i8 = new Item();
        i9 = new Item();
    }


    @Test
    public void addOneItemTest() {
        tdl.addItem(i1);
        assertEquals(1, tdl.getItems().size());
        assertTrue(tdl.getItems().contains(i1));
    }

    @Test
    public void addThreeItemsTest() {
        tdl.addItem(i1);
        tdl.addItem(i2);
        tdl.addItem(i3);
        assertEquals(3, tdl.getItems().size());
        assertTrue(tdl.getItems().contains(i1));
        assertTrue(tdl.getItems().contains(i2));
        assertTrue(tdl.getItems().contains(i3));
    }

    @Test
    public void addManyItemsTest() {
        tdl.addItem(i1);
        tdl.addItem(i2);
        tdl.addItem(i3);
        tdl.addItem(i4);
        tdl.addItem(i5);
        tdl.addItem(i6);
        tdl.addItem(i7);
        tdl.addItem(i8);
        tdl.addItem(i9);
        assertEquals(9, tdl.getItems().size());
        assertTrue(tdl.getItems().contains(i1));
        assertTrue(tdl.getItems().contains(i2));
        assertTrue(tdl.getItems().contains(i3));
        assertTrue(tdl.getItems().contains(i4));
        assertTrue(tdl.getItems().contains(i5));
        assertTrue(tdl.getItems().contains(i6));
        assertTrue(tdl.getItems().contains(i7));
        assertTrue(tdl.getItems().contains(i8));
        assertTrue(tdl.getItems().contains(i9));
    }


    @Test
    public void getEmptyListTest() {
        assertEquals(0,tdl.getItems().size());
    }

    @Test
    public void getOneItemTest() {
        tdl.addItem(i1);
        assertEquals(1, tdl.getItems().size());
        assertTrue(tdl.getItems().contains(i1));
    }
    @Test
    public void getThreeItemsTest() {
        tdl.addItem(i1);
        tdl.addItem(i2);
        tdl.addItem(i3);
        assertEquals(3, tdl.getItems().size());
        assertTrue(tdl.getItems().contains(i1));
        assertTrue(tdl.getItems().contains(i2));
        assertTrue(tdl.getItems().contains(i3));
    }

    @Test
    public void getManyItemsTest() {
        tdl.addItem(i1);
        tdl.addItem(i2);
        tdl.addItem(i3);
        tdl.addItem(i4);
        tdl.addItem(i5);
        tdl.addItem(i6);
        tdl.addItem(i7);
        tdl.addItem(i8);
        tdl.addItem(i9);
        assertEquals(9, tdl.getItems().size());
        assertTrue(tdl.getItems().contains(i1));
        assertTrue(tdl.getItems().contains(i2));
        assertTrue(tdl.getItems().contains(i3));
        assertTrue(tdl.getItems().contains(i4));
        assertTrue(tdl.getItems().contains(i5));
        assertTrue(tdl.getItems().contains(i6));
        assertTrue(tdl.getItems().contains(i7));
        assertTrue(tdl.getItems().contains(i8));
        assertTrue(tdl.getItems().contains(i9));
    }

    @Test
    public void noneLeftTest() {
        assertEquals(0, tdl.howManyLeftToDo());
    }

    @Test
    public void oneLeftTest() {
        tdl.addItem(i1);
        assertEquals(1, tdl.howManyLeftToDo());
    }

    @Test
    public void threeLeftTest() {
        tdl.addItem(i1);
        tdl.addItem(i2);
        tdl.addItem(i3);
        assertEquals(3, tdl.howManyLeftToDo());
    }

    @Test
    public void manyLeftTest() {
        tdl.addItem(i1);
        tdl.addItem(i2);
        tdl.addItem(i3);
        tdl.addItem(i4);
        tdl.addItem(i5);
        tdl.addItem(i6);
        tdl.addItem(i7);
        tdl.addItem(i8);
        tdl.addItem(i9);
        assertEquals(9, tdl.howManyLeftToDo());
    }


    //TEST CASES FOR CHECK OFF ITEM WITH TEXT
    //TODO: end of list

    @Test
    public void checkOffItemsWithSameTextTest() {
        tdl.addItem(i1);
        tdl.addItem(i2);
        tdl.addItem(i3);
        tdl.addItem(i4);
        tdl.addItem(i5);
        tdl.addItem(i6);
        tdl.addItem(i7);
        tdl.addItem(i8);
        tdl.addItem(i9);
        i1.setItemText("a");
        i2.setItemText("a");
        tdl.checkOffItemWithText("a");
        assertTrue(i1.isCheckedOff());
        assertTrue(i2.isCheckedOff());
    }

    @Test
    public void checkOffFirstItem() {
        tdl.addItem(i1);
        tdl.addItem(i2);
        tdl.addItem(i3);
        tdl.addItem(i4);
        tdl.addItem(i5);
        tdl.addItem(i6);
        tdl.addItem(i7);
        tdl.addItem(i8);
        tdl.addItem(i9);
        i1.setItemText("a");
        tdl.checkOffItemWithText("a");
        assertTrue(i1.isCheckedOff());
    }

    @Test
    public void checkOffMidItem() {
        tdl.addItem(i1);
        tdl.addItem(i2);
        tdl.addItem(i3);
        tdl.addItem(i4);
        tdl.addItem(i5);
        tdl.addItem(i6);
        tdl.addItem(i7);
        tdl.addItem(i8);
        tdl.addItem(i9);
        i5.setItemText("a");
        tdl.checkOffItemWithText("a");
        assertTrue(i5.isCheckedOff());
    }

    @Test
    public void checkOffLastItem() {
        tdl.addItem(i1);
        tdl.addItem(i2);
        tdl.addItem(i3);
        tdl.addItem(i4);
        tdl.addItem(i5);
        tdl.addItem(i6);
        tdl.addItem(i7);
        tdl.addItem(i8);
        tdl.addItem(i9);
        i9.setItemText("a");
        tdl.checkOffItemWithText("a");
        assertTrue(i9.isCheckedOff());
    }

}
