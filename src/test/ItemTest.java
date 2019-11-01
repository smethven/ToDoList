import exceptions.TooManyThingsToDo;
import model.RegularItem;
import model.Item;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ItemTest {
    Item i;

    @BeforeEach
    public void setup() {
        i = new RegularItem();
    }

    @Test
    public void checkOffUncheckedItemTest() {
        try {
            i.uncheckItem();
        } catch (TooManyThingsToDo tooManyThingsToDo) {
            fail();
        }
        assertTrue(i.getToDoList()!=null);
        i.checkOffItem();
        assertTrue(i.isCheckedOff());
        assertTrue(i.getToDoList()== null);
    }

    @Test
    public void checkOffCheckedOffItemTest() {
        i.checkOffItem();
        assertTrue(i.getToDoList()==null);
        i.checkOffItem();
        assertTrue(i.getToDoList()==null);
        assertTrue(i.isCheckedOff());
    }

    @Test
    public void uncheckUncheckedItemTest() {
        try {
            i.uncheckItem();
        } catch (TooManyThingsToDo tooManyThingsToDo) {
            fail();
        }
        assertTrue(i.getToDoList()!=null);
        assertTrue(i.getToDoList().getItemValues().contains(i));
        try {
            i.uncheckItem();
        } catch (TooManyThingsToDo tooManyThingsToDo) {
            fail();
        }
        assertTrue(i.getToDoList()!=null);
        assertTrue(i.getToDoList().getItemValues().contains(i));
        assertFalse(i.isCheckedOff());
    }

    @Test
    public void uncheckCheckedOffItemTest() {
        i.checkOffItem();
        assertTrue(i.getToDoList()==null);
        try {
            i.uncheckItem();
        } catch (TooManyThingsToDo tooManyThingsToDo) {
            fail();
        }
        assertTrue(i.getToDoList()!=null);
        assertTrue(i.getToDoList().getItemValues().contains(i));
        assertFalse(i.isCheckedOff());
    }

    @Test
    public void setNoTextTest() {
        i.setItemText("");
        assertEquals("", i.getItemText());
    }

    @Test
    public void setLittleTextTest() {
        i.setItemText("a");
        assertEquals("a", i.getItemText());
    }

    @Test
    public void setLotsTextTest() {
        i.setItemText("blah blah blah blah");
        assertEquals("blah blah blah blah", i.getItemText());
    }

    @Test
    public void setNoCategory() {
        i.setCategory("");
        assertEquals("", i.getCategory());
    }

    @Test
    public void setLittleCategory() {
        i.setCategory("a");
        assertEquals("a", i.getCategory());
    }

    @Test
    public void setLotsCategory() {
        i.setCategory("blah blah blah");
        assertEquals("blah blah blah", i.getCategory());
    }

    @Test
    public void getUncheckedItemStatusTest() {
        try {
            i.uncheckItem();
        } catch (TooManyThingsToDo tooManyThingsToDo) {
            fail();
        }
        assertFalse(i.isCheckedOff());
    }

    @Test
    public void getCheckedItemStatusTest() {
        i.checkOffItem();
        assertTrue(i.isCheckedOff());
    }

    @Test
    public void getNoTextTest() {
        i.setItemText("");
        assertEquals("", i.getItemText());
    }

    @Test
    public void getLittleTextTest() {
        i.setItemText("a");
        assertEquals("a", i.getItemText());
    }
    @Test
    public void getLotsTextTest() {
        i.setItemText("blah blah blah");
        assertEquals("blah blah blah", i.getItemText());
    }

    @Test
    public void getNoCategoryTest() {
       i.setCategory("");
       assertEquals("", i.getCategory());
    }

    @Test
    public void getLittleCategoryTest() {
        i.setCategory("a");
        assertEquals("a", i.getCategory());
    }

    @Test
    public void getLotsCategoryTest() {
        i.setCategory("blah blah blah");
        assertEquals("blah blah blah", i.getCategory());
    }

}
