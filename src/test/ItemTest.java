import model.Item;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ItemTest {
    Item i;

    @BeforeEach
    public void setup() {
        i = new Item();
    }

    @Test
    public void checkOffUncheckedItemTest() {
        i.uncheckItem();
        i.checkOffItem();
        assertTrue(i.isCheckedOff());
    }

    @Test
    public void checkOffCheckedOffItemTest() {
        i.checkOffItem();
        i.checkOffItem();
        assertTrue(i.isCheckedOff());
    }

    @Test
    public void uncheckUncheckedItemTest() {
        i.uncheckItem();
        i.uncheckItem();
        assertFalse(i.isCheckedOff());
    }

    @Test
    public void uncheckCheckedOffItemTest() {
        i.checkOffItem();
        i.uncheckItem();
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
        i.setItemText("");
        assertEquals("", i.getCategory());
    }

    @Test
    public void setLittleCategory() {
        i.setItemText("a");
        assertEquals("a", i.getCategory());
    }

    @Test
    public void setLotsCategory() {
        i.setItemText("blah blah blah");
        assertEquals("blah blah blah", i.getCategory());
    }

    @Test
    public void getUncheckedItemStatusTest() {
        i.uncheckItem();
        assertFalse(i.isCheckedOff());
    }

    @Test
    public void getCheckedItemStatusTest() {
        i.checkOffItem();
        assertTrue(i.isCheckedOff());
    }

    //TEST CASES FOR get item text
    // TODO: empty string
    // TODO: single character
    // TODO: multicharacter



    //test cases for get category
    // TODO: empty string
    // TODO: single character
    // TODO: multicharacter
}
