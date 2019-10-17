import exceptions.TooManyThingsToDo;
import model.Item;
import model.RegularItem;
import model.ToDoList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static model.ToDoList.LIST_CAPACITY;
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
        i1 = new RegularItem();
        i2 = new RegularItem();
        i3 = new RegularItem();
        i4 = new RegularItem();
        i5 = new RegularItem();
        i6 = new RegularItem();
        i7 = new RegularItem();
        i8 = new RegularItem();
        i9 = new RegularItem();
    }

    public void addNineWithTryCatch() {
        try {
            tdl.addItem(i1);
        } catch (TooManyThingsToDo tooManyThingsToDo) {
            fail();
        }
        try {
            tdl.addItem(i2);
        } catch (TooManyThingsToDo tooManyThingsToDo) {
            fail();
        }
        try {
            tdl.addItem(i3);
        } catch (TooManyThingsToDo tooManyThingsToDo) {
            fail();
        }
        try {
            tdl.addItem(i4);
        } catch (TooManyThingsToDo tooManyThingsToDo) {
            fail();
        }
        try {
            tdl.addItem(i5);
        } catch (TooManyThingsToDo tooManyThingsToDo) {
            fail();
        }
        try {
            tdl.addItem(i6);
        } catch (TooManyThingsToDo tooManyThingsToDo) {
            fail();
        }
        try {
            tdl.addItem(i7);
        } catch (TooManyThingsToDo tooManyThingsToDo) {
            fail();
        }
        try {
            tdl.addItem(i8);
        } catch (TooManyThingsToDo tooManyThingsToDo) {
            fail();
        }
        try {
            tdl.addItem(i9);
        } catch (TooManyThingsToDo tooManyThingsToDo) {
            fail();
        }

    }


    @Test
    public void addOneItemTest() {
        try {
            tdl.addItem(i1);
        } catch (TooManyThingsToDo tooManyThingsToDo) {
            fail();
        }
        assertEquals(1, tdl.getItems().size());
        assertTrue(tdl.getItems().contains(i1));
    }

    @Test
    public void addThreeItemsTest() {
        try {
            tdl.addItem(i1);
        } catch (TooManyThingsToDo tooManyThingsToDo) {
            fail();
        }
        try {
            tdl.addItem(i2);
        } catch (TooManyThingsToDo tooManyThingsToDo) {
            fail();
        }
        try {
            tdl.addItem(i3);
        } catch (TooManyThingsToDo tooManyThingsToDo) {
            fail();
        }
        assertEquals(3, tdl.getItems().size());
        assertTrue(tdl.getItems().contains(i1));
        assertTrue(tdl.getItems().contains(i2));
        assertTrue(tdl.getItems().contains(i3));
    }

    @Test
    public void addManyItemsTest() {
        addNineWithTryCatch();
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
        assertEquals(0, tdl.getItems().size());
    }

    @Test
    public void getOneItemTest() {
        try {
            tdl.addItem(i1);
        } catch (TooManyThingsToDo tooManyThingsToDo) {
            fail();
        }
        assertEquals(1, tdl.getItems().size());
        assertTrue(tdl.getItems().contains(i1));
    }

    @Test
    public void getThreeItemsTest() {
        try {
            tdl.addItem(i1);
        } catch (TooManyThingsToDo tooManyThingsToDo) {
            fail();
        }
        try {
            tdl.addItem(i2);
        } catch (TooManyThingsToDo tooManyThingsToDo) {
            fail();
        }
        try {
            tdl.addItem(i3);
        } catch (TooManyThingsToDo tooManyThingsToDo) {
            fail();
        }
        assertEquals(3, tdl.getItems().size());
        assertTrue(tdl.getItems().contains(i1));
        assertTrue(tdl.getItems().contains(i2));
        assertTrue(tdl.getItems().contains(i3));
    }

    @Test
    public void getManyItemsTest() {
        addNineWithTryCatch();
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
        try {
            tdl.addItem(i1);
        } catch (TooManyThingsToDo tooManyThingsToDo) {
            fail();
        }
        assertEquals(1, tdl.howManyLeftToDo());
    }

    @Test
    public void threeLeftTest() {
        try {
            tdl.addItem(i1);
        } catch (TooManyThingsToDo tooManyThingsToDo) {
            fail();
        }
        try {
            tdl.addItem(i2);
        } catch (TooManyThingsToDo tooManyThingsToDo) {
            fail();
        }
        try {
            tdl.addItem(i3);
        } catch (TooManyThingsToDo tooManyThingsToDo) {
            fail();
        }
        assertEquals(3, tdl.howManyLeftToDo());
    }

    @Test
    public void manyLeftTest() {
        addNineWithTryCatch();
        assertEquals(9, tdl.howManyLeftToDo());
    }


    @Test
    public void checkOffItemsWithSameTextTest() {
        addNineWithTryCatch();
        i1.setItemText("a");
        i2.setItemText("a");
        tdl.checkOffItemWithText("a");
        assertTrue(i1.isCheckedOff());
        assertTrue(i2.isCheckedOff());
    }

    @Test
    public void checkOffFirstItem() {
        addNineWithTryCatch();
        i1.setItemText("a");
        tdl.checkOffItemWithText("a");
        assertTrue(i1.isCheckedOff());
    }

    @Test
    public void checkOffMidItem() {
        addNineWithTryCatch();
        i5.setItemText("a");
        tdl.checkOffItemWithText("a");
        assertTrue(i5.isCheckedOff());
    }

    @Test
    public void checkOffLastItem() {
        addNineWithTryCatch();
        i9.setItemText("a");
        tdl.checkOffItemWithText("a");
        assertTrue(i9.isCheckedOff());
    }

    @Test
    public void loadTest() throws IOException {
        tdl.load("./data/loadTestData");
        i1 = tdl.getItems().get(0);
        i2 = tdl.getItems().get(1);
        i3 = tdl.getItems().get(2);
        i4 = tdl.getItems().get(3);
        i5 = tdl.getItems().get(4);
        assertEquals(5, tdl.getItems().size());
        assertEquals("URGENT!: general", i5.getCategory());
        assertFalse(i1.isCheckedOff());
        assertTrue(i2.isCheckedOff());
        assertFalse(i3.isCheckedOff());
        assertTrue(i4.isCheckedOff());
        assertFalse(i5.isCheckedOff());
        assertEquals("walk dog", i1.getItemText());
        assertEquals("workout", i2.getItemText());
        assertEquals("make bed", i3.getItemText());
        assertEquals("homework", i4.getItemText());
        assertEquals("file taxes", i5.getItemText());
        assertEquals("general", i1.getCategory());
        assertEquals("health", i2.getCategory());
        assertEquals("cleaning", i3.getCategory());
        assertEquals("school", i4.getCategory());

    }

    @Test
    public void saveTest() throws IOException {
        i1.setItemText("run");
        i1.setCategory("health");
        i2.setItemText("homework");
        i2.setCategory("school");
        i2.checkOffItem();
        i3.setItemText("buy gift");
        i3.setCategory("general");
        try {
            tdl.addItem(i1);
        } catch (TooManyThingsToDo tooManyThingsToDo) {
            fail();
        }
        try {
            tdl.addItem(i2);
        } catch (TooManyThingsToDo tooManyThingsToDo) {
            fail();
        }
        try {
            tdl.addItem(i3);
        } catch (TooManyThingsToDo tooManyThingsToDo) {
            fail();
        }
        tdl.save();
        List<String> lines = Files.readAllLines(Paths.get("outputfile.txt"));
        List<String> expected = new ArrayList<>();
        expected.add("false/run/health");
        expected.add("true/homework/school");
        expected.add("false/buy gift/general");
        assertEquals(expected, lines);
    }

    @Test
    public void catchTooManyThingsToDo(){
        for (int count=0; count < LIST_CAPACITY; count++) {
            Item i = new RegularItem();
            try {
                tdl.addItem(i);
            } catch (TooManyThingsToDo tooManyThingsToDo) {
                fail();
            }
        }
        assertEquals(LIST_CAPACITY, tdl.getItems().size());
        Item i100 = new RegularItem();
        try {
            tdl.addItem(i100);
            fail();
        } catch (TooManyThingsToDo tooManyThingsToDo) {
        }
    }

}
